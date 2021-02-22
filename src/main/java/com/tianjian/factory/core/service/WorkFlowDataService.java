package com.tianjian.factory.core.service;

import com.tianjian.factory.core.model.ResourceDTO;
import com.tianjian.factory.core.model.ResourceMetaDTO;
import com.tianjian.factory.core.model.WorkDataDTO;
import com.tianjian.factory.core.model.WorkDataRecordDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by tianjian on 2021/2/8.
 */
public interface WorkFlowDataService {

    boolean updateWorkData(WorkDataDTO workData);

    boolean createWorkData(WorkDataDTO workDataDTO);

    Set<String> getWorkDataCodeByUserCode(String userCode);

    WorkDataDTO getWorkDataByWorkDataCode(String workDataCode);

    List<ResourceMetaDTO> getResourceMeta(String workDataCode, String workDataDetailCode);

    boolean saveWorkOperationRecord(WorkDataRecordDTO workDataRecordDTO);

    boolean saveOrUpdateResource(ResourceDTO resourceDTO);

    boolean updateResourceMeta(String workDataCode, String workDataDetailCode, List<ResourceMetaDTO> resourceMetaDTOS);

    boolean saveResourceMetas(List<ResourceMetaDTO> resourceMetaDTOs);
}
