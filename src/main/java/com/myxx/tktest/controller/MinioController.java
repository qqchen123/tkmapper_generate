package com.myxx.tktest.controller;

import com.myxx.tktest.config.MinIOConfig;
import com.myxx.tktest.service.MinIOService;
import com.myxx.tktest.utils.result.Result;
import com.myxx.tktest.utils.result.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static com.myxx.tktest.utils.result.ResultCode.NOT_FOUND;


@Slf4j
@RestController
@RequestMapping("/minio")
public class MinioController {

    @Autowired
    private MinIOService minIOService;
    @Autowired
    private MinIOConfig minioConfig;


    @PostMapping("/upload")
    public Result uploadFile(MultipartFile file, String bucketName) {
        try {
            bucketName = !StringUtils.isEmpty(bucketName) ? bucketName : minioConfig.getBucketName();
            if (!minIOService.bucketExists(bucketName)) {
                minIOService.makeBucket(bucketName);
            }
            String fileName = file.getOriginalFilename();
            assert fileName != null;

            // 根据业务设计，设置存储路径：按天创建目录
            String objectName = new SimpleDateFormat("yyyy-MM-dd/").format(new Date())
                    + UUID.randomUUID().toString()
                    + fileName.substring(fileName.lastIndexOf("."));

            minIOService.putObject(bucketName, file, objectName);
            log.info("文件格式为:{}", file.getContentType());
            log.info("文件原名称为:{}", fileName);
            log.info("文件存储的桶为:{}", bucketName);
            log.info("文件对象路径为:{}", objectName);
            return ResultResponse.success(minIOService.getObjectUrl(bucketName, objectName));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultResponse.failure(NOT_FOUND, "上传失败");
        }
    }

    @PostMapping("/deleteFile")
    public Result deleteFile(String bucketName, String filePath) throws Exception {
        if (!minIOService.bucketExists(bucketName)) {
            throw new Exception("不存在该桶");
        }
        boolean status = minIOService.removeObject(bucketName, filePath);
        return status ? ResultResponse.success("删除成功") : ResultResponse.success("删除失败");
    }

    @GetMapping("/downloadFile")
    public Result downloadFile(String bucketName, String filePath, String originalName, HttpServletResponse response) throws Exception {
        if (!minIOService.bucketExists(bucketName)) {
            throw new Exception("不存在该桶");
        }
        boolean status = minIOService.downloadFile(bucketName, filePath, originalName, response);
        return status ? ResultResponse.success("下载成功") : ResultResponse.success("下载失败");
    }

    @GetMapping("/getUrl")
    public Result getUrl(){
//        String url = minIOService.getPresignedPutObject("jsbucket", "1.jpeg", 1000);
        String url = minIOService.getObjectUrl("tdms", "view.png");
        System.out.println(url);
        return ResultResponse.success(url);
    }


    @GetMapping("downloadObj")
    public Result downloadObj(HttpServletResponse response){
//        minIOService.getObject("jsbucket", "1.jpeg","a.jpeg");
//        return ResultResponse.success();

        boolean status = minIOService.downloadFile("jsbucket", "2022-04-18/5def3084-16b8-4de6-9868-d3b2335fc637.jpeg", "a.png",  response);
        return status ? ResultResponse.success("下载成功") : ResultResponse.success("下载失败");
    }


   @GetMapping("/bucketExists")
    public Result bucketExists(String bucketName){
       boolean b = minIOService.bucketExists(bucketName);
       return ResultResponse.success(b);
    }


}
