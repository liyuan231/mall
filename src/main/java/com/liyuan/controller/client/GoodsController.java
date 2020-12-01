package com.liyuan.controller.client;

import com.github.pagehelper.PageInfo;
import com.liyuan.dto.GoodsWithOneStorage;
import com.liyuan.model.MallGoods;
import com.liyuan.model.MallStorage;
import com.liyuan.model.MallUser;
import com.liyuan.service.GoodsServiceImpl;
import com.liyuan.service.StorageServiceImpl;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.FileEnum;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/client/goods/")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;
    @Autowired
    private StorageServiceImpl storageService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/listSearch")
    public Object listByUpdateTime(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                   @RequestParam("page") Integer page,
                                   @RequestParam("pageSize") Integer pageSize,
                                   @RequestParam(value = "sort", defaultValue = "update_time") String sort,
                                   @RequestParam(value = "order", defaultValue = "desc") String order) {
        PageInfo pageInfo = goodsService.querySelective(keyword, page, pageSize, sort, order);
        List<MallGoods> goods = pageInfo.getList();
        List<GoodsWithOneStorage> goodsWithOneStorages = new LinkedList<>();
        for (MallGoods good : goods) {
            GoodsWithOneStorage goodsWithOneStorage = new GoodsWithOneStorage();
            MallStorage mallStorage = storageService.queryOneByUserIdAndType(good.getId(), FileEnum.GOODS_PRIMARY_IMAGE.value());
            goodsWithOneStorage.setGoods(good);
            goodsWithOneStorage.setStorage(mallStorage);
            goodsWithOneStorages.add(goodsWithOneStorage);
        }
        pageInfo.setList(goodsWithOneStorages);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取最新上架商品成功！", pageInfo);
    }

    @PostMapping("/goods")
    @PreAuthorize("hasAnyRole('USER','STORE')")
    public Object publish(@RequestBody MallGoods goods) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MallUser mallUser = userService.queryByUsername(principal.getUsername(), MallUser.Column.id);
        goods.setBrandId(mallUser.getId());
        goodsService.insertSelective(goods);
        return ResponseUtils.build(HttpStatus.OK.value(), "商家发布商品成功！");
    }
}
