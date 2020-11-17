package com.liyuan.service;

import com.liyuan.dao.MallUserMapper;
import com.liyuan.utils.AssertUtils;
import com.school.model.MallPermission;
import com.school.model.MallUser;
import com.school.model.MallUserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MallUserMapper userMapper;
    @Autowired
    private PermissionServiceImpl permissionService;
    @Autowired
    private RoleServiceImpl roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MallUser mallUser = this.queryByUsername(username, MallUser.Column.id, MallUser.Column.username, MallUser.Column.role);
        AssertUtils.mallUserNotNull(mallUser);
        List<MallPermission> mallPermissions = permissionService.queryByRoleId(mallUser.getRole(), MallPermission.Column.permission);
        Collection<GrantedAuthority> authorities = new LinkedList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + roleService.queryById(mallUser.getRole()).getName()));
        for (MallPermission mallPermission : mallPermissions) {
            authorities.add(new SimpleGrantedAuthority(mallPermission.getPermission()));
        }
        return new User(username, "[PASSWORD]", authorities);
    }


    public MallUser queryByUsername(String username, MallUser.Column... columns) {
        MallUserExample mallUserExample = new MallUserExample();
        MallUserExample.Criteria criteria = mallUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userMapper.selectOneByExampleSelective(mallUserExample, columns);
    }

    public MallUser queryById(int id, MallUser.Column... columns) {
        return userMapper.selectByPrimaryKeySelective(id, columns);
    }
}
