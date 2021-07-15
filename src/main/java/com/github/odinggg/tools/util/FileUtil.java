package com.github.odinggg.tools.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 文件工具类
 */
public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void close(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
        } catch (Exception e) {
            logger.error(e.getMessage() == null ? e.toString() : e.getMessage());
        }
    }

    public static void MkDir(String filename) {
        File file = new File(filename);
        file.getParentFile().mkdirs();
    }

    /**
     * 将文件从offset开始的length数据按size分别读入readBuffers中
     *
     * @param filename
     * @param offset
     * @param length   为0 表示从offset开始到结尾
     * @return ByteBuffer[]
     * @throws IOException
     */
    public static ByteBuffer read2buffer(String filename, int offset, int length) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        FileChannel fileChannel = fileInputStream.getChannel();
        try {

            long fileSize = fileChannel.size();
            int realLength = (int) (offset == 0 ? (length == 0 ? Math.min(fileSize, Integer.MAX_VALUE) : Math.min(length, fileSize)) : (length == 0 ? Math
                    .min(fileSize - offset, Integer.MAX_VALUE) : Math.min(length, fileSize - offset)));
            ByteBuffer readBuffer = ByteBuffer.allocate(realLength);
            fileChannel.position(offset);
            fileChannel.read(readBuffer);
            readBuffer.flip();
            return readBuffer;
        } finally {
            if (fileChannel != null) close(fileChannel);
            if (fileInputStream != null) close(fileInputStream);
        }
    }

    public static boolean copy(File source, File dest, boolean preserveFileDate) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            try {
                inputStream = new FileInputStream(source);
                outputStream = new FileOutputStream(dest);
                inputChannel = inputStream.getChannel();
                outputChannel = outputStream.getChannel();
                outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
                if (preserveFileDate) {
                    dest.setLastModified(source.lastModified());
                }
                return true;
            } catch (IOException e) {
                logger.error(e.getMessage() == null ? e.toString() : e.getMessage());
                return false;
            }
        } finally {
            close(outputChannel);
            close(outputStream);
            close(inputChannel);
            close(inputStream);
        }
    }

    /**
     * @Description: 读整个文件到readBuffers中
     * @param: [filename, readBuffers, size]
     * @return: long
     * @author: Zhutaoshen
     * @Date: 2018-4-22
     */
    public static ByteBuffer read2buffer(String filename) throws IOException {
        return read2buffer(filename, 0, 0);
    }

    /**
     * @Description: 将文件从offset开始的length数据按size分别读入byte[]中
     * @param: [filename, readBytes, offset, length, size]
     * @return: long
     * @author: Zhutaoshen
     * @Date: 2018-4-22
     */
    public static byte[] read(String filename, int offset, int length) throws IOException {
        ByteBuffer readBuffer = read2buffer(filename, offset, length);
        byte[] readBytes = new byte[readBuffer.remaining()];
        readBuffer.get(readBytes);
        return readBytes;
    }

    /**
     * @Description: 读整个文件到byte[]
     * @param: [filename, readBytes]
     * @return: long
     * @author: Zhutaoshen
     * @Date: 2018-4-22
     */
    public static byte[] read(String filename) throws IOException {
        return read(filename, 0, 0);
    }

    /**
     * @Description: 判断文件是否存在
     * @param: [filename]
     * @return: java.lang.Boolean
     * @author: Zhutaoshen
     * @Date: 2018-4-22
     */
    public static Boolean isExists(String filename) {
        try {
            if (filename == null) return false;
            File file = new File(filename);
            return file.exists();
        } catch (Exception e) {
            logger.error(e.getMessage() == null ? e.toString() : e.getMessage());
            return false;
        }
    }

    /**
     * @Description: 获得文件大小
     * @param: [filename]
     * @return: long
     * @author: Zhutaoshen
     * @Date: 2018-4-22
     */
    public static long fileSize(String filename) {
        try {
            File file = new File(filename);
            return file.length();
        } catch (Exception e) {
            logger.error(e.getMessage() == null ? e.toString() : e.getMessage());
            return 0;
        }
    }

    public static List file2list(String filename) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            Object[] objects = (Object[]) objectInputStream.readObject();
            return new ArrayList(Arrays.asList(objects));
        } catch (Exception e) {
            if (filename.substring(filename.length() - 2).equals(".b") == false) {
                return file2list(filename + ".b");
            } else {
                return null;
            }
        }
    }

    public static void list2file(List list, String filename) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
            objectOutputStream.writeObject(list.toArray());
            objectOutputStream.close();
            copy(new File(filename), new File(filename + ".b"), true);
        } catch (Exception e) {
        }
    }

    public static boolean rename(String oldfilename, String newfilename) {
        File oldFile = new File(oldfilename);
        if (!oldFile.exists()) return false;
        File newFile = new File(newfilename);
        return oldFile.renameTo(newFile);
    }

    public static String getParentPath(File file) {
        return file.getParent();
    }

    public static void scanDirFile(File dir, List paths, String exts) {
        try {
            if (dir == null) return;
            if (!dir.exists() || !dir.isDirectory()) return;
            File[] files = dir.listFiles();
            if (files.length >= 0) {
                List<Map<String, String>> fileList = new ArrayList<Map<String, String>>();
                List<Map<String, Map>> dirList = new ArrayList<Map<String, Map>>();
                Map map = new HashMap();
                map.put("name", dir.getName());
                map.put("file", fileList);
                map.put("path", dirList);
                paths.add(map);
                for (File file : files) {
                    if (file.isDirectory()) {
                        scanDirFile(file, dirList, exts);
                    } else {
                        if (exts == null || exts.indexOf(file.getName()
                                .substring(file.getName().lastIndexOf(".") + 1) + ";") >= 0) {
                            Map fileMap = new HashMap();
                            fileMap.put("name", file.getName());
                            fileList.add(fileMap);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static Map scanDirFile(String path, String exts) {
        try {
            List<Map> paths = new ArrayList<Map>();
            scanDirFile(new File(path), paths, exts);
            if (paths.size() > 0) {
                return paths.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean write(String fileName, byte[] data, boolean append) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileName, append);
            outputStream.write(data);
            outputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage() == null ? e.toString() : e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage() == null ? e.toString() : e.getMessage());
        }
        return false;
    }
}
