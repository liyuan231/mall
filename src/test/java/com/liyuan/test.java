package com.liyuan;

import com.liyuan.model.MallUser;
import com.liyuan.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

//@SpringBootTest(classes = {Application.class})
//@RunWith(SpringRunner.class)
public class test {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test01() {
        for (int i = 0; i < 94; i++) {
            MallUser mallUser = new MallUser();
            mallUser.setUsername(i + "@qq.com");
            mallUser.setMobile(String.valueOf(System.currentTimeMillis()));
            mallUser.setRole(2);
            mallUser.setUpdateTime(LocalDateTime.now());
            userService.insertSelective(mallUser);
        }

    }
}
