package com.liyuan.utils;

import com.school.model.MallUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AssertUtils {
    public static void mallUserNotNull(MallUser user) {
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在！");
        }
    }
}
