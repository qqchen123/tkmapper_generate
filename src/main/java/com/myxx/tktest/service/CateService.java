package com.myxx.tktest.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myxx.tktest.dto.ProcedureCateDto;
import com.myxx.tktest.mapper.PredefinedDataMapper;
import com.myxx.tktest.mapper.ProcedureCateMapper;
import com.myxx.tktest.pojo.PredefinedData;
import com.myxx.tktest.pojo.ProcedureCate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class CateService {

    @Autowired
    private ProcedureCateMapper procedureCateMapper;

    @Autowired
    private PredefinedDataMapper predefinedDataMapper;

    /**
     * 根据id获取分类信息
     *
     * @param id
     * @return
     */
    public ProcedureCate getProcedureCate(Integer id) {
        return procedureCateMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页获取分类数据
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<ProcedureCateDto> getCateList(
            Integer pageNum,
            Integer pageSize,
            String cateName,
            String tableInfo,
            String parentCate
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProcedureCateDto> cate = procedureCateMapper.getCate(cateName,tableInfo,parentCate);
        return new PageInfo<>(cate);
    }

    /**
     * 根据父id查询数据
     * @param parentId
     * @return
     */
    public List<ProcedureCate> getCatesList(Integer parentId) {
        Example example = new Example(ProcedureCate.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId", parentId);
        return procedureCateMapper.selectByExample(example);
    }


    /*public List<ProcedureCate> getParentCatesList(Integer parentId) {
        Example example = new Example(ProcedureCate.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId", parentId);
        return procedureCateMapper.selectByExample(example);
    }*/

    /**
     * 添加分类数据
     *
     * @param procedureCate
     * @return
     */
    public Integer insertCate(ProcedureCate procedureCate) {
        procedureCate.setCreateTime(new Date());
        procedureCate.setUpdateTime(new Date());
        return procedureCateMapper.insertSelective(procedureCate);
    }

    /**
     * 更新分类数据（根据主键）
     *
     * @param procedureCate
     * @return
     */
    public Integer updateCate(ProcedureCate procedureCate) {
        procedureCate.setUpdateTime(new Date());
        return procedureCateMapper.updateByPrimaryKeySelective(procedureCate);
    }


    /**
     * 根据id删除分类
     * @param cateId
     * @return
     */
    public Integer deleteCate(Integer cateId){
        return procedureCateMapper.deleteByPrimaryKey(cateId);
    }


    /**
     * 获取数据表的所有字段
     * @param tableName
     * @return
     */
    public List<String> getFields(String tableName){
        return procedureCateMapper.getField(tableName);
    }



}
