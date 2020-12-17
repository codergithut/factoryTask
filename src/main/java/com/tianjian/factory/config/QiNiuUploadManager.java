package com.tianjian.factory.config;

import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * Created by tianjian on 2020/12/17.
 */
public class QiNiuUploadManager {
    private UploadManager uploadManager;

    private String authToken;

    public void setUploadManager(UploadManager uploadManager) {
        this.uploadManager = uploadManager;
    }

    public void setAuth(String authToken) {
        this.authToken = authToken;
    }

    public UploadManager getUploadManager() {
        return uploadManager;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
