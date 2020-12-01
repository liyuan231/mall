package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallOrderMapper;
import com.liyuan.model.MallOrder;
import com.liyuan.model.MallOrderExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MallOrderMapper orderMapper;


    public int insertSelective(MallOrder order) {
        order.setUpdateTime(LocalDateTime.now());
        return orderMapper.insertSelective(order);
    }

    public PageInfo querySelective(String keyword, Integer page, Integer pageSize, MallOrder.Column... columns) {
        MallOrderExample mallOrderExample = new MallOrderExample();
        MallOrderExample.Criteria criteria = mallOrderExample.createCriteria();
        PageHelper.startPage(page, pageSize);
        List<MallOrder> mallOrders = orderMapper.selectByExampleSelective(mallOrderExample, columns);
        return new PageInfo<>(mallOrders);
    }

    public List<MallOrder> queryByUserId(Integer userId, MallOrder.Column... columns) {
        MallOrderExample example = new MallOrderExample();
        MallOrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return orderMapper.selectByExampleSelective(example, columns);
    }
}
