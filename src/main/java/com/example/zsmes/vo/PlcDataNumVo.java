package com.example.zsmes.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlcDataNumVo {
    private String plcName;
    private Integer prodNumA;
    private Integer prodNumB;

    public PlcDataNumVo(Integer prodNumA, Integer prodNumB) {
        this.prodNumA = prodNumA;
        this.prodNumB = prodNumB;
    }
}
