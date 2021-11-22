package com.example.zsmes.service;

import com.example.zsmes.entity.MesPlc;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zsmes.vo.PlcDataNumVo;
import com.example.zsmes.vo.PlcDataVo;
import com.example.zsmes.vo.PlcStateVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
public interface MesPlcService extends IService<MesPlc> {
    public List<PlcDataVo> getPlcData();

    List<PlcDataNumVo> getNum();

    PlcDataVo queryByNum(Integer num);

    List<PlcStateVO> getState();
}
