package com.liyuan.controller.client;

import com.liyuan.model.MallUser;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/user")
public class AuthenticationController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public Object register(@RequestBody MallUser user) {
        int i = userService.insertSelective(user);
        return ResponseUtils.build(HttpStatus.OK.value(), "注册成功！");
    }
}
