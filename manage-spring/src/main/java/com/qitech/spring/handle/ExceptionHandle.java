package com.qitech.spring.handle;

import com.qitech.spring.exception.InvalidJwtAuthenticationException;
import com.qitech.spring.exception.InvalidUsernameOrPwdException;
import com.qitech.spring.exception.NoAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: micro-parent
 * @description: 异常处理类
 * @author: xin.bj
 * @create: 2018-09-13 13:24
 **/
@ControllerAdvice
public class ExceptionHandle {


    private static final String ERROR_404 = "error/404";

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionHandle(Exception e) {
        if (e instanceof NoAccountException) {
            return new ResponseEntity<>("找不到用户", HttpStatus.NOT_FOUND);
        } else if (e instanceof InvalidJwtAuthenticationException) {
            return new ResponseEntity<>("JWToken 无效", HttpStatus.UNAUTHORIZED);
        } else if (e instanceof InvalidUsernameOrPwdException) {
            return new ResponseEntity<>("用户名或密码错误", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
