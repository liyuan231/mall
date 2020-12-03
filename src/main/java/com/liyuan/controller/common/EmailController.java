package com.liyuan.controller.common;

import com.liyuan.service.EmailServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/email")
public class EmailController {
    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping("/sendEmailCode")
    public Object sendEmailCode(@RequestParam("username") String username) {
        emailService.sendCode(username);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取邮箱验证码成功！");
    }
}
