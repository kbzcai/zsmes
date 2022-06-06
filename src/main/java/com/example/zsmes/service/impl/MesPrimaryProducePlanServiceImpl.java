package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.example.zsmes.mapper.MesPrimaryProducePlanMapper;
import com.example.zsmes.service.MesPrimaryProducePlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zsmes.utils.GetUUID;
import com.example.zsmes.vo.PlanCondition;
import com.example.zsmes.vo.PlanDataVo;
import com.example.zsmes.vo.ProductingPlanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@Service
@Transactional
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
    public IPage<MesPrimaryProducePlan> queryByListByFix(int currentpage, int limit, PlanCondition planCondition) {
        Page<MesPrimaryProducePlan> page = new Page<>(currentpage, limit);
        QueryWrapper wrapper = new QueryWrapper();
        String planNo = planCondition.getPlanNo();
        String beginTime = planCondition.getBeginTime();
        String endTime = planCondition.getEndTime();

        if (!StringUtils.isEmpty(planNo)) {
            wrapper.like("plan_no", planNo);
        }
        if (!StringUtils.isEmpty(beginTime)) {
            wrapper.ge("plan_date", beginTime);
        }
        if (!StringUtils.isEmpty(endTime)) {
            wrapper.le("plan_date", endTime);
        }
        wrapper.gt("welding_finish_num", 0);
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
            mesPrimaryProducePlan.setId(GetUUID.getUUID());
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
        mesPrimaryProducePlan.setActualNum(mesPrimaryProducePlan.getPlanNum() - mesPrimaryProducePlan.getFailNum() - mesPrimaryProducePlan.getWeldingFinishNum());
        mesPrimaryProducePlan.setPlanStatus("1");
        mesPrimaryProducePlan.setStatus("0");
        mesPrimaryProducePlanMapper.updateById(mesPrimaryProducePlan);
        return "补充成功";
    }

    @Override
    public String fixPlanById(Long id) {
        MesPrimaryProducePlan mesPrimaryProducePlan = mesPrimaryProducePlanMapper.selectById(id);
        mesPrimaryProducePlan.setActualNum(mesPrimaryProducePlan.getActualNum() + mesPrimaryProducePlan.getWeldingFinishNum());
        mesPrimaryProducePlan.setWeldingFinishNum(0);
        mesPrimaryProducePlanMapper.updateById(mesPrimaryProducePlan);
        return "补焊成功";
    }

    @Override
    public String updatePlan(MesPrimaryProducePlan mesPrimaryProducePlan) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("plan_no", mesPrimaryProducePlan.getPlanNo());
        List<MesPrimaryProducePlan> list = mesPrimaryProducePlanMapper.selectList(wrapper);
        MesPrimaryProducePlan plan = list.get(0);
        if (mesPrimaryProducePlan.getActualNum() <= mesPrimaryProducePlan.getPlanNum() &&
                mesPrimaryProducePlan.getFailNum() <= mesPrimaryProducePlan.getPlanNum() &&
                mesPrimaryProducePlan.getWeldingFinishNum() <= mesPrimaryProducePlan.getPlanNum() &&
                mesPrimaryProducePlan.getActualNum() + mesPrimaryProducePlan.getFailNum() + mesPrimaryProducePlan.getWeldingFinishNum() <=
                        mesPrimaryProducePlan.getPlanNum()) {
            plan.setPlanNum(mesPrimaryProducePlan.getPlanNum());
            plan.setActualNum(mesPrimaryProducePlan.getActualNum());
            plan.setWeldingFinishNum(mesPrimaryProducePlan.getWeldingFinishNum());
            plan.setFailNum(mesPrimaryProducePlan.getFailNum());
            if (mesPrimaryProducePlan.getActualNum() + mesPrimaryProducePlan.getWeldingFinishNum() + mesPrimaryProducePlan.getFailNum() ==
                    mesPrimaryProducePlan.getPlanNum()) {
                plan.setPlanStatus("1");
            } else {
                plan.setPlanStatus("0");
            }
            plan.setPlanDate(mesPrimaryProducePlan.getPlanDate());
            plan.setPlanSchedule(mesPrimaryProducePlan.getPlanSchedule());
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
        List<Integer> planWeldingFinishNumList = new ArrayList<>();
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
        planWeldingFinishNumList.add(mesPrimaryProducePlanMapper.queryWeldingFinishNumDay());
        planWeldingFinishNumList.add(mesPrimaryProducePlanMapper.queryWeldingFinishNumWeek());
        planWeldingFinishNumList.add(mesPrimaryProducePlanMapper.queryWeldingFinishNumMonth());
        planDataVo.setActualNumList(actualNumList);
        planDataVo.setPlanNumList(planNumList);
        planDataVo.setFailNumList(failNumList);
        planDataVo.setWeldingFinishNumList(planWeldingFinishNumList);
        return planDataVo;
    }

    @Override
    public String deleteBySelectIds(List<String> deleteIds) {
        int sum = mesPrimaryProducePlanMapper.deleteBatchIds(deleteIds);
        if (sum > 0) {
            System.out.println(sum);
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @Override
    public ProductingPlanVO getProductPlan() {
        ProductingPlanVO productingPlanVO = new ProductingPlanVO();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("status", "1");
        List<MesPrimaryProducePlan> list = mesPrimaryProducePlanMapper.selectList(wrapper);
        if (list.size() == 1) {
            MesPrimaryProducePlan plan = list.get(0);
            productingPlanVO.setMesPrimaryProducePlan(plan);
            productingPlanVO.setMes("查询成功");
        } else {
            productingPlanVO.setMes("没有正在生产的计划");
        }
        return productingPlanVO;
    }

    @Override
    public String startPlanByNo(String now, String before) {
        System.out.println(now);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("plan_no", now);
        MesPrimaryProducePlan plan = mesPrimaryProducePlanMapper.selectOne(wrapper);
        System.out.println(plan.getPlanStatus());
        System.out.println(plan.getStatus());
        if (plan.getPlanStatus().equals("0") && plan.getStatus().equals("0")) {
            //status为1之前先把之前的status变成0
            if (!StringUtils.isEmpty(before)) {
                wrapper.clear();
                wrapper.eq("plan_no", before);
                MesPrimaryProducePlan beforePlan = mesPrimaryProducePlanMapper.selectOne(wrapper);
                beforePlan.setStatus("0");
                mesPrimaryProducePlanMapper.updateById(beforePlan);
            }
            //status为1
            plan.setStatus("1");
            mesPrimaryProducePlanMapper.updateById(plan);
            return "开始生产";
            /////////form 传多个对象
        } else {
            return "状态已经是正在生产！";
        }
    }

    @Override
    public List<String> queryAllPlanNo() {
        List<MesPrimaryProducePlan> items = mesPrimaryProducePlanMapper.selectList(null);
        List<String> planNoList = items.stream().map(MesPrimaryProducePlan::getPlanNo).collect(Collectors.toList());// 取出其中一列
        System.out.println(planNoList);
        return planNoList;
    }

    @Override
    public List<MesPrimaryProducePlan> getUnFinishPlan() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("plan_status", "0");
        List<MesPrimaryProducePlan> list = mesPrimaryProducePlanMapper.selectList(wrapper);
        return list;
    }

    @Override
    public String pass(String before, Integer index) {
        QueryWrapper wrapper = new QueryWrapper();
        System.out.println("--------------" + index);
        wrapper.eq("plan_no", before);
        MesPrimaryProducePlan plan = mesPrimaryProducePlanMapper.selectOne(wrapper);
        if (plan.getActualNum() + plan.getWeldingFinishNum() + plan.getFailNum() < plan.getPlanNum()) {
            if (index.equals(1)) {
                plan.setActualNum(plan.getActualNum() + 1);
            } else if (index.equals(2)) {
                plan.setFailNum(plan.getFailNum() + 1);
            } else {
                plan.setWeldingFinishNum(plan.getWeldingFinishNum() + 1);
            }
            if (plan.getActualNum() + plan.getWeldingFinishNum() + plan.getFailNum() == plan.getPlanNum()) {
                plan.setPlanStatus("1");
                plan.setStatus("0");
                mesPrimaryProducePlanMapper.updateById(plan);
                return "完成";
            }
            mesPrimaryProducePlanMapper.updateById(plan);
            return "合格";
         }else {
            return "系统出错，请重新检查数据库数据";
        }
    }
}
