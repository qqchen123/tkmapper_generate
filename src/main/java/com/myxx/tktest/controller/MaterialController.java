package com.myxx.tktest.controller;

import com.github.pagehelper.PageInfo;
import com.myxx.tktest.pojo.MaterialInfo;
import com.myxx.tktest.service.MaterialInfoService;
import com.myxx.tktest.utils.result.Result;
import com.myxx.tktest.utils.result.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/material")
@RestController
public class MaterialController {
    @Autowired
    private MaterialInfoService materialInfoService;


    @GetMapping("/materialList")
    public Result getPageMaterialList(
            @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
            @RequestParam(defaultValue = "10", value = "cateId") Integer cateId,
            @RequestParam(defaultValue = "10", value = "projectId") Integer projectId

    ) {
        PageInfo<MaterialInfo> materialInfoList = materialInfoService.getMaterialInfoByPage(pageNum, pageSize, cateId, projectId);
        return ResultResponse.success(materialInfoList);
    }


    @GetMapping("/getMaterial/{id}")
    public Result getMaterialbyId(@PathVariable("id") Integer id) {
        MaterialInfo materialInfo = materialInfoService.getMaterialInfo(id);
        return ResultResponse.success(materialInfo);
    }

    @GetMapping("/allmaterialList")
    public Result getAllPageMaterialList(
            @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize

    ) {
        PageInfo<MaterialInfo> materialInfoList = materialInfoService.getAllMaterialInfoByPage(pageNum, pageSize);
        return ResultResponse.success(materialInfoList);
    }


    @PostMapping("/insertMaterial")
    public Result insertMaterial(@RequestBody MaterialInfo materialInfo) {
        materialInfoService.insertMaterial(materialInfo);
        return ResultResponse.success();
    }

    @PostMapping("/editMaterial")
    public Result editMaterial(@RequestBody MaterialInfo materialInfo) {
        materialInfoService.updateMaterial(materialInfo);
        return ResultResponse.success();
    }

    @PostMapping("/delete/{id}")
    public Result deleteMaterial(@PathVariable Integer id) {
        materialInfoService.deleteMaterial(id);
        return ResultResponse.success();
    }
}
