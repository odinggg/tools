import random

import matplotlib.pyplot as plt
import numpy as np
import pandas as pd


def calculate_one_ratio(array):
    """
    计算数组中1的占比。

    参数:
    array (list): 输入的数组。

    返回:
    float: 1的占比。
    """
    # 将数组转换为numpy数组
    np_array = np.array(array)
    # 计算1的数量
    one_count = np.count_nonzero(np_array == 1)
    # 计算1的占比
    one_ratio = one_count / len(np_array)
    return one_ratio


def plot_one_ratio(array, ax, title):
    """
    绘制数组中1的占比的图像。

    参数:
    array (list): 输入的数组。
    ax (matplotlib.axes.Axes): 子图的坐标轴对象。
    title (str): 子图的标题。
    """
    # 计算1的占比
    one_ratio = calculate_one_ratio(array)

    # 创建一个DataFrame来存储数据
    df = pd.DataFrame({'Value': array})

    # 统计1和0的数量
    value_counts = df['Value'].value_counts()

    # 绘制饼图
    labels = ['0', '1']
    sizes = [value_counts[0], value_counts[1]]
    colors = ['lightcoral', 'lightskyblue']
    explode = (0.1, 0)  # 突出显示1的占比

    ax.pie(sizes, explode=explode, labels=labels, colors=colors,
           autopct='%1.1f%%', shadow=True, startangle=140)

    ax.axis('equal')  # 使饼图为正圆形
    ax.set_title(f'{title}\n 1: {one_ratio:.2%}')


def generate_random_arrays(n):
    """
    生成n个随机数组，每个数组中有且只有一个1，其他全是0。

    参数:
    n (int): 需要生成的数组数量。

    返回:
    list: 包含n个随机数组的列表。
    """
    arrays = []
    arr_index = []
    for _ in range(n):
        # 创建一个全为0的数组
        array = [0, 0, 0]
        # 随机选择一个位置插入1
        one_position = random.randint(0, 2)
        array[one_position] = 1
        # 将生成的数组添加到列表中
        arrays.append(array)
        arr_index.append(one_position)
    return arrays, arr_index


def remove_value_from_array(array, value):
    """
    从数组中删除指定的值，如果存在则删除，并返回删除后的数组。

    参数:
    array (list): 输入的数组。
    value: 需要删除的值。

    返回:
    list: 删除指定值后的数组。
    """
    # 创建原数组的副本
    array_copy = array[:]

    if value in array_copy:
        array_copy.remove(value)
    return array_copy


def person_random_index(n):
    """
    生成n个随机数组，每个数组中有且只有一个1，其他全是0。

    参数:
    n (int): 需要生成的数组数量。

    返回:
    list: 包含n个随机数组的列表。
    """
    arrays = []
    for _ in range(n):
        one_position = random.randint(0, 2)
        arrays.append(one_position)
    return arrays


def exclude_data(a, b, c):
    base_arr = [0, 1, 2]
    index_arr = []
    for i in range(len(a)):
        if b[i] != c[i]:
            a1 = remove_value_from_array(base_arr, b[i])
            a2 = remove_value_from_array(a1, c[i])
            a[i][a2[0]] = -1
            index_arr.append(a2[0])
        else:
            a1 = remove_value_from_array(base_arr, b[i])
            j = a1[random.randint(0, 1)]
            a[i][j] = -1
            index_arr.append(j)
    return a, index_arr


def change_choose(a, b):
    base_arr = [0, 1, 2]
    index_arr = []
    for i in range(len(a)):
        a1 = remove_value_from_array(base_arr, a[i])
        a2 = remove_value_from_array(a1, b[i])
        index_arr.append(a2[0])
    return index_arr


def print_ret(a, b, c, t, x):
    arr_ret = []
    for i in range(len(a)):
        if b[i] == c[i]:
            arr_ret.append(1)
        else:
            arr_ret.append(0)
    plot_one_ratio(arr_ret, x, t)


if __name__ == '__main__':
    num = 1000000
    # 生成原始数据
    data, data_index = generate_random_arrays(num)
    # 人选
    person_choose = person_random_index(num)
    # 排除
    exclude_ret, exclude_index = exclude_data(data, person_choose, data_index)
    # 换选择
    switch_index = change_choose(person_choose, exclude_index)
    # 不换选择
    # 创建一个图形和子图
    fig, axes = plt.subplots(1, 2, figsize=(15, 5))
    print_ret(data, data_index, switch_index, 'choose', axes[0])
    print_ret(data, data_index, person_choose, 'not choose', axes[1])
    plt.show()
