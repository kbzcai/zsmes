package com.example.zsmes.vo;

import lombok.Data;

@Data
public class PlcStateVO {
    private String plcName;
    private String stateA;
    private String stateB;

    public PlcStateVO(String stateA, String stateB) {
        this.stateA = stateA;
        this.stateB = stateB;
    }
}
