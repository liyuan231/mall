package com.liyuan.controller.client;

import com.liyuan.model.MallCategory;
import com.liyuan.service.CategoryServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/client/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;


    @GetMapping("/listAll")
    public Object listAll() {
        List<MallCategory> categories = categoryService.listAll(MallCategory.Column.id, MallCategory.Column.name, MallCategory.Column.pid);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取所有分类成功！", categories);
    }
}
