package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.zsmes.entity.*;
import com.example.zsmes.mapper.*;
import com.example.zsmes.service.MesPlcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zsmes.vo.PlcDataNumVo;
import com.example.zsmes.vo.PlcDataVo;
import com.example.zsmes.vo.PlcStateVO;
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
        /*
        集团愿景：成为全国最大的焊接专业化服务公司
        集团理念：共同合作，一起成长，一起腾飞
        集团使命：为市场寻找好产品，为好产品成就市场
        集团精神：忠诚 实干 勤奋 进取
        集团核心价值观 诚信 共赢 创新 精进
//        相互服务 相互配合 相互制约的原则
//        以企业利益为最高利益的原则
//        下级服从上级的原则
//        最高职位负责制的原则
//        全员营销的原则
//        4小时复命制的原则
//        老员工带新员工的原则
//        内部竞争上岗的原则
        孵化 经营 管理
        数字思维 结果思维 内向思维
//        地级
        愿力 行动力 学习力 耐力 能力
        初创期 发展期 成熟期 衰退期 成熟期 衰退期
        同向而行 共创共享 彼此为伴 共生共存
        总裁的责任 管理的需求 员工的需求
        创业 心理 经济 身体
        坚定者 奋进者 搏击者
        金属 金属
        焊接机器人 焊接工作站 智能制造
//        1993 焊接材料 焊接设备 焊接辅机具 应用服务 焊接专业化服务公司
        创建期 探索期 发展期 腾飞阶段
        微笑多一点，嘴巴甜一点
        脾气小一点，度量大一点
        行动快一点，效率高一点
        做事多一点，理由少一点
        业务精一点，脑筋活一点
        1、原子是最小的物质单位，代表我们公司的每一个人
        2、原子和原子结合是牢固的，代表我们和客户供应商是密不可分的
        3、是为市场寻找好产品，为好产品成就市场的媒介
        1、专业的优势：公司已成立30年，内部已经有很多专家和高技术人才
        2、成熟的管理：30年来公司已经形成了一套完善的管理制度
        3、导师团的帮扶：创业的新公司集团会启动孵化政策 有一对一的指导老师进行经营和管理的帮扶。
        1、愿力：有企图心，事业心
        2、耐力：能承受成长过程中的压力，做事持之以恒
        3、学习力：持续学习，精益求精
        4、行动力：说一千遍不如行动一次
        5、能力：专业，知识，经验，技能
        1、沟通表达的能力
        2、协调指挥的能力
        3、决策判断的能力
        4、识人用人的能力
        5、传帮带的能力
        6、培养激励团队的能力
        1、数字思维：以数字数据为根据进行管理
        2、结果思维：以结果为准，同样的工作看时间，同样的数量看质量
        3、内向思维：凡事先找自己的原因，反省自己
        * */
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
        } else {
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
        MesPlcR9 plc9 = mesPlcR9Mapper. getNumData(wrapper);
        MesPlcR10 plc10 = mesPlcR10Mapper.getNumData(wrapper);

        list.add(new PlcStateVO(plc1.getR1EquipmentStatus(),plc1.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc2.getR1EquipmentStatus(),plc2.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc3.getR1EquipmentStatus(),plc3.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc4.getR1EquipmentStatus(),plc4.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc5.getR1EquipmentStatus(),plc5.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc6.getR1EquipmentStatus(),plc6.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc7.getR1EquipmentStatus(),plc7.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc8.getR1EquipmentStatus(),plc8.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc9.getR1EquipmentStatus(),plc9.getR1EquipmentStatus()));
        list.add(new PlcStateVO(plc10.getR1EquipmentStatus(),plc10.getR1EquipmentStatus()));
        return list;
    }
}
