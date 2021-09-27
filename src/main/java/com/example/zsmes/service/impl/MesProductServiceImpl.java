package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zsmes.entity.MesPrimaryProducePlan;
import com.example.zsmes.entity.MesProduct;
import com.example.zsmes.entity.MesProductLine;
import com.example.zsmes.mapper.MesBomMapper;
import com.example.zsmes.mapper.MesPrimaryProducePlanMapper;
import com.example.zsmes.mapper.MesProductLineMapper;
import com.example.zsmes.mapper.MesProductMapper;
import com.example.zsmes.service.MesProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zsmes.utils.PageParam;
import com.example.zsmes.vo.ProductCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@Service
public class MesProductServiceImpl extends ServiceImpl<MesProductMapper, MesProduct> implements MesProductService {

    @Autowired
    private MesPrimaryProducePlanMapper mesPrimaryProducePlanMapper;

    @Autowired
    private MesProductLineMapper mesProductLineMapper;

    @Autowired
    private MesProductMapper mesProductMapper;

    @Autowired
    private MesBomMapper mesBomMapper;

    @Override
    public Page<MesPrimaryProducePlan> queryPageList(String planno, String status, String stime, String etime, PageParam pageParam) {
        Page<MesPrimaryProducePlan> page = new Page<>(pageParam.getCurrent(), pageParam.getSize());
        QueryWrapper wrapper = new QueryWrapper();
        Page<MesPrimaryProducePlan> result = mesPrimaryProducePlanMapper.selectPage(page, wrapper);
        System.out.println(result.getSize());
        System.out.println(result.getTotal());
        result.getRecords().forEach(System.out::println);
        return result;
    }

    @Override
    public String insertProducePlan(MesPrimaryProducePlan mesPrimaryProducePlan) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("order_no", mesPrimaryProducePlan.getOrderNo());
        System.out.println(mesPrimaryProducePlan.getOrderNo());
        MesPrimaryProducePlan plan = mesPrimaryProducePlanMapper.selectOne(wrapper);
        if (plan != null) {
            return "插入失败，已存在该编号的订单";
        }
        //随机id
        Random random = new Random();
        Long id = random.nextLong();
        id = Math.abs(id);
        mesPrimaryProducePlan.setId(id);
        //随机plan_no
        Random random1 = new Random();
        int plan_noid = random.nextInt(100000);
        id = Math.abs(id);
        String plan_date = mesPrimaryProducePlan.getPlanDate().toString();
        System.out.println(mesPrimaryProducePlan.getPlanDate());
        String plan_no = "JH" + plan_date.substring(0, 4) + plan_date.substring(5, 7) + plan_date.substring(8, 10) + "#" + String.valueOf(plan_noid);
        System.out.println(plan_no);
        mesPrimaryProducePlan.setPlanNo(plan_no);
        mesPrimaryProducePlan.setModifyTime(mesPrimaryProducePlan.getPlanDate());
        System.out.println(mesPrimaryProducePlan);
        mesPrimaryProducePlanMapper.insert(mesPrimaryProducePlan);
        return "插入成功";
    }

    @Override
    public String updateProducePlan(MesPrimaryProducePlan mesPrimaryProducePlan) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("order_no", mesPrimaryProducePlan.getOrderNo());
        System.out.println(mesPrimaryProducePlan.getOrderNo());
        MesPrimaryProducePlan plan = mesPrimaryProducePlanMapper.selectOne(wrapper);
        if (plan == null) {
            return "更新失败，该编号的订单不存在";
        }
        mesPrimaryProducePlanMapper.updateById(mesPrimaryProducePlan);
        return "更新成功";
    }

    @Override
    public String deletePlanById(String id) {
        MesPrimaryProducePlan plan = mesPrimaryProducePlanMapper.selectById(id);
        if (plan == null) {
            return "删除失败，该计划不存在，请刷新";
        }
        mesPrimaryProducePlanMapper.deleteById(id);
        return "删除成功";
    }

    @Override
    public Integer queryPassNumByTime(String stime, String etime) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.ge("plan_date", stime);
        wrapper.le("plan_date", etime);
        Integer pass_num = mesPrimaryProducePlanMapper.passCount(wrapper);
        return pass_num;
    }

    @Override
    public Integer queryFailNumByTime(String stime, String etime) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.ge("plan_date", stime);
        wrapper.le("plan_date", etime);
        Integer fail_num = mesPrimaryProducePlanMapper.failCount(wrapper);
        return fail_num;
    }

    @Override
    public Integer queryUndoNumByTime(String stime, String etime) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.ge("plan_date", stime);
        wrapper.le("plan_date", etime);
        Integer undo_num = mesPrimaryProducePlanMapper.undoCount(wrapper);
        return undo_num;
    }

    @Override
    public Integer queryPlanNumByTime(String stime, String etime) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.ge("plan_date", stime);
        wrapper.le("plan_date", etime);
        Integer plan_num = mesPrimaryProducePlanMapper.planCount(wrapper);
        return plan_num;
    }

    @Override
    public MesProductLine queryNowProductLine() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("status", 1);
        MesProductLine mesProductLine = mesProductLineMapper.selectOne(wrapper);
        return mesProductLine;
    }

    @Override
    public MesPrimaryProducePlan findPlanByPlanNo(String plan_no) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("plan_no", plan_no);
        MesPrimaryProducePlan mesPrimaryProducePlan = mesPrimaryProducePlanMapper.selectOne(wrapper);
        return mesPrimaryProducePlan;
    }

    @Override
    public String AutoFill(String plan_no) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("plan_no", plan_no);
        MesPrimaryProducePlan mesPrimaryProducePlan = mesPrimaryProducePlanMapper.selectOne(wrapper);
        mesPrimaryProducePlan.setPassNum(mesPrimaryProducePlan.getPlanNum() - mesPrimaryProducePlan.getFailNum());
        mesPrimaryProducePlanMapper.updateById(mesPrimaryProducePlan);
        return "填充成功";
    }

    @Override
    public IPage<MesProduct> queryByList(int currentpage, int limit, ProductCondition productCondition) {
        Page<MesProduct> page = new Page<>(currentpage, limit);
        QueryWrapper wrapper = new QueryWrapper();
        String productNo = productCondition.getProductNo();
        System.out.println(productNo);
        if (!StringUtils.isEmpty(productNo)) {
            wrapper.like("product_no", productNo);
        }
        IPage<MesProduct> productIPage = mesProductMapper.selectPage(page, wrapper);
        return productIPage;
    }

    @Override
    public String deleteBySelectIds(List<String> deleteIds) {
        for (String id : deleteIds
        ) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("product_no", mesProductMapper.selectById(id).getProductNo());
            mesBomMapper.delete(wrapper);
        }
        int sum = mesProductMapper.deleteBatchIds(deleteIds);
        if (sum > 0) {
            System.out.println(sum);
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @Override
    public List<MesProduct> queryAllProduct() {
        return mesProductMapper.selectList(null);
    }


}
