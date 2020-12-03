package com.liyuan.controller.client;

import com.liyuan.model.MallUser;
import com.liyuan.service.EmailServiceImpl;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import com.liyuan.utils.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/user")
public class AuthenticationController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping("/register")
    public Object register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("code") String code) {
        String s = emailService.get(username);
        if (s == null || !s.equals(code)) {
            return ResponseUtils.build(HttpStatus.BAD_REQUEST.value(), "邮箱验证码错误！");
        }
        emailService.remove(username);
        MallUser user = new MallUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(RoleEnum.USER.value());
        int i = userService.insertSelective(user);
        return ResponseUtils.build(HttpStatus.OK.value(), "注册成功！");
    }
}
