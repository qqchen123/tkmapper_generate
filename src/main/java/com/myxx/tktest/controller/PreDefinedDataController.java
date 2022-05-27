package com.myxx.tktest.controller;

import com.myxx.tktest.pojo.PredefinedData;
import com.myxx.tktest.service.PredefinedDataService;
import com.myxx.tktest.utils.result.Result;
import com.myxx.tktest.utils.result.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/preDefined")
@RestController
public class PreDefinedDataController {

    @Autowired
    private PredefinedDataService predefinedDataService;

    /**
     * 根据id获取预定义信息
     * @param id
     * @return
     */
    @GetMapping("/getPredefinedData/{id}")
    public Result getPredefinedDataById(@PathVariable("id") Integer id){
        PredefinedData data = predefinedDataService.getPredefinedDataById(id);
        return ResultResponse.success(data);
    }

    /**
     * 根据分类id获取数据
     * @param cateId
     * @return
     */
    @GetMapping("/getPredefinedDataByCateId/{cateId}")
    public Result getPredefinedDataByCateId(@PathVariable("cateId") Integer cateId){
        List<PredefinedData> predefinedData = predefinedDataService.getPredefinedDataByCateId(cateId);
        return ResultResponse.success(predefinedData);
    }

    /**
     * 添加数据
     * @param predefinedData
     * @return
     */
    @PostMapping("/predefinedDataInsert")
    public Result predefinedDataInsert(@RequestBody PredefinedData predefinedData){
        Integer data = predefinedDataService.insertPredefinedData(predefinedData);
        return ResultResponse.success();
    }

    /**
     * 修改数据
     * @param predefinedData
     * @return
     */
    @PostMapping("/predefinedDataUpdate")
    public Result predefinedDataUpdate(@RequestBody PredefinedData predefinedData){
        predefinedDataService.updatePredefinedData(predefinedData);
        return ResultResponse.success();
    }

}
