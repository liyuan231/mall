package com.liyuan.controller.client;

import com.github.pagehelper.PageInfo;
import com.liyuan.dto.GoodsWithOneStorage;
import com.liyuan.model.MallGoods;
import com.liyuan.model.MallStorage;
import com.liyuan.service.GoodsServiceImpl;
import com.liyuan.service.StorageServiceImpl;
import com.liyuan.utils.FileEnum;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/client/goods/")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;
    @Autowired
    private StorageServiceImpl storageService;

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
}
