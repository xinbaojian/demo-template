package com.qitech.utils;

import com.qitech.enums.ResponseErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: micro-parent
 * @description: 统一结果生成方式
 * @author: xin.bj
 * @create: 2018-08-25 10:04
 **/
@SuppressWarnings("unchecked")
public class RestResultGenerator {

    private RestResultGenerator() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResultGenerator.class);

    /**
     * 生成响应成功(带正文)的结果
     *
     * @param data    结果正文
     * @param message 成功提示信息
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> genResult(T data, String message) {
        ResponseResult<T> result = ResponseResult.getInstance();
        result.setSuccess(true);
        result.setData(data);
        result.setMessage(message);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("--------> result:{}", GsonUtils.toJson(result));
        }
        return result;
    }

    /**
     * 生成响应失败(带errorCode)的结果
     *
     * @param responseErrorEnum 失败信息
     * @return ResponseResult
     */
    public static ResponseResult genErrorResult(ResponseErrorEnum responseErrorEnum) {
        ResponseResult result = ResponseResult.getInstance();
        result.setSuccess(false);
        result.setErrorInfo(responseErrorEnum);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("--------> result:{}", GsonUtils.toJson(result));
        }
        return result;
    }
}
