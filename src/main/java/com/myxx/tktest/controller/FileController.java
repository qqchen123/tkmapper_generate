package com.myxx.tktest.controller;

import com.github.pagehelper.PageInfo;
import com.myxx.tktest.pojo.FileInfo;
import com.myxx.tktest.service.FileInfoService;
import com.myxx.tktest.utils.result.Result;
import com.myxx.tktest.utils.result.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/cates")
public class FileController {

    @Autowired
    private FileInfoService fileInfoService;

    @GetMapping("/getFileInfo/{id}")
    public Result getFileInfo(@PathVariable("id") Integer id) {
        FileInfo projectInfoById = fileInfoService.getFileInfo(id);
        return ResultResponse.success(projectInfoById);
    }

    @GetMapping("/getFileList")
    public Result getFileList(
            @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
            @RequestParam(defaultValue = "20", value = "pageSize") Integer pageSize,
            @RequestParam(defaultValue = "", value = "start") String start,
            @RequestParam(defaultValue = "", value = "end") String end

    ) {
        PageInfo<FileInfo> fileInfoList = fileInfoService.getFileInfoList(pageNum, pageSize);
        return ResultResponse.success(fileInfoList);
    }

    @PostMapping("/insertFile")
    public Result insertProject(@RequestBody FileInfo fileInfo) {
        fileInfoService.insertFileInfo(fileInfo);
        return ResultResponse.success();
    }


    @PostMapping("/editPro")
    public Result editProject(@RequestBody FileInfo fileInfo) {
        fileInfoService.updateFileInfo(fileInfo);
        return ResultResponse.success();
    }


}
