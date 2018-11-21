package com.huyun.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewDate {
    public static Date getnewDateAdd(Date olddate, String recordDate)  {
        Date  date  = olddate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String data = format.format(date);
        String dataStr[] = data.split("-");
        //年份
        int   year = (Integer.parseInt(dataStr[1]) + Integer.parseInt(recordDate))/12;
        //月份
        int  yue =  (Integer.parseInt(dataStr[1]) + Integer.parseInt(recordDate))%12;
        String a = "";
        if(yue<10){
            if(yue<1){
                a = "12";
            }else{
                a = "0"+ yue;
            }
        }else {
            a = yue + "";
        }
        dataStr[0]=String.valueOf(Integer.parseInt(dataStr[0]) + year);
        dataStr[1]=a;
        String  newdata  = dataStr[0]+"-"+dataStr[1]+"-"+dataStr[2];
        Date newDate = null;
        try {
            newDate = format.parse(newdata);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  newDate;
    }

    /**
     * 传入一个负数 减去月份 得到相应的Date shuju
     * @param date
     * @param differenceMonth
     * @return
     */

    public static Date handleMonth(Date date, int differenceMonth) {
        Calendar calendar = Calendar.getInstance();  //获取子类对象
        calendar.setTime(date);
        //calendar.add(Calendar.YEAR, -1)   //加减年 得到时间格式
        calendar.add(Calendar.MONTH, differenceMonth);  //加减月份  得到时间格式
        return calendar.getTime();
    }

}
