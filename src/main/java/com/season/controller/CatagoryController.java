package com.season.controller;

import com.season.common.Result;
import com.season.entity.CatagoryAO;
import com.season.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @decription:
 * @author: season
 * @date: 2020/7/3 10:48
 */
@RestController
@RequestMapping("/catagory")
public class CatagoryController {
    @Autowired
    private CatagoryService catagoryService;

    @PostMapping("/add")
    public Result addCatagory(@RequestBody CatagoryAO catagoryAO) {
        return catagoryService.addCatagory(catagoryAO);
    }

    @PostMapping("/update")
    public Result updateCatagory(@RequestBody CatagoryAO catagoryAO) {
        return catagoryService.updateCatagory(catagoryAO);
    }

    @PostMapping("/delete")
    public Result deleteCatagory(@RequestParam Integer catagoryId) {
        return catagoryService.deleteCatagory(catagoryId);
    }

    @GetMapping("/list")
    public Result listCatagory() {
        return catagoryService.listCatagory();
    }
}
