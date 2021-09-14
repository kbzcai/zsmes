package com.example.zsmes.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;

import com.example.zsmes.entity.MesEquipment;
import com.example.zsmes.service.MesEquipmentService;
import com.example.zsmes.vo.EquipmentCondition;
import com.example.zsmes.vo.EquipmentVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/mesEquipment")
public class MesEquipmentController {

    @Autowired
    private MesEquipmentService mesEquipmentService;

    @PostMapping("/queryByList/{page}/{limit}")
    public EquipmentVO queryByList(@PathVariable("page") int page, @PathVariable("limit") int limit, @RequestBody(required = false)EquipmentCondition equipmentCondition){
        IPage<MesEquipment> equipmentIPage = mesEquipmentService.queryByList(page, limit,equipmentCondition);
        EquipmentVO equipmentVO=new EquipmentVO();
        equipmentVO.setCurrent(page);
        equipmentVO.setData(equipmentIPage.getRecords());
        equipmentVO.setLimit(limit);
        equipmentVO.setTotal(equipmentIPage.getTotal());
        equipmentVO.setPages(equipmentIPage.getPages());
        return equipmentVO;
    }

    @PostMapping("/addEquipment")
    public String addEquipment(@RequestBody MesEquipment mesEquipment){
        return mesEquipmentService.addMesEquipment(mesEquipment);
    }

    @PutMapping("/updateEquipment")
    public String updateEquipment(@RequestBody MesEquipment mesEquipment){
        return mesEquipmentService.editByEquipmentNo(mesEquipment);
    }

    @DeleteMapping("/deleteBySelectIds/{deleteIds}")
    public String deleteBySelectIds(@PathVariable("deleteIds")List<String> deleteIds){
        return mesEquipmentService.deleteBySelectIds(deleteIds);
    }
}

