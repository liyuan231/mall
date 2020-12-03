package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallAdMapper;
import com.liyuan.model.MallAd;
import com.liyuan.model.MallAdExample;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdvertisementServiceImpl {
    @Resource
    private MallAdMapper adMapper;

    public PageInfo querySelective(String keyword, Integer page, Integer pageSize, MallAd.Column... columns) {
        MallAdExample mallAdExample = new MallAdExample();
        MallAdExample.Criteria criteria = mallAdExample.createCriteria();
        mallAdExample.setOrderByClause("id desc");
        criteria.andNameLike("%" + keyword + "%");
        PageHelper.startPage(page, pageSize);
        List<MallAd> mallAds = adMapper.selectByExampleSelective(mallAdExample, columns);
        return new PageInfo(mallAds);
    }

    public int insertSelective(MallAd mallAd) {
        return adMapper.insertSelective(mallAd);
    }

    public MallAd queryById(Integer id) {
        return adMapper.selectByPrimaryKeySelective(id);
    }

    public int updateSelective(MallAd ad) {
        Assert.notNull(ad.getId(), "广告id不应为空！");
        return adMapper.updateByPrimaryKeySelective(ad);
    }

    public int deleteById(Integer id) {
        return adMapper.deleteByPrimaryKey(id);
    }

    public List<MallAd> queryByIndexAndDate(Integer position, MallAd.Column... columns) {
        MallAdExample adExample = new MallAdExample();
        MallAdExample.Criteria criteria = adExample.createCriteria();
        criteria.andPositionEqualTo(position);
        criteria.andStartTimeLessThan(LocalDateTime.now());
        criteria.andEndTimeGreaterThan(LocalDateTime.now());
        return adMapper.selectByExampleSelective(adExample, columns);
    }
}
