package com.example.zsmes.vo;

import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.example.zsmes.entity.MesStation;
import lombok.Data;

import java.util.List;

@Data
public class PlanVO {
    private Integer current;
    private Integer limit;
    private Long total;
    List<MesPrimaryProducePlan> data;
    private Long pages;
}
