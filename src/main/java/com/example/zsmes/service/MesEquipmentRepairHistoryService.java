package com.example.zsmes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesEquipmentRepairHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zsmes.vo.RepairHistoryCondition;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
public interface MesEquipmentRepairHistoryService extends IService<MesEquipmentRepairHistory> {
    public String addRepairHistory(MesEquipmentRepairHistory mesEquipmentRepairHistory);

    IPage<MesEquipmentRepairHistory> queryByList(int page, int limit, RepairHistoryCondition repairHistoryCondition);

    String deleteBySelectIds(List<String> deleteIds);

    List<String> queryAllEquipmentNo();
}
