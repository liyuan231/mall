package com.liyuan.controller;

import com.liyuan.model.MallUser;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add")
    public String add(@RequestBody MallUser user) {
        int i = userService.insertSelective(user);
        return ResponseUtils.build(HttpStatus.OK.value(), "添加用户成功");
    }

    @GetMapping("/listSearchAll")
    public Object listSearchAll() {
        List<MallUser> mallUsers = userService.querySelective();
        return ResponseUtils.build(HttpStatus.OK.value(), "获取所哟用户成功！包括关键字", mallUsers);
    }
}
