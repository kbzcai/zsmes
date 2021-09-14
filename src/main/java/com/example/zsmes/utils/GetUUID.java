package com.example.zsmes.utils;

import com.baomidou.mybatisplus.extension.api.R;

import java.util.Random;
import java.util.UUID;

public class GetUUID {
    public static long getUUID() {
        Random random=new Random();
        String nanoRandom = System.nanoTime() + "" + random.nextInt(99999);
        int hash = Math.abs(UUID.randomUUID().hashCode());
        int needAdd = 19 - String.valueOf(hash).length() + 1;
        return Long.valueOf(hash + "" + nanoRandom.substring(needAdd));
    }
}
