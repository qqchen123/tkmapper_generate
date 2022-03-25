package com.myxx.tktest.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myxx.tktest.mapper.ProjectInfoMapper;
import com.myxx.tktest.pojo.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
     *
     * @param projectInfo
     * @return
     */
    public Integer insertProjectInfo(ProjectInfo projectInfo) {
        projectInfo.setUpdateTime(new Date());
        projectInfo.setCreateTime(new Date());
        int i = projectInfoMapper.insertSelective(projectInfo);
        return i;
    }

    /**
     * 根据id修改项目信息
     *
     * @param projectInfo
     * @return
     */
    public Integer updateProjectInfo(ProjectInfo projectInfo) {
        projectInfo.setUpdateTime(new Date());
        return projectInfoMapper.updateByPrimaryKeySelective(projectInfo);
    }

    /**
     * 分页获取项目列表数据
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<ProjectInfo> getProjectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProjectInfo> projectInfos = projectInfoMapper.selectAll();
        return new PageInfo<>(projectInfos);
    }


}
