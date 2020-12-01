package com.liyuan.controller.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liyuan.controller.common.Status;
import com.liyuan.dto.OrderDetailExt;
import com.liyuan.model.*;
import com.liyuan.service.*;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/client/order")
public class ClientOrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private AddressServiceImpl addressService;

    @Autowired
    private GoodsServiceImpl goodsService;

//    @PostMapping("/generateOrder")
//    @PreAuthorize("hasAnyRole('USER')")
//    public Object generateOrder(@RequestParam("cartIds") Integer[] cartIds) {
//        System.out.println(Arrays.toString(Arrays.stream(cartIds).toArray()));
//        return ResponseUtils.build(HttpStatus.OK.value(), "生成一个订单成功！");
//    }

    @PostMapping("/order")
    @PreAuthorize("hasAnyRole('USER')")
    public Object add(@RequestBody MallOrder order) {
        MallUser mallUser = userService.retrieveSecurityContextPrinciple(MallUser.Column.id);
        order.setUserId(mallUser.getId());
        order.setOrderStatus(Status.WAITING_FOR_DELIVERY);
        order.setAftersaleStatus(Status.WAITING_FOR_DELIVERY);
        orderService.insertSelective(order);

        String cartIds = order.getCartIds();
        JSONArray jsonArray = JSONObject.parseArray(cartIds);
        for (Object o : jsonArray) {
            Integer id = (Integer) o;
            int i = cartService.setFinishedById(id);
        }
        return ResponseUtils.build(HttpStatus.OK.value(), "生成一个订单成功！");
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('USER')")
    public Object allByUserId() {
        MallUser mallUser = userService.retrieveSecurityContextPrinciple(MallUser.Column.id);
        List<MallOrder> orders = orderService.queryByUserId(mallUser.getId(), MallOrder.Column.updateTime, MallOrder.Column.id, MallOrder.Column.addressId, MallOrder.Column.cartIds);
        List<OrderDetailExt> orderDetailExts = new LinkedList<>();
        for (MallOrder order : orders) {
            OrderDetailExt orderDetailExt = new OrderDetailExt();
            orderDetailExt.setOrderId(order.getId());
            orderDetailExt.setUpdateTime(order.getUpdateTime());
            MallAddress mallAddress = addressService.queryById(order.getAddressId());
            orderDetailExt.setAddress(mallAddress);
            JSONArray cartIds = JSONObject.parseArray(order.getCartIds());
            List<OrderDetailExt.CartAndGoodsDetailExt> cartAndGoodsDetailExtList = new LinkedList<>();
            for (Object cartId : cartIds) {
                OrderDetailExt.CartAndGoodsDetailExt ce = new OrderDetailExt.CartAndGoodsDetailExt();
                Integer cid = (Integer) cartId;
                MallCart cart = cartService.queryById(cid, MallCart.Column.goodsId, MallCart.Column.id, MallCart.Column.number);
                ce.setCartId(cart.getId());
                ce.setNumber(cart.getNumber());
                MallGoods mallGoods = goodsService.queryById(cart.getGoodsId(), MallGoods.Column.name, MallGoods.Column.id);
                ce.setGoodsId(mallGoods.getId());
                ce.setName(mallGoods.getName());
                cartAndGoodsDetailExtList.add(ce);
            }
            orderDetailExt.setGoodsExt(cartAndGoodsDetailExtList);
            orderDetailExts.add(orderDetailExt);
        }
        return ResponseUtils.build(HttpStatus.OK.value(), "获取当前用户所有的订单成功！", orderDetailExts);
    }
}
