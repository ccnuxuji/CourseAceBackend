package com.ccnuxuji.courseace.util;


import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author ruoyi
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static final String YYYY = "yyyy";

    public static final String YYYY_MM = "yyyy-MM";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String YYMMDDHHMMSS = "yyMMddHHmmss";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String format(Date date) {
        return DateFormatUtils.format(date, YYYY_MM_DD);
    }

    public static final String format(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 日期型字符串转化为日期 格式
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
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 一个日期按月推
     *
     * @param date
     * @param number
     * @return
     */
    public static String getNearMonth(Date date, int number) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, number);
        Date changeDate = c.getTime();
        return format(changeDate, YYYY_MM_DD);
    }

    /**
     * 获取日期开始时间
     *
     * @param date "2020-02-11"
     * @return eg:"2020-02-11 00:00:00"
     */
    public static Date getStartDate(String date) {
        if (date == null) return null;
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(parseDate(date, YYYY_MM_DD));
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            return c.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取日期开始时间
     *
     * @param date "2020-02-11"
     * @return eg:"2020-02-11 23:59:59"
     */
    public static Date getEndDate(String date) {
        if (date == null) return null;
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(parseDate(date, YYYY_MM_DD));
            c.set(Calendar.HOUR_OF_DAY, 23);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
            return c.getTime();
        } catch (ParseException e) {
            return null;
        }
    }


    public static String getHomeTimeFormat(Date data) {
        if (data == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(data);
        String[] split = format.split("-");
        StringBuilder sb = new StringBuilder();
        String month = getMonth(Integer.valueOf(split[1]));
        sb.append(split[2]).append(" ").append(month).append(" ").append(split[0]);
        return sb.toString();
    }

    private static String getMonth(Integer month) {
        String s = "January_February_March_April_May_June_July_August_September_October_November_December";
        String[] split = s.split("_");
        return split[month - 1];
    }

    public static void main(String[] args) throws ParseException {
        String lastWeek = getLastWeek();
        System.out.println("lastMonth = " + lastWeek);
    }

    /**
     * desc: 获取当前时间的上周周一的时间 <br>
     * date: 2021/6/2
     *
     * @return
     * @author: zhaozj
     */
    public static String getLastWeek() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Calendar cld = Calendar.getInstance();
        cld.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//周一
        String format = df.format(cld.getTime());
        Date parse = df.parse(format);
        return df.format(addDays(parse, -7));
    }

    /**
     * desc: 获取当前时间的某几天前的时间 <br>
     * date: 2021/7/2
     *
     * @param num 往前几天的时间  mum == 1 上一个    ,num ==3   三天前
     * @return
     */
    public static String getLastDay(Integer num) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -num);
        String first_day = format.format(calendar.getTime());

        return first_day;
    }

    /**
     * 距离下个自然月开始的时间（毫秒）
     * @return
     */
    private long getMonthEnd() {
        Date date= new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        //设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND,59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 获取本月最后一天的时间
        Date cTime = c.getTime();
        long time = cTime.getTime()-System.currentTimeMillis();
        return time;
    }


}
