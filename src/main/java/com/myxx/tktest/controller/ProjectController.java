package com.myxx.tktest.controller;

import com.myxx.tktest.pojo.ProjectInfo;
import com.myxx.tktest.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectInfoService projectInfoService;

    @GetMapping("/getProjectInfo")
    public ProjectInfo getProjectInfo(Integer id){
        ProjectInfo projectInfoById = projectInfoService.getProjectInfoById(id);
        return projectInfoById;
    }

    @GetMapping("/getProjectList")
    public List<ProjectInfo> getProjectList(){
        return projectInfoService.getProjectList();
    }



}
