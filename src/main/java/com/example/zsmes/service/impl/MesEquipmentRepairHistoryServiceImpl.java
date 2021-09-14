package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zsmes.entity.MesEquipment;
import com.example.zsmes.entity.MesEquipmentFaultHistory;
import com.example.zsmes.entity.MesEquipmentRepairHistory;
import com.example.zsmes.mapper.MesEquipmentMapper;
import com.example.zsmes.mapper.MesEquipmentRepairHistoryMapper;
import com.example.zsmes.service.MesEquipmentRepairHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zsmes.utils.GetUUID;
import com.example.zsmes.vo.RepairHistoryCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@Service
public class MesEquipmentRepairHistoryServiceImpl extends ServiceImpl<MesEquipmentRepairHistoryMapper, MesEquipmentRepairHistory> implements MesEquipmentRepairHistoryService {

    @Autowired
    private MesEquipmentRepairHistoryMapper mesEquipmentRepairHistoryMapper;

    @Autowired
    private MesEquipmentMapper mesEquipmentMapper;

    @Override
    public String addRepairHistory(MesEquipmentRepairHistory mesEquipmentRepairHistory) {
        mesEquipmentRepairHistory.setId(GetUUID.getUUID());
        int i = mesEquipmentRepairHistoryMapper.insert(mesEquipmentRepairHistory);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("equipment_no", mesEquipmentRepairHistory.getEquipmentNo());
        MesEquipment equipment = mesEquipmentMapper.selectOne(wrapper);
        equipment.setRepairTime(mesEquipmentRepairHistory.getRepairTime());
        equipment.setEquipmentStatus("0");

        mesEquipmentMapper.updateById(equipment);
        if (i > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @Override
    public IPage<MesEquipmentRepairHistory> queryByList(int currentpage, int limit, RepairHistoryCondition repairHistoryCondition) {
        Page<MesEquipmentRepairHistory> page = new Page<>(currentpage, limit);
        QueryWrapper wrapper = new QueryWrapper();
        String equipmentNo = repairHistoryCondition.getEquipmentNo();
        String beginTime = repairHistoryCondition.getBeginTime();
        String endTime = repairHistoryCondition.getEndTime();
        if (!StringUtils.isEmpty(equipmentNo)) {
            wrapper.like("equipment_no", equipmentNo);
        }
        if (!StringUtils.isEmpty(beginTime)) {
            wrapper.ge("repair_time", beginTime);
        }
        if (!StringUtils.isEmpty(endTime)) {
            wrapper.le("repair_time", endTime);
        }
        IPage<MesEquipmentRepairHistory> repairHistoryIPage = mesEquipmentRepairHistoryMapper.selectPage(page, wrapper);
        return repairHistoryIPage;
    }

    @Override
    public String deleteBySelectIds(List<String> deleteIds) {
        int sum = mesEquipmentRepairHistoryMapper.deleteBatchIds(deleteIds);
        if (sum > 0) {
            System.out.println(sum);
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
