package com.example.zsmes.vo;

import com.example.zsmes.entity.MesEquipment;
import com.example.zsmes.entity.MesStation;
import lombok.Data;

import java.util.List;

@Data
public class StationVO {
    private Integer current;
    private Integer limit;
    private Long total;
    List<MesStation> data;
    private Long pages;
}
