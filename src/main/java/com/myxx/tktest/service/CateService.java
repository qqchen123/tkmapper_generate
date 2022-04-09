package com.myxx.tktest.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myxx.tktest.mapper.ProcedureCateMapper;
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
    public PageInfo<ProcedureCate> getCateList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProcedureCate> procedureCates = procedureCateMapper.selectAll();
        return new PageInfo<>(procedureCates);
    }

    public List<ProcedureCate> getCatesList(Integer parentId){
        Example example = new Example(ProcedureCate.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId",parentId);
        return procedureCateMapper.selectByExample(example);
    }


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

}
