package com.liyuan.controller.admin;

import com.liyuan.service.GoodsServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;

    @DeleteMapping("/{goodsId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object deleteGoodsById(@PathVariable("goodsId") Integer goodsId) {
        int i = goodsService.deleteById(goodsId);
        return ResponseUtils.build(HttpStatus.OK.value(), "删除一个商品成功！");
    }
}
