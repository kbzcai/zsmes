package com.example.zsmes.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.zsmes.entity.MesPlcR2;
import com.example.zsmes.entity.MesPlcR7;
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
public interface MesPlcR7Mapper extends BaseMapper<MesPlcR7> {

    @Select("SELECT * FROM mes_plc_r7 ${ew.customSqlSegment} WHERE id > (SELECT MAX(id) FROM mes_plc_r7) - 20")
    List<MesPlcR7> getLastestData(@Param(Constants.WRAPPER) Wrapper<MesPlcR7> wrapper);

    @Select("SELECT * FROM mes_plc_r7 ${ew.customSqlSegment} order by create_time desc LIMIT 1")
    MesPlcR7 getNumData(@Param(Constants.WRAPPER) Wrapper<MesPlcR7> wrapper);
}
