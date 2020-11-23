package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallStorageMapper;
import com.liyuan.model.MallStorage;
import com.liyuan.model.MallStorageExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StorageServiceImpl {

    @Resource
    private MallStorageMapper storageMapper;

    public PageInfo querySelective(Integer page, Integer pageSize, MallStorage.Column... columns) {
        MallStorageExample mallStorageExample = new MallStorageExample();
        PageHelper.startPage(page, pageSize);
        List<MallStorage> mallStorages = storageMapper.selectByExampleSelective(mallStorageExample, columns);
        return new PageInfo(mallStorages);
    }

    public int insertSelective(MallStorage mallStorage) {
        mallStorage.setUpdateTime(LocalDateTime.now());
        return storageMapper.insertSelective(mallStorage);
    }

    public MallStorage queryOneByUserIdAndType(Integer userId, int type, MallStorage.Column... columns) {
        MallStorageExample storageExample = new MallStorageExample();
        MallStorageExample.Criteria criteria = storageExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andTypeEqualTo(type);
        return storageMapper.selectOneByExampleSelective(storageExample, columns);
    }
}
