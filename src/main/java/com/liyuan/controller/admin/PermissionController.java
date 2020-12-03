package com.liyuan.controller.admin;


import com.liyuan.model.MallPermission;
import com.liyuan.service.PermissionServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionServiceImpl permissionService;

    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object deleteById(@PathVariable("id") Integer id) {
        int i = permissionService.deleteById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "删除一则权限成功！");
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object add(@RequestBody MallPermission permission) {
        int i = permissionService.insertAPermission(permission);
        return ResponseUtils.build(HttpStatus.OK.value(), "插入一则权限成功！");
    }
}
