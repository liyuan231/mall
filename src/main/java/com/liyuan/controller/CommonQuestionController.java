package com.liyuan.controller;

import com.github.pagehelper.PageInfo;
import com.liyuan.model.MallIssue;
import com.liyuan.service.CommonQuestionServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commonQuestion")
public class CommonQuestionController {

    @Autowired
    private CommonQuestionServiceImpl commonQuestionService;

    @GetMapping("/listSearch")
    public Object listSearch(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                             @RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize) {
        PageInfo pageInfo = commonQuestionService.querySelective(keyword, page, pageSize);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取通用问题列表成功！包括关键字", pageInfo);
    }

    @GetMapping("/queryById/{id}")
    public Object queryById(@PathVariable("id") Integer id) {
        MallIssue mallIssue = commonQuestionService.queryById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取某一则通用问题成功！", mallIssue);
    }

    @PostMapping("/updateById")
    public Object updateById(@RequestBody MallIssue issue) {
        int i = commonQuestionService.updateSelectiveByPrimary(issue);
        return ResponseUtils.build(HttpStatus.OK.value(), "修改某一则通用问题成功！");
    }
}
