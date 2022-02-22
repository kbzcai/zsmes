package com.example.zsmes.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesEquipmentFaultHistory;
import com.example.zsmes.entity.MesEquipmentRepairHistory;
import com.example.zsmes.service.MesEquipmentRepairHistoryService;
import com.example.zsmes.vo.FaultHistoryVO;
import com.example.zsmes.vo.RepairHistoryCondition;
import com.example.zsmes.vo.RepairHistoryVO;
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
@RequestMapping("/mesEquipmentRepairHistory")
public class MesEquipmentRepairHistoryController {

    @Autowired
    private MesEquipmentRepairHistoryService mesEquipmentRepairHistoryService;

    @PostMapping("/addRepairHistory")
    public String addRepairHistory(@RequestBody MesEquipmentRepairHistory mesEquipmentRepairHistory){
        return mesEquipmentRepairHistoryService.addRepairHistory(mesEquipmentRepairHistory);
    }

    @GetMapping("/queryAllEquipmentNo")
    public List<String> queryAllEquipmentNo() {
        return mesEquipmentRepairHistoryService.queryAllEquipmentNo();
    }

    @PostMapping("/queryByList/{page}/{limit}")
    public RepairHistoryVO queryByList(@PathVariable("page") int page, @PathVariable("limit") int limit, @RequestBody(required = false)RepairHistoryCondition repairHistoryCondition){
        IPage<MesEquipmentRepairHistory> repairHistoryIPage = mesEquipmentRepairHistoryService.queryByList(page, limit,repairHistoryCondition);
        RepairHistoryVO repairHistoryVO=new RepairHistoryVO();
        repairHistoryVO.setCurrent(page);
        repairHistoryVO.setData(repairHistoryIPage.getRecords());
        repairHistoryVO.setLimit(limit);
        repairHistoryVO.setTotal(repairHistoryIPage.getTotal());
        repairHistoryVO.setPages(repairHistoryIPage.getPages());
        return repairHistoryVO;
    }

    @DeleteMapping("/deleteBySelectIds/{deleteIds}")
    public String deleteBySelectIds(@PathVariable("deleteIds") List<String> deleteIds){
        return mesEquipmentRepairHistoryService.deleteBySelectIds(deleteIds);
    }
}

