package com.myxx.tktest.service;

import com.myxx.tktest.mapper.ProjectInfoMapper;
import com.myxx.tktest.pojo.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen
 */
@Service
public class ProjectInfoService {

    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    /**
     * 根据id获取项目信息
     *
     * @param proId
     * @return
     */
    public ProjectInfo getProjectInfoById(Integer proId) {
        return projectInfoMapper.selectByPrimaryKey(proId);
    }

    /**
     * 插入项目基本信息
     * @param projectInfo
     * @return
     */
    public Integer insertProjectInfo(ProjectInfo projectInfo) {
        int i = projectInfoMapper.insertSelective(projectInfo);
        return i;
    }

    public List<ProjectInfo> getProjectList(){
        return projectInfoMapper.selectAll();
    }



}
