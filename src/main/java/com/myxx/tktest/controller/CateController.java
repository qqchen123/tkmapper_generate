package com.myxx.tktest.controller;

import com.github.pagehelper.PageInfo;
import com.myxx.tktest.dto.ProcedureCateDto;
import com.myxx.tktest.pojo.ProcedureCate;
import com.myxx.tktest.service.CateService;
import com.myxx.tktest.utils.result.Result;
import com.myxx.tktest.utils.result.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cate")
@RestController
public class CateController {


    @Autowired
    private CateService cateService;

    /**
     * 通过分页获取分类数据
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/cateList")
    public Result getPageCateList(
            @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
            @RequestParam(defaultValue = "", value = "cateName") String cateName,
            @RequestParam(defaultValue = "", value = "tableInfo") String tableInfo,
            @RequestParam(defaultValue = "", value = "parentCate") String parentCate
    ) {
        PageInfo<ProcedureCateDto> cateList = cateService.getCateList(pageNum, pageSize,cateName,tableInfo,parentCate);
        return ResultResponse.success(cateList);
    }

    /**
     *
     * @param pid
     * @return
     */
    @GetMapping("/getCatesbyPid/{pid}")
    public Result getCatesbyPid(@PathVariable("pid") Integer pid){
        List<ProcedureCate> catesList = cateService.getCatesList(pid);
        return ResultResponse.success(catesList);
    }


    /**
     * 根据id获取分类信息
     *
     * @param id
     * @return
     */
    @GetMapping("/cateInfo/{id}")
    public Result getCateInfo(@PathVariable("id") Integer id) {
        ProcedureCate procedureCate = cateService.getProcedureCate(id);
        return ResultResponse.success(procedureCate);
    }

    /**
     * 添加分类数据
     *
     * @param procedureCate
     * @return
     */
    @PostMapping("/cateInfoInsert")
    public Result insertCateInfo(@RequestBody ProcedureCate procedureCate) {
        cateService.insertCate(procedureCate);
        return ResultResponse.success();
    }

    /**
     * 修改分类数据
     *
     * @param procedureCate
     * @return
     */
    @PostMapping("/cateInfoEdit")
    public Result editCateInfo(@RequestBody ProcedureCate procedureCate) {
        cateService.updateCate(procedureCate);
        return ResultResponse.success();
    }

    @GetMapping("/deleteCate/{id}")
    public Result deleteCate(@PathVariable("id") Integer id){
        cateService.deleteCate(id);
        return ResultResponse.success();
    }

}
