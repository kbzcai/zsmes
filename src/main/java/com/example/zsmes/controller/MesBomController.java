package com.example.zsmes.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesBom;
import com.example.zsmes.service.MesBomService;
import com.example.zsmes.utils.ReadExcelUtil;
import com.example.zsmes.vo.BomCondition;
import com.example.zsmes.vo.BomVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
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
@RequestMapping("/mesBom")
@Slf4j
public class MesBomController {

    @Autowired
    private MesBomService mesBomService;

    @GetMapping("/queryByProductNo/{productNo}")
    public List<MesBom> queryByProductNo(@PathVariable("productNo") String productNo) {
        return mesBomService.queryByProductNo(productNo);
    }

    @GetMapping("/queryAllProductNo")
    public List<String> queryAllProductNo() {
        return mesBomService.queryAllProductNo();
    }

    @GetMapping("/queryByMaterialNo/{materialNo}")
    public MesBom queryByMaterialNo(@PathVariable("materialNo") String materialNo) {
        return mesBomService.queryByMaterialNo(materialNo);
    }

    @GetMapping("/queryAllMaterialNo")
    public List<String> queryAllMaterialNo() {
        return mesBomService.queryAllMaterialNo();
    }

    @PostMapping("/queryByList/{page}/{limit}")
    public BomVO queryByList(@PathVariable("page") int page, @PathVariable("limit") int limit, @RequestBody(required = false) BomCondition bomCondition) {
        IPage<MesBom> bomIPage = mesBomService.queryByList(page, limit, bomCondition);
        BomVO bomVO = new BomVO();
        bomVO.setCurrent(page);
        bomVO.setData(bomIPage.getRecords());
        bomVO.setLimit(limit);
        bomVO.setTotal(bomIPage.getTotal());
        bomVO.setPages(bomIPage.getPages());
        return bomVO;
    }

    @PutMapping("/updateBom")
    public String updateBom(@RequestBody MesBom mesBom) {
        System.out.println(mesBom);
        return mesBomService.updateBom(mesBom);
    }

    @PostMapping("/importBom")
    public String importBom(@RequestParam("file") MultipartFile multipartFile) {
        log.info("导入bom表信息");
        List<Map<String, Object>> excelInfo = ReadExcelUtil.getExcelInfo(multipartFile, 0);
        for (Map<String, Object> map : excelInfo
        ) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.print("Key = " + entry.getKey() + ", Value = " + entry.getValue() + " ");
            }
        }
//        excelInfo.forEach(System.out::println);
        return mesBomService.importBom(excelInfo);
    }
}

