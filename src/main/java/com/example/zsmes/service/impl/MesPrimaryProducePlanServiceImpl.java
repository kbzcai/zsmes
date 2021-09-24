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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

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
}
