package com.example.zsmes.utils;

import lombok.Data;

@Data
public class PageParam {
    //第几页开始
    private int current;
    //每页大小
    private int size;
}
