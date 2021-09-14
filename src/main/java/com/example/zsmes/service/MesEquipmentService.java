package com.example.zsmes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesEquipment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zsmes.vo.EquipmentCondition;
import com.example.zsmes.vo.EquipmentVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
public interface MesEquipmentService extends IService<MesEquipment> {
    public String editByEquipmentNo(MesEquipment mesEquipment);

    public String addMesEquipment(MesEquipment mesEquipment);

    String deleteBySelectIds(List<String> deleteIds);

    IPage<MesEquipment> queryByList(int page, int limit, EquipmentCondition equipmentCondition);
}
