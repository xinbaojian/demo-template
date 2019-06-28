package com.qitech.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author xin.bj
 * @program security-parent
 * @description ping 某个IP
 * @create 2019-03-17 15:39
 **/
@Slf4j
public class PingUtils {

    private static Runtime runtime = Runtime.getRuntime();

    public static Boolean ping(String ip) {
        // 声明处理类对象
        Process process;
        // 返回行信息
        String line;
        // 输入流
        InputStream is = null;
        // 字节流
        InputStreamReader isr = null;
        BufferedReader br = null;

        Boolean result = Boolean.FALSE;
        Integer timeoutNums = 0;
        try {
            // PING
            process = runtime.exec(String.format("ping %s", ip));
            // 实例化输入流
            is = process.getInputStream();
            // 把输入流转换成字节流
            isr = new InputStreamReader(is);
            // 从字节中读取文本
            br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                log.info(line);
                if (line.toLowerCase().contains("ttl")) {
                    result = Boolean.TRUE;
                    log.info(String.format("%s 在线", ip));
                    break;
                }else{
                    timeoutNums++;
                }
                if (timeoutNums >= 10){
                    log.info(String.format("%s 离线", ip));
                    break;
                }
            }
        } catch (Exception e) {
            log.error(String.format("IP: %s ping......失败", ip));
            runtime.exit(1);
        } finally {
            try {
                is.close();
                isr.close();
                br.close();
            } catch (IOException e) {
                log.error("关闭流出错了", e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //test
        System.out.println(PingUtils.ping("192.168.6.128"));
    }

}
