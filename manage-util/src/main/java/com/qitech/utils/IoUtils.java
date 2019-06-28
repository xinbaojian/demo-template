package com.qitech.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @program: micro-parent
 * @description: 数据流工具类
 * @author: xin.bj
 * @create: 2018-08-25 14:27
 **/
public class IoUtils extends org.apache.commons.io.IOUtils {

    private static Logger logger = LoggerFactory.getLogger(IoUtils.class);

    private static final String ERROR_MSG = "错误信息:文件不存在";

    /**
     * 根据文件路径创建文件输入流处理 以字节为单位（非 unicode ）
     *
     * @param filepath
     * @return
     */
    public static FileInputStream getFileInputStream(String filepath) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            logger.error(ERROR_MSG, e);
        }
        return fileInputStream;
    }

    /**
     * 根据文件对象创建文件输入流处理 以字节为单位（非 unicode ）
     *
     * @param file
     * @return
     */
    public static FileInputStream getFileInputStream(File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            logger.error(ERROR_MSG, e);
        }
        return fileInputStream;
    }

    /**
     * 根据文件对象创建文件输出流处理 以字节为单位（非 unicode ）
     *
     * @param file
     * @param append true:文件以追加方式打开,false:则覆盖原文件的内容
     * @return
     */
    public static FileOutputStream getFileOutputStream(File file, boolean append) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, append);
        } catch (FileNotFoundException e) {
            logger.error(ERROR_MSG, e);
        }
        return fileOutputStream;
    }

    /**
     * 根据文件路径创建文件输出流处理 以字节为单位（非 unicode ）
     *
     * @param filepath
     * @param append   true:文件以追加方式打开,false:则覆盖原文件的内容
     * @return
     */
    public static FileOutputStream getFileOutputStream(String filepath, boolean append) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filepath, append);
        } catch (FileNotFoundException e) {
            logger.error(ERROR_MSG, e);
        }
        return fileOutputStream;
    }
}
