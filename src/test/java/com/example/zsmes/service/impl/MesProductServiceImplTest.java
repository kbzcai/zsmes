package com.example.zsmes.service.impl;

import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.example.zsmes.service.MesProductService;
import com.example.zsmes.utils.PageParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class MesProductServiceImplTest {

    @Autowired
    private MesProductService mesProductService;

    @Test
    void findByPage() {
        String planno = "JH202104";
        String status = "1";
        String stime = "2021-04-02 00:00:00";
        String etime = "2021-04-26 00:00:00";
        PageParam pageParam = new PageParam();
        pageParam.setCurrent(1);
        pageParam.setSize(10);
        mesProductService.queryPageList(planno, status, stime, etime, pageParam);
    }

    @Test
    void insertPlan() {
        MesPrimaryProducePlan plan = new MesPrimaryProducePlan();
        plan.setProductNo("31100-M513-000000");
        plan.setPlanDate(LocalDateTime.now());
        System.out.println(plan.getPlanDate());
        plan.setOrderNo("20210427");
        mesProductService.insertProducePlan(plan);
    }

    @Test
    void editPlan() {
        MesPrimaryProducePlan plan = new MesPrimaryProducePlan();
        plan.setProductNo("31100-M513-000000");
        plan.setPlanDate(LocalDateTime.now());
        System.out.println(plan.getPlanDate());
        mesProductService.updateProducePlan(plan);
    }

    @Test
    void deletePlan() {
        String id = "25254";
        mesProductService.deletePlanById(id);
    }

    @Test
    void count(){
        String stime="2021-04-01";
        String etime="2021-04-30";
        Integer count = mesProductService.queryPassNumByTime(stime, etime);
        Integer count1 = mesProductService.queryFailNumByTime(stime, etime);
        Integer count2 = mesProductService.queryUndoNumByTime(stime, etime);
        Integer count3 = mesProductService.queryPlanNumByTime(stime, etime);
        System.out.println(count);
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
    }
}