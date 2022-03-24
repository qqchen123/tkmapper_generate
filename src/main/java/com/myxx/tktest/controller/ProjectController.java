package com.myxx.tktest.controller;

import com.myxx.tktest.pojo.ProjectInfo;
import com.myxx.tktest.service.ProjectInfoService;
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

    @GetMapping("/getProjectInfo")
    public ProjectInfo getProjectInfo(Integer id) {
        ProjectInfo projectInfoById = projectInfoService.getProjectInfoById(id);
        return projectInfoById;
    }

    @GetMapping("/getProjectList")
    public List<ProjectInfo> getProjectList() {
        return projectInfoService.getProjectList();
    }


    @PostMapping("/insertPro")
    public void insertProject(@RequestBody ProjectInfo projectInfo) {
        projectInfoService.insertProjectInfo(projectInfo);
    }


}
