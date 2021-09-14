package com.example.zsmes.vo;

import com.example.zsmes.entity.MesEquipmentRepairHistory;
import com.example.zsmes.entity.MesProduct;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductVO implements Serializable {
    private Integer current;
    private Integer limit;
    private Long total;
    List<MesProduct> data;
    private Long pages;
}
