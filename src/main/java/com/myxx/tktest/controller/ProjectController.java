package com.myxx.tktest.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myxx.tktest.pojo.ProjectInfo;
import com.myxx.tktest.service.ProjectInfoService;
import com.myxx.tktest.utils.result.Result;
import com.myxx.tktest.utils.result.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectInfoService projectInfoService;

    @GetMapping("/getProjectInfo/{id}")
    public Result getProjectInfo(@PathVariable("id") Integer id) {
        ProjectInfo projectInfoById = projectInfoService.getProjectInfoById(id);
        return ResultResponse.success(projectInfoById);
    }

    @GetMapping("/getProjectList")
    public Result getProjectList() {
        PageHelper.startPage(1, 3);
        List<ProjectInfo> projectList = projectInfoService.getProjectList();
        PageInfo<ProjectInfo> projectInfoPageInfo = new PageInfo<>(projectList);
        return ResultResponse.success(projectInfoPageInfo);
    }


    @PostMapping("/insertPro")
    public void insertProject(@RequestBody ProjectInfo projectInfo) {
        projectInfoService.insertProjectInfo(projectInfo);
    }


}
