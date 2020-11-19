package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallAddressMapper;
import com.liyuan.model.MallAddress;
import com.liyuan.model.MallAddressExample;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl {

    @Resource
    private MallAddressMapper addressMapper;

    public int insertSelective(MallAddress address) {
        return addressMapper.insertSelective(address);
    }

    public PageInfo querySelective(String keyWord, Integer page, Integer pageSize, MallAddress.Column... columns) {
        MallAddressExample addressExample = new MallAddressExample();
        MallAddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andAddressDetailLike("%" + keyWord + "%");
        PageHelper.startPage(page, pageSize);
        List<MallAddress> mallAddresses = addressMapper.selectByExampleSelective(addressExample, columns);
        return new PageInfo<>(mallAddresses);
    }

    public int deleteById(Integer id) {
        int i = addressMapper.deleteByPrimaryKey(id);
        return i;
    }

    public MallAddress queryById(Integer id, MallAddress.Column... columns) {
        return addressMapper.selectByPrimaryKeySelective(id, columns);
    }

    public int updateSelectiveById(MallAddress address) {
        Assert.notNull(address.getId(), "地址id不存在！");
        return addressMapper.updateByPrimaryKeySelective(address);
    }
}
