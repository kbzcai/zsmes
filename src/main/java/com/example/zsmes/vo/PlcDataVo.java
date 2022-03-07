package com.example.zsmes.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlcDataVo {
    private String plcName;
    private List<String> plcElectric;
    private List<String> plcVoltage;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private List<LocalDateTime> time;
}
