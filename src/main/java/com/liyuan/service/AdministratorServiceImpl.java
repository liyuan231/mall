package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallAdminMapper;
import com.liyuan.model.MallAdmin;
import com.liyuan.model.MallAdminExample;
import com.liyuan.model.MallRole;
import com.liyuan.utils.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdministratorServiceImpl implements UserDetailsService {
    @Resource
    private MallAdminMapper adminMapper;
    @Autowired
    private RoleServiceImpl roleService;

    public PageInfo listSearch(String keyword, Integer page, Integer pageSize, MallAdmin.Column... columns) {
        MallAdminExample mallAdminExample = new MallAdminExample();
        MallAdminExample.Criteria criteria = mallAdminExample.createCriteria();
        criteria.andUsernameLike("%" + keyword + "%");
        PageHelper.startPage(page, pageSize);
        List<MallAdmin> mallAdmins = adminMapper.selectByExampleSelective(mallAdminExample, columns);
        return new PageInfo(mallAdmins);
    }

    public int insertSelective(MallAdmin admin) {
        admin.setCreateTime(LocalDateTime.now());
        return adminMapper.insertSelective(admin);
    }

    public MallAdmin queryById(Integer id, MallAdmin.Column... columns) {
        return adminMapper.selectByPrimaryKeySelective(id, columns);
    }

    public int updateSelective(MallAdmin admin) {
        Assert.notNull(admin.getId(), "管理员id不应为空！");
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    public int deleteById(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MallAdmin admin = queryByUsername(username);
        AssertUtils.adminUserNotNull(admin);
        MallRole role = roleService.queryById(admin.getRole());
        return new User(username, admin.getPassword(), AuthorityUtils.createAuthorityList(role.getName()));
    }

    public MallAdmin queryByUsername(String username, MallAdmin.Column... columns) {
        MallAdminExample adminExample = new MallAdminExample();
        MallAdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return adminMapper.selectOneByExampleSelective(adminExample, columns);
    }

    public int updateSelectiveByUsername(MallAdmin admin) {
        MallAdminExample adminExample = new MallAdminExample();
        MallAdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(admin.getUsername());
        return adminMapper.updateByExampleSelective(admin,adminExample);
    }
}
