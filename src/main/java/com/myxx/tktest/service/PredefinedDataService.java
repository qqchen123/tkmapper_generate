package com.myxx.tktest.service;

import com.myxx.tktest.mapper.PredefinedDataMapper;
import com.myxx.tktest.pojo.PredefinedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class PredefinedDataService {

    @Autowired
    private PredefinedDataMapper predefinedDataMapper;

    /**
     * 根据主键获取数据
     * @param id
     * @return
     */
    public PredefinedData getPredefinedDataById(Integer id){
        return  predefinedDataMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据分类id获取预定义数据
     * @param cateId
     * @return
     */
    public List<PredefinedData> getPredefinedDataByCateId(Integer cateId){
        Example preDefinedExample = new Example(PredefinedData.class);
        Example.Criteria preDefinedExampleCriteria = preDefinedExample.createCriteria();
        preDefinedExampleCriteria.andEqualTo("cateId",cateId);
        return predefinedDataMapper.selectByExample(preDefinedExample);
    }

    /**
     * 添加预定义数据
     * @param predefinedData
     * @return
     */
    public Integer insertPredefinedData(PredefinedData predefinedData){
        predefinedData.setCreateTime(new Date());
        predefinedData.setUpdateTime(new Date());
        return predefinedDataMapper.insertSelective(predefinedData);
    }

    /**
     * 修改预定义数据
     *
     * @param predefinedData
     */
    public void updatePredefinedData(PredefinedData predefinedData){
        predefinedData.setUpdateTime(new Date());
        predefinedDataMapper.updateByPrimaryKeySelective(predefinedData);
    }

    /**
     * 根据id物理删除预定义数据
     * @param id
     * @return
     */
    public Integer deletePredefinedData(Integer id){
        return predefinedDataMapper.deleteByPrimaryKey(id);
    }

}
