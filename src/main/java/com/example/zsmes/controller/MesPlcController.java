package com.example.zsmes.controller;


import com.example.zsmes.service.MesPlcService;
import com.example.zsmes.vo.PlcDataNumVo;
import com.example.zsmes.vo.PlcDataVo;
import com.example.zsmes.vo.PlcStateVO;
import com.example.zsmes.vo.PlcVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@RestController
@RequestMapping("/mesPlc")
public class MesPlcController {

    @Autowired
    private MesPlcService mesPlcService;

    @RequestMapping("/query")
    public List<PlcDataVo> getData() {
        List<PlcDataVo> plcDataList = mesPlcService.getPlcData();
        System.out.println(plcDataList);
        return plcDataList;
    }

    @GetMapping("/getPlcRecentlyData")
    public List<PlcVO> getPlcRecentlyData() {
        List<PlcVO> plcVOList = mesPlcService.getPlcRecentlyData();
        System.out.println(plcVOList);
        return plcVOList;
    }

    @GetMapping("/queryByNum/{num}")
    public PlcDataVo queryByNum(@PathVariable("num") Integer num) {
        System.out.println(num);
        PlcDataVo plcDataVo = mesPlcService.queryByNum(num);
        System.out.println(plcDataVo);
        return plcDataVo;
    }

    @RequestMapping("/getNum")
    public List<PlcDataNumVo> getNum() {
        List<PlcDataNumVo> plcDataNumVoList = mesPlcService.getNum();
        System.out.println(plcDataNumVoList);
        return plcDataNumVoList;
    }

    @RequestMapping("/getStates")
    public List<PlcStateVO> getStates() {
        List<PlcStateVO> plcStateVOList = mesPlcService.getState();
        System.out.println(plcStateVOList);
        return plcStateVOList;
    }
}

