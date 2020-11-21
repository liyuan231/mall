package com.liyuan.utils;


import com.liyuan.model.MallAdmin;
import com.liyuan.model.MallUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AssertUtils {
    public static void mallUserNotNull(MallUser user) {
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
    }

    public static void adminUserNotNull(MallAdmin admin) {
        if (admin == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
    }
}
