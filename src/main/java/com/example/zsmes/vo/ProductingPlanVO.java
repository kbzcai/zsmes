package com.example.zsmes.vo;

import com.example.zsmes.entity.MesPrimaryProducePlan;
import lombok.Data;

@Data
public class ProductingPlanVO {
    private MesPrimaryProducePlan mesPrimaryProducePlan;
    private String mes;
}
