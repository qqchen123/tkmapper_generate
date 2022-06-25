package com.myxx.tktest.service;

import com.myxx.tktest.mapper.PredefinedDataMapper;
import com.myxx.tktest.mapper.ProcedureCateMapper;
import com.myxx.tktest.pojo.FileInfo;
import com.myxx.tktest.pojo.MaterialInfo;
import com.myxx.tktest.pojo.PredefinedData;
import com.myxx.tktest.pojo.ProcedureCate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CommonService {
    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private MaterialInfoService materialInfoService;

    @Autowired
    private ProjectInfoService projectInfoService;
    @Autowired
    private ProcedureCateMapper procedureCateMapper;

    @Autowired
    private PredefinedDataMapper predefinedDataMapper;


    public void dealCateAndPreDefinedData(){
        //1.查询pid不等于0 的cate
        Example example = new Example(ProcedureCate.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andNotEqualTo("parentId", 0);
//        criteria.andNotEqualTo("cateId", 84);
        List<ProcedureCate> procedureCates = procedureCateMapper.selectByExample(example);
//        System.out.println(procedureCates);
        //2.跟cateid查询所有的预定义的数据
        for (ProcedureCate procedureCate : procedureCates) {
            Example preDefined = new Example(PredefinedData.class);
            Example.Criteria precriteria = preDefined.createCriteria();
            precriteria.andEqualTo("cateId", procedureCate.getCateId());
            List<PredefinedData> predefinedData = predefinedDataMapper.selectByExample(preDefined);
            System.out.println("--------------------------------------------------");
            for (PredefinedData data : predefinedData) {
                System.out.println("tableinfo:"+procedureCate.getTableInfo());
                System.out.println("predefineddata:"+data.getPredefinedData());
                System.out.println("column:"+data.getTableColumn());
                System.out.println("cateId:"+data.getCateId());
//                System.out.println(data);
                System.out.println("============================");
//                procedureCateMapper.insertPreDefinedData("tdms_"+procedureCate.getTableInfo(), data.getTableColumn(), data.getPredefinedData());

                if ("file_info".equals(procedureCate.getTableInfo())){
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.setFileName(data.getPredefinedData());
                    fileInfo.setCateId(data.getCateId());
                    fileInfoService.insertFileInfo(fileInfo);
                } else if ("material_info".equals(procedureCate.getTableInfo())) {
                    MaterialInfo materialInfo = new MaterialInfo();
                    materialInfo.setCategory(data.getPredefinedData());
                    materialInfo.setCateId(data.getCateId());
                    materialInfoService.insertMaterial(materialInfo);
                }else {

                }
            }
            System.out.println("--------------------------------------------------");

        }
        //3。将预定义数据插入数据表

    }
}
