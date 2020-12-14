package com.tianjian.factory.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;


@Configuration
public class BeanConfig {

    @Bean
    public BufferedImageHttpMessageConverter bufferedImageHttpMessageConverter(){
        return new BufferedImageHttpMessageConverter();
    }

    @Value("${app.image.bucket}")
    private String bucketName;

    @Value("${app.image.url}")
    private String url;

    @Value("${app.image.port}")
    private Integer port;

    @Value("${app.image.accessKey}")
    private String accessKey;

    @Value("${app.image.secretKey}")
    private String secretKey;

    @Bean
    public MinioClient initMinioClient() throws Exception {
        MinioClient minioClient = new MinioClient(url, port, accessKey,
                secretKey);
        // 检查存储桶是否已经存在
        boolean isExist = false;
        isExist = minioClient.bucketExists(bucketName);
        if(isExist) {
            System.out.println("Bucket already exists.");
        } else {
            // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
            minioClient.makeBucket(bucketName);
        }
        return  minioClient;
    }
}