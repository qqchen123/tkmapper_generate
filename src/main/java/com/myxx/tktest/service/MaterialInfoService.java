package com.myxx.tktest.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myxx.tktest.mapper.MaterialInfoMapper;
import com.myxx.tktest.pojo.MaterialInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class MaterialInfoService {
    @Autowired
    private MaterialInfoMapper materialInfoMapper;

    /**
     * 根据id获取信息
     *
     * @param id
     * @return
     */
    public MaterialInfo getMaterialInfo(Integer id) {
        return materialInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页获取分类数据(根据分类id和项目id)
     * @param pageNum
     * @param pageSize
     * @param cateId
     * @param projectId
     * @return
     */
    public PageInfo<MaterialInfo> getMaterialInfoByPage(Integer pageNum, Integer pageSize,Integer cateId,Integer projectId) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(MaterialInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cateId",cateId);
        criteria.andEqualTo("projectId",projectId);
        List<MaterialInfo> procedureCates = materialInfoMapper.selectByExample(example);
        return new PageInfo<>(procedureCates);
    }

    public PageInfo<MaterialInfo> getAllMaterialInfoByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MaterialInfo> procedureCates = materialInfoMapper.selectAll();
        return new PageInfo<>(procedureCates);
    }

    /**
     * 根据分类id和项目id查询数据
     * @param cateId
     * @param projectId
     * @return
     */
    public List<MaterialInfo> getMaterialByCateIdAndProjectId(Integer cateId,Integer projectId){
        Example example = new Example(MaterialInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cateId",cateId);
        criteria.andEqualTo("projectId",projectId);
        return materialInfoMapper.selectByExample(example);
    }


    /**
     * 添加数据
     *
     * @param materialInfo
     * @return
     */
    public Integer insertMaterial(MaterialInfo materialInfo) {
        materialInfo.setCreateTime(new Date());
        materialInfo.setUpdateTime(new Date());
        return materialInfoMapper.insertSelective(materialInfo);
    }

    /**
     * 更新数据（根据主键）
     *
     * @param materialInfo
     * @return
     */
    public Integer updateMaterial(MaterialInfo materialInfo) {
        materialInfo.setUpdateTime(new Date());
        return materialInfoMapper.updateByPrimaryKeySelective(materialInfo);
    }

    /**
     * 根据id删除数据
     * @param materialId
     * @return
     */
    public Integer deleteMaterial(Integer materialId) {
        return materialInfoMapper.deleteByPrimaryKey(materialId);
    }
}
