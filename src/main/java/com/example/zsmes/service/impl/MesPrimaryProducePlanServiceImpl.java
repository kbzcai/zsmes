package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zsmes.entity.MesEquipment;
import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.example.zsmes.mapper.MesPrimaryProducePlanMapper;
import com.example.zsmes.service.MesPrimaryProducePlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zsmes.vo.PlanCondition;
import com.example.zsmes.vo.PlanDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@Service
public class MesPrimaryProducePlanServiceImpl extends ServiceImpl<MesPrimaryProducePlanMapper, MesPrimaryProducePlan> implements MesPrimaryProducePlanService {

    @Autowired
    private MesPrimaryProducePlanMapper mesPrimaryProducePlanMapper;

    @Override
    public IPage<MesPrimaryProducePlan> queryByList(int currentpage, int limit, PlanCondition planCondition) {
        Page<MesPrimaryProducePlan> page = new Page<>(currentpage, limit);
        QueryWrapper wrapper = new QueryWrapper();
        String planNo = planCondition.getPlanNo();
        String planStatus = planCondition.getPlanStatus();
        String beginTime = planCondition.getBeginTime();
        String endTime = planCondition.getEndTime();
        if (!StringUtils.isEmpty(planNo)) {
            wrapper.like("plan_no", planNo);
        }
        if (!StringUtils.isEmpty(planStatus) && planStatus != "") {
            wrapper.like("plan_status", planStatus);
        }
        if (!StringUtils.isEmpty(beginTime)) {
            wrapper.ge("plan_date", beginTime);
        }
        if (!StringUtils.isEmpty(endTime)) {
            wrapper.le("plan_date", endTime);
        }
        IPage<MesPrimaryProducePlan> primaryProducePlanIPage = mesPrimaryProducePlanMapper.selectPage(page, wrapper);
        return primaryProducePlanIPage;
    }

    @Override
    public String addPlan(MesPrimaryProducePlan mesPrimaryProducePlan) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("plan_no", mesPrimaryProducePlan.getPlanNo());
        List<MesPrimaryProducePlan> list = mesPrimaryProducePlanMapper.selectList(wrapper);
        if (list.size() > 0) {
            return "添加失败，存在改计划";
        } else {
            mesPrimaryProducePlan.setActualNum(0);
            mesPrimaryProducePlan.setFailNum(0);
            mesPrimaryProducePlan.setPassNum(0);
            mesPrimaryProducePlan.setWeldingFinishNum(0);
            mesPrimaryProducePlanMapper.insert(mesPrimaryProducePlan);
            return "添加成功";
        }
    }

    @Override
    public String autoFillPlanById(Long id) {
        MesPrimaryProducePlan mesPrimaryProducePlan = mesPrimaryProducePlanMapper.selectById(id);
        mesPrimaryProducePlan.setActualNum(mesPrimaryProducePlan.getPlanNum() - mesPrimaryProducePlan.getFailNum());
        mesPrimaryProducePlan.setPlanStatus("1");
        mesPrimaryProducePlan.setStatus("1");
        mesPrimaryProducePlanMapper.updateById(mesPrimaryProducePlan);
        return "补充成功";
    }

    @Override
    public String updatePlan(MesPrimaryProducePlan mesPrimaryProducePlan) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("plan_no", mesPrimaryProducePlan.getPlanNo());
        List<MesPrimaryProducePlan> list = mesPrimaryProducePlanMapper.selectList(wrapper);
        MesPrimaryProducePlan plan = list.get(0);
        if (mesPrimaryProducePlan.getActualNum() <= mesPrimaryProducePlan.getPlanNum() &&
                mesPrimaryProducePlan.getFailNum() <= mesPrimaryProducePlan.getPlanNum() &&
                mesPrimaryProducePlan.getActualNum() + mesPrimaryProducePlan.getFailNum() <=
                        mesPrimaryProducePlan.getPlanNum()) {
            plan.setActualNum(mesPrimaryProducePlan.getActualNum());
            plan.setFailNum(mesPrimaryProducePlan.getFailNum());
            if (mesPrimaryProducePlan.getActualNum() + mesPrimaryProducePlan.getFailNum() ==
                    mesPrimaryProducePlan.getPlanNum()) {
                plan.setPlanStatus("1");
                plan.setStatus("1");
            } else {
                plan.setPlanStatus("0");
                plan.setStatus("0");
            }
            plan.setPlanDate(mesPrimaryProducePlan.getPlanDate());
            mesPrimaryProducePlanMapper.updateById(plan);
            return "修改成功";
        } else {
            return "请检查输入数量是否正清并合理";
        }
    }

    @Override
    public PlanDataVo getPlanData() {
        PlanDataVo planDataVo = new PlanDataVo();
        List<Integer> actualNumList = new ArrayList<>();
        List<Integer> planNumList = new ArrayList<>();
        List<Integer> failNumList = new ArrayList<>();
        for (MesPrimaryProducePlan plan : mesPrimaryProducePlanMapper.queryDayList()
        ) {
            System.out.println(plan);
        }
        for (MesPrimaryProducePlan plan : mesPrimaryProducePlanMapper.queryWeekList()
        ) {
            System.out.println(plan);
        }
        for (MesPrimaryProducePlan plan : mesPrimaryProducePlanMapper.queryMonthList()
        ) {
            System.out.println(plan);
        }
        actualNumList.add(mesPrimaryProducePlanMapper.queryActualNumDay());
        actualNumList.add(mesPrimaryProducePlanMapper.queryActualNumWeek());
        actualNumList.add(mesPrimaryProducePlanMapper.queryActualNumMonth());
        planNumList.add(mesPrimaryProducePlanMapper.queryPlanNumDay());
        planNumList.add(mesPrimaryProducePlanMapper.queryPlanNumWeek());
        planNumList.add(mesPrimaryProducePlanMapper.queryPlanNumMonth());
        failNumList.add(mesPrimaryProducePlanMapper.queryFailNumDay());
        failNumList.add(mesPrimaryProducePlanMapper.queryFailNumWeek());
        failNumList.add(mesPrimaryProducePlanMapper.queryFailNumMonth());
        planDataVo.setActualNumList(actualNumList);
        planDataVo.setPlanNumList(planNumList);
        planDataVo.setFailNumList(failNumList);
        return planDataVo;
    }
}
