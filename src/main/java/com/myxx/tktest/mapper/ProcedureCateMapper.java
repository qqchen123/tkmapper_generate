package com.myxx.tktest.mapper;

import com.myxx.tktest.dto.ProcedureCateDto;
import com.myxx.tktest.pojo.ProcedureCate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProcedureCateMapper extends Mapper<ProcedureCate> {

    /**
     * 获取分类表的自连接的数据
     * @param cateName
     * @param tableInfo
     * @param parentCate
     * @return
     */
    @Select("<script> select " +
                "t.cate_id cateId,t.cate_name cateName,t.parent_id parentId,t.is_delete isDelete," +
                "t.create_time createTime,t.update_time updateTime,t.table_info tableInfo,tt.cate_name AS parentCate " +
            "from TDMS_PROCEDURE_CATE t " +
            "LEFT JOIN TDMS_PROCEDURE_CATE tt " +
            "ON t.parent_id=tt.cate_id " +
            "<where> " +
            "<if test=\"cateName != null and cateName != ''\"> and t.cate_name like '%'||#{cateName}||'%'</if> " +
            "<if test=\"tableInfo != null and tableInfo != ''\"> and t.table_info like '%'||#{tableInfo}||'%' </if> " +
            "<if test=\"parentCate != null and parentCate != ''\">and tt.cate_name like '%'||#{parentCate}||'%' </if> " +
            "</where>"+
            "ORDER BY t.cate_id DESC </script>")
    public List<ProcedureCateDto> getCate(String cateName, String tableInfo, String parentCate);

    /**
     * 获取数据表的所有字段
     * @param tableName
     * @return
     */
    @Select("<script>select (column_name) from user_tab_columns where table_name= upper(#{tableName})</script>")
    public List<String> getField(String tableName);

    @Insert("<script>insert into #{tableName} (#{tableColumn}) values(#{data})</script>")
    public void insertPreDefinedData(String tableName,String tableColumn,String data);
}