package com.tianjian.factory.img.service;

import com.qiniu.common.QiniuException;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by tianjian on 2020/12/16.
 */
public interface ImageService {

   boolean fileUploader(InputStream inputStream, String fileName) throws QiniuException, UnsupportedEncodingException;

   String getImgUrl(String fileName);

}
