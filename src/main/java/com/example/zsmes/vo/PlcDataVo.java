package com.example.zsmes.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlcDataVo {
    private String plcName;
    private List<String> plcElectric;
    private List<String> plcVoltage;
    private List<LocalDateTime> time;
}
