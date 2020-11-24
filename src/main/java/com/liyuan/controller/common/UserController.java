package com.liyuan.controller.common;

import com.liyuan.component.cos.COSProperties;
import com.liyuan.model.MallUser;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/common")
@RestController("commonUserController")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private COSProperties cosProperties;


    @GetMapping("/retrieveUserByToken")
    @PreAuthorize("hasAnyRole('USER','ADMINISTRATOR')")
    public Object retrieveUserByToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String username = user.getUsername();
        MallUser mallUser = userService.queryByUsername(username, MallUser.Column.id, MallUser.Column.username, MallUser.Column.mobile, MallUser.Column.avatar, MallUser.Column.role);
        mallUser.setAvatar(cosProperties.getBaseUrl() + mallUser.getAvatar());
        return ResponseUtils.build(HttpStatus.OK.value(), "获取用户信息成功！", mallUser);
    }

}
