package com.liyuan.controller.client;

import com.liyuan.service.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/goods/")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;

    @GetMapping("/listByUpdateTime")
    public Object listByUpdateTime(@RequestParam("keyword") String keyword,
                                   @RequestParam("page") Integer page,
                                   @RequestParam("pageSize") Integer pageSize) {


    }
}
