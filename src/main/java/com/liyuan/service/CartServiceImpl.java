package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallCartMapper;
import com.liyuan.model.MallCart;
import com.liyuan.model.MallCartExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartServiceImpl {
    @Resource
    private MallCartMapper cartMapper;

    public int insertSelective(MallCart cart) {
        cart.setUpdateTime(LocalDateTime.now());
        return cartMapper.insertSelective(cart);
    }


    public PageInfo querySelective(Integer userId, Integer page, Integer pageSize, MallCart.Column... columns) {
        MallCartExample cartExample = new MallCartExample();
        MallCartExample.Criteria criteria = cartExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        cartExample.setOrderByClause("update_time desc");
        PageHelper.startPage(page, pageSize);
        List<MallCart> mallCarts = cartMapper.selectByExampleSelective(cartExample, columns);
        return new PageInfo(mallCarts);
    }

    public int deleteById(Integer id) {
        return cartMapper.deleteByPrimaryKey(id);
    }

}
