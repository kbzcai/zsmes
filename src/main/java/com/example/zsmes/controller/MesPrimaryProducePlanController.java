package com.example.zsmes.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesEquipment;
import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.example.zsmes.service.MesPrimaryProducePlanService;
import com.example.zsmes.vo.EquipmentCondition;
import com.example.zsmes.vo.EquipmentVO;
import com.example.zsmes.vo.PlanCondition;
import com.example.zsmes.vo.PlanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@RestController
@RequestMapping("/mesPrimaryProducePlan")
public class MesPrimaryProducePlanController {

    @Autowired
    private MesPrimaryProducePlanService mesPrimaryProducePlanService;

    @PostMapping("/queryByList/{page}/{limit}")
    public PlanVO queryByList(@PathVariable("page") int page, @PathVariable("limit") int limit, @RequestBody(required = false) PlanCondition planCondition){
        IPage<MesPrimaryProducePlan> primaryProducePlanIPage = mesPrimaryProducePlanService.queryByList(page, limit,planCondition);
        PlanVO planVO=new PlanVO();
        planVO.setCurrent(page);
        planVO.setData(primaryProducePlanIPage.getRecords());
        planVO.setLimit(limit);
        planVO.setTotal(primaryProducePlanIPage.getTotal());
        planVO.setPages(primaryProducePlanIPage.getPages());
        return planVO;
    }
}

