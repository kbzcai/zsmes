package com.example.zsmes.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.zsmes.entity.MesPlc;
import com.example.zsmes.entity.MesPlcR3;
import com.example.zsmes.entity.MesPlcR5;
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
public interface MesPlcR5Mapper extends BaseMapper<MesPlcR5> {

    @Select("SELECT * FROM mes_plc_r5 ${ew.customSqlSegment} WHERE id > (SELECT MAX(id) FROM mes_plc_r5) - 20")
    List<MesPlcR5> getLastestData(@Param(Constants.WRAPPER) Wrapper<MesPlcR5> wrapper);

    @Select("SELECT * FROM mes_plc_r5 ${ew.customSqlSegment} order by create_time desc LIMIT 1")
    MesPlcR5 getNumData(@Param(Constants.WRAPPER) Wrapper<MesPlcR5> wrapper);

}
