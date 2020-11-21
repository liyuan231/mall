package com.liyuan.controller;

import com.liyuan.model.MallSystem;
import com.liyuan.service.MallSystemServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system")
public class MallSystemController {

    @Autowired
    private MallSystemServiceImpl systemService;

    @GetMapping("/listAll")
    public Object listALl() {
        List<MallSystem> mallSystems = systemService.querySelectiveAll();
        return ResponseUtils.build(HttpStatus.OK.value(), "获取所有商城的配置成功！", mallSystems);
    }

    @PostMapping("/batchUpdate")
    public Object batchUpdate(@RequestBody MallSystem[] systems) {
        for (MallSystem system : systems) {
            systemService.updateSelective(system);
        }
        return ResponseUtils.build(HttpStatus.OK.value(), "更新成功！");
    }

}
