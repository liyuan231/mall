package com.liyuan.controller.client;

import com.liyuan.service.OrderCartServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/orderCart")
public class ClientOrderCartController {

    @Autowired
    private OrderCartServiceImpl orderCartService;

    @PostMapping("/finish")
    @PreAuthorize("hasAnyRole('STORE')")
    public Object finishAnOrder(@RequestParam("orderCartId")Integer orderCartId) {
        orderCartService.finishAnOrder(orderCartId);
        return ResponseUtils.build(HttpStatus.OK.value(), "商家完成一则订单成功！");
    }
}
