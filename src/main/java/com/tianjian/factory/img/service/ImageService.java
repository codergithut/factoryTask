package com.tianjian.factory.img.service;

import com.qiniu.common.QiniuException;

import java.io.InputStream;

/**
 * Created by tianjian on 2020/12/16.
 */
public interface ImageService {

   boolean fileUploader(InputStream inputStream, String fileName) throws QiniuException;

   String getImgUrl(String fileName);

}
