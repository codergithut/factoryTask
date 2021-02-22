package com.tianjian.factory.core.service;

import com.tianjian.factory.core.model.*;
import com.tianjian.factory.core.model.constant.WorkOperator;
import com.tianjian.factory.core.data.ResourceMetaEo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.tianjian.factory.core.model.constant.DataStatus.CREATE;
import static com.tianjian.factory.core.model.constant.DataStatus.UPDATE;
import static com.tianjian.factory.core.model.constant.WorkOperator.*;
import static com.tianjian.factory.core.model.constant.WorkStatus.DOING;
import static com.tianjian.factory.core.model.constant.WorkStatus.DONE;
import static com.tianjian.factory.core.model.constant.WorkStatus.WAITE;

/**
 * Created by tianjian on 2021/2/8.
 */
@Service
public class WorkFlowService {

    @Autowired
    private WorkFlowDataService workFlowDataService;

    private Map<String, WorkDataDTO> allWorkData = new HashMap<>();

    private Map<String, Set<String>> userWorkData = new HashMap<>();

    private Map<String, List<ResourceMetaDTO>> allResourceMeta = new HashMap<>();

    public WorkDataDTO getWorkDataByCode(String workDataCode) {
        if(allWorkData.containsKey(workDataCode)) {
            return allWorkData.get(workDataCode);
        }
        WorkDataDTO workDataDTO = workFlowDataService.getWorkDataByWorkDataCode(workDataCode);
        allWorkData.put(workDataCode, workDataDTO);
        return workDataDTO;
    }



    //拒接某个任务
    public WorkDataDTO rejectWork(String workDataCode, String workDataDetailCode, String userCode) {
        WorkDataDTO workDataDTO = getWorkDataByCode(workDataCode);

        //判断userCode是否有权限删除该任务
        if(workDataDTO == null) {
            return null;
        }

        List<WorkDataDetailDTO> workDetails = workDataDTO.getWorkDataDetailDTOS();
        if(workDetails == null || workDataDTO.getWorkStatus() == WAITE) {
            return null;
        }

        boolean findWorkDetail = false;
        for(WorkDataDetailDTO workDataDetailDTO : workDetails) {
            if(workDataDetailDTO.getWorkDataDetailCode().equals(workDataDetailCode)) {
                findWorkDetail = true;
                workDataDetailDTO.setWorkStatus(DOING);
            } else if(findWorkDetail) {
                workDataDetailDTO.setWorkStatus(WAITE);
            }
        }

        if(!findWorkDetail) {
            //没有能驳回任何任务
            return null;
        }

        if(findWorkDetail && workDataDTO.getWorkStatus() == DONE) {
            workDataDTO.setWorkStatus(DOING);
        }
        workDataDTO.setDataStatus(UPDATE);

        WorkDataRecordDTO workDataRecordDTO = createWorkDatRecordDTO(userCode,
                workDataCode, workDataDetailCode, REJECT);


        workFlowDataService.saveWorkOperationRecord(workDataRecordDTO);
        workFlowDataService.updateWorkData(workDataDTO);
        workDataDTO.addWorkRecord(workDataRecordDTO);

        return workDataDTO;
    }

    public WorkDataDTO startWork(String workDataCode, String userCode) {
        WorkDataDTO workDataDTO = getWorkDataByCode(workDataCode);
        if(workDataDTO == null) {
            return null;
        }
        List<WorkDataDetailDTO> workDataDetailDTOS =  workDataDTO.getWorkDataDetailDTOS();
        if(CollectionUtils.isEmpty(workDataDetailDTOS) || workDataDetailDTOS.stream().filter(e -> e.getWorkStatus() != WAITE).findAny().isPresent()){
            return null;
        }

        workDataDetailDTOS.get(0).setWorkStatus(DOING);
        workDataDTO.setWorkStatus(DOING);
        workFlowDataService.updateWorkData(workDataDTO);

        WorkDataRecordDTO workDataRecordDTO = createWorkDatRecordDTO(userCode,
                workDataCode, null, STARTWORK);
        workFlowDataService.saveWorkOperationRecord(workDataRecordDTO);
        workDataDTO.addWorkRecord(workDataRecordDTO);

        return workDataDTO;
    }

    //通过某个任务
    public WorkDataDTO passWork(String workDataCode, String workDataDetailCode, String userCode) {

        WorkDataDTO workDataDTO = getWorkDataByCode(workDataCode);

        if(workDataDTO == null) {
            return null;
        }

        List<WorkDataDetailDTO> workDetails = workDataDTO.getWorkDataDetailDTOS();

        int findWorkDetail = 0;

        boolean findWorkDetailBoolean = false;

        for(int i = 0; i < workDetails.size(); i++) {
            WorkDataDetailDTO workDataDetailDTO = workDetails.get(i);
            if(workDataDetailDTO.getWorkDataDetailCode().equals(workDataDetailCode)) {

                findWorkDetailBoolean = true;

                if(workDataDetailDTO.getWorkStatus() != DOING) {
                    return null;
                }

                findWorkDetail = i;
                workDataDetailDTO.setWorkStatus(DONE);

                if(workDataDetailDTO.getSortNum() == workDataDetailDTO.getTotalNum()) {
                    workDataDTO.setWorkStatus(DONE);
                } else {
                    workDetails.get(i + 1).setWorkStatus(DOING);
                }
            }

            if(findWorkDetailBoolean && i > findWorkDetail + 1) {
                workDataDetailDTO.setWorkStatus(WAITE);
            }
        }


        workDataDTO.setDataStatus(UPDATE);
        workFlowDataService.updateWorkData(workDataDTO);

        WorkDataRecordDTO workDataRecordDTO = createWorkDatRecordDTO(userCode,
                workDataCode, workDataDetailCode, PASS);
        workFlowDataService.saveWorkOperationRecord(workDataRecordDTO);
        workDataDTO.addWorkRecord(workDataRecordDTO);

        return workDataDTO;
    }

    //查询用户的工作流数据
    public WorkDataDTO initWorkDataByUserCode(String userCode) {
        Set<String> detail = workFlowDataService.getWorkDataCodeByUserCode(userCode);
        for(String key : detail) {
            if(!allWorkData.containsKey(key)) {
                WorkDataDTO workDataDTO = workFlowDataService.getWorkDataByWorkDataCode(key);
                if(workDataDTO != null) {
                    allWorkData.put(key, workDataDTO);
                }
            }
            return allWorkData.get(key);
        }
        return null;
    }

    public WorkDataDTO createWorkData(WorkDataDTO workDataDTO, String userCode) {
        String workDataCode = UUID.randomUUID().toString();
        workDataDTO.setWorkDataCode(workDataCode);
        workDataDTO.setDataStatus(CREATE);

        workDataDTO.getWorkDataDetailDTOS().forEach(e -> {
            e.setWorkDataCode(workDataCode);
        });

        workFlowDataService.createWorkData(workDataDTO);
        allWorkData.put(workDataDTO.getWorkDataCode(), workDataDTO);
        addUserWorkDataDTO(userCode, workDataDTO);
        WorkDataRecordDTO workDataRecordDTO = createWorkDatRecordDTO(userCode, workDataCode, null,
                CREATEWORK );
        workDataDTO.addWorkRecord(workDataRecordDTO);
        return workDataDTO;
    }

    private List<ResourceMetaDTO> getResourceMetaDTO(String workDataCode, String workDataDetailCode) {
        if(!allResourceMeta.containsKey(workDataCode + ":" + workDataDetailCode)){
            List<ResourceMetaDTO> resourceMetaDTOS = workFlowDataService
                    .getResourceMeta(workDataCode, workDataDetailCode);
            allResourceMeta.put(workDataCode + ":" + workDataDetailCode, resourceMetaDTOS);
        }

        return allResourceMeta.get(workDataCode + ":" + workDataDetailCode);

    }

    public boolean addResourceMetaDTO(List<ResourceMetaDTO> resourceMetaDTOs) {

        if(CollectionUtils.isEmpty(resourceMetaDTOs)) {
            return false;
        }

        String workDataCode = resourceMetaDTOs.get(0).getWorkDataCode();
        String workDataDetailCode = resourceMetaDTOs.get(0).getWorkDataDetailCode();
        if(StringUtils.isEmpty(workDataCode) || StringUtils.isEmpty(workDataDetailCode)) {
            return false;
        }

        if(resourceMetaDTOs.stream().filter(e -> !workDataCode.equals(e.getWorkDataCode()) ||
                !workDataDetailCode.equals(e.getWorkDataDetailCode())).findAny().isPresent()) {
            return false;
        }

        if(StringUtils.isEmpty(workDataCode) || StringUtils.isEmpty(workDataDetailCode)) {
            return false;
        }
        boolean r = workFlowDataService.saveResourceMetas(resourceMetaDTOs);
        allResourceMeta.put(workDataCode + ":" + workDataDetailCode, resourceMetaDTOs);
        return r;
    }

    public WorkDataDTO changeResource(String workDataCode, String workDataDetailCode,
                                      String userCode, String resourceValue){
        WorkDataDTO workDataDTO = getWorkDataByCode(workDataCode);
        workDataDTO.getWorkDataDetailDTOS().forEach(e -> {
            if(e.getWorkDataDetailCode().equals(workDataCode)) {
                ResourceDTO resourceDTO = e.getResourceDTO();
                if(resourceDTO == null) {
                    resourceDTO = new ResourceDTO();
                    resourceDTO.setResourceCode(UUID.randomUUID().toString());
                    List<ResourceMetaDTO> resourceMetaDTOs = getResourceMetaDTO(workDataCode, workDataDetailCode);
                    if(!CollectionUtils.isEmpty(resourceMetaDTOs)) {
                        resourceDTO.setResourceMetaDTOS(resourceMetaDTOs);
                    }
                }
                resourceDTO.setWorkDataCode(workDataCode);
                resourceDTO.setWorkDataDetailCode(workDataDetailCode);
                resourceDTO.setResourceValue(resourceValue);
                resourceDTO.setUserCode(userCode);
                boolean result = workFlowDataService.saveOrUpdateResource(resourceDTO);
            }
        });

        WorkDataRecordDTO workDataRecordDTO = createWorkDatRecordDTO(userCode,
                workDataCode, workDataDetailCode, CHANGERESOURCE);
        workFlowDataService.saveWorkOperationRecord(workDataRecordDTO);
        workDataDTO.addWorkRecord(workDataRecordDTO);
        workDataDTO.setDataStatus(UPDATE);
        return workDataDTO;
    }

    public boolean changeResourceMeta(String workDataCode, String workDataDetailCode, List<ResourceMetaDTO> resourceMetaDTOS) {
        allResourceMeta.put(workDataCode + ":" + workDataDetailCode, resourceMetaDTOS);
        List<ResourceMetaDTO> resourceMetaEos = workFlowDataService.getResourceMeta(workDataCode, workDataDetailCode);
        List<ResourceMetaEo> deleteEos = resourceMetaEos.stream().map(e -> {
            ResourceMetaEo resourceMetaEo = new ResourceMetaEo();
            BeanUtils.copyProperties(e, resourceMetaEo);
            resourceMetaEo.setIsDelete("Y");
            return resourceMetaEo;
        }).collect(Collectors.toList());
        workFlowDataService.updateResourceMeta(workDataCode, workDataDetailCode, resourceMetaDTOS);
        return false;
    }

    private WorkDataRecordDTO createWorkDatRecordDTO(String userCode, String workDataCode,
                                                     String workDataDetailCode, WorkOperator workOperator) {
        WorkDataRecordDTO workDataRecordDTO = new WorkDataRecordDTO();
        workDataRecordDTO.setUserCode(userCode);
        workDataRecordDTO.setWorkDataCode(workDataCode);
        workDataRecordDTO.setWorkDataDetailCode(workDataDetailCode);
        workDataRecordDTO.setWorkOperator(workOperator);
        workDataRecordDTO.setWorkDataRecordCode(UUID.randomUUID().toString());
        return workDataRecordDTO;
    }

    private void addUserWorkDataDTO(String userCode, WorkDataDTO workDataDTO) {
        if(userWorkData.containsKey(userCode)) {
            userWorkData.get(userCode).add(workDataDTO.getWorkDataCode());
        }
        Set<String> workDataDTOS = new HashSet<>();
        workDataDTOS.add(workDataDTO.getWorkDataCode());
        userWorkData.put(userCode, workDataDTOS);
    }
}
