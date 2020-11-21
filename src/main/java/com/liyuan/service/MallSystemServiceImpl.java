package com.liyuan.service;

import com.liyuan.dao.MallSystemMapper;
import com.liyuan.model.MallSystem;
import com.liyuan.model.MallSystemExample;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class MallSystemServiceImpl {

    @Resource
    private MallSystemMapper systemMapper;

    public List<MallSystem> querySelectiveAll(MallSystem.Column... columns) {
        MallSystemExample systemExample = new MallSystemExample();
        return systemMapper.selectByExampleSelective(systemExample, columns);
    }

    public int updateSelective(MallSystem system) {
        Assert.notNull(system.getId(), "商城这一则配置的id 不应该为空！");
        return systemMapper.updateByPrimaryKeySelective(system);
    }
}
