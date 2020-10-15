package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("任务元数据细节")
public class TaskTemplateTypeMetaDetailVo {

    @ApiModelProperty("数据key")
    private String metaName;

    @ApiModelProperty("数据类型 file:文件 string:字符串 img:图片 number:数字 date:时间")
    private String metaType;

    @ApiModelProperty("是否必填 1:必须 0:非必须")
    private String isRequired;

    public String getMetaName() {
        return metaName;
    }

    public void setMetaName(String metaName) {
        this.metaName = metaName;
    }

    public String getMetaType() {
        return metaType;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
    }

    public String getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired;
    }
}
