package com.example.zsmes.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Select("select sum(welding_finish_num) from mes_primary_produce_plan ${ew.customSqlSegment}")
    Integer weldingFinishCount(@Param(Constants.WRAPPER) Wrapper<MesPrimaryProducePlan> wrapper);


    @Select("select * from mes_primary_produce_plan where to_days(plan_date) = to_days(now())")
    List<MesPrimaryProducePlan> queryDayList();

    @Select("select * from mes_primary_produce_plan where YEARWEEK(date_format(plan_date,'%Y-%m-%d')) = YEARWEEK(now())")
    List<MesPrimaryProducePlan> queryWeekList();

    @Select("select * from mes_primary_produce_plan where date_format(plan_date,'%Y%m') = date_format(CURDATE(),'%Y%m')")
    List<MesPrimaryProducePlan> queryMonthList();

    @Select("select sum(actual_num) from mes_primary_produce_plan where to_days(plan_date) = to_days(now())")
    Integer queryActualNumDay();

    @Select("select sum(actual_num) from mes_primary_produce_plan where YEARWEEK(date_format(plan_date,'%Y-%m-%d')) = YEARWEEK(now())")
    Integer queryActualNumWeek();

    @Select("select sum(actual_num) from mes_primary_produce_plan where date_format(plan_date,'%Y%m') = date_format(CURDATE(),'%Y%m')")
    Integer queryActualNumMonth();

    @Select("select sum(plan_num) from mes_primary_produce_plan where to_days(plan_date) = to_days(now())")
    Integer queryPlanNumDay();

    @Select("select sum(plan_num) from mes_primary_produce_plan where YEARWEEK(date_format(plan_date,'%Y-%m-%d')) = YEARWEEK(now())")
    Integer queryPlanNumWeek();

    @Select("select sum(plan_num) from mes_primary_produce_plan where date_format(plan_date,'%Y%m') = date_format(CURDATE(),'%Y%m')")
    Integer queryPlanNumMonth();

    @Select("select sum(fail_num) from mes_primary_produce_plan where to_days(plan_date) = to_days(now())")
    Integer queryFailNumDay();

    @Select("select sum(fail_num) from mes_primary_produce_plan where YEARWEEK(date_format(plan_date,'%Y-%m-%d')) = YEARWEEK(now())")
    Integer queryFailNumWeek();

    @Select("select sum(fail_num) from mes_primary_produce_plan where date_format(plan_date,'%Y%m') = date_format(CURDATE(),'%Y%m')")
    Integer queryFailNumMonth();

    @Select("select sum(welding_finish_num) from mes_primary_produce_plan where to_days(plan_date) = to_days(now())")
    Integer queryWeldingFinishNumDay();

    @Select("select sum(welding_finish_num) from mes_primary_produce_plan where YEARWEEK(date_format(plan_date,'%Y-%m-%d')) = YEARWEEK(now())")
    Integer queryWeldingFinishNumWeek();

    @Select("select sum(welding_finish_num) from mes_primary_produce_plan where date_format(plan_date,'%Y%m') = date_format(CURDATE(),'%Y%m')")
    Integer queryWeldingFinishNumMonth();
}
