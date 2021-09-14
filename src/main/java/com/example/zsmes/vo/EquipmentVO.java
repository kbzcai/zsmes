package com.example.zsmes.vo;

import com.example.zsmes.entity.MesEquipment;
import com.example.zsmes.entity.MesEquipmentFaultHistory;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EquipmentVO {
    private Integer current;
    private Integer limit;
    private Long total;
    List<MesEquipment> data;
    private Long pages;
}
