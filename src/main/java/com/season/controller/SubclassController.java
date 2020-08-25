package com.season.controller;

import com.season.common.Result;
import com.season.entity.SubclassAO;
import com.season.service.SubclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @decription:
 * @author: season
 * @date: 2020/7/13 13:57
 */
@RestController
@RequestMapping("/subclass")
public class SubclassController {
    @Autowired
    private SubclassService subclassService;

    @PostMapping("/add")
    public Result addSubclass(@RequestBody SubclassAO subclassAO) {
        return subclassService.addSubclass(subclassAO);
    }

    @PostMapping("/update")
    public Result updateSubclass(@RequestBody SubclassAO subclassAO) {
        return subclassService.updateSubclass(subclassAO);
    }

    @PostMapping("/delete")
    public Result deleteSubclass(@RequestParam Integer subclassId) {
        return subclassService.deleteSubclass(subclassId);
    }

    @PostMapping("/list")
    public Result listSubclasses(@RequestParam Integer catagoryId) {
        return subclassService.listSubclasses(catagoryId);
    }
}
