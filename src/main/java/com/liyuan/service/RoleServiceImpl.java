package com.liyuan.service;

import com.liyuan.dao.MallRoleMapper;
import com.liyuan.model.MallRole;
import com.liyuan.model.MallRoleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleServiceImpl {
    @Resource
    private MallRoleMapper roleMapper;

    public MallRole queryById(Integer id, MallRole.Column... columns) {
        MallRoleExample mallRoleExample = new MallRoleExample();
        mallRoleExample.createCriteria().andIdEqualTo(id);
        return roleMapper.selectByPrimaryKeySelective(id, columns);
    }

    public List<MallRole> querySelectiveAll(MallRole.Column... columns) {
        MallRoleExample roleExample = new MallRoleExample();
        return roleMapper.selectByExampleSelective(roleExample, columns);
    }

    public int deleteById(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);

    }

    public int insertSelective(MallRole role) {
        role.setUpdateTime(LocalDateTime.now());
        return roleMapper.insertSelective(role);
    }

    public MallRole queryByName(String roleName, MallRole.Column... columns) {
        MallRoleExample roleExample = new MallRoleExample();
        MallRoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andNameEqualTo(roleName);
        return roleMapper.selectOneByExampleSelective(roleExample, columns);
    }
}
