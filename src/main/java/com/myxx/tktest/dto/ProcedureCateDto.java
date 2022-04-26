package com.myxx.tktest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ProcedureCateDto {
    private Long cateId;

    private String cateName;

    private String parentCate;

    private String isDelete;

    private Date createTime;

    private Date updateTime;

    private String tableInfo;


}