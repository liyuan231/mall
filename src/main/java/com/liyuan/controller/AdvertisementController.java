package com.liyuan.controller;

import com.liyuan.service.AdvertisementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {
    @Autowired
    AdvertisementServiceImpl advertisementService;

    @GetMapping("/listSearch")
    public Object listSearch(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                             @RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize) {
        return advertisementService.querySelective(keyword, page, pageSize);
    }

}
