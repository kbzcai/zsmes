package com.example.zsmes.utils;

import com.example.zsmes.entity.MesBom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BomMapToBean {
    public static List<MesBom> changeToBom(List<Map<String,Object>> bomList){
        List<MesBom> mesBomList=new ArrayList<>();
        for (Map<String,Object> map:bomList
             ) {
            MesBom mesBom=new MesBom();
            if(map.containsKey("工位")){
               mesBom.setStationNo(map.get("工位").toString());
            }if(map.containsKey("物料编码")){
                mesBom.setMaterialDesc(map.get("物料编码").toString());
            }
        }
        return mesBomList;
    }
}
