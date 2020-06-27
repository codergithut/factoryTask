package com.tianjian.factory.data.task;

import com.tianjian.factory.model.task.WorkTemplateDetailVo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface WorkTemplateDetailCurd extends CrudRepository<WorkTemplateDetailPo, String> {
    WorkTemplateDetailPo findByWorkTemplateIdAndOrderNum(String workTemplateId, int orderNum);

    List<WorkTemplateDetailPo> findByWorkTemplateId(String workTemplateId);

    WorkTemplateDetailPo findByWorkTemplateIdAndHandleUserId(String workTemplateId, String userId);
}
