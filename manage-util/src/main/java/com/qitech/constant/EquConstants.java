package com.qitech.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author lyh
 */
public class EquConstants {
    /**
     * 海康实时流格式
     */
    public static final String HK_VIDEOADRESS = "rtsp://{username}:{password}@{ip}:554/h264/ch1/main/av_stream";
    /**
     * 大华实时流格式
     */
    public static final String DH_VIDEOADRESS = "rtsp://{username}:{password}@{ip}:554/cam/realmonitor?channel=1&subtype=0";
    /**
     * 大华DVS实时流格式
     */
    public static final String DVS_VIDEOADRESS = "rtsp://{username}:{password}@{ip}:554/cam/realmonitor?channel={channel}&subtype=0";
    /**
     * 紫川高清实时流格式
     */
    public static final String ZC1_VIDEOADRESS = "rtsp://{username:password@}{ip}:554/majorAV";
    /**
     * 紫川热成像海康实时流格式
     */
    public static final String ZC2_VIDEOADRESS = "rtsp://{username:password@}{ip}:554/bs0";
    /**
     * 华南球机实时流格式
     */
    public static final String HN1_VIDEOADRESS = "rtsp://%s:%s/channel=0;stream=0;user=%s;pass=%s;";
    /**
     * 华南网络摄像头实时流格式
     */
    public static final String HN2_VIDEOADRESS = "rtsp://%s:554/mpeg4";
    /**
     * 滨海安高清实时流格式
     */
    public static final String BHA1_VIDEOADRESS = "rtsp://%s:%s@%s:554/0";
    /**
     * 滨海安红外实时流格式
     */
    public static final String BHA2_VIDEOADRESS = "rtsp://%s:%s@%s:554/10";
    public static final ArrayList<String> HK_CONN_IDS = new ArrayList<String>() {{
        add("0b1e30f3a2e84245b72f9094e1210075");
    }};
    public static final ArrayList<String> DH_CONN_IDS = new ArrayList<String>() {{
        add("7b8445df1240402d98a486ab4c4136d4");
    }};
    public static final ArrayList<String> DVS_CONN_IDS = new ArrayList<String>() {{
        add("b4b0d616d6e649edaeca316b03616627");
    }};
    /**
     * 紫川热成像
     */
    public static final ArrayList<String> ZC1_CONN_IDS = new ArrayList<String>() {{
        add("e2ed9d0f3ab144079ee2c003d847eb85");
    }};
    /**
     * 紫川热高清
     */
    public static final ArrayList<String> ZC2_CONN_IDS = new ArrayList<String>() {{
        add("567f3d8d0d344a9286f74d2842aa3095");
    }};
    public static final ArrayList<String> ONVIF_IDS = new ArrayList<String>() {{
        add("0b1e30f3a2e84245b72f9094e1210075");
    }};
    /**
     * 华南球机
     */
    public static final ArrayList<String> HN1_CONN_IDS = new ArrayList<String>() {{
        add("72971df1daaf4faa95869158c41c762c");
    }};
    /**
     * 华南网络摄像头
     */
    public static final ArrayList<String> HN2_CONN_IDS = new ArrayList<String>() {{
        add("678a9d61f33f4f029e50d07db3a8b028");
    }};
    /**
     * 滨海安高清
     */
    public static final ArrayList<String> BHA1_CONN_IDS = new ArrayList<String>() {{
        add("73752b7c8fe5454ca1f6631c28d5320b");
    }};
    /**
     * 滨海安红外
     */
    public static final ArrayList<String> BHA2_CONN_IDS = new ArrayList<String>() {{
        add("14896a73587146a8865f727b73cb28e3");
    }};
    public static final String NVR1_TYPE = "1";
    public static final String NVR2_TYPE = "2";
    public static final String NVR3_TYPE = "3";
    public static final String NVR4_TYPE = "4";
    public static final String NVR5_TYPE = "5";
    public static final String NVR6_TYPE = "6";
    public static final String NVR7_TYPE = "7";
    public static final List<String> NVRTYPES = asList(NVR1_TYPE,NVR2_TYPE,NVR3_TYPE,NVR4_TYPE,NVR5_TYPE,NVR6_TYPE,NVR7_TYPE);
    public static final String NVR1_BACKURL = "rtsp://admin:admin@192.168.6.27:554/cam/playback?channel={pass}&subtype=0";
    public static final String NVR2_BACKURL = "rtsp://admin:admin@192.168.6.29:554/cam/playback?channel={pass}&subtype=0";
    public static final String NVR3_BACKURL = "rtsp://admin:admin@192.168.6.31:554/cam/playback?channel={pass}&subtype=0";
    public static final String NVR4_BACKURL = "rtsp://test:admin@192.168.6.183:554/cam/playback?channel={pass}&subtype=0";
    public static final String NVR5_BACKURL = "rtsp://admin:admin12345@192.168.6.25:554/cam/playback?channel={pass}&subtype=0";
    public static final String NVR6_BACKURL = "rtsp://admin:admin12345@192.168.6.32:554/cam/playback?channel={pass}&subtype=0";
    public static final String NVR7_BACKURL = "rtsp://admin:admin12345@192.168.6.33:554/cam/playback?channel={pass}&subtype=0";
    public static final List<String> NVRURLS = asList(NVR1_BACKURL,NVR2_BACKURL,NVR3_BACKURL,NVR4_BACKURL,NVR5_BACKURL,NVR6_BACKURL,NVR7_BACKURL);
    public static String getNvrBackUrlByType(String type, String pass) {
        String nvrBackUrl = StringUtils.EMPTY;
        switch (type) {
            case "1":
                nvrBackUrl = NVR1_BACKURL;
                break;
            case "2":
                nvrBackUrl = NVR2_BACKURL;
                break;
            case "3":
                nvrBackUrl = NVR3_BACKURL;
                break;
            case "4":
                nvrBackUrl = NVR4_BACKURL;
                break;
            case "5":
                nvrBackUrl = NVR5_BACKURL;
                break;
            case "6":
                nvrBackUrl = NVR6_BACKURL;
                break;
            case "7":
                nvrBackUrl = NVR7_BACKURL;
                break;
            default:
                break;
        }
        if (StringUtils.isBlank(nvrBackUrl)){
            return nvrBackUrl;
        }
        if (StringUtils.isNotBlank(pass)) {
            return nvrBackUrl.replace("{pass}", pass);
        }
        return nvrBackUrl;
    }

    public static String getNvrBackUrlByType(String type) {
        return getNvrBackUrlByType(type, null);
    }

    public static void main(String[] args) {
        System.out.println(getNvrBackUrlByType("1"));
    }
}
