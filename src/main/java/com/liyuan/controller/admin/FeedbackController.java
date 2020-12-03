package com.liyuan.controller.admin;

import com.github.pagehelper.PageInfo;
import com.liyuan.dto.FeedBackAndUser;
import com.liyuan.model.MallFeedback;
import com.liyuan.model.MallUser;
import com.liyuan.service.FeedbackServiceImpl;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackServiceImpl feedbackService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/listSearch")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object listSearch(@RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize,
                             @RequestParam(value = "keyWord", defaultValue = "", required = false) String keyWord) {
        PageInfo pageInfo = feedbackService.querySelective(keyWord,
                page,
                pageSize,
                MallFeedback.Column.id,
                MallFeedback.Column.title,
                MallFeedback.Column.userId,
                MallFeedback.Column.updateTime);
        List<MallFeedback> list = pageInfo.getList();
        List<FeedBackAndUser> feedBackAndUsers = new LinkedList<>();
        for (MallFeedback mallFeedback : list) {
            FeedBackAndUser feedBackAndUser = new FeedBackAndUser();
            feedBackAndUser.setFeedback(mallFeedback);
            feedBackAndUser.setUser(userService.queryById(mallFeedback.getUserId(), MallUser.Column.id, MallUser.Column.username));
            feedBackAndUsers.add(feedBackAndUser);
        }
        pageInfo.setList(feedBackAndUsers);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取所you用户成功！包括关键字", pageInfo);
    }

    @GetMapping("/queryFeedbackById/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String queryFeedbackById(@PathVariable("id") Integer id) {
        MallFeedback mallFeedback = feedbackService.queryById(id);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取该则意见反馈", mallFeedback);
    }
}
