package com.example.zsmes.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.*;
import com.example.zsmes.service.MesProductService;
import com.example.zsmes.utils.GetFirstDayAndLastDay;
import com.example.zsmes.utils.GetMondayAndSunday;
import com.example.zsmes.utils.GetToday;
import com.example.zsmes.utils.Md5Util;
import com.example.zsmes.vo.ProductCondition;
import com.example.zsmes.vo.ProductVO;
import com.example.zsmes.vo.RepairHistoryCondition;
import com.example.zsmes.vo.RepairHistoryVO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@RestController
@RequestMapping("/mesProduct")
public class MesProductController {

    @Autowired
    private MesProductService mesProductService;

    @PostMapping("/queryByList/{page}/{limit}")
    public ProductVO queryByList(@PathVariable("page") int page, @PathVariable("limit") int limit, @RequestBody(required = false) ProductCondition productCondition){
        IPage<MesProduct> productIPage = mesProductService.queryByList(page, limit,productCondition);
        ProductVO productVO=new ProductVO();
        productVO.setCurrent(page);
        productVO.setData(productIPage.getRecords());
        productVO.setLimit(limit);
        productVO.setTotal(productIPage.getTotal());
        productVO.setPages(productIPage.getPages());
        return productVO;
    }

    @GetMapping("/queryAllProductNo")
    public List<String> queryAllProductNo() {
        return mesProductService.queryAllProductNo();
    }

    @DeleteMapping("/deleteBySelectIds/{deleteIds}")
    public String deleteBySelectIds(@PathVariable("deleteIds") List<String> deleteIds){
        return mesProductService.deleteBySelectIds(deleteIds);
    }

    @GetMapping("/queryAllProduct")
    public List<MesProduct> queryAllProduct(){
        return mesProductService.queryAllProduct();
    }
}

