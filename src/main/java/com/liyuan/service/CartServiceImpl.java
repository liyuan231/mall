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
        criteria.andFinishedEqualTo(false);
        cartExample.setOrderByClause("update_time desc");
        PageHelper.startPage(page, pageSize);
        List<MallCart> mallCarts = cartMapper.selectByExampleSelective(cartExample, columns);
        return new PageInfo(mallCarts);
    }

    public int deleteById(Integer id) {
        return cartMapper.deleteByPrimaryKey(id);
    }

    public int check(Integer id) {
        MallCart mallCart = queryById(id);
        mallCart.setId(id);
        mallCart.setChecked(!mallCart.getChecked());
        return cartMapper.updateByPrimaryKeySelective(mallCart);
    }

    public MallCart queryById(Integer id, MallCart.Column... columns) {
        return cartMapper.selectByPrimaryKeySelective(id, columns);
    }

    public int plusNumber(Integer id) {
        MallCart mallCart = queryById(id, MallCart.Column.id, MallCart.Column.number);
        mallCart.setNumber(mallCart.getNumber() + 1);
        return cartMapper.updateByPrimaryKeySelective(mallCart);
    }

    public int minusNumber(Integer id) {
        MallCart mallCart = queryById(id, MallCart.Column.id, MallCart.Column.number);
        mallCart.setNumber(mallCart.getNumber() > 0 ? mallCart.getNumber() - 1 : mallCart.getNumber());
        return cartMapper.updateByPrimaryKeySelective(mallCart);
    }

    public int setFinishedById(Integer id) {
        MallCart cart = new MallCart();
        cart.setId(id);
        cart.setUpdateTime(LocalDateTime.now());
        cart.setFinished(true);
        return cartMapper.updateByPrimaryKeySelective(cart);
    }

    public List<MallCart> queryByBrandId(Integer brandId, MallCart.Column... columns) {
        MallCartExample cartExample = new MallCartExample();
        MallCartExample.Criteria criteria = cartExample.createCriteria();
        criteria.andBrandIdEqualTo(brandId);
        return cartMapper.selectByExampleSelective(cartExample, columns);
    }
}
