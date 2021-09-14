package com.example.zsmes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesEquipmentFaultHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zsmes.vo.FaultHistoryCondition;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
public interface MesEquipmentFaultHistoryService extends IService<MesEquipmentFaultHistory> {
    public String addFaultHistoryService(MesEquipmentFaultHistory mesEquipmentFaultHistory);

    IPage<MesEquipmentFaultHistory> queryByList(int page, int limit, FaultHistoryCondition faultHistoryCondition);

    String deleteBySelectIds(List<String> deleteIds);
}
