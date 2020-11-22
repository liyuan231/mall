package com.liyuan.controller.admin;

import com.github.pagehelper.PageInfo;
import com.liyuan.dto.OrderAndUserAndAddress;
import com.liyuan.model.MallAddress;
import com.liyuan.model.MallOrder;
import com.liyuan.model.MallUser;
import com.liyuan.service.AddressServiceImpl;
import com.liyuan.service.OrderServiceImpl;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private AddressServiceImpl addressService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/listSearch")
    public Object listSearch(@RequestParam(value = "keyword", defaultValue = "", required = false) String keyword,
                             @RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize) {
        PageInfo pageInfo = orderService.querySelective(keyword, page, pageSize);
        List<MallOrder> orders = pageInfo.getList();
        List<OrderAndUserAndAddress> orderAndUserAndAddresses = new LinkedList<>();
        for (MallOrder order : orders) {
            OrderAndUserAndAddress orderAndUserAndAddress = new OrderAndUserAndAddress();
            orderAndUserAndAddress.setOrder(order);
            MallAddress mallAddress = addressService.queryById(order.getAddressId());
            orderAndUserAndAddress.setAddress(mallAddress);
            MallUser mallUser = userService.queryById(order.getUserId(), MallUser.Column.id, MallUser.Column.username);
            orderAndUserAndAddress.setUser(mallUser);
            orderAndUserAndAddresses.add(orderAndUserAndAddress);
        }
        pageInfo.setList(orderAndUserAndAddresses);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取suoyou orders 成功！包括关键字", pageInfo);
    }
}
