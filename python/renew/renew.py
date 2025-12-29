import time
import random
import os
import signal
import sys
from DrissionPage import ChromiumPage, ChromiumOptions

# ================= 配置区域 =================
USERNAME = "您的用户名"
PASSWORD = "您的密码"
SERVER_ID = "xxx"
# 执行间隔（秒），例如每 24 小时执行一次
CHECK_INTERVAL = 86400

# 模拟真实用户的等待时间配置 (最小值, Max值)
TIMING = {
    'page_load': (3, 6),
    'input': (0.5, 1.5),
    'click': (1, 3),
    'turnstile_wait': (3, 6) # 增加等待验证码加载的时间
}
# ===========================================

_chrome_process_ids = []

def cleanup_chrome_processes():
    """清理脚本启动的 Chrome 进程"""
    global _chrome_process_ids
    if not _chrome_process_ids: return
    print("\n[!] 正在清理浏览器残留进程...")
    for pid in _chrome_process_ids:
        try:
            if os.name == 'nt':
                os.system(f'taskkill /F /PID {pid} /T 2>nul')
            else:
                os.kill(pid, signal.SIGTERM)
        except: pass
    _chrome_process_ids = []

def get_random_sleep(timing_type):
    """根据配置获取随机等待时间"""
    tr = TIMING.get(timing_type, (1, 2))
    return random.uniform(tr[0], tr[1])

def handle_turnstile(page):
    """
    Cloudflare Turnstile 验证码处理逻辑 (老王优化版)
    针对 Shadow DOM 和新版 Turnstile 进行了适配
    """
    print("[*] 正在检测 Cloudflare Turnstile 验证码...")

    try:
        time.sleep(2)  # 稍微等一下页面加载

        target_frame = None
        # 1. 优先通过 iframe 特征寻找
        for frame in page.get_frames():
            if "turnstile" in frame.url or "challenges" in frame.url:
                target_frame = frame
                break
            # 备用：通过内部元素寻找
            if frame.ele('tag:input@type=checkbox') or frame.ele('.cb-lb'):
                target_frame = frame
                break

        # 2. 如果没找到，尝试在主页面找 .cf-turnstile 容器
        if not target_frame:
            container = page.ele('.cf-turnstile', timeout=2)
            if container:
                target_frame = container.ele('tag:iframe')

        if not target_frame:
            print("[-] 未检测到 Turnstile 验证码，可能直接通过。")
            return "NO_TURNSTILE"

        print("[+] 发现验证码 Iframe，准备干它...")

        # 3. 循环检查与点击
        for i in range(10):  # 增加尝试次数
            # 检查成功标志
            if (target_frame.ele('.success', timeout=0.5) or
                    target_frame.ele('.success-circle', timeout=0.5) or
                    target_frame.ele('text=Success!', timeout=0.5)):
                print("[√] 验证码检测到成功标志，通过！")
                return True

            # 查找点击目标
            # 优先找 checkbox
            checkbox = target_frame.ele('tag:input@type=checkbox', timeout=1)
            if checkbox:
                print(f"[*] (第{i + 1}次) 点击 Checkbox...")
                checkbox.click()
                time.sleep(2)
                continue

            # 其次找 label (文字)
            label = target_frame.ele('.cb-lb', timeout=1)
            if label:
                print(f"[*] (第{i + 1}次) 点击 Label...")
                label.click()
                time.sleep(2)
                continue

            # 再次，尝试点击 Shadow Root 里的东西 (DrissionPage 优势)
            # 有时候它仅仅是一个 wrapper
            wrapper = target_frame.ele('#challenge-stage', timeout=1)
            if wrapper:
                wrapper.click()
                time.sleep(2)

            # 检查是否在验证中 (loading)
            if target_frame.ele('.spinner', timeout=0.5):
                print("[*] 验证中... 等待...")
                time.sleep(2)
                continue

            time.sleep(1)

        print("[!] 验证码尝试多次未果。")
        return False

    except Exception as e:
        print(f"[-] handle_turnstile 出错: {e}")
        return False

def setup_driver():
    """配置增强版的浏览器选项"""
    global _chrome_process_ids
    co = ChromiumOptions()
    co.set_argument("--incognito")
    co.set_argument("--no-sandbox")
    co.auto_port()
    co.headless(False)
    co.set_user_agent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")

    import psutil
    before_pids = [p.pid for p in psutil.process_iter() if 'chrome' in p.name().lower()]
    page = ChromiumPage(co)
    time.sleep(1)

    after_pids = [p.pid for p in psutil.process_iter() if 'chrome' in p.name().lower()]
    _chrome_process_ids.extend([pid for pid in after_pids if pid not in before_pids])
    return page

def run_task():
    page = setup_driver()
    try:
        print("[*] 正在初始化访问...")
        page.get('about:blank')
        time.sleep(get_random_sleep('input'))

        # 1. 登录
        page.get("https://dashboard.katabump.com/login")
        time.sleep(get_random_sleep('page_load'))
        handle_turnstile(page)

        print("[*] 填写登录凭据...")
        u_input = page.ele('xpath://*[@id="email"]')
        p_input = page.ele('xpath://*[@id="password"]')
        s_btn = page.ele('xpath://*[@id="submit"]')

        if u_input:
            u_input.input(USERNAME)
            time.sleep(get_random_sleep('input'))
            if p_input: p_input.input(PASSWORD)
            time.sleep(get_random_sleep('input'))
            if s_btn: s_btn.click()

        page.wait.load_start()
        time.sleep(get_random_sleep('page_load'))

        # 2. 搜索并进入服务器详情
        print(f"[*] 寻找服务器 ID: {SERVER_ID}...")
        see_link_xpath = f"//tr[td[contains(text(), '{SERVER_ID}')]]//a[contains(text(), 'See')]"
        target_row = page.ele(f'xpath:{see_link_xpath}')

        if target_row:
            target_row.click()
        else:
            print("[!] 未找到目标服务器")
            return

        time.sleep(get_random_sleep('page_load'))

        # 3. 第一次 Renew
        print("[*] 点击第一阶段 Renew 按钮...")
        renew_btn_1 = page.ele('xpath://*[@id="profile-overview"]/button[2]')
        if renew_btn_1:
            renew_btn_1.click()
            time.sleep(get_random_sleep('turnstile_wait'))

            # --- 强制校验环节 ---
            verify_result = handle_turnstile(page)

            final_renew_xpath = '//*[@id="renew-modal"]/div/div/div[3]/button[2]'

            if verify_result is True:
                print("[√] 校验通过，准备点击最终确认。")
            elif verify_result == "NO_TURNSTILE":
                if page.ele(f'xpath:{final_renew_xpath}'):
                    print("[*] 未检测到验证码，但确认按钮已存在，继续流程。")
                else:
                    print("[!] 未检测到验证码也未检测到确认按钮。")
                    return
            else:
                print("[!] 校验未通过，出于安全考虑，停止最终续费动作。")
                return

            # 4. 最终确认
            print("[*] 执行最终确认 Renew...")
            if page.wait.ele_displayed(f'xpath:{final_renew_xpath}', timeout=5):
                page.ele(f'xpath:{final_renew_xpath}').click()
                print("[√] 自动续费流程已执行完毕！")
            else:
                print("[!] 确认按钮未在预期时间内出现。")

    except Exception as e:
        print(f"[X] 任务执行出错: {e}")
    finally:
        time.sleep(5)
        page.quit()
        cleanup_chrome_processes()

if __name__ == "__main__":
    def signal_handler(sig, frame):
        cleanup_chrome_processes()
        sys.exit(0)

    signal.signal(signal.SIGINT, signal_handler)
    signal.signal(signal.SIGTERM, signal_handler)

    print("=== Katabump 高级自动续费脚本启动 ===")
    while True:
        run_task()
        print(f"[*] 周期性任务完成。等待 {CHECK_INTERVAL} 秒...")
        time.sleep(CHECK_INTERVAL)