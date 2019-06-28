package com.qitech.constant;

/**
 * 静态常量类
 *
 * @author baojian
 * @date 2018/8/28
 * @time 21:00
 */
public final class GlobalConstants {

    private GlobalConstants() {
    }

    /**
     * jwt 授权Header
     */
    public static final String AUTHORIZATION_HEADER = "Authorization";


    public static final String BEARER = "Bearer ";

    public static final String AUTHORITIES = "authorities";

    public static final String XML_HTTP_REQUEST = "XMLHttpRequest";

    /**
     * 英文逗号 ,
     */
    public static final String COMMA = ",";
    /**
     * 英文 .
     */
    public static final String DOT = ".";
    /**
     * 冒号 :
     */
    public static final String COLON = ":";
    /**
     * 双冒号 ::
     */
    public static final String DOUBLE_COLON = "::";
    /**
     * 横线 -
     */
    public static final String HORIZONTAL_LINE = "-";
    /**
     * true
     */
    public static final String TRUE = "true";
    /**
     * ok
     */
    public static final String OK = "ok";
    
    /**
     * 当前用户
     */
    public static final String CURRENT_USER = "CURRENT_USER";

    /**
     * zuul header 传输用户名
     */
    public static final String HEADER_LOGIN_NAME = "HEADER_LOGIN_NAME";

    /**
     * zuul header 传输用户角色
     */
    public static final String HEADER_USER_ROLE = "HEADER_USER_ROLE";

    public static final String ID_PARAMS_NOLL_MSG = "id参数不能为空";
    /**
     * 请求返回成功
     */
    public static  final int REQ_SUCCESS_CODE = 0;

    public static final String DEL_FLAG_FALSE = "0";

    public static final String DEL_FLAG_TRUE = "1";

    public static final String ALARM = "alarm";

    public static final String MONITORING = "monitoring";

    public static final String ACCESS = "access";

    public static final String MSGACCESS = "门禁接口日志";

    public static final String MSGMONITORING = "涉密监控接口日志";

    public static final String MSGALARM = "报警主机接口日志";

    public final static String PHONE_PREFIX = "sms:phone:%s";
    /**
     * redis key begin
     */

    public final static String FIRE_CONTROLS_REDIS_KEY = "jobs:fire:control";

    public final static String SYS_FIRE_SAFETY_EQU_NODE_REDIS_KEY = "jobs:sys:fire:safety:equ:node";

    public final static String JOBS_EQU_NODE = "jobs:equ:node";

    public final static String LOCKED = "jobs:locked";

    /**
     * 视频回放token存储
     */
    public final static String VIDEO_TOKEN = "video:playback:token:%s";

    /**
     * server dt redis 同步锁
     */
    public final static String SERVER_DT_LOCKED = "video:playback:token:%s";

    /**
     * 记录消防报警消息上报，过滤短时间内重复上报报警
     */
    public final static String ALARM_REPORT_MSG = "alarm:report:%s";

    /**
     * 用户信息
     */
    public final static String LOGIN_USER = "sys:user";

    public final static String SYS_MENU = "sys:menu";
    public final static String SYS_MENU_TREE_LIST = "sys:menu:tree:list";

}
