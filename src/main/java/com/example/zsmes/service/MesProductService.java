package com.example.zsmes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.example.zsmes.entity.MesProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zsmes.entity.MesProductLine;
import com.example.zsmes.utils.PageParam;
import com.example.zsmes.vo.ProductCondition;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
public interface MesProductService extends IService<MesProduct> {
    public Page<MesPrimaryProducePlan> queryPageList(String planno, String status, String stime, String etime, PageParam pageParam);

    public String insertProducePlan(MesPrimaryProducePlan mesPrimaryProducePlan);

    public String updateProducePlan(MesPrimaryProducePlan mesPrimaryProducePlan);

    public String deletePlanById(String id);

    public Integer queryPassNumByTime(String stime, String etime);

    public Integer queryFailNumByTime(String stime, String etime);

    public Integer queryUndoNumByTime(String stime, String etime);

    public Integer queryPlanNumByTime(String stime, String etime);

    public MesProductLine queryNowProductLine();

    public MesPrimaryProducePlan findPlanByPlanNo(String plan_no);

    public String AutoFill(String plan_no);

    IPage<MesProduct> queryByList(int page, int limit, ProductCondition productCondition);

    String deleteBySelectIds(List<String> deleteIds);

    List<MesProduct> queryAllProduct();
}
