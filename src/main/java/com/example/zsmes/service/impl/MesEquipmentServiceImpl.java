package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zsmes.entity.MesEquipment;
import com.example.zsmes.entity.MesEquipmentFaultHistory;
import com.example.zsmes.entity.MesEquipmentRepairHistory;
import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.example.zsmes.mapper.MesEquipmentFaultHistoryMapper;
import com.example.zsmes.mapper.MesEquipmentMapper;
import com.example.zsmes.mapper.MesEquipmentRepairHistoryMapper;
import com.example.zsmes.service.MesEquipmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zsmes.vo.EquipmentCondition;
import com.example.zsmes.vo.EquipmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@Service
public class MesEquipmentServiceImpl extends ServiceImpl<MesEquipmentMapper, MesEquipment> implements MesEquipmentService {

    @Autowired
    private MesEquipmentMapper mesEquipmentMapper;

    @Autowired
    private MesEquipmentFaultHistoryMapper mesEquipmentFaultHistoryMapper;

    @Autowired
    private MesEquipmentRepairHistoryMapper mesEquipmentRepairHistoryMapper;

    @Override
    public String editByEquipmentNo(MesEquipment mesEquipment) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("equipment_no", mesEquipment.getEquipmentNo());
        List<MesEquipment> list = mesEquipmentMapper.selectList(wrapper);
        if (list.size() > 0) {
            MesEquipment equipment = list.get(0);
            equipment.setEquipmentName(mesEquipment.getEquipmentName());
            equipment.setEquipmentStatus(mesEquipment.getEquipmentStatus());
            equipment.setEquipmentNo(mesEquipment.getEquipmentNo());
            equipment.setFailTime(mesEquipment.getFailTime());
            equipment.setRepairTime(mesEquipment.getRepairTime());
            equipment.setInstallDate(mesEquipment.getInstallDate());
            mesEquipmentMapper.updateById(equipment);
            return "修改成功";
        }
        return "修改失败，不存在该设备号的机器";
    }

    @Override
    public String addMesEquipment(MesEquipment mesEquipment) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("equipment_no", mesEquipment.getEquipmentNo());
        List<MesEquipment> list = mesEquipmentMapper.selectList(wrapper);
        if (list.size() > 0) {
            return "添加失败，存在相同设备号的机器";
        } else {
            mesEquipmentMapper.insert(mesEquipment);
            return "添加成功";
        }
    }

    @Override
    public String deleteBySelectIds(List<String> deleteIds) {
        List<MesEquipment> mesEquipments = mesEquipmentMapper.selectBatchIds(deleteIds);
        System.out.println(mesEquipments);
        for (MesEquipment mesEquipment:mesEquipments
             ) {
            QueryWrapper wrapper=new QueryWrapper();
            String equipmentNo=mesEquipment.getEquipmentNo();
            wrapper.eq("equipment_no",equipmentNo);
            mesEquipmentFaultHistoryMapper.delete(wrapper);
            mesEquipmentRepairHistoryMapper.delete(wrapper);
        }
        int sum = mesEquipmentMapper.deleteBatchIds(deleteIds);
        if (sum > 0) {
            System.out.println(sum);
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @Override
    public IPage<MesEquipment> queryByList(int currentpage, int limit, EquipmentCondition equipmentCondition) {
        Page<MesEquipment> page = new Page<>(currentpage, limit);
        QueryWrapper wrapper=new QueryWrapper();
        String equipmentNo = equipmentCondition.getEquipmentNo();
        String beginTime = equipmentCondition.getBeginTime();
        String endTime = equipmentCondition.getEndTime();
        if (!StringUtils.isEmpty(equipmentNo)) {
            wrapper.like("equipment_no", equipmentNo);
        }
        if (!StringUtils.isEmpty(beginTime)) {
            wrapper.ge("install_date", beginTime);
        }
        if (!StringUtils.isEmpty(endTime)) {
            wrapper.le("install_date", endTime);
        }
        IPage<MesEquipment> mesEquipmentIPage = mesEquipmentMapper.selectPage(page, wrapper);
        return mesEquipmentIPage;
    }

    @Override
    public List<String> queryAllEquipmentNo() {
        List<MesEquipment> items = mesEquipmentMapper.selectList(null);
        List<String> equipmentNoList = items.stream().map(MesEquipment::getEquipmentNo).collect(Collectors.toList());// 取出其中一列
        System.out.println(equipmentNoList);
        return equipmentNoList;
    }
}
