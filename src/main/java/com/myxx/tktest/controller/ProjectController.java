package com.myxx.tktest.controller;

import com.github.pagehelper.PageInfo;
import com.myxx.tktest.pojo.ProjectInfo;
import com.myxx.tktest.service.ProjectInfoService;
import com.myxx.tktest.utils.result.Result;
import com.myxx.tktest.utils.result.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectInfoService projectInfoService;

    /**
     * 根据id获取项目数据
     *
     * @param id
     * @return
     */
    @GetMapping("/getProjectInfo/{id}")
    public Result getProjectInfo(@PathVariable("id") Integer id) {
        ProjectInfo projectInfoById = projectInfoService.getProjectInfoById(id);
        return ResultResponse.success(projectInfoById);
    }

    /**
     * 分页获取项目列表数据
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getProjectList")
    public Result getProjectList(
            @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
            @RequestParam(defaultValue = "20", value = "pageSize") Integer pageSize,
            @RequestParam(defaultValue = "", value = "start") String start,
            @RequestParam(defaultValue = "", value = "end") String end

    ) {
        PageInfo<ProjectInfo> projectList = projectInfoService.getProjectList(pageNum, pageSize,start,end);
        return ResultResponse.success(projectList);
    }


    /**
     * 添加项目数据
     *
     * @param projectInfo
     */
    @PostMapping("/insertPro")
    public Result insertProject(@RequestBody ProjectInfo projectInfo) {
        projectInfoService.insertProjectInfo(projectInfo);
        return ResultResponse.success();
    }

    /**
     * 修改数据
     *
     * @param projectInfo
     * @return
     */
    @PostMapping("/editPro")
    public Result editProject(@RequestBody ProjectInfo projectInfo) {
        projectInfoService.updateProjectInfo(projectInfo);
        return ResultResponse.success();
    }

    /**
     * 根据id 逻辑删除
     *
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    public Result deleteProject(@PathVariable Integer id) {
        projectInfoService.deleteProjectInfo(id, "Y");
        return ResultResponse.success();
    }


}
