package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallSearchHistoryMapper;
import com.liyuan.model.MallSearchHistory;
import com.liyuan.model.MallSearchHistoryExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SearchHistoryServiceImpl {

    @Resource
    private MallSearchHistoryMapper searchHistoryMapper;

    public PageInfo querySelective(String keyWord, Integer page, Integer pageSize, MallSearchHistory.Column... columns) {
        MallSearchHistoryExample mallSearchHistoryExample = new MallSearchHistoryExample();
        MallSearchHistoryExample.Criteria criteria = mallSearchHistoryExample.createCriteria();
        criteria.andKeywordLike("%" + keyWord + "%");
        PageHelper.startPage(page, pageSize);
        List<MallSearchHistory> mallUsers = searchHistoryMapper.selectByExampleSelective(mallSearchHistoryExample, columns);
        return new PageInfo(mallUsers);
    }

    public int insertSelective(MallSearchHistory searchHistory) {
        searchHistory.setUpdateTime(LocalDateTime.now());
        return searchHistoryMapper.insertSelective(searchHistory);
    }
}
