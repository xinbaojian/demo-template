package com.qitech.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @program: micro-parent
 * @description: 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @author: xin.bj
 * @create: 2018-08-25 14:30
 **/
public class DateUtil extends DateUtils {

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            DEFAULT_FORMAT, DEFAULT_FORMAT_TIME, "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM.dd HH", "yyyy.MM",
            "yyyy年MM月dd日", "yyyy年MM月dd日 HH时mm分ss秒", "yyyy年MM月dd日 HH时mm分", "yyyy年MM月dd日 HH时", "yyyy年MM月",
            "yyyy"};

    /**
     * 得到日期字符串 ，转换格式（yyyy-MM-dd）
     */
    public static String formatDate(Date date) {
        return formatDate(date, DEFAULT_FORMAT);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(long dateTime, String pattern) {
        return formatDate(new Date(dateTime), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, String pattern) {
        String formatDate = null;
        if (date != null) {
            if (StringUtils.isBlank(pattern)) {
                pattern = DEFAULT_FORMAT;
            }
            formatDate = FastDateFormat.getInstance(pattern).format(date);
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, DEFAULT_FORMAT_TIME);
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate(DEFAULT_FORMAT);
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return FastDateFormat.getInstance(pattern).format(new Date());
    }

    /**
     * 得到当前日期前后多少天，月，年的日期字符串
     *
     * @param pattern 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     * @param amont   数量，前为负数，后为正数
     * @param type    类型，可参考Calendar的常量(如：Calendar.HOUR、Calendar.MINUTE、Calendar.SECOND)
     * @return
     */
    public static String getDate(String pattern, int amont, int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(type, amont);
        return FastDateFormat.getInstance(pattern).format(calendar.getTime());
    }

    /**
     * 得到当前日期前后多少天，月，年的日期字符串
     *
     * @param date    时间
     * @param pattern 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     * @param amont   数量，前为负数，后为正数
     * @param type    类型，可参考Calendar的常量(如：Calendar.HOUR、Calendar.MINUTE、Calendar.SECOND)
     * @return
     */
    public static Date getDate(Date date, String pattern, int amont, int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(type, amont);
        return calendar.getTime();
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), DEFAULT_FORMAT_TIME);
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式   see to DateUtil#parsePatterns
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24.0);
    }

    /**
     * 获取某月有几天
     *
     * @param date 日期
     * @return 天数
     */
    public static int getMonthHasDays(Date date) {
        String yyyyMM = FastDateFormat.getInstance("yyyyMM").format(date);
        String year = yyyyMM.substring(0, 4);
        String month = yyyyMM.substring(4, 6);
        String day31 = ",01,03,05,07,08,10,12,";
        String day30 = "04,06,09,11";
        int day;
        if (day31.contains(month)) {
            day = 31;
        } else if (day30.contains(month)) {
            day = 30;
        } else {
            int y = Integer.parseInt(year);
            //是否是闰年
            boolean isLeapYear = (y % 4 == 0 && (y % 100 != 0)) || y % 400 == 0;
            if (isLeapYear) {
                day = 29;
            } else {
                day = 28;
            }
        }
        return day;
    }

    /**
     * 获取日期是当年的第几周
     *
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取一天的开始时间（如：2015-11-3 00:00:00.000）
     *
     * @param date 日期
     * @return
     */
    public static Date getOfDayFirst(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取一天的最后时间（如：2015-11-3 23:59:59.999）
     *
     * @param date 日期
     * @return
     */
    public static Date getOfDayLast(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取服务器启动时间
     *
     * @return
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 格式化为日期范围字符串
     *
     * @param beginDate 2018-01-01
     * @param endDate   2018-01-31
     * @return 2018-01-01 ~ 2018-01-31
     * @author ThinkGem
     */
    public static String formatDateBetweenString(Date beginDate, Date endDate) {
        String begin = DateUtil.formatDate(beginDate);
        String end = DateUtil.formatDate(endDate);
        if (StringUtils.isNoneBlank(begin, end)) {
            return begin + " ~ " + end;
        }
        return null;
    }

    /**
     * 解析日期范围字符串为日期对象
     *
     * @param dateString 2018-01-01 ~ 2018-01-31
     * @return new Date[]{2018-01-01, 2018-01-31}
     * @author ThinkGem
     */
    public static Date[] parseDateBetweenString(String dateString) {
        Date beginDate = null;
        Date endDate = null;
        int length = 2;
        if (StringUtils.isNotBlank(dateString)) {
            String[] ss = StringUtils.split(dateString, "~");
            if (ss != null && ss.length == length) {
                String begin = StringUtils.trim(ss[0]);
                String end = StringUtils.trim(ss[1]);
                if (StringUtils.isNoneBlank(begin, end)) {
                    beginDate = DateUtil.parseDate(begin);
                    endDate = DateUtil.parseDate(end);
                }
            }
        }
        return new Date[]{beginDate, endDate};
    }

    public static String getOrderDate() {
        return formatDate(new Date(), "yyyyMMddHHmmssSSS");
    }

    /**
     * 根据日期获取日期为星期几
     *
     * @param date
     * @return
     */
    public static Integer getWeekIndex(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int weekIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (weekIndex < 0) {
            weekIndex = 0;
        }
        return weekIndex;
    }

    /**
     * 传入的日期和当前时间对比，获取时间差
     *
     * @param date 要和当前时间比较的日期
     * @param unit 返回的时间类型
     * @return Double 正数为已过去多少时间，负数为到传入参数的时间还有多少时间
     */
    public static Double pastDate(Date date, TimeUnit unit) {
        Long diff = System.currentTimeMillis() - date.getTime();
        if (diff == 0) {
            return 0d;
        }
        switch (unit) {
            case SECONDS:
                return diff / 1000.0;
            case MINUTES:
                return diff / 1000.0 / 60.0;
            case HOURS:
                return diff / 1000.0 / 60.0 / 60.0;
            case DAYS:
                return diff / 1000.0 / 60.0 / 60.0 / 24.0;
            case NANOSECONDS:
                return diff * 1000.0 * 1000.0;
            case MICROSECONDS:
                return diff * 1000.0;
            case MILLISECONDS:
            default:
                break;
        }
        return 0d;
    }

    /**
     * 根据参数 获取当前时间 之前或之后的 时间
     * 如果两个参数任意一个为空，则返回当前时间
     *
     * @param num  时间差数值 负数为之后
     * @param type 时间差单位 例如： Calendar.HOUR
     * @return java.util.Date
     */
    public static Date getBeforeOrAfterDateForNow(Integer num, Integer type) {
        return getBeforeOrAfterDateForNow(new Date(), num, type);
    }

    /**
     * 根据参数 获取当前时间 之前或之后的 时间
     * 如果两个参数任意一个为空，则返回当前时间
     *
     * @param date 需要计算的日期
     * @param num  时间差数值 负数为之后
     * @param type 时间差单位 例如： Calendar.HOUR
     * @return java.util.Date
     */
    public static Date getBeforeOrAfterDateForNow(Date date, Integer num, Integer type) {
        if (num == null || type == null) {
            return new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(type, calendar.get(type) + num);
        return calendar.getTime();
    }

}
