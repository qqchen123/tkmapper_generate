package com.myxx.tktest.service;

import com.myxx.tktest.utils.MinioUtils;
import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@Service
public class MinIOService {
    @Autowired
    private MinioUtils minIOUtils;

    /**
     * 判断 bucket是否存在
     *
     * @param bucketName
     * @return
     */
    public boolean bucketExists(String bucketName) {
        return minIOUtils.bucketExists(bucketName);
    }

    /**
     * 创建 bucket
     *
     * @param bucketName
     */
    public void makeBucket(String bucketName) {
        minIOUtils.makeBucket(bucketName);
    }

    /**
     * 文件上传
     *
     * @param bucketName
     * @param objectName
     * @param filename
     */
    public void putObject(String bucketName, String objectName, String filename) {
        minIOUtils.putObject(bucketName, objectName, filename);
    }

    public void putObject(String bucketName, String objectName, InputStream stream, String contentType) {
        minIOUtils.putObject(bucketName, objectName, stream, contentType);
    }

    /**
     * 文件上传
     *
     * @param bucketName
     * @param multipartFile
     */
    public void putObject(String bucketName, MultipartFile multipartFile, String filename) {
        minIOUtils.putObject(bucketName, multipartFile, filename);
    }

    /**
     * 删除文件
     *
     * @param bucketName
     * @param filePath
     */
    public boolean removeObject(String bucketName, String filePath) {
        return minIOUtils.removeObject(bucketName, filePath);
    }

    /**
     * 下载文件
     *
     * @param bucketName
     * @param filePath
     * @param originalName
     * @param response
     * @return
     */
    public boolean downloadFile(String bucketName, String filePath, String originalName, HttpServletResponse response) {
        return minIOUtils.downloadFile(bucketName, filePath, originalName, response);
    }

    /**
     * 获取文件路径
     *
     * @param bucketName
     * @param objectName
     * @return
     */
    public String getObjectUrl(String bucketName, String objectName) {
        return minIOUtils.getObjectUrl(bucketName, objectName);
    }

    public String getPresignedPutObject(String bucketName, String objectName, Integer expires) {
        return minIOUtils.presignedGetObject(bucketName, objectName, expires);
    }

    public boolean getObject(String bucketName, String objectNa, String fileName ){
        return minIOUtils.getObject(bucketName, objectNa, fileName);
    }

    public Iterable<Result<Item>> listObjects(String bucketName){
        return minIOUtils.listObjects(bucketName);
    }
}
