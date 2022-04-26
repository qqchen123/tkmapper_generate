package com.myxx.tktest.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "TDMS_MATERIAL_INFO")
public class MaterialInfo {
    @Id
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATE_TIME")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "UPDATE_TIME")
    private Date updateTime;
}