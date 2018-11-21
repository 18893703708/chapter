package com.huyun.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUnits {
    /*
    * 将时间转换为时间戳
    */
    public static String dateToStamp(String date) throws ParseException {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = sdf.parse(date);
        long l = d.getTime();
        String str = String.valueOf(l);
        return str;
    }
}
