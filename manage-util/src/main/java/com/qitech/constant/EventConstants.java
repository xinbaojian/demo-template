package com.qitech.constant;

/**
 * @Author lyh
 * @Date 2018/11/13 0013
 * @Description 报警事件常量池
 */
public class EventConstants {
    /**
     * 布防事件类型1.人脸抓拍 2.定员 3.传感器
     */
    public static final int ALARM_TYPE1 = 1;
    public static final int ALARM_TYPE2 = 2;
    public static final int ALARM_TYPE3 = 3;

    /**
     * 布防名单类型1.白名单 0.黑名单
     */

    public static final String ALARM_TEAM_TYPE1 = "1";
    public static final String ALARM_TEAM_TYPE2 = "0";

    /**
     * 推送类型
     */
    public static final int PUSH_TYPE1 = 1;
    public static final int PUSH_TYPE2 = 2;
    public static final int PUSH_TYPE3 = 3;
    public static final int PUSH_TYPE4 = 4;
    public static final int PUSH_TYPE5 = 5;
    public static final int PUSH_TYPE6 = 6;
    public static final int PUSH_TYPE7 = 7;
    public static final int PUSH_TYPE8 = 8;

    /**
     * url 报警新增
     */
    public static final String ACTION_REPORT_ADD_URL = "http://192.168.25.73:8080/security_m/f/action/actionReport/save";

    public static final String H5SS_SESSION = "session=c1782caf-b670-42d8-ba90-2244d0b0ee83";

    public static  final String LV_ADD_PARAM="name=temp&token=TOKEN&user=temp&password=temp&url=URL&session=c1782caf-b670-42d8-ba90-2244d0b0ee83&playback=true";

    public static final String LV_CONN_AddSrcRTSPRUL = "http://192.168.6.21:8080/api/v1/AddSrcRTSP";

    public static final String LV_CONN_AddBackSrcRTSPRUL = "http://192.168.6.234:8080/api/v1/AddSrcRTSP";

    public static final String LV_CONN_AddSrcONVIFRUL = "http://192.168.6.21:8080/api/v1/AddSrcONVIF";
    /**
     * 删除H5视频源
     */
    public static final String DEL_VIDEO_SOURCE_URL = "http://192.168.6.21:8080/api/v1/DelSrc?token=%s&session=c1782caf-b670-42d8-ba90-2244d0b0ee83";
}


