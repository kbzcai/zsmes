package com.example.zsmes.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlanDataVo {
    private List<Integer> actualNumList;
    private List<Integer> planNumList;
    private List<Integer> failNumList;
}
