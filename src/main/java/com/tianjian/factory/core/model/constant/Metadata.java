package com.tianjian.factory.core.model.constant;

/**
 * Created by tianjian on 2021/2/8.
 */
public enum Metadata {
    NUMBER("NUMBER"), STRING("STRING"), DATE("DATE"), FILE("FILE"), IMG("IMG");

    private String metaData;

    Metadata(String metaData) {
        this.metaData = metaData;
    }

    private String getMetaData() {
        return metaData;
    }
}
