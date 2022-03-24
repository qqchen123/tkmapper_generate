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
@Table(name = "TDMS_PROCEDURE_CATE")
public class ProcedureCate {
    @Id
    @Column(name = "CATE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_TDMS_PROCEDURE_CATE.nextval from dual")
    private Long cateId;

    @Column(name = "CATE_NAME")
    private String cateName;

    @Column(name = "PARENT_ID")
    private Long parentId;

    @Column(name = "IS_DELETE")
    private String isDelete;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;
}