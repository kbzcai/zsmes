package com.example.zsmes.vo;

import com.example.zsmes.entity.MesEquipmentFaultHistory;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FaultHistoryVO implements Serializable {
    private Integer current;
    private Integer limit;
    private Long total;
    List<MesEquipmentFaultHistory> data;
    private Long pages;
}
