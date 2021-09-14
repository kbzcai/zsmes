package com.example.zsmes.vo;

import com.example.zsmes.entity.MesBom;
import com.example.zsmes.entity.MesProduct;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BomVO implements Serializable {
    private Integer current;
    private Integer limit;
    private Long total;
    List<MesBom> data;
    private Long pages;
}
