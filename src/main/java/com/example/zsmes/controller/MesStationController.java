package com.example.zsmes.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zsmes.entity.MesStation;
import com.example.zsmes.service.MesStationService;
import com.example.zsmes.vo.StationCondition;
import com.example.zsmes.vo.StationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@RestController
@RequestMapping("/mesStation")
public class MesStationController {

    @Autowired
    private MesStationService mesStationService;

    @PostMapping("/addStation")
    public String addStation(@RequestBody MesStation mesStation){
        return mesStationService.addStation(mesStation);
    }

    @PostMapping("/queryByList/{page}/{limit}")
    public StationVO queryByList(@PathVariable("page") int page, @PathVariable("limit") int limit, @RequestBody(required = false) StationCondition stationCondition){
        IPage<MesStation> stationIPage = mesStationService.queryByList(page, limit,stationCondition);
        StationVO stationVO=new StationVO();
        stationVO.setCurrent(page);
        stationVO.setData(stationIPage.getRecords());
        stationVO.setLimit(limit);
        stationVO.setTotal(stationIPage.getTotal());
        stationVO.setPages(stationIPage.getPages());
        return stationVO;
    }

    @GetMapping("/queryAllStation")
    public List<MesStation> queryAllStation(){
        return mesStationService.queryAllStation();
    }

    @PutMapping("/updateStation")
    public String updateStation(@RequestBody MesStation mesStation){
        return mesStationService.updateStation(mesStation);
    }

    @DeleteMapping("/deleteBySelectIds/{deleteIds}")
    public String deleteBySelectIds(@PathVariable("deleteIds") List<String> deleteIds){
        return mesStationService.deleteBySelectIds(deleteIds);
    }
}

