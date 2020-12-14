package com.tianjian.factory.img.service;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class ImageService {
    @Autowired
    private MinioClient minioClient;

    public boolean fileUploader(InputStream inputStream, String fileName) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {
        try {
            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists("asiatrip");
            if(isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket("asiatrip");
            }
            // 使用putObject上传一个文件到存储桶中。
            minioClient.putObject("asiatrip",fileName, inputStream, null);
            return true;
        } catch(MinioException e) {
            System.out.println("Error occurred: " + e);
            return false;
        }
    }

    /** MinioClient.getObject() example. */
    public InputStream getInputStream(String fileName)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            // Get input stream to have content of 'my-objectname' from 'my-bucketname'
            InputStream stream =
                    minioClient.getObject("asiatrip", fileName);
            return stream;
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
            return null;
        }
    }
}
