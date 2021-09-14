package com.example.zsmes.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GetFirstDayAndLastDay {
    public static Map<String,String> getMonthDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday, lastday;
        Calendar cale = null;
        Map<String,String> map = new HashMap();
        cale = Calendar.getInstance();
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(cale.getTime());
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastday = format.format(cale.getTime());

        map.put("firstDate", firstday);
        map.put("lastDate", lastday);
        return map;
    }
}
