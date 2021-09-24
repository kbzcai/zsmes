package com.example.zsmes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zsmes.vo.PlanCondition;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
public interface MesPrimaryProducePlanService extends IService<MesPrimaryProducePlan> {

    IPage<MesPrimaryProducePlan> queryByList(int page, int limit, PlanCondition planCondition);
}
