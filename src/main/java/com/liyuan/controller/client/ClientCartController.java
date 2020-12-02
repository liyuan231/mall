package com.liyuan.controller.client;

import com.github.pagehelper.PageInfo;
import com.liyuan.component.cos.COSProperties;
import com.liyuan.dto.SimpleInfoCart;
import com.liyuan.model.MallCart;
import com.liyuan.model.MallGoods;
import com.liyuan.model.MallStorage;
import com.liyuan.model.MallUser;
import com.liyuan.service.CartServiceImpl;
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
@RequestMapping("/client/cart")
public class ClientCartController {

    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private GoodsServiceImpl goodsService;
    @Autowired
    private StorageServiceImpl storageService;
    @Autowired
    private COSProperties cosProperties;

    @GetMapping("/listSearch")
    @PreAuthorize("hasAnyRole('USER')")
    public Object listSearch(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MallUser mallUser = userService.queryByUsername(user.getUsername(), MallUser.Column.id);
        PageInfo pageInfo = cartService.querySelective(mallUser.getId(), page, pageSize);
        List<MallCart> carts = pageInfo.getList();
        List<SimpleInfoCart> simpleInfoCarts = new LinkedList<>();
        float sum = 0.0f;
        for (MallCart cart : carts) {
            SimpleInfoCart simpleInfoCart = new SimpleInfoCart();
            simpleInfoCart.setCartId(cart.getId());
            simpleInfoCart.setChecked(cart.getChecked());
            MallGoods mallGoods = goodsService.queryById(cart.getGoodsId(), MallGoods.Column.id, MallGoods.Column.name, MallGoods.Column.price, MallGoods.Column.brandId,MallGoods.Column.primaryImage);
            simpleInfoCart.setGoodsId(mallGoods.getId());
            simpleInfoCart.setGoodsPrice(mallGoods.getPrice());
            simpleInfoCart.setName(mallGoods.getName());
            simpleInfoCart.setNumber(cart.getNumber());
//            MallStorage mallStorage = storageService.queryOneByTargetIdAndType(mallGoods.getBrandId(), FileEnum.GOODS_PRIMARY_IMAGE.value(), MallStorage.Column.location);
//            Assert.notNull(mallStorage, "该商品无对应的主要展示图片！");
//            if (mallStorage == null) {
//                mallStorage = new MallStorage();
//                mallStorage.setLocation("-1");
//            }
            simpleInfoCart.setPicUrl( mallGoods.getPrimaryImage());
            simpleInfoCart.setUpdateTime(cart.getUpdateTime());
            simpleInfoCarts.add(simpleInfoCart);
            sum += cart.getNumber() * mallGoods.getPrice();
        }

        pageInfo.setList(simpleInfoCarts);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取该用户购物车列表成功！", pageInfo);
    }


    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public Object deleteById(@PathVariable("id") Integer id) {
        int i = cartService.deleteById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "删除一个购物车记录成功！");
    }

    @PostMapping("/check/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public Object check(@PathVariable("id") Integer id) {
        int i = cartService.check(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "tick一个购物车商品成功！");

    }


    @PostMapping("/plusNumber/{cartId}")
    @PreAuthorize("hasAnyRole('USER')")
    public Object plusNumber(@PathVariable("cartId") Integer id) {
        int i = cartService.plusNumber(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "增加一个购物车商品成功！");
    }


    @PostMapping("/minusNumber/{cartId}")
    @PreAuthorize("hasAnyRole('USER')")
    public Object minusNumber(@PathVariable("cartId") Integer id) {
        int i = cartService.minusNumber(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "减少一个购物车商品成功！");
    }

    @PostMapping("/cart")
    @PreAuthorize("hasAnyRole('USER')")
    public Object add(@RequestBody MallCart cart) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MallUser mallUser = userService.queryByUsername(principal.getUsername(), MallUser.Column.id);
        cart.setUserId(mallUser.getId());
        cart.setChecked(false);
        int i = cartService.insertSelective(cart);
        return ResponseUtils.build(HttpStatus.OK.value(), "添加一个商品到购物车成功！");
    }

    @GetMapping("/cart/brand/{brandId}")
    public Object queryByBrandId(@PathVariable("brandId")Integer brandId){
        List<MallCart> mallCarts = cartService.queryByBrandId(brandId);

        return ResponseUtils.build(HttpStatus.OK.value(),"商家获取他的订单s成功！",mallCarts);
    }

}
