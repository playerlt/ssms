package com.index.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author index
 * @date 2020/10/29
 **/
public class DateUtil {
    public static Date getWeekEndTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        calendar.set(Calendar.AM_PM, Calendar.PM);
        calendar.set(Calendar.HOUR, 11);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date res = calendar.getTime();
        res.setTime(calendar.getTimeInMillis()+1);
        return res;
    }
}
