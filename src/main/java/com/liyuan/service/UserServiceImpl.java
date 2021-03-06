package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallUserMapper;
import com.liyuan.model.MallRole;
import com.liyuan.model.MallUser;
import com.liyuan.model.MallUserExample;
import com.liyuan.utils.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 此UserServicesDetails用于客户端登录
 */
@Service
public class UserServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private MallUserMapper userMapper;
    @Autowired
    private PermissionServiceImpl permissionService;
    @Autowired
    private RoleServiceImpl roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MallUser mallUser = this.queryByUsername(username, MallUser.Column.id, MallUser.Column.username, MallUser.Column.password, MallUser.Column.role);
        AssertUtils.mallUserNotNull(mallUser);
        MallRole role = roleService.queryById(mallUser.getRole());
        return new User(username, mallUser.getPassword(), AuthorityUtils.createAuthorityList(role.getName()));
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

    public int insertSelective(MallUser user) {
        MallUser mallUser = queryByUsername(user.getUsername());
        Assert.isNull(mallUser, "用户名已存在！");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.insertSelective(user);
    }

    public int updateSelectiveById(MallUser mallUser) {
        return userMapper.updateByPrimaryKeySelective(mallUser);
    }

    public PageInfo querySelective(String keyWord, Integer page, Integer pageSize, MallUser.Column... columns) {
        MallUserExample mallUserExample = new MallUserExample();
        mallUserExample.setOrderByClause("id desc");
        MallUserExample.Criteria criteria = mallUserExample.createCriteria();
        criteria.andUsernameLike("%" + keyWord + "%");
        PageHelper.startPage(page, pageSize);
        List<MallUser> mallUsers = userMapper.selectByExampleSelective(mallUserExample, columns);
        return new PageInfo(mallUsers);
    }

    public PageInfo querySelective(Integer page, Integer pageSize, MallUser.Column... columns) {
        return querySelective("", page, pageSize, columns);
    }


    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public int updateSelectiveByUsername(MallUser mallUser) {
        MallUserExample userExample = new MallUserExample();
        MallUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(mallUser.getUsername());
        return userMapper.updateByExampleSelective(mallUser, userExample);
    }

    public MallUser retrieveSecurityContextPrinciple(MallUser.Column... columns) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return queryByUsername(principal.getUsername(), columns);
    }
}
