package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallFeedbackMapper;
import com.liyuan.model.MallFeedback;
import com.liyuan.model.MallFeedbackExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackServiceImpl {
    @Resource
    private MallFeedbackMapper feedbackMapper;


    public PageInfo querySelective(String keyWord, Integer page, Integer pageSize, MallFeedback.Column... columns) {
        MallFeedbackExample mallFeedbackExample = new MallFeedbackExample();
        MallFeedbackExample.Criteria criteria = mallFeedbackExample.createCriteria();
        criteria.andTitleLike("%" + keyWord + "%");
        PageHelper.startPage(page, pageSize);
        List<MallFeedback> mallFeedbacks = feedbackMapper.selectByExampleSelective(mallFeedbackExample, columns);
        return new PageInfo(mallFeedbacks);
    }

    public int insertSelective(MallFeedback mallFeedback) {
        mallFeedback.setUpdateTime(LocalDateTime.now());
        return feedbackMapper.insertSelective(mallFeedback);
    }

    public MallFeedback queryById(Integer id) {
        return feedbackMapper.selectByPrimaryKey(id);
    }
}
