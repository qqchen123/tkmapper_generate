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
@Table(name = "TDMS_PROCEDURE_INFO")
public class ProcedureInfo {
    @Column(name = "PROCEDURE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_TDMS_PROCEDURE_INFO.nextval from dual")
    private Short procedureId;

    @Column(name = "ITEM")
    private String item;

    @Column(name = "RESULT")
    private String result;

    @Column(name = "REPORT")
    private String report;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PROJECT_ID")
    private Short projectId;

    @Column(name = "CATE_ID")
    private Short cateId;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "IS_DELETE")
    private String isDelete;
}