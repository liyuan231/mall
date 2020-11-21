package com.liyuan.controller;

import com.liyuan.service.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageServiceImpl storageService;

    @GetMapping("/listSearch")
    public Object listSearch(@RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize) {
        return storageService.querySelective(page, pageSize);

    }
}
