package com.myxx.tktest.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myxx.tktest.mapper.FileInfoMapper;
import com.myxx.tktest.pojo.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FileInfoService {

    @Autowired
    private FileInfoMapper fileInfoMapper;

    /**
     * 根据id获取分类信息
     *
     * @param id
     * @return
     */
    public FileInfo getFileInfo(Integer id) {
        return fileInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页获取分类数据
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<FileInfo> getFileInfoList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<FileInfo> fileInfoList = fileInfoMapper.selectAll();
        return new PageInfo<>(fileInfoList);
    }

    /**
     * 添加分类数据
     *
     * @param fileInfo
     * @return
     */
    public Integer insertFileInfo(FileInfo fileInfo) {
        fileInfo.setCreateTime(new Date());
        fileInfo.setUpdateTime(new Date());
        return fileInfoMapper.insertSelective(fileInfo);
    }

    /**
     * 更新分类数据（根据主键）
     *
     * @param fileInfo
     * @return
     */
    public Integer updateFileInfo(FileInfo fileInfo) {
        fileInfo.setUpdateTime(new Date());
        return fileInfoMapper.updateByPrimaryKeySelective(fileInfo);
    }
}
