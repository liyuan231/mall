package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallAddressMapper;
import com.liyuan.model.MallAddress;
import com.liyuan.model.MallAddressExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressServiceImpl {

    @Resource
    private MallAddressMapper addressMapper;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public int insertSelective(MallAddress address) {
        address.setUpdateTime(LocalDateTime.now());
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
        return addressMapper.deleteByPrimaryKey(id);
    }

    public MallAddress queryById(Integer id, MallAddress.Column... columns) {
        return addressMapper.selectByPrimaryKeySelective(id, columns);
    }

    public int updateSelectiveById(MallAddress address) {
        Assert.notNull(address.getId(), "地址id不存在！");
        address.setUpdateTime(LocalDateTime.now());
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    public List<MallAddress> queryByUserId(int i, MallAddress.Column... columns) {
        MallAddressExample mallAddressExample = new MallAddressExample();
        MallAddressExample.Criteria criteria = mallAddressExample.createCriteria();
        criteria.andUserIdEqualTo(i);
        return addressMapper.selectByExampleSelective(mallAddressExample, columns);
    }

    public void batchUpdateSelectiveById(MallAddress[] addresses) {
        for (MallAddress address : addresses) {
            try {
                updateSelectiveById(address);
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage());
            }
        }

    }
}
