package com.example.zsmes.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PlcVO {
    private String name;
    private String r1_status;
    private String r2_status;
    private Integer prod_numA;
    private Integer prod_numB;
    private String r1_electric;
    private String r1_voltage;
    private String r2_electric;
    private String r2_voltage;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    public PlcVO(String name, String r1_status, String r2_status, Integer prod_numA, Integer prod_numB, String r1_electric, String r1_voltage, String r2_electric, String r2_voltage, LocalDateTime createTime) {
        this.name = name;
        this.r1_status = r1_status;
        this.r2_status = r2_status;
        this.prod_numA = prod_numA;
        this.prod_numB = prod_numB;
        this.r1_electric = r1_electric;
        this.r1_voltage = r1_voltage;
        this.r2_electric = r2_electric;
        this.r2_voltage = r2_voltage;
        this.createTime = createTime;
    }
}
