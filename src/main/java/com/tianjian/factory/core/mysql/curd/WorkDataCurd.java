package com.tianjian.factory.core.mysql.curd;

import com.tianjian.factory.core.mysql.WorkDataEo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tianjian on 2021/2/8.
 */
public interface WorkDataCurd extends CrudRepository<WorkDataEo, String> {
    WorkDataEo findAllByWorkDataCode(String workDataCode);
}
