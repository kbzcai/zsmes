package com.example.zsmes.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesEquipmentFaultHistory;
import com.example.zsmes.service.MesEquipmentFaultHistoryService;
import com.example.zsmes.vo.FaultHistoryCondition;
import com.example.zsmes.vo.FaultHistoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@RestController
@RequestMapping("/mesEquipmentFaultHistory")
public class MesEquipmentFaultHistoryController {

    @Autowired
    private MesEquipmentFaultHistoryService mesEquipmentFaultHistoryService;

    @PostMapping("/addFaultHistory")
    public String addFaultHistory(@RequestBody MesEquipmentFaultHistory mesEquipmentFaultHistory){
        return mesEquipmentFaultHistoryService.addFaultHistoryService(mesEquipmentFaultHistory);
    }

    @PostMapping("/queryByList/{page}/{limit}")
    public FaultHistoryVO queryByList(@PathVariable("page") int page, @PathVariable("limit") int limit, @RequestBody(required = false)FaultHistoryCondition faultHistoryCondition){
        IPage<MesEquipmentFaultHistory> faultHistoryIPage = mesEquipmentFaultHistoryService.queryByList(page, limit,faultHistoryCondition);
        FaultHistoryVO faultHistoryVO=new FaultHistoryVO();
        faultHistoryVO.setCurrent(page);
        faultHistoryVO.setData(faultHistoryIPage.getRecords());
        faultHistoryVO.setLimit(limit);
        faultHistoryVO.setTotal(faultHistoryIPage.getTotal());
        faultHistoryVO.setPages(faultHistoryIPage.getPages());
        return faultHistoryVO;
    }

    @DeleteMapping("/deleteBySelectIds/{deleteIds}")
    public String deleteBySelectIds(@PathVariable("deleteIds")List<String> deleteIds){
        return mesEquipmentFaultHistoryService.deleteBySelectIds(deleteIds);
    }
}

