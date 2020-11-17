package com.liyuan.service;

import com.liyuan.dao.MallPermissionMapper;
import com.school.model.MallPermission;
import com.school.model.MallPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl {
    @Resource
    private MallPermissionMapper mallPermissionMapper;

    public List<MallPermission> queryByRoleId(Integer role, MallPermission.Column... columns) {
        MallPermissionExample mallPermissionExample = new MallPermissionExample();
        MallPermissionExample.Criteria criteria = mallPermissionExample.createCriteria();
        criteria.andRoleIdEqualTo(role);
        return mallPermissionMapper.selectByExampleSelective(mallPermissionExample, columns);
    }
}
