package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zsmes.entity.MesEquipment;
import com.example.zsmes.entity.MesEquipmentFaultHistory;
import com.example.zsmes.mapper.MesEquipmentFaultHistoryMapper;
import com.example.zsmes.mapper.MesEquipmentMapper;
import com.example.zsmes.service.MesEquipmentFaultHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zsmes.utils.GetUUID;
import com.example.zsmes.vo.FaultHistoryCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
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
public class MesEquipmentFaultHistoryServiceImpl extends ServiceImpl<MesEquipmentFaultHistoryMapper, MesEquipmentFaultHistory> implements MesEquipmentFaultHistoryService {

    @Autowired
    private MesEquipmentFaultHistoryMapper mesEquipmentFaultHistoryMapper;

    @Autowired
    private MesEquipmentMapper mesEquipmentMapper;

    @Override
    public String addFaultHistoryService(MesEquipmentFaultHistory mesEquipmentFaultHistory) {
        mesEquipmentFaultHistory.setId(GetUUID.getUUID());
        int i = mesEquipmentFaultHistoryMapper.insert(mesEquipmentFaultHistory);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("equipment_no", mesEquipmentFaultHistory.getEquipmentNo());
        MesEquipment equipment = mesEquipmentMapper.selectOne(wrapper);
        equipment.setFailTime(mesEquipmentFaultHistory.getFaultStartTime());
        equipment.setEquipmentStatus("-1");
        mesEquipmentMapper.updateById(equipment);
        if (i > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @Override
    public IPage<MesEquipmentFaultHistory> queryByList(int currentpage, int limit, FaultHistoryCondition faultHistoryCondition) {
        Page<MesEquipmentFaultHistory> page = new Page<>(currentpage, limit);
        QueryWrapper wrapper=new QueryWrapper();
        String equipmentNo=faultHistoryCondition.getEquipmentNo();
        String beginTime=faultHistoryCondition.getBeginTime();
        String endTime=faultHistoryCondition.getEndTime();
        if(!StringUtils.isEmpty(equipmentNo)){
            wrapper.like("equipment_no",equipmentNo);
        }
        if (!StringUtils.isEmpty(beginTime)){
            wrapper.ge("fault_start_time",beginTime);
        }
        if (!StringUtils.isEmpty(endTime)){
            wrapper.le("fault_start_time",endTime);
        }
        IPage<MesEquipmentFaultHistory> faultHistoryIPage = mesEquipmentFaultHistoryMapper.selectPage(page, wrapper);
        return faultHistoryIPage;
    }

    @Override
    public String deleteBySelectIds(List<String> deleteIds) {
        int sum = mesEquipmentFaultHistoryMapper.deleteBatchIds(deleteIds);
        if (sum > 0) {
            System.out.println(sum);
            return "删除成功";
        } else {
            return "删除失败";
        }

    }
}
