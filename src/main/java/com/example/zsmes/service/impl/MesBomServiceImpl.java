package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zsmes.entity.MesBom;
import com.example.zsmes.entity.MesProduct;
import com.example.zsmes.entity.MesStation;
import com.example.zsmes.mapper.MesBomMapper;
import com.example.zsmes.mapper.MesProductMapper;
import com.example.zsmes.mapper.MesStationMapper;
import com.example.zsmes.service.MesBomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zsmes.utils.GetUUID;
import com.example.zsmes.vo.BomCondition;
import com.example.zsmes.vo.BomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@Service
public class MesBomServiceImpl extends ServiceImpl<MesBomMapper, MesBom> implements MesBomService {

    @Autowired
    private MesBomMapper mesBomMapper;

    @Autowired
    private MesStationMapper mesStationMapper;

    @Autowired
    private MesProductMapper mesProductMapper;

    @Override
    public List<MesBom> changeToBomList(List<Map<String, Object>> bomList) {
        for (Map<String, Object> map : bomList
        ) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("station_name", map.get("工位"));
            MesStation mesStation = mesStationMapper.selectOne(wrapper);
            map.put("工位", mesStation.getStationNo());
        }

        return null;
    }

    @Override
    public List<MesBom> queryByProductNo(String productNo) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("product_no", productNo);
        List list = mesBomMapper.selectList(wrapper);
        return list;
    }

    @Override
    public IPage<MesBom> queryByList(int currentpage, int limit, BomCondition bomCondition) {
        Page<MesBom> page = new Page<>(currentpage, limit);
        QueryWrapper wrapper = new QueryWrapper();
        String productNo = bomCondition.getProductNo();
        String materialNo = bomCondition.getMaterialNo();
        System.out.println(productNo);
        System.out.println(materialNo);
        if (!StringUtils.isEmpty(productNo)) {
            wrapper.like("product_no", productNo);
        }
        if (!StringUtils.isEmpty(materialNo)) {
            wrapper.like("material_no", materialNo);
        }
        IPage<MesBom> bomIPage = mesBomMapper.selectPage(page, wrapper);
        return bomIPage;
    }

    @Override
    public String updateBom(MesBom mesBom) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("material_no", mesBom.getMaterialNo());
        List<MesBom> list = mesBomMapper.selectList(wrapper);
        if (list.size() > 0) {
            MesBom bom = list.get(0);
            System.out.println(mesBom.getStationNo());
            if (!StringUtils.isEmpty(mesBom.getStationNo()) && !mesBom.getStationNo().equals("")) {
                bom.setStationNo(mesBom.getStationNo());
            }
            bom.setMaterialDesc(mesBom.getMaterialDesc());
            bom.setProductNum(mesBom.getProductNum());
            mesBomMapper.updateById(bom);
            return "修改成功";
        }
        return "修改失败！";
    }

    @Override
    public MesBom queryByMaterialNo(String materialNo) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("material_no", materialNo);
        List<MesBom> list = mesBomMapper.selectList(wrapper);
        return list.get(0);
    }

    @Override
    public String importBom(List<Map<String, Object>> excelInfo) {
        Map<String, Object> productNoMap = excelInfo.get(1);
        String productNo = (String) productNoMap.get("物料编码");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("product_no", productNo);
        List list = mesProductMapper.selectList(wrapper);
        if (list.size() > 0) {
            return "该产品已存在！";
        } else {
            MesProduct mesProduct = new MesProduct();
            mesProduct.setId(GetUUID.getUUID());
            mesProduct.setProductNo(productNo);
            mesProduct.setStatus("1");
            //添加
            mesProductMapper.insert(mesProduct);
            for (Map<String, Object> map : excelInfo
            ) {
                if (!map.get("层次").toString().equals("1") && !map.get("层次").toString().equals("2")) {
                    MesBom bom = new MesBom();
                    bom.setId(GetUUID.getUUID());
                    bom.setMaterialLevel(map.get("层次").toString());
                    QueryWrapper wrapper1 = new QueryWrapper();
                    wrapper1.eq("station_name", map.get("工位").toString());
                    List<MesStation> list1 = mesStationMapper.selectList(wrapper1);
                    if (list1.size() > 0) {
                        String stationNo = list1.get(0).getStationNo();
                        bom.setStationNo(stationNo);
                    }
                    bom.setProductNo(productNo);
                    bom.setMaterialNo(map.get("物料编码").toString());
                    bom.setMaterialDesc(map.get("物料描述").toString());
                    bom.setProductNum((Integer) map.get("数量"));
                    bom.setProductUnit(map.get("单位").toString());
                    bom.setWorkingHours(map.get("工时(min)").toString());
                    bom.setProductWeight(map.get("重量(g)").toString());
                    bom.setManufacturer(map.get("使用单位").toString());
                    bom.setStatus("1");
                    //添加
                    mesBomMapper.insert(bom);
                    System.out.println(bom);
                }
            }
            return "导入成功";
        }

    }
}
