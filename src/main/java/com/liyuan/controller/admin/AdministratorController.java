package com.liyuan.controller.admin;

import com.github.pagehelper.PageInfo;
import com.liyuan.component.cos.COSProperties;
import com.liyuan.model.MallAdmin;
import com.liyuan.service.AdministratorServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorServiceImpl administratorService;
    @Autowired
    private COSProperties cosProperties;

    @GetMapping("/listSearch")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object listSearch(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                             @RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize) {
        PageInfo<MallAdmin> pageInfo = administratorService.listSearch(keyword, page, pageSize, MallAdmin.Column.id,
                MallAdmin.Column.username, MallAdmin.Column.lastLoginTime, MallAdmin.Column.role, MallAdmin.Column.avatar);
        for (MallAdmin admin : pageInfo.getList()) {
            admin.setAvatar(cosProperties.getBaseUrl() + admin.getAvatar());
        }

        return ResponseUtils.build(HttpStatus.OK.value(), "获取管理员列表 成功！", pageInfo);
    }

    @GetMapping("/queryById/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object queryById(@PathVariable("id") Integer id) {
        MallAdmin admin = administratorService.queryById(id, MallAdmin.Column.id, MallAdmin.Column.username, MallAdmin.Column.role, MallAdmin.Column.avatar, MallAdmin.Column.lastLoginTime);
        admin.setAvatar(cosProperties.getBaseUrl() + admin.getAvatar());
        return ResponseUtils.build(HttpStatus.OK.value(), "获取某一管理员信息成功！", admin);
    }

    @PostMapping("/updateAdministratorById")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object updateAdministratorById(@RequestBody MallAdmin admin) {
        int i = administratorService.updateSelective(admin);
        return ResponseUtils.build(HttpStatus.OK.value(), "更新管理员信息成功！");
    }

    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object deleteById(@PathVariable("id") Integer id) {
        int i = administratorService.deleteById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "删除一个用户成功！");
    }
}
