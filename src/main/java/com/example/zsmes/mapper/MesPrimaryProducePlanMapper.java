package com.example.zsmes.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@Repository
public interface MesPrimaryProducePlanMapper extends BaseMapper<MesPrimaryProducePlan> {
    @Select("select sum(pass_num) from mes_primary_produce_plan ${ew.customSqlSegment}")
    Integer passCount(@Param(Constants.WRAPPER) Wrapper<MesPrimaryProducePlan> wrapper);

    @Select("select sum(fail_num) from mes_primary_produce_plan ${ew.customSqlSegment}")
    Integer failCount(@Param(Constants.WRAPPER) Wrapper<MesPrimaryProducePlan> wrapper);

    @Select("select sum(plan_num-pass_num-fail_num) from mes_primary_produce_plan ${ew.customSqlSegment}")
    Integer undoCount(@Param(Constants.WRAPPER) Wrapper<MesPrimaryProducePlan> wrapper);

    @Select("select sum(plan_num) from mes_primary_produce_plan ${ew.customSqlSegment}")
    Integer planCount(@Param(Constants.WRAPPER) Wrapper<MesPrimaryProducePlan> wrapper);
}
