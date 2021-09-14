package com.example.zsmes.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GetToday {
    public static Map<String,String> gettoday() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String today;
        Calendar cale = null;
        Map<String,String> map = new HashMap();
        cale = Calendar.getInstance();
        today = format.format(cale.getTime());
        map.put("today", today);
        return map;
    }
}
