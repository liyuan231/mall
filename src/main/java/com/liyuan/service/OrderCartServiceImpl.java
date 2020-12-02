package com.liyuan.service;

import com.liyuan.dao.MallOrderCartMapper;
import com.liyuan.model.MallOrderCart;
import com.liyuan.model.MallOrderCartExample;
import com.liyuan.utils.Status;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderCartServiceImpl {

    @Resource
    private MallOrderCartMapper orderCartMapper;


    public List<MallOrderCart> queryOneByOrderId(Integer orderId, MallOrderCart.Column... columns) {
        MallOrderCartExample orderCartExample = new MallOrderCartExample();
        MallOrderCartExample.Criteria criteria = orderCartExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return orderCartMapper.selectByExampleSelective(orderCartExample, columns);
    }

    public int insertSelective(MallOrderCart mallOrderCart) {
        return orderCartMapper.insertSelective(mallOrderCart);
    }

    public MallOrderCart queryOneByCartId(Integer cartId, MallOrderCart.Column... columns) {
        MallOrderCartExample orderCartExample = new MallOrderCartExample();
        MallOrderCartExample.Criteria criteria = orderCartExample.createCriteria();
        criteria.andCartIdEqualTo(cartId);
//        criteria.andStatusEqualTo(status);
        return orderCartMapper.selectOneByExampleSelective(orderCartExample, columns);
    }

    public int finishAnOrder(Integer orderCartId) {
        MallOrderCart orderCart = new MallOrderCart();
        orderCart.setId(orderCartId);
        orderCart.setStatus(Status.ORDER_FINISHED);
        return orderCartMapper.updateByPrimaryKeySelective(orderCart);
    }
}
