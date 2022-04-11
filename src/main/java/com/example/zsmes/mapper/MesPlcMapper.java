package com.example.zsmes.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.zsmes.entity.MesPlc;
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
public interface MesPlcMapper extends BaseMapper<MesPlc> {
    @Select("SELECT * FROM mes_plc ${ew.customSqlSegment} WHERE id > (SELECT MAX(id) FROM mes_plc) - 20")
    List<MesPlc> getLastestData(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);

    @Select("SELECT * FROM mes_plc_r11 ${ew.customSqlSegment} WHERE id > (SELECT MAX(id) FROM mes_plc_r11) - 20")
    List<MesPlc> getLastestDataR11(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);

    @Select("SELECT * FROM mes_plc_r12 ${ew.customSqlSegment} WHERE id > (SELECT MAX(id) FROM mes_plc_r12) - 20")
    List<MesPlc> getLastestDataR12(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);

    @Select("SELECT * FROM mes_plc_r13 ${ew.customSqlSegment} WHERE id > (SELECT MAX(id) FROM mes_plc_r13) - 20")
    List<MesPlc> getLastestDataR13(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);

    @Select("SELECT * FROM mes_plc_r14 ${ew.customSqlSegment} WHERE id > (SELECT MAX(id) FROM mes_plc_r14) - 20")
    List<MesPlc> getLastestDataR14(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);

    @Select("SELECT * FROM mes_plc_r15 ${ew.customSqlSegment} WHERE id > (SELECT MAX(id) FROM mes_plc_r15) - 20")
    List<MesPlc> getLastestDataR15(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);

    @Select("SELECT * FROM mes_plc ${ew.customSqlSegment} order by create_time desc LIMIT 1")
    MesPlc getNumData(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);

    @Select("SELECT * FROM mes_plc_r11 ${ew.customSqlSegment} order by create_time desc LIMIT 1")
    MesPlc getNumDataR11(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);

    @Select("SELECT * FROM mes_plc_r12 ${ew.customSqlSegment} order by create_time desc LIMIT 1")
    MesPlc getNumDataR12(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);

    @Select("SELECT * FROM mes_plc_r13 ${ew.customSqlSegment} order by create_time desc LIMIT 1")
    MesPlc getNumDataR13(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);

    @Select("SELECT * FROM mes_plc_r14 ${ew.customSqlSegment} order by create_time desc LIMIT 1")
    MesPlc getNumDataR14(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);

    @Select("SELECT * FROM mes_plc_r15 ${ew.customSqlSegment} order by create_time desc LIMIT 1")
    MesPlc getNumDataR15(@Param(Constants.WRAPPER) Wrapper<MesPlc> wrapper);
}
