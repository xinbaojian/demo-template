package com.qitech.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @program: micro-parent
 * @description: 时间工具类
 * @author: xin.bj
 * @create: 2018-08-25 14:29
 **/
@Slf4j
public class TimeUtils {

    private static final long ONE_THOUSAND = 1000L;

    private static final int TEN = 10;

    /**
     * 1小时的毫秒数
     */
    private static final int TOTAL_MILLIS_OF_HOUR = 3600000;

    /**
     * 一分钟的毫秒数
     */
    private static final int TOTAL_MILLIS_OF_MINUTE = 60000;

    private static final int HOUR_OF_DAY = 24;

    private static final int FOUR = 4;

    private static final int SIXTY = 4;


    /**
     * 将过去的时间转为为，刚刚，xx秒，xx分钟，xx小时前、xx天前，大于3天的显示日期
     */
    public static String formatTimeAgo(String dateTime) {
        return formatTimeAgo(DateUtil.parseDate(dateTime));
    }

    /**
     * 将过去的时间转为为，刚刚，xx秒，xx分钟，xx小时前、xx天前，大于3天的显示日期
     */
    public static String formatTimeAgo(Date dateTime) {
        String interval;
        // 得出的时间间隔是毫秒
        long time = System.currentTimeMillis() - dateTime.getTime();
        // 如果时间间隔小于10秒则显示“刚刚”time/10得出的时间间隔的单位是秒
        if (time / ONE_THOUSAND < TEN && time / ONE_THOUSAND >= 0) {
            interval = "刚刚";
        }
        // 如果时间间隔大于24小时则显示多少天前
        else if (time / TOTAL_MILLIS_OF_HOUR < HOUR_OF_DAY * FOUR && time / TOTAL_MILLIS_OF_HOUR >= HOUR_OF_DAY) {
            // 得出的时间间隔的单位是天
            int d = (int) (time / (TOTAL_MILLIS_OF_HOUR * HOUR_OF_DAY));
            interval = d + "天前";
        }
        // 如果时间间隔小于24小时则显示多少小时前
        else if (time / TOTAL_MILLIS_OF_HOUR < HOUR_OF_DAY && time / TOTAL_MILLIS_OF_HOUR >= 1) {
            // 得出的时间间隔的单位是小时
            int h = (int) (time / TOTAL_MILLIS_OF_HOUR);
            interval = h + "小时前";
        }
        // 如果时间间隔小于60分钟则显示多少分钟前
        else if (time / TOTAL_MILLIS_OF_MINUTE < SIXTY && time / TOTAL_MILLIS_OF_MINUTE >= 1) {
            // 得出的时间间隔的单位是分钟
            int m = (int) ((time % TOTAL_MILLIS_OF_HOUR) / TOTAL_MILLIS_OF_MINUTE);
            interval = m + "分钟前";
        }
        // 如果时间间隔小于60秒则显示多少秒前
        else if (time / ONE_THOUSAND < SIXTY && time / ONE_THOUSAND >= TEN) {
            int se = (int) ((time % 60000) / 1000);
            interval = se + "秒前";
        }
        // 大于3天的，则显示正常的时间，但是不显示秒
        else {
            interval = DateUtil.formatDate(dateTime, "yyyy-MM-dd");
        }
        return interval;
    }

    /**
     * 时间字段常量，表示“秒”
     */
    public static final int SECOND = 0;

    /**
     * 时间字段常量，表示“分”
     */
    public static final int MINUTE = 1;

    /**
     * 时间字段常量，表示“时”
     */
    public static final int HOUR = 2;

    /**
     * 时间字段常量，表示“天”
     */
    public static final int DAY = 3;

    /**
     * 各常量允许的最大值
     */
    private static final int[] MAX_FIELDS = {59, 59, 23, Integer.MAX_VALUE - 1};

    /**
     * 各常量允许的最小值
     */
    private static final int[] MINFIELDS = {0, 0, 0, Integer.MIN_VALUE};

    /**
     * 默认的字符串格式时间分隔符
     */
    private String timeSeparator = ":";

    /**
     * 时间数据容器
     */
    private int[] fields = new int[4];

    /**
     * 无参构造，将各字段置为 0
     */
    public TimeUtils() {
        this(0, 0, 0, 0);
    }

    /**
     * 使用时、分构造一个时间
     *
     * @param hour   小时
     * @param minute 分钟
     */
    public TimeUtils(int hour, int minute) {
        this(0, hour, minute, 0);
    }

    /**
     * 使用时、分、秒构造一个时间
     *
     * @param hour   小时
     * @param minute 分钟
     * @param second 秒
     */
    public TimeUtils(int hour, int minute, int second) {
        this(0, hour, minute, second);
    }


    /**
     * 使用天、时、分、秒构造时间，进行全字符的构造
     *
     * @param day    天
     * @param hour   时
     * @param minute 分
     * @param second 秒
     */
    public TimeUtils(int day, int hour, int minute, int second) {
        initialize(day, hour, minute, second);
    }


    /**
     * 设置时间字段的值
     *
     * @param field 时间字段常量
     * @param value 时间字段的值
     */
    public void set(int field, int value) {
        if (value < MINFIELDS[field]) {
            throw new IllegalArgumentException(value + ", time value must be positive.");
        }
        fields[field] = value % (MAX_FIELDS[field] + 1);
        // 进行进位计算
        int carry = value / (MAX_FIELDS[field] + 1);
        if (carry > 0) {
            int upFieldValue = get(field + 1);
            set(field + 1, upFieldValue + carry);
        }
    }

    /**
     * 获得时间字段的值
     *
     * @param field 时间字段常量
     * @return 该时间字段的值
     */
    public int get(int field) {
        if (field < 0 || field > fields.length - 1) {
            throw new IllegalArgumentException(field + ", field value is error.");
        }
        return fields[field];
    }

    /**
     * 将时间进行“加”运算，即加上一个时间
     *
     * @param time 需要加的时间
     * @return 运算后的时间
     */
    public TimeUtils addTime(TimeUtils time) {
        TimeUtils result = new TimeUtils();
        // 进位标志
        int up = 0;
        for (int i = 0; i < fields.length; i++) {
            int sum = fields[i] + time.fields[i] + up;
            up = sum / (MAX_FIELDS[i] + 1);
            result.fields[i] = sum % (MAX_FIELDS[i] + 1);
        }
        return result;
    }

    /**
     * 将时间进行“减”运算，即减去一个时间
     *
     * @param time 需要减的时间
     * @return 运算后的时间
     */
    public TimeUtils subtractTime(TimeUtils time) {
        TimeUtils result = new TimeUtils();
        // 退位标志
        int down = 0;
        for (int i = 0, k = fields.length - 1; i < k; i++) {
            int difference = fields[i] + down;
            if (difference >= time.fields[i]) {
                difference -= time.fields[i];
                down = 0;
            } else {
                difference += MAX_FIELDS[i] + 1 - time.fields[i];
                down = -1;
            }
            result.fields[i] = difference;
        }
        result.fields[DAY] = fields[DAY] - time.fields[DAY] + down;
        return result;
    }

    /**
     * 获得时间字段的分隔符
     *
     * @return
     */
    public String getTimeSeparator() {
        return timeSeparator;
    }

    /**
     * 设置时间字段的分隔符（用于字符串格式的时间）
     *
     * @param timeSeparator 分隔符字符串
     */
    public void setTimeSeparator(String timeSeparator) {
        this.timeSeparator = timeSeparator;
    }

    private void initialize(int day, int hour, int minute, int second) {
        set(DAY, day);
        set(HOUR, hour);
        set(MINUTE, minute);
        set(SECOND, second);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append(fields[DAY]).append(',').append(' ');
        buildString(sb, HOUR).append(timeSeparator);
        buildString(sb, MINUTE).append(timeSeparator);
        buildString(sb, SECOND);
        return sb.toString();
    }

    private StringBuilder buildString(StringBuilder sb, int field) {
        if (fields[field] < TEN) {
            sb.append('0');
        }
        return sb.append(fields[field]);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(fields);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimeUtils other = (TimeUtils) obj;
        return Arrays.equals(fields, other.fields);
    }

    /**
     * 校验两组时间范围是否有重合冲突部分
     *
     * @param list 要检验的时间范围
     * @param dist 比较的对象
     * @return true 有重合冲突 false 无重合冲突
     */
    public static Boolean rangeConflict(List<String> list, List<String> dist) {
        if (list == null || list.isEmpty() || dist == null || dist.isEmpty()) {
            return false;
        }
        for (String time : list) {
            for (String distTime : dist) {
                if (coincide(splitTime(time), splitTime(distTime))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 分割时间段
     *
     * @param time 要分割的时间段 如：13:00:00 - 18:00:00
     * @return
     */
    public static Date[] splitTime(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            String[] times = time.split(" - ");
            return new Date[]{format.parse(times[0]), format.parse(times[1])};
        } catch (ParseException e) {
            log.error("转换时间时出错了", e);
        }
        return new Date[0];
    }

    public static Boolean coincide(Date[] date, Date[] dist) {
        return (date[0].after(dist[0]) || date[0].before(dist[1])) || (date[1].after(dist[0]) || date[1].before(dist[1]));
    }

    public static Boolean containsTime(Date date, Date[] dist) {
        return dist[0].before(date) && dist[1].after(date);
    }

    public static Boolean containsTime(String time, String dist) {
        try {
            if (StringUtil.isBlank(time) || StringUtil.isBlank(dist)){
                return false;
            }
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date date = format.parse(time);
            String[] times = dist.split(" - ");
            Date[] distDate = new Date[]{format.parse(times[0]), format.parse(times[1])};
            return containsTime(date, distDate);
        } catch (ParseException e) {
            log.error("转换日期出错了", e);
        }
        return false;
    }

    public static String getDateTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(date);
    }

}
