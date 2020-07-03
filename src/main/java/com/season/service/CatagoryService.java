package com.season.service;

import com.season.common.Result;
import com.season.entity.CatagoryAO;
import com.season.entity.dto.CatagoryDTO;

import java.util.List;

/**
 * @decription:
 * @author: season
 * @date: 2020/7/3 10:52
 */
public interface CatagoryService {
    Result<Integer> addCatagory(CatagoryAO catagoryAO);
    Result<Boolean> updateCatagory(CatagoryAO catagoryAO);
    Result<Boolean> deleteCatagory(Integer catagoryId);
    Result<List<CatagoryDTO>> listCatagory();
}
