package com.liyuan.service;

import com.liyuan.dao.MallRoleMapper;

import com.liyuan.model.MallRole;
import com.liyuan.model.MallRoleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl {
    @Resource
    private MallRoleMapper roleMapper;

    public MallRole queryById(Integer id) {
        MallRoleExample mallRoleExample = new MallRoleExample();
        mallRoleExample.createCriteria().andIdEqualTo(id);
        return roleMapper.selectByPrimaryKeySelective(id, MallRole.Column.id, MallRole.Column.name);
    }
}
