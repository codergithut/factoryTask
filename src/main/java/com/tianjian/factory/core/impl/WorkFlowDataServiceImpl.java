package com.tianjian.factory.core.impl;

import com.tianjian.factory.core.model.*;
import com.tianjian.factory.core.mysql.*;
import com.tianjian.factory.core.mysql.curd.*;
import com.tianjian.factory.core.service.WorkFlowDataService;
import com.tianjian.factory.data.user.UserInfoDataCurd;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tianjian on 2021/2/8.
 */
@Service
public class WorkFlowDataServiceImpl implements WorkFlowDataService {

    @Autowired
    private WorkDataCurd workDataCurd;

    @Autowired
    private WorkDataDetailCurd workDataDetailCurd;

    @Autowired
    private WorkDataRecordCurd workDataRecordCurd;

    @Autowired
    private ResourceMetaCurd resourceMetaCurd;

    @Autowired
    private ResourceCurd resourceCurd;

    @Autowired
    private UserInfoCurd userInfoCurd;

    @Override
    public boolean updateWorkData(WorkDataDTO workData) {

        WorkDataEo workDataEo = new WorkDataEo();
        BeanUtils.copyProperties(workData, workDataEo);

        List<WorkDataDetailEo> workDataDetailEos = workData.getWorkDataDetailDTOS().stream().map(e -> {
            WorkDataDetailEo workDataDetailEo = new WorkDataDetailEo();
            BeanUtils.copyProperties(e, workDataDetailEo);
            workDataDetailEo.setUserCode(e.getHandleUserInfo().getUserCode());
            return workDataDetailEo;
        }).collect(Collectors.toList());

        workDataCurd.save(workDataEo);
        workDataDetailCurd.saveAll(workDataDetailEos);

        return true;
    }

    @Override
    public boolean createWorkData(WorkDataDTO workDataDTO) {
        WorkDataEo workDataEo = new WorkDataEo();
        BeanUtils.copyProperties(workDataDTO, workDataEo);

        List<WorkDataDetailEo> workDataDetailEos = workDataDTO.getWorkDataDetailDTOS().stream().map(e -> {
            WorkDataDetailEo workDataDetailEo = new WorkDataDetailEo();
            BeanUtils.copyProperties(e, workDataDetailEo);
            workDataDetailEo.setWorkDataDetailCode(UUID.randomUUID().toString());
            workDataDetailEo.setUserCode(e.getHandleUserInfo().getUserCode());
            e.setWorkDataDetailCode(workDataDetailEo.getWorkDataDetailCode());
            return workDataDetailEo;
        }).collect(Collectors.toList());

        workDataCurd.save(workDataEo);
        workDataDetailCurd.saveAll(workDataDetailEos);

        return true;
    }

    @Override
    public Set<String> getWorkDataCodeByUserCode(String userCode) {
        List<WorkDataDetailEo> workDataDetailEos = workDataDetailCurd.findByUserCode(userCode);
        if(!CollectionUtils.isEmpty(workDataDetailEos)) {
            return workDataDetailEos.stream().map(WorkDataDetailEo::getWorkDataCode).collect(Collectors.toSet());
        }
        return null;
    }

    @Override
    public WorkDataDTO getWorkDataByWorkDataCode(String workDataCode) {
        WorkDataDTO workDataDTO = new WorkDataDTO();
        WorkDataEo workDataEo = workDataCurd.findAllByWorkDataCode(workDataCode);
        List<WorkDataDetailEo> workDataDetailEos = workDataDetailCurd.findByWorkDataCode(workDataCode);
        BeanUtils.copyProperties(workDataEo, workDataDTO);
        workDataDTO.setWorkStatus(workDataEo.getWorkStatus());
        Collections.sort(workDataDetailEos,
                Comparator.comparingInt(WorkDataDetailEo::getSortNum));

        List<WorkDataDetailDTO> detailDTOS = new ArrayList<>();

        for(WorkDataDetailEo dataDetailEo : workDataDetailEos) {
            WorkDataDetailDTO workDataDetailDTO = new WorkDataDetailDTO();
            BeanUtils.copyProperties(dataDetailEo, workDataDetailDTO);

            ResourceEo resourceEo = resourceCurd.findByWorkDataCodeAndWorkDataDetailCode(workDataCode,
                    dataDetailEo.getWorkDataDetailCode());

            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setUserCode(dataDetailEo.getUserCode());
            if(!StringUtils.isEmpty(dataDetailEo.getUserCode())) {
                UserInfoEo userInfoEo = userInfoCurd.findByUserCode(dataDetailEo.getUserCode());
                if(userInfoEo != null) {
                    BeanUtils.copyProperties(userInfoEo, userInfoDTO);
                }
            }

            workDataDetailDTO.setHandleUserInfo(userInfoDTO);

            if(resourceEo != null) {
                ResourceDTO resourceDTO = new ResourceDTO();
                BeanUtils.copyProperties(resourceEo, resourceDTO);
                List<ResourceMetaEo> resourceMetaEos = resourceMetaCurd.findByWorkDataCodeAndWorkDataDetailCodeAndIsDelete(workDataCode,
                        dataDetailEo.getWorkDataDetailCode(), "N");
                if(!CollectionUtils.isEmpty(resourceMetaEos)) {
                    List<ResourceMetaDTO> resourceMetaDTOS = resourceMetaEos.stream().map(e -> {
                        ResourceMetaDTO resourceMetaDTO = new ResourceMetaDTO();
                        BeanUtils.copyProperties(e, resourceDTO);
                        return resourceMetaDTO;
                    }).collect(Collectors.toList());
                    resourceDTO.setResourceMetaDTOS(resourceMetaDTOS);
                }
                workDataDetailDTO.setResourceDTO(resourceDTO);
            }

            detailDTOS.add(workDataDetailDTO);
        }
        workDataDTO.setWorkDataDetailDTOS(detailDTOS);

        List<WorkDataRecordEo> workDataRecordEos = workDataRecordCurd.findByWorkDataCode(workDataCode);
        if(CollectionUtils.isEmpty(workDataDetailEos)) {
            List<WorkDataRecordDTO> workDataRecordDTOS = workDataRecordEos.stream().map(e -> {
                WorkDataRecordDTO workDataRecordDTO = new WorkDataRecordDTO();
                BeanUtils.copyProperties(e, workDataRecordDTO);
                return workDataRecordDTO;
            }).collect(Collectors.toList());
            workDataDTO.setWorkDataRecordDTOS(workDataRecordDTOS);
        }

        return workDataDTO;
    }


    @Override
    public List<ResourceMetaDTO> getResourceMeta(String workDataCode, String workDataDetailCode) {
        List<ResourceMetaEo> resourceMetaEos = resourceMetaCurd.
                findByWorkDataCodeAndWorkDataDetailCodeAndIsDelete(workDataCode, workDataDetailCode, "N");
        List<ResourceMetaDTO> resourceMetaDTOS = resourceMetaEos.stream().map(e -> {
            ResourceMetaDTO resourceMetaDTO = new ResourceMetaDTO();
            BeanUtils.copyProperties(e, resourceMetaDTO);
            return resourceMetaDTO;
        }).collect(Collectors.toList());
        return resourceMetaDTOS;
    }

    @Override
    public boolean saveWorkOperationRecord(WorkDataRecordDTO workDataRecordDTO) {
        WorkDataRecordEo workDataRecordEo = new WorkDataRecordEo();
        BeanUtils.copyProperties(workDataRecordDTO, workDataRecordEo);
        if(StringUtils.isEmpty(workDataRecordDTO.getWorkDataRecordCode())) {
            workDataRecordEo.setWorkDataRecordCode(UUID.randomUUID().toString());
        }
        workDataRecordCurd.save(workDataRecordEo);
        return true;
    }

    @Override
    public boolean saveOrUpdateResource(ResourceDTO resourceDTO) {
        ResourceEo resourceEo = new ResourceEo();
        BeanUtils.copyProperties(resourceDTO, resourceEo);
        return resourceCurd.save(resourceEo) != null;
    }

    @Override
    public boolean updateResourceMeta(String workDataCode, String workDataDetailCode, List<ResourceMetaDTO> resourceMetaDTOS) {
        List<ResourceMetaDTO> resourceMetaEos = getResourceMeta(workDataCode, workDataDetailCode);
        if(!CollectionUtils.isEmpty(resourceMetaDTOS)) {
            List<ResourceMetaEo> deleteEos = resourceMetaEos.stream().map(e -> {
                ResourceMetaEo resourceMetaEo = new ResourceMetaEo();
                BeanUtils.copyProperties(e, resourceMetaEo);
                resourceMetaEo.setIsDelete("Y");
                return resourceMetaEo;
            }).collect(Collectors.toList());
            resourceMetaCurd.saveAll(deleteEos);
        }

        if(!CollectionUtils.isEmpty(resourceMetaDTOS)) {
            List<ResourceMetaEo> details = resourceMetaDTOS.stream().map(e -> {
                ResourceMetaEo resourceMetaEo = new ResourceMetaEo();
                BeanUtils.copyProperties(e, resourceMetaEo);
                resourceMetaEo.setIsDelete("N");
                return resourceMetaEo;
            }).collect(Collectors.toList());
            resourceMetaCurd.saveAll(details);
        }


        return true;
    }

}
