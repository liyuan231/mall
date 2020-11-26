package com.liyuan.controller.client;

import com.liyuan.utils.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/client/order")
public class ClientOrderController {

    @PostMapping("/generateOrder")
    @PreAuthorize("hasAnyRole('USER')")
    public Object generateOrder(@RequestParam("cartIds") Integer[] cartIds) {
        System.out.println(Arrays.toString(Arrays.stream(cartIds).toArray()));
        return ResponseUtils.build(HttpStatus.OK.value(), "生成一个订单成功！");
    }
}
