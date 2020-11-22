package com.liyuan.controller.admin;

import com.github.pagehelper.PageInfo;
import com.liyuan.model.MallAd;
import com.liyuan.service.AdvertisementServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {
    @Autowired
    AdvertisementServiceImpl advertisementService;

    @GetMapping("/listSearch")
    public Object listSearch(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                             @RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize) {
        PageInfo pageInfo = advertisementService.querySelective(keyword, page, pageSize);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取列表广告成功", pageInfo);
    }

    @GetMapping("/queryById/{id}")
    public Object queryById(@PathVariable("id") Integer id) {
        MallAd mallAd = advertisementService.queryById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取某一则广告成功！", mallAd);
    }

    @PostMapping("/updateAdvertisementById")
    public Object updateAdvertisementById(@RequestBody MallAd ad) {
        int i = advertisementService.updateSelective(ad);
        return ResponseUtils.build(HttpStatus.OK.value(), "修改一则广告成功！", i);
    }

}
