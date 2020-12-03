package com.liyuan.controller.admin;

import com.liyuan.model.MallSystem;
import com.liyuan.service.MallSystemServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system")
public class MallSystemController {

    @Autowired
    private MallSystemServiceImpl systemService;

    @GetMapping("/listAll")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object listALl() {
        List<MallSystem> mallSystems = systemService.querySelectiveAll();
        return ResponseUtils.build(HttpStatus.OK.value(), "获取所有商城的配置成功！", mallSystems);
    }

    @PostMapping("/batchUpdate")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object batchUpdate(@RequestBody MallSystem[] systems) {
        for (MallSystem system : systems) {
            systemService.updateSelective(system);
        }
        return ResponseUtils.build(HttpStatus.OK.value(), "更新成功！");
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object add(@RequestBody MallSystem system) {
        systemService.insertSelective(system);
        return ResponseUtils.build(HttpStatus.OK.value(), "添加一则配置成功！");
    }

}
