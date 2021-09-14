package com.example.zsmes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesStation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zsmes.vo.StationCondition;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
public interface MesStationService extends IService<MesStation> {

    String addStation(MesStation mesStation);

    IPage<MesStation> queryByList(int page, int limit, StationCondition stationCondition);

    String updateStation(MesStation mesStation);

    String deleteBySelectIds(List<String> deleteIds);
}
