import cv2
import time
import os
import subprocess
import pyautogui
from deepface import DeepFace
import argparse
import logging
import sys
import shutil

# 配置日志格式
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - [%(levelname)s] - %(message)s',
    datefmt='%H:%M:%S'
)
logger = logging.getLogger("SmartLock")

class SmartFaceLock:
    def __init__(self, debug_mode=False):
        # --- 用户配置区 ---
        self.PASSWORD = "testpwd"  # ⚠️ 警告：明文密码，仅供测试
        self.LOCK_TIMEOUT = 600     # 10分钟自动锁屏
        self.CHECK_INTERVAL = 30    # 检测间隔帧数
        self.CONFIDENCE_THRESHOLD = 0.4 # 相似度阈值

        # 存储多角度照片的文件夹
        self.FACE_DB_DIR = "face_db"

        # --- 安全配置 ---
        self.UNLOCK_COOLDOWN = 5.0  # 解锁冷却时间
        self.MAX_UNLOCK_ATTEMPTS = 3 # 最大自动解锁尝试次数

        # --- 系统状态 ---
        self.last_seen_time = time.time()
        self.last_unlock_attempt_time = 0
        self.unlock_attempts_count = 0
        self.is_locked = False
        self.program_running = True
        self.debug_mode = debug_mode

        # 启用 PyAutoGUI 的防故障功能
        pyautogui.FAILSAFE = True

        if self.debug_mode:
            logger.setLevel(logging.DEBUG)
            logger.debug("Debug 模式已开启")

        # 确保数据库目录存在
        if not os.path.exists(self.FACE_DB_DIR):
            os.makedirs(self.FACE_DB_DIR)

        # 初始化模型
        self._init_model()

    def _init_model(self):
        logger.info("正在初始化 ArcFace 模型 (Apple Silicon 加速)...")
        try:
            # 预热模型
            DeepFace.build_model("ArcFace")
            logger.info("✅ 模型加载完成")
        except Exception as e:
            logger.error(f"❌ 模型加载失败: {e}")
            sys.exit(1)

    # ================= 注册流程 =================

    def _draw_text(self, img, text, y, color=(0, 255, 0), scale=0.8):
        """辅助函数：在图片上绘制文字"""
        cv2.putText(img, text, (30, y), cv2.FONT_HERSHEY_SIMPLEX, scale, color, 2)

    def _interactive_capture(self, cap, instruction, filename):
        """交互式拍照：预览 -> 拍照 -> 确认"""
        while True:
            # --- 阶段1: 预览与拍照 ---
            while True:
                ret, frame = cap.read()
                if not ret: return False

                display = frame.copy()
                # 绘制半透明蒙版和提示
                cv2.rectangle(display, (0, 0), (display.shape[1], 120), (0, 0, 0), -1)
                self._draw_text(display, f"POSE: {instruction}", 40, (255, 255, 255), 1.0)
                self._draw_text(display, "Press [SPACE] to Snap", 90, (0, 255, 255))

                cv2.imshow("Registration Wizard", display)
                key = cv2.waitKey(1) & 0xFF
                if key == 32: # Space键
                    break
                if key == 27 or key == ord('q'): # ESC or q
                    return False

            # --- 阶段2: 处理与裁剪 ---
            logger.info("正在检测人脸...")
            try:
                # 尝试检测人脸
                detected_faces = DeepFace.extract_faces(
                    img_path=frame,
                    detector_backend='opencv',
                    enforce_detection=True
                )

                if not detected_faces:
                    logger.warning("未检测到人脸，请重试")
                    continue # 回到预览循环

                # 获取第一张脸并裁剪
                face_obj = detected_faces[0]
                area = face_obj['facial_area']
                x, y, w, h = area['x'], area['y'], area['w'], area['h']

                h_img, w_img, _ = frame.shape
                pad = 40
                x1 = max(0, x - pad)
                y1 = max(0, y - pad)
                x2 = min(w_img, x + w + pad)
                y2 = min(h_img, y + h + pad)

                cropped_face = frame[y1:y2, x1:x2]

            except ValueError:
                logger.warning("❌ 未能识别出人脸，请调整光线或角度后重试。")
                continue

            # --- 阶段3: 确认保存 ---
            while True:
                review_screen = frame.copy()
                # 变暗背景
                review_screen = (review_screen * 0.3).astype('uint8')

                # 将裁剪的人脸贴在中间展示
                ch, cw, _ = cropped_face.shape
                center_y, center_x = h_img // 2, w_img // 2

                # 确保贴图不越界
                y_start = max(0, center_y - ch//2)
                y_end = min(h_img, center_y + ch//2)
                x_start = max(0, center_x - cw//2)
                x_end = min(w_img, center_x + cw//2)

                # 调整cropped_face大小以适应目标区域(简单起见直接覆盖，实际应该resize)
                review_screen[y_start:y_end, x_start:x_end] = cv2.resize(cropped_face, (x_end-x_start, y_end-y_start))

                # 绘制绿框
                cv2.rectangle(review_screen, (x_start, y_start), (x_end, y_end), (0, 255, 0), 3)

                self._draw_text(review_screen, "Check Quality", 40, (255, 255, 255), 1.0)
                self._draw_text(review_screen, "[Y] Save & Next   [N] Retake", 90, (0, 255, 0))

                cv2.imshow("Registration Wizard", review_screen)
                key = cv2.waitKey(0) & 0xFF

                if key == ord('y'):
                    # 保存
                    save_path = os.path.join(self.FACE_DB_DIR, filename)
                    cv2.imwrite(save_path, cropped_face)
                    logger.info(f"✅ 已保存: {filename}")
                    return True
                elif key == ord('n'):
                    logger.info("用户选择重拍")
                    break # 跳出确认循环，回到最外层预览循环
                elif key == 27: # ESC
                    return False

    def run_registration(self):
        """执行完整的注册向导"""
        logger.info(">>> 进入注册模式 <<<")
        logger.info(f"照片将保存在: {os.path.abspath(self.FACE_DB_DIR)}")

        cap = cv2.VideoCapture(0)
        if not cap.isOpened():
            logger.error("无法打开摄像头")
            return

        poses = [
            ("Look Straight (Front)", "pose_front.jpg"),
            ("Turn Head LEFT slightly", "pose_left.jpg"),
            ("Turn Head RIGHT slightly", "pose_right.jpg"),
            ("Look UP slightly", "pose_up.jpg"),
            ("Look DOWN slightly", "pose_down.jpg")
        ]

        logger.info("请按屏幕提示操作。按空格拍照，按Y确认，按N重拍。")

        completed_count = 0
        for instruction, filename in poses:
            # 检查是否已存在，如果存在询问是否覆盖？这里简化逻辑：直接覆盖流程
            if self._interactive_capture(cap, instruction, filename):
                completed_count += 1
            else:
                logger.warning("注册流程中断。")
                break

        cap.release()
        cv2.destroyAllWindows()

        if completed_count == len(poses):
            logger.info("🎉 注册完成！所有角度已录入。")
            logger.info("现在请使用不带 --register 参数的命令启动监控。")
        else:
            logger.warning(f"⚠️ 注册未完全完成 ({completed_count}/{len(poses)})。建议重新运行补全。")

    # ================= 监控流程 =================

    def verify_face(self, frame):
        """核验人脸 (多角度匹配策略)"""
        try:
            # 获取所有注册图片
            reference_imgs = [
                os.path.join(self.FACE_DB_DIR, f)
                for f in os.listdir(self.FACE_DB_DIR)
                if f.endswith('.jpg')
            ]

            # 安全检查：如果图片被删了
            if not reference_imgs:
                return False

            best_distance = 100.0
            matched = False

            # 遍历所有注册角度
            for ref_img in reference_imgs:
                try:
                    result = DeepFace.verify(
                        img1_path = frame,
                        img2_path = ref_img,
                        model_name = "ArcFace",
                        detector_backend = "opencv",
                        enforce_detection = False,
                        distance_metric = "cosine"
                    )

                    if result['verified']:
                        dist = result['distance']
                        if dist < best_distance:
                            best_distance = dist

                        if dist < self.CONFIDENCE_THRESHOLD:
                            matched = True
                            # 找到一个极佳匹配就停止，节省资源
                            break
                except Exception:
                    continue

            if matched:
                if self.debug_mode:
                    logger.debug(f"验证通过 | 距离: {best_distance:.4f}")
                return True
            return False

        except Exception as e:
            if self.debug_mode:
                logger.debug(f"识别异常: {e}")
            return False

    def lock_screen(self):
        logger.warning(f"🔒 离座超时 ({self.LOCK_TIMEOUT}s)，执行锁屏...")
        try:
            subprocess.run(["pmset", "displaysleepnow"])
            self.is_locked = True
            self.unlock_attempts_count = 0
        except Exception as e:
            logger.error(f"锁屏失败: {e}")

    def unlock_screen(self):
        current_time = time.time()

        if current_time - self.last_unlock_attempt_time < self.UNLOCK_COOLDOWN:
            return

        if self.unlock_attempts_count >= self.MAX_UNLOCK_ATTEMPTS:
            logger.warning("⚠️ 达到最大自动解锁次数，暂停自动解锁。")
            return

        logger.warning(f"🔓 尝试解锁... (第 {self.unlock_attempts_count + 1} 次)")

        try:
            pyautogui.press('space')
            time.sleep(1.0)
            pyautogui.write(self.PASSWORD)
            pyautogui.press('enter')

            self.is_locked = False
            self.last_unlock_attempt_time = current_time
            self.unlock_attempts_count += 1
            self.last_seen_time = time.time()

        except pyautogui.FailSafeException:
            logger.critical("🚨 鼠标FailSafe触发，停止运行！")
            self.program_running = False
        except Exception as e:
            logger.error(f"解锁出错: {e}")

    def run_monitor(self):
        """执行监控主循环"""
        # 1. 检查注册库
        existing_files = [f for f in os.listdir(self.FACE_DB_DIR) if f.endswith('.jpg')]
        if len(existing_files) == 0:
            logger.error("❌ 未检测到人脸数据！")
            logger.error("请先运行注册命令: python smart_lock.py --register")
            return

        logger.info(f"✅ 已加载 {len(existing_files)} 张人脸数据，开始监控...")

        cap = cv2.VideoCapture(0)
        if not cap.isOpened():
            logger.error("无法打开摄像头")
            return

        frame_count = 0
        logger.info(f"🚀 监控已启动 | 超时: {self.LOCK_TIMEOUT}s")
        if not self.debug_mode:
            logger.info("ℹ️ 当前为静默模式，按 [Ctrl+C] 停止程序")

        try:
            while self.program_running:
                ret, frame = cap.read()
                if not ret: break

                current_time = time.time()

                # 每隔 CHECK_INTERVAL 帧进行一次识别
                if frame_count % self.CHECK_INTERVAL == 0:
                    is_me = self.verify_face(frame)

                    if is_me:
                        # 检测到人
                        self.last_seen_time = current_time
                        if self.is_locked:
                            logger.info("锁定状态 -> 请求解锁")
                            self.unlock_screen()
                        else:
                            if self.unlock_attempts_count > 0:
                                self.unlock_attempts_count = 0
                                logger.info("状态活跃，重置解锁计数")
                    else:
                        # 未检测到人
                        elapsed = current_time - self.last_seen_time
                        if elapsed > self.LOCK_TIMEOUT and not self.is_locked:
                            self.lock_screen()

                frame_count += 1

                # UI 显示逻辑优化：仅在 debug 模式下处理窗口和按键
                if self.debug_mode:
                    status = "LOCKED" if self.is_locked else "ACTIVE"
                    color = (0, 0, 255) if self.is_locked else (0, 255, 0)
                    cv2.putText(frame, f"State: {status}", (10, 30), cv2.FONT_HERSHEY_SIMPLEX, 0.7, color, 2)
                    cv2.imshow('Face Guard Monitor', frame)

                    # 只有有窗口时，waitKey 才有意义且能捕获按键
                    if cv2.waitKey(1) & 0xFF == ord('q'):
                        break
                else:
                    # 静默模式下，不调用 waitKey，避免触发 macOS IMK 报错
                    # 也不需要 sleep，因为 cap.read() 本身就是按帧率阻塞的
                    pass

        except KeyboardInterrupt:
            logger.info("用户停止 (Ctrl+C)")
        finally:
            cap.release()
            cv2.destroyAllWindows()

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="MacOS 人脸识别自动锁屏工具")
    parser.add_argument("--register", action="store_true", help="进入人脸注册模式")
    parser.add_argument("--debug", action="store_true", help="开启详细调试日志")
    args = parser.parse_args()

    app = SmartFaceLock(debug_mode=args.debug)

    if args.register:
        app.run_registration()
    else:
        app.run_monitor()