package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.zsmes.entity.*;
import com.example.zsmes.mapper.*;
import com.example.zsmes.service.MesPlcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zsmes.vo.PlcDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
public class MesPlcServiceImpl extends ServiceImpl<MesPlcMapper, MesPlc> implements MesPlcService {

    @Autowired
    private MesPlcMapper mesPlcMapper;

    @Autowired
    private MesPlcR2Mapper mesPlcR2Mapper;

    @Autowired
    private MesPlcR3Mapper mesPlcR3Mapper;

    @Autowired
    private MesPlcR4Mapper mesPlcR4Mapper;

    @Autowired
    private MesPlcR5Mapper mesPlcR5Mapper;

    @Autowired
    private MesPlcR6Mapper mesPlcR6Mapper;

    @Override
    public List<PlcDataVo> getPlcData() {
        List<PlcDataVo> list = new ArrayList<>();

        QueryWrapper wrapper = new QueryWrapper();
        List<MesPlc> data1 = mesPlcMapper.getLastestData(wrapper);
        List<MesPlcR2> data2 = mesPlcR2Mapper.getLastestData(wrapper);
        List<MesPlcR3> data3 = mesPlcR3Mapper.getLastestData(wrapper);
        List<MesPlcR4> data4 = mesPlcR4Mapper.getLastestData(wrapper);
        List<MesPlcR5> data5 = mesPlcR5Mapper.getLastestData(wrapper);
        List<MesPlcR6> data6 = mesPlcR6Mapper.getLastestData(wrapper);

        PlcDataVo plcDataVo = new PlcDataVo();
        PlcDataVo plcDataVo2 = new PlcDataVo();
        PlcDataVo plcDataVo3 = new PlcDataVo();
        PlcDataVo plcDataVo4 = new PlcDataVo();
        PlcDataVo plcDataVo5 = new PlcDataVo();
        PlcDataVo plcDataVo6 = new PlcDataVo();

        plcDataVo.setPlcName("plc1");
        plcDataVo2.setPlcName("plc2");
        plcDataVo3.setPlcName("plc3");
        plcDataVo4.setPlcName("plc4");
        plcDataVo5.setPlcName("plc5");
        plcDataVo6.setPlcName("plc6");

        List<String> plcElectricList = new ArrayList<>();
        List<String> plcVoltageList = new ArrayList<>();
        List<LocalDateTime> plctimeList = new ArrayList<>();
        List<String> plcElectricList2 = new ArrayList<>();
        List<String> plcVoltageList2 = new ArrayList<>();
        List<LocalDateTime> plctimeList2 = new ArrayList<>();
        List<String> plcElectricList3 = new ArrayList<>();
        List<String> plcVoltageList3 = new ArrayList<>();
        List<LocalDateTime> plctimeList3 = new ArrayList<>();
        List<String> plcElectricList4 = new ArrayList<>();
        List<String> plcVoltageList4 = new ArrayList<>();
        List<LocalDateTime> plctimeList4 = new ArrayList<>();
        List<String> plcElectricList5 = new ArrayList<>();
        List<String> plcVoltageList5 = new ArrayList<>();
        List<LocalDateTime> plctimeList5 = new ArrayList<>();
        List<String> plcElectricList6 = new ArrayList<>();
        List<String> plcVoltageList6 = new ArrayList<>();
        List<LocalDateTime> plctimeList6 = new ArrayList<>();

        for (MesPlc mesplc : data1
        ) {
            plcElectricList.add(mesplc.getR1Electric());
            plcVoltageList.add(mesplc.getR1Voltage());
            plctimeList.add(mesplc.getCreateTime());
        }
        plcDataVo.setPlcElectric(plcElectricList);
        plcDataVo.setPlcVoltage(plcVoltageList);
        plcDataVo.setTime(plctimeList);

        for (MesPlcR2 mesplc : data2
        ) {
            plcElectricList2.add(mesplc.getR1Electric());
            plcVoltageList2.add(mesplc.getR1Voltage());
            plctimeList2.add(mesplc.getCreateTime());
        }
        plcDataVo2.setPlcElectric(plcElectricList2);
        plcDataVo2.setPlcVoltage(plcVoltageList2);
        plcDataVo2.setTime(plctimeList2);

        for (MesPlcR3 mesplc : data3
        ) {
            plcElectricList3.add(mesplc.getR1Electric());
            plcVoltageList3.add(mesplc.getR1Voltage());
            plctimeList3.add(mesplc.getCreateTime());
        }
        plcDataVo3.setPlcElectric(plcElectricList3);
        plcDataVo3.setPlcVoltage(plcVoltageList3);
        plcDataVo3.setTime(plctimeList3);

        for (MesPlcR4 mesplc : data4
        ) {
            plcElectricList4.add(mesplc.getR1Electric());
            plcVoltageList4.add(mesplc.getR1Voltage());
            plctimeList4.add(mesplc.getCreateTime());
        }
        plcDataVo4.setPlcElectric(plcElectricList4);
        plcDataVo4.setPlcVoltage(plcVoltageList4);
        plcDataVo4.setTime(plctimeList4);

        for (MesPlcR5 mesplc : data5
        ) {
            plcElectricList5.add(mesplc.getR1Electric());
            plcVoltageList5.add(mesplc.getR1Voltage());
            plctimeList5.add(mesplc.getCreateTime());
        }
        plcDataVo5.setPlcElectric(plcElectricList5);
        plcDataVo5.setPlcVoltage(plcVoltageList5);
        plcDataVo5.setTime(plctimeList5);

        for (MesPlcR6 mesplc : data6
        ) {
            plcElectricList6.add(mesplc.getR1Electric());
            plcVoltageList6.add(mesplc.getR1Voltage());
            plctimeList6.add(mesplc.getCreateTime());
        }
        plcDataVo6.setPlcElectric(plcElectricList6);
        plcDataVo6.setPlcVoltage(plcVoltageList6);
        plcDataVo6.setTime(plctimeList6);

        list.add(plcDataVo);
        list.add(plcDataVo2);
        list.add(plcDataVo3);
        list.add(plcDataVo4);
        list.add(plcDataVo5);
        list.add(plcDataVo6);

        return list;
    }
}
