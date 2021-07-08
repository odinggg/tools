import imghdr
import os

import cv2
import numpy as np

from constant import passersby
from logger import get_logger

logger = get_logger()


def get_image_file_list(img_file):
    images_lists = []
    if img_file is None or not os.path.exists(img_file):
        raise Exception("not found any img file in {}".format(img_file))

    img_end = {'jpg', 'bmp', 'png', 'jpeg', 'rgb', 'tif', 'tiff', 'gif', 'GIF'}
    if os.path.isfile(img_file) and imghdr.what(img_file) in img_end:
        images_lists.append(img_file)
    elif os.path.isdir(img_file):
        for single_file in os.listdir(img_file):
            file_path = os.path.join(img_file, single_file)
            if os.path.isfile(file_path) and imghdr.what(file_path) in img_end:
                images_lists.append(file_path)
    if len(images_lists) == 0:
        raise Exception("not found any img file in {}".format(img_file))
    images_lists = sorted(images_lists)
    return images_lists


def crop_img_and_gray(img_file, save_path="/tmp/cropImg/"):
    img_list = get_image_file_list(img_file)
    for idx, image_file in enumerate(img_list):
        img = cv2.imread(image_file)
        dsg = img[passersby.get("imagePoints").get("p2").get("x"):passersby.get("imagePoints").get("p2").get("y"),
              passersby.get("imagePoints").get("p1").get("x"):passersby.get("imagePoints").get("p1").get("y")]
        if not os.path.exists(save_path):
            os.makedirs(save_path)
        gray_path = os.path.join(save_path, "gray/")
        if not os.path.exists(gray_path):
            os.makedirs(gray_path)
        file_name = save_path + str(idx) + ".png"
        gray_file_name = gray_path + str(idx) + ".png"
        tmp = dsg.copy()
        gray = cv2.cvtColor(tmp, cv2.COLOR_BGR2GRAY)
        cv2.imwrite(file_name, dsg)
        cv2.imwrite(gray_file_name, gray)
        logger.info("The visualized image saved in {}".format(file_name))


def crop_gray(img_file, save_path="/tmp/cropImg/"):
    img_list = get_image_file_list(img_file)
    for idx, image_file in enumerate(img_list):
        img = cv2.imread(image_file)
        dsg = img[passersby.get("imagePoints").get("p2").get("x"):passersby.get("imagePoints").get("p2").get("y"),
              passersby.get("imagePoints").get("p1").get("x"):passersby.get("imagePoints").get("p1").get("y")]
        if not os.path.exists(save_path):
            os.makedirs(save_path)
        tmp = dsg.copy()
        gray = cv2.cvtColor(tmp, cv2.COLOR_BGR2GRAY)
        file_name = save_path + str(idx) + ".png"
        cv2.imwrite(file_name, gray)


def crop_gray_point(img, point):
    tmp = img.copy()
    crop = tmp[point[1][0]:point[1][1], point[0][0]:point[0][1]]
    gray = cv2.cvtColor(crop, cv2.COLOR_BGR2GRAY)
    return gray


def ssim(img1, img2):
    c1 = (0.01 * 255) ** 2
    c2 = (0.03 * 255) ** 2
    img1 = img1.astype(np.float64)
    img2 = img2.astype(np.float64)
    kernel = cv2.getGaussianKernel(11, 1.5)
    window = np.outer(kernel, kernel.transpose())
    mu1 = cv2.filter2D(img1, -1, window)[5:-5, 5:-5]  # valid
    mu2 = cv2.filter2D(img2, -1, window)[5:-5, 5:-5]
    mu1_sq = mu1 ** 2
    mu2_sq = mu2 ** 2
    mu1_mu2 = mu1 * mu2
    sigma1_sq = cv2.filter2D(img1 ** 2, -1, window)[5:-5, 5:-5] - mu1_sq
    sigma2_sq = cv2.filter2D(img2 ** 2, -1, window)[5:-5, 5:-5] - mu2_sq
    sigma12 = cv2.filter2D(img1 * img2, -1, window)[5:-5, 5:-5] - mu1_mu2
    ssim_map = ((2 * mu1_mu2 + c1) * (2 * sigma12 + c2)) / ((mu1_sq + mu2_sq + c1) *
                                                            (sigma1_sq + sigma2_sq + c2))
    return ssim_map.mean()


def calculate_ssim(img1, img2):
    """calculate SSIM
    the same outputs as MATLAB's
    img1, img2: [0, 255]
    """
    if not img1.shape == img2.shape:
        print(img1.shape)
        print(img2.shape)
        raise ValueError('Input images must have the same dimensions.')
    if img1.ndim == 2:
        return ssim(img1, img2)
    elif img1.ndim == 3:
        if img1.shape[2] == 3:
            sims = []
            for i in range(3):
                sims.append(ssim(img1, img2))
            return np.array(sims).mean()
        elif img1.shape[2] == 1:
            return ssim(np.squeeze(img1), np.squeeze(img2))
    else:
        raise ValueError('Wrong input image dimensions.')


def detect_circle_save(file_path, save_path):
    if not os.path.exists(save_path):
        os.makedirs(save_path)
    img = cv2.imread(file_path, 0)
    triangle = np.array([[370, 150], [534, 150], [534, 370], [370, 370]])
    cv2.fillConvexPoly(img, triangle, (255, 255, 255))
    circles = cv2.HoughCircles(img, cv2.HOUGH_GRADIENT, 1, 10, np.array([]), 100, 50, 10, 40)
    circles = np.uint16(np.around(circles))
    if circles.size == 0:
        return ""
    print(circles)
    for i in circles[0, :]:
        # draw the outer circle
        cv2.circle(img, (i[0], i[1]), i[2], (0, 255, 0), 2)
        # draw the center of the circle
        cv2.circle(img, (i[0], i[1]), 2, (0, 0, 255), 3)
    result_file = os.path.join(save_path, os.path.basename(file_path))
    cv2.imwrite(result_file, img)
    return result_file


def detect_circle(img):
    tmp = img.copy()
    img = cv2.cvtColor(tmp, cv2.COLOR_BGR2GRAY)
    img = img[passersby.get("imagePoints").get("p2").get("x"):passersby.get("imagePoints").get("p2").get("y"),
          passersby.get("imagePoints").get("p1").get("x"):passersby.get("imagePoints").get("p1").get("y")]
    triangle = np.array([[370, 150], [534, 150], [534, 370], [370, 370]])
    cv2.fillConvexPoly(img, triangle, (255, 255, 255))
    circles = cv2.HoughCircles(img, cv2.HOUGH_GRADIENT, 1, 10, np.array([]), 100, 50, 10, 40)
    circles = np.uint16(np.around(circles))
    data = dict()
    # 取最大半径的圆点
    for index, i in enumerate(circles[0, :]):
        data[i[2]] = [i[0] + passersby.get("imagePoints").get("p1").get("x"),
                      i[1] + passersby.get("imagePoints").get("p1").get("y")]
    point = data[max(data.keys())]
    return point
