package com.season.service;

import com.season.common.Result;
import com.season.entity.SubclassAO;
import com.season.entity.dto.SubclassDTO;

import java.util.List;

/**
 * @decription: 事件小类服务
 * @author: zhixian.lin@luckincoffee.com
 * @date: 2020/7/13 13:51
 */
public interface SubclassService {
    Result<Integer> addSubclass(SubclassAO subclassAO);
    Result<Boolean> updateSubclass(SubclassAO subclassAO);
    Result<Boolean> deleteSubclass(Integer subclassId);

    Result<List<SubclassDTO>> listSubclasses(Integer catagoryId);
}
