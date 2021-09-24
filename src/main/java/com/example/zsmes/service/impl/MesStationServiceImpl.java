package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zsmes.entity.MesEquipment;
import com.example.zsmes.entity.MesStation;
import com.example.zsmes.mapper.MesStationMapper;
import com.example.zsmes.service.MesStationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zsmes.utils.GetUUID;
import com.example.zsmes.vo.StationCondition;
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
public class MesStationServiceImpl extends ServiceImpl<MesStationMapper, MesStation> implements MesStationService {

    @Autowired
    private MesStationMapper mesStationMapper;

    @Override
    public String addStation(MesStation mesStation) {
        mesStation.setId(GetUUID.getUUID());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("station_no", mesStation.getStationNo());
        List<MesEquipment> list = mesStationMapper.selectList(wrapper);
        if (list.size() > 0) {
            return "添加失败，存在相同工位号的工位";
        } else {
            mesStation.setStatus("0");
            mesStationMapper.insert(mesStation);
            return "添加成功";
        }
    }

    @Override
    public IPage<MesStation> queryByList(int currentpage, int limit, StationCondition stationCondition) {
        Page<MesStation> page = new Page<>(currentpage, limit);
        QueryWrapper wrapper = new QueryWrapper();
        String stationName = stationCondition.getStationName();
        System.out.println(stationName);
        String status = stationCondition.getStatus();
        if (!StringUtils.isEmpty(stationName)) {
            wrapper.like("station_name", stationName);
        }
        if (!StringUtils.isEmpty(status)) {
            wrapper.eq("status", status);
        }
        IPage<MesStation> stationIPage = mesStationMapper.selectPage(page, wrapper);
        return stationIPage;
    }

    @Override
    public String updateStation(MesStation mesStation) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("station_no", mesStation.getStationNo());
        List<MesStation> list = mesStationMapper.selectList(wrapper);
        if (list.size() > 0) {
            MesStation station = list.get(0);
            station.setStationName(mesStation.getStationName());
            station.setStatus(mesStation.getStatus());
            mesStationMapper.updateById(station);
            return "修改成功";
        }
        return "修改失败，不存在该工位号的工位";
    }

    @Override
    public String deleteBySelectIds(List<String> deleteIds) {
        int sum = mesStationMapper.deleteBatchIds(deleteIds);
        if (sum > 0) {
            System.out.println(sum);
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @Override
    public List<MesStation> queryAllStation() {
        return mesStationMapper.selectList(null);
    }
}
