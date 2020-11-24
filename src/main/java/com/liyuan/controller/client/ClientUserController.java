package com.liyuan.controller.client;

import com.liyuan.model.MallAddress;
import com.liyuan.model.MallUser;
import com.liyuan.service.AddressServiceImpl;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client/user")
public class ClientUserController {

    @Autowired
    private AddressServiceImpl addressService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/retrieveUserAddressesByToken")
    @PreAuthorize("hasRole('USER')")
    public Object retrieveUserAddressesByToken() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        MallUser mallUser = userService.queryByUsername(username, MallUser.Column.id);
        List<MallAddress> mallAddresses = addressService.queryByUserId(mallUser.getId());
        return ResponseUtils.build(HttpStatus.OK.value(), "获取用户地址信息成功！", mallAddresses);
    }
}
