package com.liyuan.controller.client;

import com.github.pagehelper.PageInfo;
import com.liyuan.component.cos.COSProperties;
import com.liyuan.dto.CartAndGoodsAndAPrimaryImage;
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
import org.springframework.util.Assert;
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
        List<CartAndGoodsAndAPrimaryImage> cartAndGoodsAndAPrimaryImages = new LinkedList<>();
        for (MallCart cart : carts) {
            CartAndGoodsAndAPrimaryImage cartAndGoodsAndAPrimaryImage = new CartAndGoodsAndAPrimaryImage();
            cartAndGoodsAndAPrimaryImage.setCart(cart);
            MallGoods mallGoods = goodsService.queryById(cart.getGoodsId(), MallGoods.Column.id, MallGoods.Column.name, MallGoods.Column.price, MallGoods.Column.brandId);
            cartAndGoodsAndAPrimaryImage.setGoods(mallGoods);
            MallStorage mallStorage = storageService.queryOneByUserIdAndType(mallGoods.getBrandId(), FileEnum.GOODS_PRIMARY_IMAGE.value(), MallStorage.Column.location);
            Assert.notNull(mallStorage, "该商品无对应的主要展示图片！");
            mallStorage.setLocation(cosProperties.getBaseUrl() + mallStorage.getLocation());
            cartAndGoodsAndAPrimaryImage.setStorage(mallStorage);
            cartAndGoodsAndAPrimaryImages.add(cartAndGoodsAndAPrimaryImage);
        }
        pageInfo.setList(cartAndGoodsAndAPrimaryImages);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取该用户购物车列表成功！", pageInfo);
    }


    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public Object deleteById(@PathVariable("id") Integer id) {
        int i = cartService.deleteById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "删除一个购物车记录成功！");
    }


}
