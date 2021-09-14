package com.example.zsmes.vo;

import lombok.Data;

import java.util.List;

@Data
public class PlcVO {
    private List<String> names;
    private List<Integer> values;
}
