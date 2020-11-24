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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/address")
public class ClientAddressController {

    @Autowired
    private AddressServiceImpl addressService;
    @Autowired
    private UserServiceImpl userService;

    @DeleteMapping("/deleteAddressById/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public Object deleteAddressById(@PathVariable("id") Integer id) {
        int i = addressService.deleteById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "删除一个地址成功！");
    }

    @GetMapping("/retrieveAddressesByToken")
    @PreAuthorize("hasRole('USER')")
    public Object retrieveUserAddressesByToken() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        MallUser mallUser = userService.queryByUsername(username, MallUser.Column.id);
        List<MallAddress> mallAddresses = addressService.queryByUserId(mallUser.getId());
        return ResponseUtils.build(HttpStatus.OK.value(), "获取用户地址信息成功！", mallAddresses);
    }

    @PostMapping("/addAddress")
    @PreAuthorize("hasAnyRole('USER')")
    public Object addAddress(@RequestBody MallAddress address) {
        int i = addressService.insertSelective(address);
        return ResponseUtils.build(HttpStatus.OK.value(), "添加收货地址成功！");
    }

    @PostMapping("/updateAddresses")
    @PreAuthorize("hasAnyRole('USER')")
    public Object updateAddresses(@RequestBody MallAddress[] addresses) {
        addressService.batchUpdateSelectiveById(addresses);
        return ResponseUtils.build(HttpStatus.OK.value(), "修改收货地址成功！");
    }
}
