package com.example.zsmes.vo;

import com.example.zsmes.entity.MesEquipmentFaultHistory;
import com.example.zsmes.entity.MesEquipmentRepairHistory;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RepairHistoryVO implements Serializable {
    private Integer current;
    private Integer limit;
    private Long total;
    List<MesEquipmentRepairHistory> data;
    private Long pages;
}
