package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallGoodsMapper;
import com.liyuan.model.MallGoods;
import com.liyuan.model.MallGoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl {
    @Resource
    private MallGoodsMapper goodsMapper;


    public PageInfo querySelective(String keyword, Integer page, Integer pageSize, MallGoods.Column... columns) {
        MallGoodsExample goodsExample = new MallGoodsExample();
        goodsExample.setOrderByClause("update_time desc");
        MallGoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andNameLike("%" + keyword + "%");
        PageHelper.startPage(page, pageSize);
        List<MallGoods> mallGoods = goodsMapper.selectByExampleSelective(goodsExample, columns);
        return new PageInfo(mallGoods);
    }

}
