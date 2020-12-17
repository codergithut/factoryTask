package com.tianjian.factory.config;

import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * Created by tianjian on 2020/12/17.
 */
@org.springframework.context.annotation.Configuration
public class QiuNiuConfig {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @Bean
    public QiNiuUploadManager getUploadManager() {
        QiNiuUploadManager qiNiuUploadManager = new QiNiuUploadManager();
        Zone zone = new Zone.Builder(Zone.zone2()).build();
        Configuration cfg = new Configuration(zone);
        cfg.useHttpsDomains = false;
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        qiNiuUploadManager.setAuth(upToken);
        qiNiuUploadManager.setUploadManager(uploadManager);
        return qiNiuUploadManager;
    }


}
