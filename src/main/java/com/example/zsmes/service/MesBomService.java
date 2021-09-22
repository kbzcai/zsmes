package com.example.zsmes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesBom;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zsmes.vo.BomCondition;
import com.example.zsmes.vo.BomVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
public interface MesBomService extends IService<MesBom> {
    public List<MesBom> changeToBomList(List<Map<String,Object>> bomList);

    List<MesBom> queryByProductNo(String productNo);

    IPage<MesBom> queryByList(int page, int limit, BomCondition bomCondition);

    String updateBom(MesBom mesBom);

    MesBom queryByMaterialNo(String materialNo);

    String importBom(List<Map<String, Object>> excelInfo);
}
