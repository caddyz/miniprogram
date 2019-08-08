package com.miaoyidj.miniprogram.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: TimeUtil
 * @Description: TODO 时间工具类
 * @Author: Kaiser
 * @Date: 2019/4/22 11:01
 * @Version: 1.0
 */
public class TimeUtil {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getCurrentTime(){
        return simpleDateFormat.format(new Date());
    }

    public static long getSignTimeStmap(){
        return System.currentTimeMillis() / 1000;
    }

    public static String getNextMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,1);
        return simpleDateFormat.format(calendar.getTime());
    }
}
