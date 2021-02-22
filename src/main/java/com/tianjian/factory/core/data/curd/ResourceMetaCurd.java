package com.tianjian.factory.core.data.curd;

import com.tianjian.factory.core.data.ResourceMetaEo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tianjian on 2021/2/8.
 */
public interface ResourceMetaCurd extends CrudRepository<ResourceMetaEo, String> {
    List<ResourceMetaEo> findByWorkDataCodeAndWorkDataDetailCodeAndIsDelete(String workDataCode,
                                                                            String workDataDetailCode, String isDelete);
}
