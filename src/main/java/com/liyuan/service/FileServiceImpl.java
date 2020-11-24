package com.liyuan.service;

import com.liyuan.component.cos.COSProperties;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FileServiceImpl {
    @Autowired
    private COSClient cosClient;
    @Autowired
    private COSProperties cosProperties;

    public PutObjectResult putObject(MultipartFile file, Integer type, String key) throws IOException {
        InputStream inputStream = file.getInputStream();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        return cosClient.putObject(cosProperties.getBucketName(), key, inputStream, objectMetadata);
    }
}
