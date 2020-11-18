package com.liyuan.controller;

import com.liyuan.model.MallUser;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add")
    public String add(@RequestBody MallUser user) {
        int i = userService.insertSelective(user);
        return ResponseUtils.build(HttpStatus.OK.value(), "添加用户成功");
    }
}
