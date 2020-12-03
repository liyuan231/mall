package com.liyuan.controller.common;

import com.liyuan.model.MallAd;
import com.liyuan.service.AdvertisementServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/common/ad")
public class AdController {

    @Autowired
    private AdvertisementServiceImpl advertisementService;

    @GetMapping("/{position}")
    @PreAuthorize("permitAll()")
    public Object ads(@PathVariable("position") Integer position) {
        List<MallAd> mallAds = advertisementService.queryByIndexAndDate(position, MallAd.Column.id, MallAd.Column.name, MallAd.Column.link, MallAd.Column.url);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取相应位置相应时间的广告成功！", mallAds);
    }
}
