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
@Table(name = "TDMS_PROJECT_INFO")
public class ProjectInfo {
    @Id
    @Column(name = "PRO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_TDMS_PROJECT_INFO.nextval from dual")
    private Long proId;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "PMO")
    private String pmo;

    @Column(name = "SPONSOR")
    private String sponsor;

    @Column(name = "TECHNOLOGY")
    private String technology;

    @Column(name = "CUSTOMER")
    private String customer;

    @Column(name = "APPLICATION")
    private String application;

    @Column(name = "KEY_WORDS")
    private String keyWords;

    @Column(name = "FILE_PATH")
    private String filePath;

    @Column(name = "M0_STATUS")
    private String m0Status;

    @Column(name = "M0_TIME")
    private Date m0Time;

    @Column(name = "T0_STATUS")
    private String t0Status;

    @Column(name = "T1_TIME")
    private Date t1Time;

    @Column(name = "T2_STATUS")
    private String t2Status;

    @Column(name = "T2_TIME")
    private Date t2Time;

    @Column(name = "IS_DELETE")
    private String isDelete;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;
}