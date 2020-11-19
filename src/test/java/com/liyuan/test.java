package com.liyuan;

import com.github.pagehelper.PageInfo;
import com.liyuan.model.MallAddress;
import com.liyuan.model.MallFeedback;
import com.liyuan.model.MallSearchHistory;
import com.liyuan.model.MallUser;
import com.liyuan.service.AddressServiceImpl;
import com.liyuan.service.FeedbackServiceImpl;
import com.liyuan.service.SearchHistoryServiceImpl;
import com.liyuan.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringRunner.class)
public class test {
    @Autowired
    private UserServiceImpl userService;

    //    @Test
    public void insertUser() {
        for (int i = 0; i < 94; i++) {
            MallUser mallUser = new MallUser();
            mallUser.setUsername(i + "@qq.com");
            mallUser.setMobile(String.valueOf(System.currentTimeMillis()));
            mallUser.setRole(2);
            mallUser.setUpdateTime(LocalDateTime.now());
            userService.insertSelective(mallUser);
        }

    }

    @Autowired
    private AddressServiceImpl addressService;

    //    @Test
    public void insertAddress() {
        PageInfo pageInfo = userService.querySelective(1, 100, MallUser.Column.id);
        List<MallUser> users = pageInfo.getList();
        List<Integer> userIds = new LinkedList<>();
        for (MallUser user : users) {
            userIds.add(user.getId());
        }
        for (int i = 0; i < 100; i++) {
            MallAddress mallAddress = new MallAddress();
            int n = (int) (Math.random() * userIds.size());
            mallAddress.setUserId(userIds.get(n));
            mallAddress.setMobile("mobile" + i);
            mallAddress.setName("收货人" + i + userIds.get(n));
            mallAddress.setAddressDetail("详细地址" + i);
            mallAddress.setUpdateTime(LocalDateTime.now());
            addressService.insertSelective(mallAddress);
        }
    }

    @Autowired
    private SearchHistoryServiceImpl searchHistoryService;

    //    @Test
    public void insertSearchHistory() {
        PageInfo pageInfo = userService.querySelective(1, 100, MallUser.Column.id);
        List<MallUser> users = pageInfo.getList();
        List<Integer> userIds = new LinkedList<>();
        for (MallUser user : users) {
            userIds.add(user.getId());
        }
        for (int i = 0; i < 100; i++) {
            MallSearchHistory searchHistory = new MallSearchHistory();
            int n = (int) (Math.random() * userIds.size());
            searchHistory.setUserId(userIds.get(n));
            searchHistory.setKeyword("keyword" + i);
            searchHistory.setUpdateTime(LocalDateTime.now());
            searchHistoryService.insertSelective(searchHistory);
        }
    }


    @Autowired
    private FeedbackServiceImpl feedbackService;

//    @Test
    public void insertFeedback() {
        PageInfo pageInfo = userService.querySelective(1, 100, MallUser.Column.id);
        List<MallUser> users = pageInfo.getList();
        List<Integer> userIds = new LinkedList<>();
        for (MallUser user : users) {
            userIds.add(user.getId());
        }
        for (int i = 0; i < 100; i++) {
            MallFeedback mallFeedback = new MallFeedback();
            int n = (int) (Math.random() * userIds.size());
            mallFeedback.setUserId(userIds.get(n));
            mallFeedback.setTitle("title" + i);
            mallFeedback.setContent("content" + i);
            mallFeedback.setUpdateTime(LocalDateTime.now());
            feedbackService.insertSelective(mallFeedback);
        }
    }
}
