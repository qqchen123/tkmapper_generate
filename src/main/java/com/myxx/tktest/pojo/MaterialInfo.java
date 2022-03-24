package com.myxx.tktest.pojo;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "TDMS_MATERIAL_INFO")
public class MaterialInfo {
    @Column(name = "MATERIAL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_TDMS_MATERIAL_INFO.nextval from dual")
    private Short materialId;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "MATERIAL")
    private String material;

    @Column(name = "PROJECT_ID")
    private Short projectId;

    @Column(name = "CATE_ID")
    private Short cateId;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;
}