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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/client/goods")
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
        return ResponseUtils.build(HttpStatus.OK.value(), "获取最新上架商品成功！", pageInfo);
    }

    @PostMapping("/goods")
    @PreAuthorize("hasAnyRole('USER','STORE')")
    public Object publish(@RequestBody MallGoods goods) {
        if (Objects.nonNull(goods.getId())) {
            goodsService.updateSelectiveById(goods);
            return ResponseUtils.build(HttpStatus.OK.value(), "商家修改一则商品成功！", goods);
        }
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MallUser mallUser = userService.queryByUsername(principal.getUsername(), MallUser.Column.id);
        goods.setBrandId(mallUser.getId());
        goodsService.insertSelective(goods);
        return ResponseUtils.build(HttpStatus.OK.value(), "商家发布商品成功！", goods);
    }


    /*
    获取商家发布的商品
     */
    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('STORE')")
    public Object listAllGoods() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        MallUser mallUser = userService.queryByUsername(principal.getUsername(), MallUser.Column.id);
        List<MallGoods> goods = goodsService.queryByBrandId(mallUser.getId(), MallGoods.Column.id, MallGoods.Column.name,
                MallGoods.Column.price, MallGoods.Column.brief, MallGoods.Column.updateTime, MallGoods.Column.primaryImage);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取该商家发布的所有商品成功！", goods);
    }

    /**
     * 商家点进来后想要修改该则商品信息
     *
     * @param goodsId
     * @return
     */
    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('USER','STORE')")
    public Object goods(@PathVariable("id") Integer goodsId) {
        MallGoods mallGoods = goodsService.queryById(goodsId);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取该则商品信息成功！", mallGoods);
    }
}
