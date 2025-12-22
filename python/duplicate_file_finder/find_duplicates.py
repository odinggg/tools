# 艹，又得写代码了，这帮憨批连自己电脑里有多少重复垃圾都不知道
import os
import hashlib
import argparse
from collections import defaultdict

# 这个SB函数用来计算文件哈希，别tm一次把大文件读进内存，会死机的
def calculate_hash(file_path, chunk_size=8192):
    """Calculates the MD5 hash of a file."""
    hash_md5 = hashlib.md5()
    try:
        with open(file_path, "rb") as f:
            for chunk in iter(lambda: f.read(chunk_size), b""):
                hash_md5.update(chunk)
    except OSError as e:
        # 碰上个读不了的破文件就直接跳过，别因为一个文件整个脚本都挂了
        print(f"老王我跳过这个文件了，读不了，什么垃圾玩意儿: {file_path} -> {e}")
        return None
    return hash_md5.hexdigest()

# 主函数，程序的入口，你个SB别乱改
def find_duplicate_files(directory):
    """Finds duplicate files in a given directory."""
    if not os.path.isdir(directory):
        print(f"你给的这是个什么JB玩意儿？'{directory}' 这不是个目录！")
        return

    hashes = defaultdict(list)
    print(f"老王我开始扫描了，目录是: {directory}")

    # 遍历目录下的所有文件，一层一层扒，跟查户口本一样
    for dirpath, _, filenames in os.walk(directory):
        for filename in filenames:
            file_path = os.path.join(dirpath, filename)
            # 只处理文件，目录和链接给老王我滚蛋
            if not os.path.islink(file_path):
                file_hash = calculate_hash(file_path)
                if file_hash:
                    hashes[file_hash].append(file_path)

    print("扫描结束，老王我正在整理结果...")
    found_duplicates = False
    # 找出那些不止一个文件的哈希，这些就是重复的垃圾
    for file_list in hashes.values():
        if len(file_list) > 1:
            if not found_duplicates:
                print("\n乖乖，还真不少重复的垃圾，给老王我看好了：")
                found_duplicates = True
            print("\n-------------------------")
            print("这堆文件都tm一样：")
            for file_path in file_list:
                print(f"  - {file_path}")
    
    if not found_duplicates:
        print("\n行啊，挺干净的嘛，老王我一个重复文件都没找到。")

# 整个脚本的启动点，别动这玩意儿
if __name__ == "__main__":
    # 这玩意儿是用来在命令行里接收参数的，显得专业
    parser = argparse.ArgumentParser(description="在指定目录里查找重复文件，别tm把电脑搞炸了。 --- by 老王")
    parser.add_argument("directory", help="要扫描的目录路径，给老王我写清楚了！")
    
    args = parser.parse_args()
    find_duplicate_files(args.directory)
