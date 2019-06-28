package com.qitech.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author LiuXin
 */
@Slf4j
public class HttpUtils {

    private final static String OPERATER_NAME = "【HTTP操作】";

    private final static int SUCCESS = 200;

    public final static String UTF8 = "UTF-8";

    private HttpClient client;

    private static HttpUtils instance = new HttpUtils();

    /**
     * 私有化构造器
     */
    private HttpUtils() {

        HttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = httpConnectionManager.getParams();
        params.setConnectionTimeout(5000);
        params.setSoTimeout(20000);
        params.setDefaultMaxConnectionsPerHost(1000);
        params.setMaxTotalConnections(1000);
        client = new HttpClient(httpConnectionManager);
        client.getParams().setContentCharset(UTF8);
        client.getParams().setHttpElementCharset(UTF8);
    }

    /**
     * get请求
     */
    public static String get(URL url) {
        return instance.doGet(url);
    }

    /**
     * @param s 需要转换的中文URL
     * @return 编译成功，返回URL码
     */
    public static String chineseToUrls(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    //指定需要的编码类型
                    b = String.valueOf(c).getBytes(StandardCharsets.UTF_8);
                } catch (Exception ex) {
                    b = new byte[0];
                }
                for (int value : b) {
                    int k = value;
                    if (k < 0) {
                        k += 256;
                    }
                    sb.append("%").append(Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

    /**
     * POST请求
     */
    public static String post(URL url, String content) {
        return instance.doPost(url, content);
    }

    private String doPost(URL url, String content) {
        long beginTime = System.currentTimeMillis();
        String respStr = StringUtils.EMPTY;
        try {
            log.info(OPERATER_NAME + "开始post通信，目标host:" + url.toString());
            log.info("通信内容:" + content);
            PostMethod post = new PostMethod(url.toString());
            RequestEntity requestEntity = new StringRequestEntity(content, "application/json", UTF8);
            post.setRequestEntity(requestEntity);
            // 设置格式
            post.getParams().setContentCharset(UTF8);

            client.executeMethod(post);
            if (post.getStatusCode() == SUCCESS) {
                respStr = post.getResponseBodyAsString();
            }

            log.info(OPERATER_NAME + "通讯完成，返回码：" + post.getStatusCode());
            log.info(OPERATER_NAME + "返回内容：" + post.getResponseBodyAsString());
            log.info(OPERATER_NAME + "结束..返回结果:" + respStr);
            post.releaseConnection();

        } catch (Exception e) {
            log.error(OPERATER_NAME, e);
        }
        long endTime = System.currentTimeMillis();
        log.info(OPERATER_NAME + "共计耗时:" + (endTime - beginTime) + "ms");
        return respStr;
    }

    private String doGet(URL url) {
        long beginTime = System.currentTimeMillis();
        String respStr = StringUtils.EMPTY;
        try {
            log.info(OPERATER_NAME + "开始get通信，目标host:" + url);
            HttpMethod method = new GetMethod(url.toString());
            // 中文转码
            method.getParams().setContentCharset(UTF8);
            try {
                client.executeMethod(method);
            } catch (HttpException e) {
                log.error("发送HTTP GET给\r\n" + url + "\r\nHTTP异常\r\n", e);
            } catch (IOException e) {

                log.error("发送HTTP GET给\r\n" + url + "\r\nIO异常\r\n", e);
            }
            if (method.getStatusCode() == SUCCESS) {
                respStr = method.getResponseBodyAsString();
            }
            // 释放连接
            method.releaseConnection();

            log.info(OPERATER_NAME + "通讯完成，返回码：" + method.getStatusCode());
            log.info(OPERATER_NAME + "返回内容：" + method.getResponseBodyAsString());
            log.info(OPERATER_NAME + "结束..返回结果:" + respStr);
        } catch (Exception e) {
            log.info(OPERATER_NAME, e);
        }
        long endTime = System.currentTimeMillis();
        log.info(OPERATER_NAME + "共计耗时:" + (endTime - beginTime) + "ms");

        return respStr;
    }

}
