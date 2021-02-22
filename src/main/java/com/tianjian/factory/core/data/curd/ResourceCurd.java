package com.tianjian.factory.core.data.curd;

import com.tianjian.factory.core.data.ResourceEo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tianjian on 2021/2/8.
 */
public interface ResourceCurd extends CrudRepository<ResourceEo, String> {
    ResourceEo findByWorkDataCodeAndWorkDataDetailCode(String workDataCode, String workDataDetailCode);
}
