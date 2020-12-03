package com.liyuan.controller.admin;

import com.liyuan.dto.RoleAndPermissions;
import com.liyuan.model.MallPermission;
import com.liyuan.model.MallRole;
import com.liyuan.service.PermissionServiceImpl;
import com.liyuan.service.RoleServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;
    @Autowired
    private PermissionServiceImpl permissionService;


    @GetMapping("/listSearchAll")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object listSearchAll() {
        List<MallRole> mallRoles = roleService.querySelectiveAll();
        return ResponseUtils.build(HttpStatus.OK.value(), "获取所有角色成功！", mallRoles);
    }

    @GetMapping("/queryById/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object queryRoleById(@PathVariable("id") Integer id) {
        MallRole mallRole = roleService.queryById(id);
        List<MallPermission> mallPermissions = permissionService.queryByRoleId(id);
        RoleAndPermissions roleAndPermission = new RoleAndPermissions();
        roleAndPermission.setRole(mallRole);
        roleAndPermission.setPermission(mallPermissions);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取某一角色及其权限成功！", roleAndPermission);
    }

    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object deleteById(@PathVariable("id") Integer id) {
        int i = roleService.deleteById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "删除某一角色成功！", i);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object add(@RequestBody MallRole role) {
        int i = roleService.insertSelective(role);
        return ResponseUtils.build(HttpStatus.OK.value(), "插入一个角色成功！");
    }
}
