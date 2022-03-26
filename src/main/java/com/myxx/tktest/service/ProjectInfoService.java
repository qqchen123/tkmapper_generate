package com.myxx.tktest.service;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myxx.tktest.mapper.ProjectInfoMapper;
import com.myxx.tktest.pojo.ProjectInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
     * 根据id进行 逻辑删除
     *
     * @param projectId
     * @param isDelete
     * @return
     */
    public Integer deleteProjectInfo(Integer projectId, String isDelete) {
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setIsDelete(isDelete);
        projectInfo.setProId(projectId);
        return projectInfoMapper.updateByPrimaryKeySelective(projectInfo);
    }

    /**
     * 分页获取项目列表数据
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<ProjectInfo> getProjectList(Integer pageNum, Integer pageSize, String start, String end) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(ProjectInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("(IS_DELETE='N' or IS_DELETE='' or IS_DELETE is null)");
        if (StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)){
            criteria.andBetween("createTime", DateUtil.parse(start,"yyyy/MM/dd HH:mm:ss"), DateUtil.parse(end,"yyyy/MM/dd HH:mm:ss"));
        }
        List<ProjectInfo> projectInfos = projectInfoMapper.selectByExample(example);
        return new PageInfo<>(projectInfos);
    }


}
