package com.myxx.tktest.controller;

import com.github.pagehelper.PageInfo;
import com.myxx.tktest.pojo.ProcedureCate;
import com.myxx.tktest.service.CateService;
import com.myxx.tktest.utils.result.Result;
import com.myxx.tktest.utils.result.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize
    ) {
        PageInfo<ProcedureCate> cateList = cateService.getCateList(pageNum, pageSize);
        return ResultResponse.success(cateList);
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
    @PostMapping("/cateInfo")
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


}
