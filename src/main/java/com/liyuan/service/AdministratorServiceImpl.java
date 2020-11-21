package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallAdminMapper;
import com.liyuan.model.MallAdmin;
import com.liyuan.model.MallAdminExample;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdministratorServiceImpl {

    @Resource
    private MallAdminMapper adminMapper;

    public PageInfo listSearch(String keyword, Integer page, Integer pageSize, MallAdmin.Column... columns) {

        MallAdminExample mallAdminExample = new MallAdminExample();
        MallAdminExample.Criteria criteria = mallAdminExample.createCriteria();
        criteria.andUsernameLike("%" + keyword + "%");
        PageHelper.startPage(page, pageSize);
        List<MallAdmin> mallAdmins = adminMapper.selectByExampleSelective(mallAdminExample, columns);
        return new PageInfo(mallAdmins);
    }

    public int insertSelective(MallAdmin admin) {
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
}
