package com.qitech.websocket.controller;

import com.qitech.constant.UrlConstants;
import com.qitech.websocket.endpoint.PublishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xin.bj
 * @program security-parent
 * @description WebSocket Controller 接口
 * @create 2019-04-11 16:36
 **/
@Api(value = UrlConstants.ROOT_URL + "/socket", tags = "WebSocket接口管理")
@Slf4j
@RestController
@RequestMapping(UrlConstants.ROOT_URL + "/socket")
public class WebSocketController {

    @ApiOperation(value = "群发Socket消息")
    @GetMapping("/send")
    public ResponseEntity sendMsg(@ApiParam(name = "channel", value = "频道", required = true) @RequestParam(name = "channel") String channel,
                                  @ApiParam(name = "msg", value = "消息", required = true) @RequestParam(name = "msg") String msg) {
        PublishService ps = new PublishService();
        ps.publish(channel, msg);
        return new ResponseEntity(HttpStatus.OK);
    }
}
