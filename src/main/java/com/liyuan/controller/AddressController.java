package com.liyuan.controller;

import com.github.pagehelper.PageInfo;
import com.liyuan.dto.AddressAndUser;
import com.liyuan.model.MallAddress;
import com.liyuan.model.MallUser;
import com.liyuan.service.AddressServiceImpl;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/listSearch")
    public Object listSearch(@RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize,
                             @RequestParam(value = "keyWord", defaultValue = "", required = false) String keyWord) {
        PageInfo pageInfo = addressService.querySelective(keyWord, page, pageSize, MallAddress.Column.id, MallAddress.Column.userId, MallAddress.Column.addressDetail, MallAddress.Column.mobile, MallAddress.Column.name);
        List<MallAddress> list = pageInfo.getList();
        List<AddressAndUser> addressAndUsers = new LinkedList<>();
        for (MallAddress mallAddress : list) {
            MallUser mallUser = userService.queryById(mallAddress.getUserId(), MallUser.Column.id, MallUser.Column.username);
            AddressAndUser addressWithUser = new AddressAndUser();
            addressWithUser.setAddress(mallAddress);
            addressWithUser.setUser(mallUser);
            addressAndUsers.add(addressWithUser);
        }
        pageInfo.setList(addressAndUsers);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取所哟用户成功！包括关键字", pageInfo);
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteAddressById(@PathVariable("id") Integer id) {
        addressService.deleteById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "删除一个地址成功！！");
    }

    @GetMapping("/queryAddressById/{id}")
    public Object queryAddressById(@PathVariable("id") Integer id) {
        MallAddress mallAddress = addressService.queryById(id);
        MallUser mallUser = userService.queryById(mallAddress.getUserId(), MallUser.Column.id, MallUser.Column.username);
        AddressAndUser addressWithUser = new AddressAndUser();
        addressWithUser.setAddress(mallAddress);
        addressWithUser.setUser(mallUser);


        return ResponseUtils.build(HttpStatus.OK.value(), "获取一个地址成功！！", addressWithUser);
    }

    @PostMapping("/updateAddressById")
    public Object updateAddressById(@RequestBody MallAddress address) {
        int i = addressService.updateSelectiveById(address);
        return ResponseUtils.build(HttpStatus.OK.value(), "修改地址信息成功！");
    }
}
