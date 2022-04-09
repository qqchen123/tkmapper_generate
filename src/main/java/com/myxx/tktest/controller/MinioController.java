package com.myxx.tktest.controller;

import com.myxx.tktest.utils.MinioUtils;
import com.myxx.tktest.utils.result.Result;
import com.myxx.tktest.utils.result.ResultCode;
import com.myxx.tktest.utils.result.ResultResponse;
import io.minio.messages.Bucket;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/minio")
public class MinioController {

    @Autowired
    MinioUtils minioUtils;


    @GetMapping("/index")
    public Result bucketExists()  {
        Boolean file = minioUtils.bucketExists("file");
        return ResultResponse.success();
    }

    @GetMapping("/all")
    public Result getAllBuckets() throws Exception {
        List<Bucket> allBuckets = minioUtils.getAllBuckets();
        log.info(allBuckets.toString());
        return ResultResponse.success(allBuckets);
    }

    /**
     * 文件上传
     * @param file
     * @param bucketName
     * @return
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file, @RequestParam(value = "bucketName") String bucketName) {
        if (StringUtils.isBlank(bucketName)) {
            log.error("存储bucket名称为空，无法上传");
            return ResultResponse.failure(ResultCode.FAIL,"存储bucket名称为空，无法上传");
        }
        if (!minioUtils.upload(file, bucketName)) {
            log.error("文件上传异常");
            return ResultResponse.failure(ResultCode.FAIL,"文件上传异常");
        }
        log.info("文件上传成功");
        return ResultResponse.success("文件上传成功");
    }

    @GetMapping("/download")
    public Result download(@RequestParam(value = "bucketName") String bucketName, @RequestParam(value = "file") String file, HttpServletResponse response){
        minioUtils.download(bucketName,file,response);
        return ResultResponse.success();
    }

}
