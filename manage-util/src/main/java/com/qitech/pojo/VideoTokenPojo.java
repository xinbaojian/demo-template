package com.qitech.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author xin.bj
 * @program security-parent
 * @description 视频回放token Pojo
 * @create 2019-04-14 10:09
 **/
@Data
@Accessors(chain = true)
public class VideoTokenPojo {

    /**
     * token
     */
    private String token;

    /**
     * 用户JWToken信息
     */
    private String authorization;

    /**
     * 生成token时间
     */
    private Date date;
}
