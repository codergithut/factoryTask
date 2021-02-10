package com.tianjian.factory.core.model;

import com.tianjian.factory.core.model.constant.Constraints;
import com.tianjian.factory.core.model.constant.Metadata;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.tianjian.factory.core.model.constant.Constraints.REQUIRED;
import static com.tianjian.factory.core.model.constant.Metadata.STRING;

/**
 * Created by tianjian on 2021/2/8.
 */
public class ResourceMetaDTO {

    //当前数据编码
    private String workDataDetailCode;

    //工作请求编码
    private String workDataCode;

    //资源模型编码
    private String resourceMetaCode;

    //约束条件
    private Constraints constraints;

    //元数据类型
    private Metadata metadata;

    public String getResourceMetaCode() {
        return resourceMetaCode;
    }

    public void setResourceMetaCode(String resourceMetaCode) {
        this.resourceMetaCode = resourceMetaCode;
    }

    public Constraints getConstraints() {
        return constraints;
    }

    public void setConstraints(Constraints constraints) {
        this.constraints = constraints;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getWorkDataDetailCode() {
        return workDataDetailCode;
    }

    public void setWorkDataDetailCode(String workDataDetailCode) {
        this.workDataDetailCode = workDataDetailCode;
    }

    public String getWorkDataCode() {
        return workDataCode;
    }

    public void setWorkDataCode(String workDataCode) {
        this.workDataCode = workDataCode;
    }

    public static List<ResourceMetaDTO> mockResourceMeta(String workDataCode, String workDataDetailCode) {
        List<ResourceMetaDTO> resourceMetaDTOS = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            ResourceMetaDTO resourceMetaDTO = new ResourceMetaDTO();
            resourceMetaDTO.setConstraints(REQUIRED);
            resourceMetaDTO.setMetadata(STRING);
            resourceMetaDTO.setResourceMetaCode(UUID.randomUUID().toString());
            resourceMetaDTO.setWorkDataCode(workDataCode);
            resourceMetaDTO.setWorkDataDetailCode(workDataDetailCode);
            resourceMetaDTOS.add(resourceMetaDTO);
        }
        return resourceMetaDTOS;
    }


}
