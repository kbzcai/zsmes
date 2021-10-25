package com.example.zsmes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zsmes.vo.PlanCondition;
import com.example.zsmes.vo.PlanDataVo;
import com.example.zsmes.vo.ProductingPlanVO;

import java.util.List;

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

    String addPlan(MesPrimaryProducePlan mesPrimaryProducePlan);

    String autoFillPlanById(Long id);

    String updatePlan(MesPrimaryProducePlan mesPrimaryProducePlan);

    PlanDataVo getPlanData();

    String deleteBySelectIds(List<String> deleteIds);

    ProductingPlanVO getProductPlan();

    String startPlanById(Long id);
}
