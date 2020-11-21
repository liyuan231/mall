package com.liyuan.controller;

import com.github.pagehelper.PageInfo;
import com.liyuan.dto.StorageAndUser;
import com.liyuan.model.MallStorage;
import com.liyuan.model.MallUser;
import com.liyuan.service.StorageServiceImpl;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageServiceImpl storageService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/listSearch")
    public Object listSearch(@RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize) {
        PageInfo pageInfo = storageService.querySelective(page, pageSize);
        List<MallStorage> storages = pageInfo.getList();
        List<StorageAndUser> storageAndUsers = new LinkedList<>();
        for (MallStorage storage : storages) {
            StorageAndUser storageAndUser = new StorageAndUser();
            storageAndUser.setStorage(storage);
            MallUser mallUser = userService.queryById(storage.getUserId(), MallUser.Column.username);
            storageAndUser.setUser(mallUser);
            storageAndUsers.add(storageAndUser);
        }
        pageInfo.setList(storageAndUsers);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取数据库对象存储列表成功！", pageInfo);
    }
}
