package com.example.zsmes.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.example.zsmes.service.MesPrimaryProducePlanService;

import com.example.zsmes.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
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
    public PlanVO queryByList(@PathVariable("page") int page, @PathVariable("limit") int limit, @RequestBody(required = false) PlanCondition planCondition) {
        IPage<MesPrimaryProducePlan> primaryProducePlanIPage = mesPrimaryProducePlanService.queryByList(page, limit, planCondition);
        PlanVO planVO = new PlanVO();
        planVO.setCurrent(page);
        planVO.setData(primaryProducePlanIPage.getRecords());
        planVO.setLimit(limit);
        planVO.setTotal(primaryProducePlanIPage.getTotal());
        planVO.setPages(primaryProducePlanIPage.getPages());
        return planVO;
    }

    @PostMapping("/queryByListByFix/{page}/{limit}")
    public PlanVO queryByListByFix(@PathVariable("page") int page, @PathVariable("limit") int limit, @RequestBody(required = false) PlanCondition planCondition) {
        IPage<MesPrimaryProducePlan> primaryProducePlanIPage = mesPrimaryProducePlanService.queryByListByFix(page, limit, planCondition);
        PlanVO planVO = new PlanVO();
        planVO.setCurrent(page);
        planVO.setData(primaryProducePlanIPage.getRecords());
        planVO.setLimit(limit);
        planVO.setTotal(primaryProducePlanIPage.getTotal());
        planVO.setPages(primaryProducePlanIPage.getPages());
        return planVO;
    }

    @PostMapping("/addPlan")
    public String addPlan(@RequestBody MesPrimaryProducePlan mesPrimaryProducePlan) {
        return mesPrimaryProducePlanService.addPlan(mesPrimaryProducePlan);
    }

    @GetMapping("/autoFillPlanById/{id}")
    public String autoFillPlanById(@PathVariable("id") Long id) {
        return mesPrimaryProducePlanService.autoFillPlanById(id);
    }

    @GetMapping("/fixPlanById/{id}")
    public String fixPlanById(@PathVariable("id") Long id) {
        return mesPrimaryProducePlanService.fixPlanById(id);
    }

    @GetMapping("/getProductPlan")
    public ProductingPlanVO getProductPlan() {
        return mesPrimaryProducePlanService.getProductPlan();
    }

    @GetMapping("/getUnFinishPlan")
    public List<MesPrimaryProducePlan> getUnFinishPlan() {
        return mesPrimaryProducePlanService.getUnFinishPlan();
    }

    @GetMapping("/queryAllPlanNo")
    public List<String> queryAllPlanNo() {
        return mesPrimaryProducePlanService.queryAllPlanNo();
    }

    @PostMapping("/startPlanByNo")
    public String startPlanByNo(@RequestBody Map<String, Object> map) {
        System.out.println(map);
        return mesPrimaryProducePlanService.startPlanByNo(map.get("now").toString(), map.get("before").toString());
    }

    @PostMapping("/pass")
    public String pass(@RequestBody Map<String, Object> map) {
        System.out.println(map);
        return mesPrimaryProducePlanService.pass(map.get("before").toString(), (Integer) map.get("enum"));
    }

    @PutMapping("/updatePlan")
    public String updatePlan(@RequestBody MesPrimaryProducePlan mesPrimaryProducePlan) {
        System.out.println("-----------------------------------");
        System.out.println(mesPrimaryProducePlan);
        return mesPrimaryProducePlanService.updatePlan(mesPrimaryProducePlan);
    }

    @GetMapping("/query")
    public PlanDataVo getPlanData() {
        PlanDataVo planData = mesPrimaryProducePlanService.getPlanData();
        System.out.println(planData);
        return planData;
    }

    @DeleteMapping("/deleteBySelectIds/{deleteIds}")
    public String deleteBySelectIds(@PathVariable("deleteIds") List<String> deleteIds) {
        return mesPrimaryProducePlanService.deleteBySelectIds(deleteIds);
    }
}

