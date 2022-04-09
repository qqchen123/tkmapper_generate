package com.myxx.tktest.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "TDMS_FILE_INFO")
public class FileInfo {
    @Column(name = "FILE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_TDMS_FILE_INFO.nextval from dual")
    private Long fileId;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_PATH")
    private String filePath;

    @Column(name = "PROJECT_ID")
    private Long projectId;

    @Column(name = "CATE_ID")
    private Long cateId;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "IS_DELETE")
    private String isDelete;
}