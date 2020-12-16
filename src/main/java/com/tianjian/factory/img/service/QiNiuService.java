package com.tianjian.factory.img.service;

import com.alibaba.fastjson.JSON;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Created by tianjian on 2020/12/16.
 */
@Service
public class QiNiuService implements ImageService{

    @Override
    public boolean fileUploader(InputStream inputStream, String fileName) {

        String accessKey = "jxgr_bnMKABzSHlbvycdYibY6_6boF-1ZB_Psi1A";
        String secretKey = "utBczFSyeRtfj8lcP29qDni6kWd4-RD7FUHuHDJu";
        String bucket = "test";

        Zone zone = new Zone.Builder(Zone.zone0()).build();
        Configuration cfg = new Configuration(zone);
        cfg.useHttpsDomains = false;

        UploadManager uploadManager = new UploadManager(cfg);

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        BucketManager bucketManager = new BucketManager(auth, cfg);


        try {
            bucketManager.createBucket(bucket, "z0");
        } catch (QiniuException e) {
            System.out.print("hsshsh");
            e.printStackTrace();
        }


        try {
            Response response = uploadManager.put(inputStream, fileName, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                return false;
            }
        }
        return true;
    }


    @Override
    public String getImgUrl(String fileName) {
        return null;
    }
}
