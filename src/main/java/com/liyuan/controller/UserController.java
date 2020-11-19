package com.liyuan.controller;

import com.github.pagehelper.PageInfo;
import com.liyuan.model.MallUser;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add")
    public String add(@RequestBody MallUser user) {
        int i = userService.insertSelective(user);
        return ResponseUtils.build(HttpStatus.OK.value(), "添加用户成功");
    }

    @PostMapping("/updateUserById")
    public Object updateUserById(@RequestBody MallUser mallUser) {
        int i = userService.updateSelectiveById(mallUser);
        return ResponseUtils.build(HttpStatus.OK.value(), "修改用户信息成功！");

    }

    @GetMapping("/listSearch")
    public Object listSearch(@RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize,
                             @RequestParam(value = "keyWord", defaultValue = "", required = false) String keyWord) {
        PageInfo pageInfo = userService.querySelective(keyWord, page, pageSize, MallUser.Column.id, MallUser.Column.username, MallUser.Column.role, MallUser.Column.mobile);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取所哟用户成功！包括关键字", pageInfo);
    }

    @GetMapping("/queryUserById")
    public Object queryUserById(@RequestParam("id") Integer id) {
        MallUser mallUser = userService.queryById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取某一用户信息成功！", mallUser);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "删除一个用户成功！！");
    }

}
