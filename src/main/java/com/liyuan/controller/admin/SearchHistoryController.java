package com.liyuan.controller.admin;

import com.github.pagehelper.PageInfo;
import com.liyuan.dto.SearchHistoryAndUser;
import com.liyuan.model.MallSearchHistory;
import com.liyuan.model.MallUser;
import com.liyuan.service.SearchHistoryServiceImpl;
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
@RequestMapping("/searchHistory")
public class SearchHistoryController {

    @Autowired
    private SearchHistoryServiceImpl searchHistoryService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/listSearch")
    public Object listSearch(@RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize,
                             @RequestParam(value = "keyWord", defaultValue = "", required = false) String keyWord) {
        PageInfo pageInfo = searchHistoryService.querySelective(keyWord, page, pageSize, MallSearchHistory.Column.id, MallSearchHistory.Column.userId, MallSearchHistory.Column.keyword);
        List<MallSearchHistory> list = pageInfo.getList();
        List<SearchHistoryAndUser> addressAndUsers = new LinkedList<>();
        for (MallSearchHistory searchHistory : list) {
            MallUser mallUser = userService.queryById(searchHistory.getUserId(), MallUser.Column.id, MallUser.Column.username);
            SearchHistoryAndUser searchHistoryAndUser = new SearchHistoryAndUser();
            searchHistoryAndUser.setSearchHistory(searchHistory);
            searchHistoryAndUser.setUser(mallUser);
            addressAndUsers.add(searchHistoryAndUser);
        }
        pageInfo.setList(addressAndUsers);
        return ResponseUtils.build(HttpStatus.OK.value(), "获取所哟用户成功！包括关键字", pageInfo);
    }
}
