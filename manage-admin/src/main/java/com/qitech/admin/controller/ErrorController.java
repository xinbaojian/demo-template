package com.qitech.admin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: micro-parent
 * @description: 错误跳转Controller
 * @author: xin.bj
 * @create: 2018-09-13 11:17
 **/
@Controller
public class ErrorController {

    /**
     * 403 无权限页面
     *
     * @return
     */
    @RequestMapping(value = "/403")
    public ResponseEntity<String> noPermission() {
        return new ResponseEntity<>("403", HttpStatus.FORBIDDEN);
    }

    /**
     * 404 找不到页面
     *
     * @return
     */
    @RequestMapping(value = "/404")
    public ResponseEntity<String> noPage() {
        return new ResponseEntity<>("404", HttpStatus.NOT_FOUND);
    }

    /**
     * 500服务器内部错误
     *
     * @return
     */
    @RequestMapping(value = "/500")
    public ResponseEntity<String> serviceError() {
        return new ResponseEntity<>("500", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
