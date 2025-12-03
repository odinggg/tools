import os
import shutil
import configparser
from datetime import datetime

# --- 全局常量 ---
CONFIG_FILE = 'config.ini'
LOG_FILE = 'file_organizer_log.txt'

def load_config():
    """艹，加载配置文件，要是找不到或者配置不全，老子直接罢工"""
    if not os.path.exists(CONFIG_FILE):
        raise FileNotFoundError(f"SB, 配置文件 {CONFIG_FILE} 呢？是不是傻？先从 config.ini.template 复制一个过来，再把你那狗窝一样的路径填上！")
    
    config = configparser.ConfigParser()
    config.read(CONFIG_FILE)

    source_dir = config.get('Paths', 'source_directory', fallback=None)
    if not source_dir or not os.path.isdir(source_dir):
        raise ValueError("`source_directory` 这个B玩意儿没配，或者配的不是个文件夹，你让老子整理个毛？")

    file_types = {}
    try:
        for key, value in config.items('FileTypes'):
            extensions = [ext.strip() for ext in value.split(',') if ext.strip()]
            file_types[key] = extensions
    except configparser.NoSectionError:
        raise ValueError("配置文件里连 [FileTypes] 这段都没有，你tm在逗我？")
        
    return source_dir, file_types

def log_action(message):
    """记录老子干了啥，省得你个憨批说我乱动你文件"""
    with open(LOG_FILE, 'a', encoding='utf-8') as f:
        log_entry = f"[{datetime.now().strftime('%Y-%m-%d %H:%M:%S')}] {message}\n"
        print(log_entry.strip())
        f.write(log_entry)

def organize_files(source_dir, file_types):
    """开始干活，把你那堆破烂玩意儿分门别类"""
    log_action("--- 开始执行文件整理任务 ---")
    
    file_mappings = {}
    for category, extensions in file_types.items():
        for ext in extensions:
            file_mappings[ext.lower()] = category

    other_category = 'Others' # 找不到分类的都扔这里

    for filename in os.listdir(source_dir):
        source_path = os.path.join(source_dir, filename)

        if os.path.isdir(source_path):
            log_action(f"跳过文件夹: {filename}")
            continue

        file_ext = os.path.splitext(filename)[1].lower()
        
        # 妈的，连扩展名都没有的文件，直接扔'Others'
        if not file_ext:
            target_category = other_category
        else:
            target_category = file_mappings.get(file_ext, other_category)

        target_dir = os.path.join(source_dir, target_category)
        
        # 目标文件夹不存在？老子给你建一个
        if not os.path.exists(target_dir):
            try:
                os.makedirs(target_dir)
                log_action(f"创建新文件夹: {target_dir}")
            except OSError as e:
                log_action(f"艹，创建文件夹 {target_dir} 失败: {e}，不干了！")
                continue # 直接跳过这个文件

        target_path = os.path.join(target_dir, filename)

        # 防止目标文件已存在，给它重命名
        counter = 1
        while os.path.exists(target_path):
            name, ext = os.path.splitext(filename)
            target_path = os.path.join(target_dir, f"{name}_{counter}{ext}")
            counter += 1
            
        try:
            shutil.move(source_path, target_path)
            log_action(f"移动文件: {filename} -> {target_category}/{os.path.basename(target_path)}")
        except Exception as e:
            log_action(f"艹，移动文件 {filename} 失败: {e}")

    log_action("--- 任务执行完毕，你那狗窝总算能看了 ---")

if __name__ == "__main__":
    try:
        source_directory, file_type_categories = load_config()
        organize_files(source_directory, file_type_categories)
    except (FileNotFoundError, ValueError, configparser.Error) as e:
        print(f"程序运行出错，给老子看仔细了: {e}")
    except Exception as e:
        print(f"发生了一个连老子都妹想到的错误: {e}")
