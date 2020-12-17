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
import com.tianjian.factory.config.QiNiuUploadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Created by tianjian on 2020/12/16.
 */
@Service
public class QiNiuService implements ImageService{

    @Autowired
    private QiNiuUploadManager qiNiuUploadManager;



    @Override
    public boolean fileUploader(InputStream inputStream, String fileName) {
        try {
            String upToken = qiNiuUploadManager.getAuthToken();
            Response response = qiNiuUploadManager.getUploadManager().put(inputStream, fileName, upToken, null, null);
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
