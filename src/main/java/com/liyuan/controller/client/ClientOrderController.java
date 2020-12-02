package com.liyuan.controller.client;

import com.liyuan.utils.Status;
import com.liyuan.dto.OrderDetailExt;
import com.liyuan.model.*;
import com.liyuan.service.*;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private OrderCartServiceImpl cartOrderService;

    @PostMapping("/order")
    @PreAuthorize("hasAnyRole('USER')")

    public Object add(@RequestParam Integer addressId,
                      @RequestParam Float goodsPrice,
                      @RequestParam Integer[] cartIds) {
        MallUser mallUser = userService.retrieveSecurityContextPrinciple(MallUser.Column.id);
        MallOrder order = new MallOrder();
        order.setUserId(mallUser.getId());
        order.setOrderStatus(Status.ORDER_WAITING_FOR_DELIVERY);
        order.setAftersaleStatus(Status.ORDER_WAITING_FOR_DELIVERY);
        order.setGoodsPrice(goodsPrice);
        order.setAddressId(addressId);
        orderService.insertSelective(order);
        for (Integer cartId : cartIds) {
            MallOrderCart mallOrderCart = new MallOrderCart();
            mallOrderCart.setCartId(cartId);
            mallOrderCart.setOrderId(order.getId());
            mallOrderCart.setStatus(Status.ORDER_WAITING_FOR_DELIVERY);
            cartService.setFinishedById(cartId);
            int i = cartOrderService.insertSelective(mallOrderCart);
        }
        return ResponseUtils.build(HttpStatus.OK.value(), "生成一个订单成功！");
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('USER')")
    public Object allByUserId() {
        MallUser mallUser = userService.retrieveSecurityContextPrinciple(MallUser.Column.id);
        List<MallOrder> orders = orderService.queryByUserId(mallUser.getId(), MallOrder.Column.updateTime, MallOrder.Column.id, MallOrder.Column.addressId);
        List<OrderDetailExt> orderDetailExts = new LinkedList<>();
        for (MallOrder order : orders) {
            OrderDetailExt orderDetailExt = new OrderDetailExt();
            orderDetailExt.setOrderId(order.getId());
            orderDetailExt.setUpdateTime(order.getUpdateTime());
            MallAddress mallAddress = addressService.queryById(order.getAddressId());
            orderDetailExt.setAddress(mallAddress);
            List<MallOrderCart> mallOrderCarts = cartOrderService.queryOneByOrderId(order.getId());
//            JSONArray cartIds = JSONObject.parseArray(order.getCartIds());
            List<OrderDetailExt.CartAndGoodsDetailExt> cartAndGoodsDetailExtList = new LinkedList<>();
            for (MallOrderCart mallOrderCart : mallOrderCarts) {
                OrderDetailExt.CartAndGoodsDetailExt ce = new OrderDetailExt.CartAndGoodsDetailExt();
                MallCart cart = cartService.queryById(mallOrderCart.getCartId(), MallCart.Column.goodsId, MallCart.Column.id, MallCart.Column.number);
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
