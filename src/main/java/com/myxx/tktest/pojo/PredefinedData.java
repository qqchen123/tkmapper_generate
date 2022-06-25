package com.myxx.tktest.pojo;

import java.math.BigDecimal;
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
@Table(name = "TDMS_PREDEFINED_DATA")
public class PredefinedData {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_TDMS_PREDEFINED_DATA.nextval from dual")
    private BigDecimal id;

    @Column(name = "PREDEFINED_DATA")
    private String predefinedData;

    @Column(name = "CATE_ID")
    private Short cateId;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "IS_DELETE")
    private String isDelete;

    @Column(name = "TABLE_COLUMN")
    private String tableColumn;
}