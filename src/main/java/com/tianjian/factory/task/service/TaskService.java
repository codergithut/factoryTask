package com.tianjian.factory.task.service;

import com.alibaba.fastjson.JSON;
import com.tianjian.factory.data.task.*;
import com.tianjian.factory.model.task.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskTemplateTypeMetaCurd taskTemplateTypeMetaCurd;

    /**
     * 保存任务元数据
     * @param taskTemplateTypeMetaVos
     * @return
     */
    public boolean saveTaskTemplateTypeMeta(List<TaskTemplateTypeMetaVo> taskTemplateTypeMetaVos) {
        List<TaskTemplateTypeMetaPo> taskTemplateTypeMetaPos = new ArrayList<>();
        for(TaskTemplateTypeMetaVo taskTemplateTypeMetaVo : taskTemplateTypeMetaVos) {
            List<TaskTemplateTypeMetaDetailVo> taskTemplateTypeMetaDetailVos = taskTemplateTypeMetaVo.getTaskTemplateTypeMetaDetails();
            for(TaskTemplateTypeMetaDetailVo taskTemplateTypeMetaDetailVo : taskTemplateTypeMetaDetailVos) {
                TaskTemplateTypeMetaPo taskTemplateTypeMetaPo = new TaskTemplateTypeMetaPo();
                BeanUtils.copyProperties(taskTemplateTypeMetaDetailVo, taskTemplateTypeMetaPo);
                taskTemplateTypeMetaPo.setTaskTemplateType(taskTemplateTypeMetaVo.getTaskTemplateType());
                taskTemplateTypeMetaPo.setId(UUID.randomUUID().toString());
                taskTemplateTypeMetaPos.add(taskTemplateTypeMetaPo);
            }
        }
        if(CollectionUtils.isEmpty(taskTemplateTypeMetaPos)) {
            return false;
        }
        taskTemplateTypeMetaCurd.saveAll(taskTemplateTypeMetaPos);
        return true;
    }

    /**
     * 根据模板类型获取模板扩展数据
     * @param taskTemplateType
     * @return
     */
    public TaskTemplateTypeMetaVo findTaskTemplateTypeMetaByType(String taskTemplateType) {
        return getTaskTemplateTypeMetaVoByTaskTemplateType(taskTemplateType);
    }

    /**
     * 查找所有的模板外置数据类型节点
     * @return
     */
    public Set<String> findAllTakTemplateType() {
        List<TaskTemplateTypeMetaPo> taskTemplateTypeMetaPos = (List<TaskTemplateTypeMetaPo>) taskTemplateTypeMetaCurd.findAll();
        if(CollectionUtils.isEmpty(taskTemplateTypeMetaPos)) {
            return null;
        }
        return taskTemplateTypeMetaPos.stream().map(e -> e.getTaskTemplateType()).collect(Collectors.toSet());
    }

    @Autowired
    private TaskTemplateCurd taskTemplateCurd;

    /**
     * 保存具体任务模板信息
     * @param taskTemplateVo
     * @return
     */
    public boolean saveTaskTemplate(TaskTemplateVo taskTemplateVo) {
        TaskTemplatePo taskTemplatePo = new TaskTemplatePo();
        BeanUtils.copyProperties(taskTemplateVo, taskTemplatePo);
        taskTemplatePo.setTaskTemplateName(taskTemplateVo.getTaskName());
        taskTemplatePo.setId(UUID.randomUUID().toString());
        taskTemplatePo.setTaskTemplateTypes(JSON.toJSONString(taskTemplateVo.getTaskTemplateTypes()));
        return taskTemplateCurd.save(taskTemplatePo) != null;
    }

    /**
     * 根据模板id获取模板视图信息
     * @param taskTemplateId
     * @return
     */
    public TaskTemplateVo findByTaskTemplateId(String taskTemplateId) {
        Optional<TaskTemplatePo> taskTemplatePoOpt = taskTemplateCurd.findById(taskTemplateId);
        if(taskTemplatePoOpt.isPresent()) {
            TaskTemplateVo taskTemplateVo = new TaskTemplateVo();
            List<TaskTemplateTypeMetaVo> taskTemplateTypeMetaVos = new ArrayList<>();
            TaskTemplatePo taskTemplatePo = taskTemplatePoOpt.get();
            BeanUtils.copyProperties(taskTemplatePo, taskTemplateVo);
            Set<String> templateTypes = JSON.parseObject(taskTemplatePo.getTaskTemplateTypes(),Set.class);
            for(String taskTemplateType : templateTypes) {
                taskTemplateTypeMetaVos.add(getTaskTemplateTypeMetaVoByTaskTemplateType(taskTemplateType));
            }
            taskTemplateVo.setTaskName(taskTemplatePo.getTaskTemplateName());
            taskTemplateVo.setTaskTemplateTypes(templateTypes);
            taskTemplateVo.setTaskTemplateTypeMetaVos(taskTemplateTypeMetaVos);
            return taskTemplateVo;
        }
        return null;
    }


    @Autowired
    private WorkTemplateCurd workTemplateCurd;
    @Autowired
    private WorkTemplateDetailCurd workTemplateDetailCurd;

    /**
     * 保存工作模板信息
     * @param workTemplateVo 工作模板视图
     * @return 是否保存成功
     */
    public boolean saveWorkTemplateVo(WorkTemplateVo workTemplateVo) {
        //模板基础数据添加
        WorkTemplatePo workTemplatePo = new WorkTemplatePo();
        BeanUtils.copyProperties(workTemplateVo, workTemplatePo);
        workTemplatePo.setWorkName(workTemplateVo.getJobName());
        workTemplatePo.setId(UUID.randomUUID().toString());
        List<WorkTemplateDetailVo> workTemplateDetailVos = workTemplateVo.getSubTasks();
        List<WorkTemplateDetailPo> workTemplateDetailPos = new ArrayList<>();
        int orderNum = 0;
        //具体工作模板添加
        for(WorkTemplateDetailVo workTemplateDetailVo : workTemplateDetailVos) {
            WorkTemplateDetailPo workTemplateDetailPo = new WorkTemplateDetailPo();
            BeanUtils.copyProperties(workTemplateDetailVo, workTemplateDetailPo);
            workTemplateDetailPo.setId(UUID.randomUUID().toString());
            workTemplateDetailPo.setOrderNum(orderNum++);
            workTemplateDetailPo.setWorkTemplateId(workTemplatePo.getId());
            workTemplateDetailPos.add(workTemplateDetailPo);
        }
        return workTemplateDetailCurd.saveAll(workTemplateDetailPos) != null
                && workTemplateCurd.save(workTemplatePo) != null && workProcess(workTemplatePo.getId(), 0);

    }


    @Autowired
    private TaskInsDataCurd taskInsDataCurd;

    @Autowired
    private WorkInsDataCurd workInsDataCurd;

    public boolean workProcess(String workTemplateId, int orderNum) {
        Optional<WorkTemplatePo> workTemplatePoOptional = workTemplateCurd.findById(workTemplateId);
        if(!workTemplatePoOptional.isPresent()) {
            return false;
        }
        WorkTemplateDetailPo workTemplateDetailPo = workTemplateDetailCurd.findByWorkTemplateIdAndOrderNum(workTemplateId, orderNum);
        if(workTemplateDetailPo == null) {
            return false;
        }

        TaskInsDataPo taskInsDataPo = new TaskInsDataPo();
        taskInsDataPo.setId(UUID.randomUUID().toString());
        taskInsDataPo.setHandleUserId(workTemplateDetailPo.getHandleUserId());
        taskInsDataPo.setTaskStatus("wait");
        taskInsDataPo.setTaskTemplateId(workTemplateDetailPo.getTaskTemplateId());
        //资源id很重要，是业务添加数据资源的表示
        taskInsDataPo.setResourceId(UUID.randomUUID().toString());
        taskInsDataPo.setTaskTemplateName(workTemplateDetailPo.getTaskTemplateName());
        taskInsDataPo.setWorkTemplateId(workTemplateId);

        WorkInsDataPo workInsDataPo = null;

        if(orderNum == 0) {
            workInsDataPo = workInsDataCurd.findByWorkTemplateIdAndWorkStatusNot(workTemplateId,"reject");
            if(workInsDataPo != null) {
                return false;
            }
            workInsDataPo = new WorkInsDataPo();
            workInsDataPo.setId(UUID.randomUUID().toString());
            List<WorkTemplateDetailPo> workTemplateDetailPos = workTemplateDetailCurd.findByWorkTemplateId(workTemplateId);
            workInsDataPo.setTotalTaskNum(workTemplateDetailPos.size() -1);
        } else {
            workInsDataPo = workInsDataCurd.findByWorkTemplateIdAndWorkStatus(workTemplateId,"active");
        }

        workInsDataPo.setWorkTemplateId(workTemplateId);
        workInsDataPo.setCurrentTaskTemplateId(workTemplateDetailPo.getTaskTemplateId());
        workInsDataPo.setOrderNum(orderNum);
        workInsDataPo.setWorkStatus("active");
        workInsDataPo.setHanderUserId(workTemplateDetailPo.getHandleUserId());

        return taskInsDataCurd.save(taskInsDataPo) != null && workInsDataCurd.save(workInsDataPo) != null;
    }

    public boolean workSubmit(String workTemplateId) {
        TaskInsDataPo taskInsDataPo = taskInsDataCurd.findByWorkTemplateIdAndTaskStatus(workTemplateId, "wait");
        taskInsDataPo.setTaskStatus("finish");
        taskInsDataCurd.save(taskInsDataPo);
        WorkInsDataPo workInsDataPo = workInsDataCurd.findByWorkTemplateIdAndWorkStatus(workTemplateId, "active");
        if(workInsDataPo.getOrderNum() == workInsDataPo.getTotalTaskNum()) {
            workInsDataPo.setWorkStatus("finish");
            workInsDataCurd.save(workInsDataPo);
            return true;
        }
        return workProcess(workTemplateId, workInsDataPo.getOrderNum() + 1);
    }

    public boolean workReject(String workTemplateId, int orderNum) {
        WorkInsDataPo workInsDataPo = workInsDataCurd.findByWorkTemplateIdAndWorkStatusNot(workTemplateId, "reject");
        List<TaskInsDataPo> taskInsDataPos = taskInsDataCurd.findByWorkTemplateId(workTemplateId);
        if(workInsDataPo == null || CollectionUtils.isEmpty(taskInsDataPos) || taskInsDataPos.size() < orderNum -1) {
            return false;
        }
        List<TaskInsDataPo> rejectTaskInsDataPos = new ArrayList<>();
        workInsDataPo.setWorkStatus("reject");
        workInsDataPo.setOrderNum(orderNum);
        workInsDataCurd.save(workInsDataPo);
        for(int i = orderNum; i < taskInsDataPos.size(); i++) {
            TaskInsDataPo rejectData = taskInsDataPos.get(i);
            rejectData.setTaskStatus("reject");
            rejectTaskInsDataPos.add(rejectData);
        }
        taskInsDataCurd.saveAll(rejectTaskInsDataPos);
        return workProcess(workTemplateId, orderNum);
    }

    private TaskTemplateTypeMetaVo getTaskTemplateTypeMetaVoByTaskTemplateType(String taskTemplateType) {
        TaskTemplateTypeMetaVo taskTemplateTypeMetaVo = new TaskTemplateTypeMetaVo();
        List<TaskTemplateTypeMetaPo> taskTemplateTypeMetaPos = taskTemplateTypeMetaCurd.findByTaskTemplateType(taskTemplateType);
        List<TaskTemplateTypeMetaDetailVo> taskTemplateTypeMetaDetailVos = taskTemplateTypeMetaPos.stream().map(e -> {
            TaskTemplateTypeMetaDetailVo taskTemplateTypeMetaDetailVo = new TaskTemplateTypeMetaDetailVo();
            BeanUtils.copyProperties(e, taskTemplateTypeMetaDetailVo);
            return taskTemplateTypeMetaDetailVo;
        }).collect(Collectors.toList());
        taskTemplateTypeMetaVo.setTaskTemplateType(taskTemplateType);
        taskTemplateTypeMetaVo.setTaskTemplateTypeMetaDetails(taskTemplateTypeMetaDetailVos);
        return taskTemplateTypeMetaVo;
    }

    public List<WorkTemplateVo> getMyWork(String userId) {
        List<WorkInsDataPo> workInsDataPos = workInsDataCurd.findByHanderUserIdAndWorkStatus(userId, "active");
        if(CollectionUtils.isEmpty(workInsDataPos)) {
            return null;
        }
        return workInsDataPos.stream().map(e -> {
            WorkTemplateVo workTemplateVo = new WorkTemplateVo();
            WorkTemplatePo workTemplatePo = workTemplateCurd.findById(e.getWorkTemplateId()).get();
            BeanUtils.copyProperties(workTemplatePo, workTemplateVo);
            workTemplateVo.setJobName(workTemplatePo.getWorkName());
            return workTemplateVo;
        }).collect(Collectors.toList());
    }

    public List<WorkTemplateVo> getAllWork() {
        List<WorkTemplatePo> workTemplatePos = (List<WorkTemplatePo>) workTemplateCurd.findAll();
        if(CollectionUtils.isEmpty(workTemplatePos)) {
            return null;
        }
        return workTemplatePos.stream().map(e -> {
            WorkTemplateVo workTemplateVo = new WorkTemplateVo();
            BeanUtils.copyProperties(e, workTemplateVo);
            workTemplateVo.setJobName(e.getWorkName());
            String workTemplateId = e.getId();
            WorkInsDataPo workInsDataPo = workInsDataCurd.findByWorkTemplateId(workTemplateId);
            workTemplateVo.setJobStatus(workInsDataPo.getWorkStatus());
            return workTemplateVo;
        }).collect(Collectors.toList());
    }


    public List<TaskTemplateVo> getAllTaskTemplates() {
        List<TaskTemplatePo> taskTemplatePos = (List<TaskTemplatePo>) taskTemplateCurd.findAll();
        List<TaskTemplateVo> taskTemplateVos = new ArrayList<>();
        if(CollectionUtils.isEmpty(taskTemplatePos)){
            return null;
        }
        taskTemplateVos = taskTemplatePos.stream().map(e -> {
            TaskTemplateVo taskTemplateVo = new TaskTemplateVo();
            BeanUtils.copyProperties(e, taskTemplateVo);
            taskTemplateVo.setTaskCode(e.getId());
            taskTemplateVo.setTaskName(e.getTaskTemplateName());
            return taskTemplateVo;
        }).collect(Collectors.toList());
        return taskTemplateVos;
    }

    public WorkDetailDataVo findTaskInsInfo(String workTemplateId, String userId) {
        WorkTemplateDetailPo workTemplateDetailPo = workTemplateDetailCurd.findByWorkTemplateIdAndHandleUserId(workTemplateId, userId);
        WorkDetailDataVo workDetailDataVo = new WorkDetailDataVo();
        workDetailDataVo.setSubmitTime(workTemplateDetailPo.getStartTime());
        workDetailDataVo.setUpdateTime(workTemplateDetailPo.getEndTime());
        workDetailDataVo.setTaskManager(workTemplateDetailPo.getHandleUserId());
        workDetailDataVo.setTaskFlow(workTemplateDetailPo.getTaskTemplateName());
        workDetailDataVo.setBelongs(workTemplateDetailPo.getWorkTemplateId());
        return workDetailDataVo;
    }
}
