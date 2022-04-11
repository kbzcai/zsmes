package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.zsmes.entity.*;
import com.example.zsmes.mapper.*;
import com.example.zsmes.service.MesPlcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zsmes.vo.PlcDataNumVo;
import com.example.zsmes.vo.PlcDataVo;
import com.example.zsmes.vo.PlcStateVO;
import com.example.zsmes.vo.PlcVO;
import org.apache.poi.ss.formula.functions.T;
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

    @Autowired
    private MesPlcR7Mapper mesPlcR7Mapper;

    @Autowired
    private MesPlcR8Mapper mesPlcR8Mapper;

    @Autowired
    private MesPlcR9Mapper mesPlcR9Mapper;

    @Autowired
    private MesPlcR10Mapper mesPlcR10Mapper;

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
        List<MesPlcR7> data7 = mesPlcR7Mapper.getLastestData(wrapper);
        List<MesPlcR8> data8 = mesPlcR8Mapper.getLastestData(wrapper);
        List<MesPlcR9> data9 = mesPlcR9Mapper.getLastestData(wrapper);
        List<MesPlcR10> data10 = mesPlcR10Mapper.getLastestData(wrapper);

        PlcDataVo plcDataVo = new PlcDataVo();
        PlcDataVo plcDataVo2 = new PlcDataVo();
        PlcDataVo plcDataVo3 = new PlcDataVo();
        PlcDataVo plcDataVo4 = new PlcDataVo();
        PlcDataVo plcDataVo5 = new PlcDataVo();
        PlcDataVo plcDataVo6 = new PlcDataVo();
        PlcDataVo plcDataVo7 = new PlcDataVo();
        PlcDataVo plcDataVo8 = new PlcDataVo();
        PlcDataVo plcDataVo9 = new PlcDataVo();
        PlcDataVo plcDataVo10 = new PlcDataVo();

        plcDataVo.setPlcName("plc1");
        plcDataVo2.setPlcName("plc2");
        plcDataVo3.setPlcName("plc3");
        plcDataVo4.setPlcName("plc4");
        plcDataVo5.setPlcName("plc5");
        plcDataVo6.setPlcName("plc6");
        plcDataVo7.setPlcName("plc7");
        plcDataVo8.setPlcName("plc8");
        plcDataVo9.setPlcName("plc9");
        plcDataVo10.setPlcName("plc10");

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
        List<String> plcElectricList7 = new ArrayList<>();
        List<String> plcVoltageList7 = new ArrayList<>();
        List<LocalDateTime> plctimeList7 = new ArrayList<>();
        List<String> plcElectricList8 = new ArrayList<>();
        List<String> plcVoltageList8 = new ArrayList<>();
        List<LocalDateTime> plctimeList8 = new ArrayList<>();
        List<String> plcElectricList9 = new ArrayList<>();
        List<String> plcVoltageList9 = new ArrayList<>();
        List<LocalDateTime> plctimeList9 = new ArrayList<>();
        List<String> plcElectricList10 = new ArrayList<>();
        List<String> plcVoltageList10 = new ArrayList<>();
        List<LocalDateTime> plctimeList10 = new ArrayList<>();

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

        for (MesPlcR7 mesplc : data7
        ) {
            plcElectricList7.add(mesplc.getR1Electric());
            plcVoltageList7.add(mesplc.getR1Voltage());
            plctimeList7.add(mesplc.getCreateTime());
        }
        plcDataVo7.setPlcElectric(plcElectricList7);
        plcDataVo7.setPlcVoltage(plcVoltageList7);
        plcDataVo7.setTime(plctimeList7);

        for (MesPlcR8 mesplc : data8
        ) {
            plcElectricList8.add(mesplc.getR1Electric());
            plcVoltageList8.add(mesplc.getR1Voltage());
            plctimeList8.add(mesplc.getCreateTime());
        }
        plcDataVo8.setPlcElectric(plcElectricList8);
        plcDataVo8.setPlcVoltage(plcVoltageList8);
        plcDataVo8.setTime(plctimeList8);

        for (MesPlcR9 mesplc : data9
        ) {
            plcElectricList9.add(mesplc.getR1Electric());
            plcVoltageList9.add(mesplc.getR1Voltage());
            plctimeList9.add(mesplc.getCreateTime());
        }
        plcDataVo9.setPlcElectric(plcElectricList9);
        plcDataVo9.setPlcVoltage(plcVoltageList9);
        plcDataVo9.setTime(plctimeList9);

        for (MesPlcR10 mesplc : data10
        ) {
            plcElectricList10.add(mesplc.getR1Electric());
            plcVoltageList10.add(mesplc.getR1Voltage());
            plctimeList10.add(mesplc.getCreateTime());
        }
        plcDataVo10.setPlcElectric(plcElectricList10);
        plcDataVo10.setPlcVoltage(plcVoltageList10);
        plcDataVo10.setTime(plctimeList10);

        list.add(plcDataVo);
        list.add(plcDataVo2);
        list.add(plcDataVo3);
        list.add(plcDataVo4);
        list.add(plcDataVo5);
        list.add(plcDataVo6);
        list.add(plcDataVo7);
        list.add(plcDataVo8);
        list.add(plcDataVo9);
        list.add(plcDataVo10);
        return list;
    }

    @Override
    public List<PlcDataNumVo> getNum() {
        List<PlcDataNumVo> list = new ArrayList<>();
        QueryWrapper wrapper = new QueryWrapper();
        MesPlc plc1 = mesPlcMapper.getNumData(wrapper);
        MesPlcR2 plc2 = mesPlcR2Mapper.getNumData(wrapper);
        MesPlcR3 plc3 = mesPlcR3Mapper.getNumData(wrapper);
        MesPlcR4 plc4 = mesPlcR4Mapper.getNumData(wrapper);
        MesPlcR5 plc5 = mesPlcR5Mapper.getNumData(wrapper);
        MesPlcR6 plc6 = mesPlcR6Mapper.getNumData(wrapper);
        MesPlcR7 plc7 = mesPlcR7Mapper.getNumData(wrapper);
        MesPlcR8 plc8 = mesPlcR8Mapper.getNumData(wrapper);
        MesPlcR9 plc9 = mesPlcR9Mapper.getNumData(wrapper);
        MesPlcR10 plc10 = mesPlcR10Mapper.getNumData(wrapper);

        MesPlc plc11 = mesPlcMapper.getNumDataR11(wrapper);
        MesPlc plc12 = mesPlcMapper.getNumDataR12(wrapper);
        MesPlc plc13 = mesPlcMapper.getNumDataR13(wrapper);
        MesPlc plc14 = mesPlcMapper.getNumDataR14(wrapper);
        MesPlc plc15 = mesPlcMapper.getNumDataR15(wrapper);

        list.add(new PlcDataNumVo(plc1.getProdNum(), plc1.getProdNumb()));
        list.add(new PlcDataNumVo(plc2.getProdNum(), plc2.getProdNumb()));
        list.add(new PlcDataNumVo(plc3.getProdNum(), plc3.getProdNumb()));
        list.add(new PlcDataNumVo(plc4.getProdNum(), plc4.getProdNumb()));
        list.add(new PlcDataNumVo(plc5.getProdNum(), plc5.getProdNumb()));
        list.add(new PlcDataNumVo(plc6.getProdNum(), plc6.getProdNumb()));
        list.add(new PlcDataNumVo(plc7.getProdNum(), plc7.getProdNumb()));
        list.add(new PlcDataNumVo(plc8.getProdNum(), plc8.getProdNumb()));
        list.add(new PlcDataNumVo(plc9.getProdNum(), plc9.getProdNumb()));
        list.add(new PlcDataNumVo(plc10.getProdNum(), plc10.getProdNumb()));
        list.add(new PlcDataNumVo(plc11.getProdNum(), plc11.getProdNumb()));
        list.add(new PlcDataNumVo(plc12.getProdNum(), plc12.getProdNumb()));
        list.add(new PlcDataNumVo(plc13.getProdNum(), plc13.getProdNumb()));
        list.add(new PlcDataNumVo(plc14.getProdNum(), plc14.getProdNumb()));
        list.add(new PlcDataNumVo(plc15.getProdNum(), plc15.getProdNumb()));
        return list;
    }

    @Override
    public PlcDataVo queryByNum(Integer num) {
        PlcDataVo plcDataVo = new PlcDataVo();
        QueryWrapper wrapper = new QueryWrapper();
        List<String> plcElectricList = new ArrayList<>();
        List<String> plcVoltageList = new ArrayList<>();
        List<LocalDateTime> timeList = new ArrayList<>();
        if (num.equals(1)) {
            plcDataVo.setPlcName("plc1");
            List<MesPlc> data = mesPlcMapper.getLastestData(wrapper);
            for (MesPlc plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(2)) {
            plcDataVo.setPlcName("plc2");
            List<MesPlcR2> data = mesPlcR2Mapper.getLastestData(wrapper);
            for (MesPlcR2 plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(3)) {
            plcDataVo.setPlcName("plc3");
            List<MesPlcR3> data = mesPlcR3Mapper.getLastestData(wrapper);
            for (MesPlcR3 plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(4)) {
            plcDataVo.setPlcName("plc4");
            List<MesPlcR4> data = mesPlcR4Mapper.getLastestData(wrapper);
            for (MesPlcR4 plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(5)) {
            plcDataVo.setPlcName("plc5");
            List<MesPlcR5> data = mesPlcR5Mapper.getLastestData(wrapper);
            for (MesPlcR5 plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(6)) {
            plcDataVo.setPlcName("plc6");
            List<MesPlcR6> data = mesPlcR6Mapper.getLastestData(wrapper);
            for (MesPlcR6 plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(7)) {
            plcDataVo.setPlcName("plc7");
            List<MesPlcR7> data = mesPlcR7Mapper.getLastestData(wrapper);
            for (MesPlcR7 plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(8)) {
            plcDataVo.setPlcName("plc8");
            List<MesPlcR8> data = mesPlcR8Mapper.getLastestData(wrapper);
            for (MesPlcR8 plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(9)) {
            plcDataVo.setPlcName("plc9");
            List<MesPlcR9> data = mesPlcR9Mapper.getLastestData(wrapper);
            for (MesPlcR9 plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(10)) {
            plcDataVo.setPlcName("plc10");
            List<MesPlcR10> data = mesPlcR10Mapper.getLastestData(wrapper);
            for (MesPlcR10 plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(11)) {
            plcDataVo.setPlcName("plc11");
            List<MesPlc> data = mesPlcMapper.getLastestDataR11(wrapper);
            for (MesPlc plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(12)) {
            plcDataVo.setPlcName("plc12");
            List<MesPlc> data = mesPlcMapper.getLastestDataR12(wrapper);
            for (MesPlc plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(13)) {
            plcDataVo.setPlcName("plc13");
            List<MesPlc> data = mesPlcMapper.getLastestDataR13(wrapper);
            for (MesPlc plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(14)) {
            plcDataVo.setPlcName("plc14");
            List<MesPlc> data = mesPlcMapper.getLastestDataR14(wrapper);
            for (MesPlc plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        } else if (num.equals(15)) {
            plcDataVo.setPlcName("plc15");
            List<MesPlc> data = mesPlcMapper.getLastestDataR15(wrapper);
            for (MesPlc plcData : data
            ) {
                plcElectricList.add(plcData.getR1Electric());
                plcVoltageList.add(plcData.getR1Voltage());
                timeList.add(plcData.getCreateTime());
            }
            plcDataVo.setPlcElectric(plcElectricList);
            plcDataVo.setPlcVoltage(plcVoltageList);
            plcDataVo.setTime(timeList);
        }
        return plcDataVo;
    }

    @Override
    public List<PlcStateVO> getState() {
        List<PlcStateVO> list = new ArrayList<>();

        QueryWrapper wrapper = new QueryWrapper();
        MesPlc plc1 = mesPlcMapper.getNumData(wrapper);
        MesPlcR2 plc2 = mesPlcR2Mapper.getNumData(wrapper);
        MesPlcR3 plc3 = mesPlcR3Mapper.getNumData(wrapper);
        MesPlcR4 plc4 = mesPlcR4Mapper.getNumData(wrapper);
        MesPlcR5 plc5 = mesPlcR5Mapper.getNumData(wrapper);
        MesPlcR6 plc6 = mesPlcR6Mapper.getNumData(wrapper);
        MesPlcR7 plc7 = mesPlcR7Mapper.getNumData(wrapper);
        MesPlcR8 plc8 = mesPlcR8Mapper.getNumData(wrapper);
        MesPlcR9 plc9 = mesPlcR9Mapper.getNumData(wrapper);
        MesPlcR10 plc10 = mesPlcR10Mapper.getNumData(wrapper);
        MesPlc plc11 = mesPlcMapper.getNumDataR11(wrapper);
        MesPlc plc12 = mesPlcMapper.getNumDataR12(wrapper);
        MesPlc plc13 = mesPlcMapper.getNumDataR13(wrapper);
        MesPlc plc14 = mesPlcMapper.getNumDataR14(wrapper);
        MesPlc plc15 = mesPlcMapper.getNumDataR15(wrapper);

        list.add(new PlcStateVO(plc1.getR1EquipmentStatus(), plc1.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc2.getR1EquipmentStatus(), plc2.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc3.getR1EquipmentStatus(), plc3.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc4.getR1EquipmentStatus(), plc4.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc5.getR1EquipmentStatus(), plc5.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc6.getR1EquipmentStatus(), plc6.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc7.getR1EquipmentStatus(), plc7.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc8.getR1EquipmentStatus(), plc8.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc9.getR1EquipmentStatus(), plc9.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc10.getR1EquipmentStatus(), plc10.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc11.getR1EquipmentStatus(), plc11.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc12.getR1EquipmentStatus(), plc12.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc13.getR1EquipmentStatus(), plc13.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc14.getR1EquipmentStatus(), plc14.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc15.getR1EquipmentStatus(), plc15.getR1EquipmentStatus()));
        return list;
    }

    @Override
    public List<PlcVO> getPlcRecentlyData() {
        List<PlcVO> plcVOList = new ArrayList<>();
        QueryWrapper wrapper = new QueryWrapper();

        MesPlc plc1 = mesPlcMapper.getNumData(wrapper);
        MesPlcR2 plc2 = mesPlcR2Mapper.getNumData(wrapper);
        MesPlcR3 plc3 = mesPlcR3Mapper.getNumData(wrapper);
        MesPlcR4 plc4 = mesPlcR4Mapper.getNumData(wrapper);
        MesPlcR5 plc5 = mesPlcR5Mapper.getNumData(wrapper);
        MesPlcR6 plc6 = mesPlcR6Mapper.getNumData(wrapper);
        MesPlcR7 plc7 = mesPlcR7Mapper.getNumData(wrapper);
        MesPlcR8 plc8 = mesPlcR8Mapper.getNumData(wrapper);
        MesPlcR9 plc9 = mesPlcR9Mapper.getNumData(wrapper);
        MesPlcR10 plc10 = mesPlcR10Mapper.getNumData(wrapper);
        MesPlc plc11 = mesPlcMapper.getNumDataR11(wrapper);
        MesPlc plc12 = mesPlcMapper.getNumDataR12(wrapper);
        MesPlc plc13 = mesPlcMapper.getNumDataR13(wrapper);
        MesPlc plc14 = mesPlcMapper.getNumDataR14(wrapper);
        MesPlc plc15 = mesPlcMapper.getNumDataR15(wrapper);

        plcVOList.add(new PlcVO("#01", plc1.getR1EquipmentStatus(), plc1.getR1EquipmentStatus(), plc1.getProdNum(), plc1.getProdNumb(), plc1.getR1Electric(), plc1.getR1Voltage(), plc1.getR2Electric(), plc1.getR2Voltage(), plc1.getCreateTime()));
        plcVOList.add(new PlcVO("#02", plc2.getR1EquipmentStatus(), plc2.getR1EquipmentStatus(), plc2.getProdNum(), plc2.getProdNumb(), plc2.getR1Electric(), plc2.getR1Voltage(), plc2.getR2Electric(), plc2.getR2Voltage(), plc2.getCreateTime()));
        plcVOList.add(new PlcVO("#03", plc3.getR1EquipmentStatus(), plc3.getR1EquipmentStatus(), plc3.getProdNum(), plc3.getProdNumb(), plc3.getR1Electric(), plc3.getR1Voltage(), plc3.getR2Electric(), plc3.getR2Voltage(), plc3.getCreateTime()));
        plcVOList.add(new PlcVO("#04", plc4.getR1EquipmentStatus(), plc4.getR1EquipmentStatus(), plc4.getProdNum(), plc4.getProdNumb(), plc4.getR1Electric(), plc4.getR1Voltage(), plc4.getR2Electric(), plc4.getR2Voltage(), plc4.getCreateTime()));
        plcVOList.add(new PlcVO("#05", plc5.getR1EquipmentStatus(), plc5.getR1EquipmentStatus(), plc5.getProdNum(), plc5.getProdNumb(), plc5.getR1Electric(), plc5.getR1Voltage(), plc5.getR2Electric(), plc5.getR2Voltage(), plc5.getCreateTime()));
        plcVOList.add(new PlcVO("#06", plc6.getR1EquipmentStatus(), plc6.getR1EquipmentStatus(), plc6.getProdNum(), plc6.getProdNumb(), plc6.getR1Electric(), plc6.getR1Voltage(), plc6.getR2Electric(), plc6.getR2Voltage(), plc6.getCreateTime()));
        plcVOList.add(new PlcVO("#07", plc7.getR1EquipmentStatus(), plc7.getR1EquipmentStatus(), plc7.getProdNum(), plc7.getProdNumb(), plc7.getR1Electric(), plc7.getR1Voltage(), plc7.getR2Electric(), plc7.getR2Voltage(), plc7.getCreateTime()));
        plcVOList.add(new PlcVO("#08", plc8.getR1EquipmentStatus(), plc8.getR1EquipmentStatus(), plc8.getProdNum(), plc8.getProdNumb(), plc8.getR1Electric(), plc8.getR1Voltage(), plc8.getR2Electric(), plc8.getR2Voltage(), plc8.getCreateTime()));
        plcVOList.add(new PlcVO("#09", plc9.getR1EquipmentStatus(), plc9.getR1EquipmentStatus(), plc9.getProdNum(), plc9.getProdNumb(), plc9.getR1Electric(), plc9.getR1Voltage(), plc9.getR2Electric(), plc9.getR2Voltage(), plc9.getCreateTime()));
        plcVOList.add(new PlcVO("#10", plc10.getR1EquipmentStatus(), plc10.getR1EquipmentStatus(), plc10.getProdNum(), plc10.getProdNumb(), plc10.getR1Electric(), plc10.getR1Voltage(), plc10.getR2Electric(), plc10.getR2Voltage(), plc10.getCreateTime()));
        plcVOList.add(new PlcVO("#11", plc11.getR1EquipmentStatus(), plc11.getR1EquipmentStatus(), plc11.getProdNum(), plc11.getProdNumb(), plc11.getR1Electric(), plc11.getR1Voltage(), plc11.getR2Electric(), plc11.getR2Voltage(), plc11.getCreateTime()));
        plcVOList.add(new PlcVO("#12", plc12.getR1EquipmentStatus(), plc12.getR1EquipmentStatus(), plc12.getProdNum(), plc12.getProdNumb(), plc12.getR1Electric(), plc12.getR1Voltage(), plc12.getR2Electric(), plc12.getR2Voltage(), plc12.getCreateTime()));
        plcVOList.add(new PlcVO("#13", plc13.getR1EquipmentStatus(), plc13.getR1EquipmentStatus(), plc13.getProdNum(), plc13.getProdNumb(), plc13.getR1Electric(), plc13.getR1Voltage(), plc13.getR2Electric(), plc13.getR2Voltage(), plc13.getCreateTime()));
        plcVOList.add(new PlcVO("#14", plc14.getR1EquipmentStatus(), plc14.getR1EquipmentStatus(), plc14.getProdNum(), plc14.getProdNumb(), plc14.getR1Electric(), plc14.getR1Voltage(), plc14.getR2Electric(), plc14.getR2Voltage(), plc14.getCreateTime()));
        plcVOList.add(new PlcVO("#15", plc15.getR1EquipmentStatus(), plc15.getR1EquipmentStatus(), plc15.getProdNum(), plc15.getProdNumb(), plc15.getR1Electric(), plc15.getR1Voltage(), plc15.getR2Electric(), plc15.getR2Voltage(), plc15.getCreateTime()));
        return plcVOList;
    }
}
