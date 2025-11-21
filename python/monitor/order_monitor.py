import os
import requests
import json
import time
import base64
import configparser
import schedule
import google.generativeai as genai
from datetime import datetime, timedelta

# --- 全局常量 ---
CONFIG_FILE = 'config.ini'
TOKEN_FILE = 'token.txt'
ORDER_STATUS_FILE = 'order_status.json'
BASE_API_URL = 'https://haokaapi.lot-ml.com/api'

# --- 配置加载 ---
def load_config():
    """从 config.ini 文件加载配置"""
    if not os.path.exists(CONFIG_FILE):
        raise FileNotFoundError(f"配置文件 {CONFIG_FILE} 未找到。请根据模板创建并填写配置。")
    config = configparser.ConfigParser()
    config.read(CONFIG_FILE)
    return config

# --- Token 管理 ---
def save_token(token):
    """将 Token 保存到本地文件"""
    with open(TOKEN_FILE, 'w') as f:
        f.write(token)
    print("Token 已成功保存。")

def load_token():
    """从本地文件加载 Token"""
    if os.path.exists(TOKEN_FILE):
        with open(TOKEN_FILE, 'r') as f:
            return f.read().strip()
    return None

# --- Bark 通知 ---
def send_bark_notification(bark_server, bark_key, title, body):
    """通过 Bark 发送推送通知（支持自定义服务器）"""
    if not bark_key:
        print("警告: Bark Key 未配置，跳过发送通知。")
        return

    # 如果配置了自定义服务器则使用，否则使用官方默认服务器
    base_url = bark_server.strip() if bark_server and bark_server.strip() else "https://api.day.app"

    try:
        # 确保基础URL末尾没有斜杠，避免生成 //
        base_url = base_url.rstrip('/')
        # URL编码消息体，防止特殊字符导致请求失败
        encoded_body = requests.utils.quote(body)
        url = f"{base_url}/{bark_key}/{title}/{encoded_body}"
        print(f"正在发送 Bark 通知到: {base_url}")
        response = requests.get(url)
        response.raise_for_status()
        print(f"Bark 通知已发送: {title}")
    except requests.RequestException as e:
        print(f"发送 Bark 通知失败: {e}")

# --- 核心业务逻辑 ---
def solve_captcha_with_gemini(api_key, image_base64):
    """使用 Gemini API 识别验证码"""
    if not api_key:
        raise ValueError("Gemini API Key 未在配置文件中设置。")

    print("正在调用 Gemini API 识别验证码...")
    genai.configure(api_key=api_key)

    # 从 base64 字符串中提取图片数据
    image_data = base64.b64decode(image_base64.split(',')[1])

    image_part = {
        "mime_type": "image/png",
        "data": image_data
    }

    prompt = "图片内容是一个4位数字和大小写字母组合的验证码。请识别图中的内容，并只返回这4个字符，不要包含任何其他说明和文字。确保区分大小写。"

    model = genai.GenerativeModel('gemini-1.5-flash')
    response = model.generate_content([prompt, image_part])

    captcha_code = response.text.strip()
    print(f"Gemini 识别结果: {captcha_code}")
    return captcha_code

def get_new_token(config):
    """通过登录流程获取新的 Token"""
    print("Token 无效或不存在，开始执行登录流程...")
    username = config.get('credentials', 'username')
    password = config.get('credentials', 'password')
    gemini_api_key = config.get('api_keys', 'gemini_api_key')

    # 1. 获取验证码
    try:
        print("正在获取验证码...")
        response = requests.get(f"{BASE_API_URL}/User/ImgCode")
        response.raise_for_status()
        captcha_data = response.json()
        if captcha_data.get('code') != 0:
            print(f"获取验证码失败: {captcha_data.get('message')}")
            return None
        img_base64 = captcha_data['data']
    except requests.RequestException as e:
        print(f"获取验证码请求失败: {e}")
        return None

    # 2. 识别验证码
    try:
        code = solve_captcha_with_gemini(gemini_api_key, img_base64)
        if len(code) != 4:
            print(f"验证码识别结果 '{code}' 长度不符合要求，登录失败。")
            return None
    except Exception as e:
        print(f"调用 Gemini API 失败: {e}")
        return None

    # 3. 执行登录
    try:
        print("正在执行登录操作...")
        login_payload = {
            "UserName": username,
            "PassWord": password,
            "Code": code
        }
        response = requests.post(f"{BASE_API_URL}/User/Login", json=login_payload)
        response.raise_for_status()
        login_result = response.json()

        if login_result.get('code') == 0:
            token = login_result['data']['token']
            print("登录成功！")
            save_token(token)
            return token
        else:
            print(f"登录失败: {login_result.get('message')}")
            return None
    except requests.RequestException as e:
        print(f"登录请求失败: {e}")
        return None

def query_orders(token):
    """使用 Token 查询订单状态"""
    print("正在查询订单列表...")
    headers = {'Authorization': f'bearer {token}'}

    end_time = datetime.now()
    begin_time = end_time - timedelta(days=30)
    params = {
        'page': 1,
        'limit': 50,
        'BeginTime': begin_time.strftime('%Y-%m-%d 00:00:00'),
        'EndTime': end_time.strftime('%Y-%m-%d 23:59:59'),
    }

    try:
        response = requests.get(f"{BASE_API_URL}/Order/Query", headers=headers, params=params)
        if response.status_code == 200 and response.json().get('code') in [401, -1]:
            print("Token 已失效。")
            return None

        response.raise_for_status()
        return response.json()
    except requests.RequestException as e:
        print(f"查询订单请求失败: {e}")
        return {'code': -99, 'data': []}

def check_order_status_job():
    """主任务：检查并通知订单状态变更"""
    print(f"\n--- 开始执行订单状态检查任务: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')} ---")
    config = load_config()
    bark_server = config.get('bark', 'bark_server', fallback='')
    bark_key = config.get('bark', 'bark_key', fallback='')

    token = load_token()
    order_data = None

    if token:
        print("检测到本地Token，尝试直接查询订单...")
        order_data = query_orders(token)

    if order_data is None:
        token = get_new_token(config)
        if not token:
            print("无法获取有效 Token，任务终止。")
            return
        order_data = query_orders(token)

    if not order_data or order_data.get('code') != 0:
        print(f"获取订单数据失败: {order_data.get('msg', '未知错误')}")
        return

    orders = order_data.get('data', [])
    print(f"成功获取到 {len(orders)} 条订单数据。")

    old_statuses = {}
    if os.path.exists(ORDER_STATUS_FILE):
        with open(ORDER_STATUS_FILE, 'r', encoding='utf-8') as f:
            try:
                old_statuses = json.load(f)
            except json.JSONDecodeError:
                pass

    new_statuses = {}
    has_changes = False
    for order in orders:
        order_no = str(order['orderNo'])
        current_status = order['orderStatus']
        new_statuses[order_no] = current_status

        old_status = old_statuses.get(order_no)
        if old_status and old_status != current_status:
            has_changes = True
            print(f"检测到状态变更！订单号: {order_no}")
            title = "订单状态更新"
            name = order.get('name', 'N/A')
            phone = order.get('phone', 'N/A')
            masked_name = name[0] + '*' * (len(name) - 1) if len(name) > 1 else name
            masked_phone = phone[:3] + '****' + phone[7:] if len(phone) == 11 else phone

            body = f"订单【{masked_name} {masked_phone}】状态已从【{old_status}】变为【{current_status}】"
            print(body)
            send_bark_notification(bark_server, bark_key, title, body)
        elif not old_status:
            print(f"检测到新订单！订单号: {order_no}, 状态: {current_status}")

    updated_statuses = {**old_statuses, **new_statuses}
    with open(ORDER_STATUS_FILE, 'w', encoding='utf-8') as f:
        json.dump(updated_statuses, f, indent=4, ensure_ascii=False)

    if not has_changes:
        print("本次检查未发现订单状态变更。")
    print("--- 任务执行完毕 ---")


if __name__ == "__main__":
    try:
        config = load_config()
        interval = config.getint('settings', 'check_interval_minutes', fallback=30)

        print("订单状态监控应用已启动。")
        print(f"将每隔 {interval} 分钟检查一次订单状态。")

        check_order_status_job()

        schedule.every(interval).minutes.do(check_order_status_job)

        while True:
            schedule.run_pending()
            time.sleep(1)

    except FileNotFoundError as e:
        print(f"错误: {e}")
    except (configparser.NoSectionError, configparser.NoOptionError) as e:
        print(f"配置错误: {e}。请检查 config.ini 文件是否完整。")
    except Exception as e:
        print(f"程序发生未知错误: {e}")
