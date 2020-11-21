package com.liyuan.service;

import com.liyuan.dao.MallPermissionMapper;
import com.liyuan.model.MallPermission;
import com.liyuan.model.MallPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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

    public int deleteById(Integer id) {
        return mallPermissionMapper.deleteByPrimaryKey(id);
    }


    public int insertAPermission(MallPermission permission) {
        permission.setUpdateTime(LocalDateTime.now());
        return mallPermissionMapper.insertSelective(permission);
    }
}
