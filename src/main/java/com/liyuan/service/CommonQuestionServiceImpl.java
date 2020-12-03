package com.liyuan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyuan.dao.MallIssueMapper;
import com.liyuan.model.MallIssue;
import com.liyuan.model.MallIssueExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommonQuestionServiceImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MallIssueMapper issueMapper;

    public PageInfo querySelective(String keyword, Integer page, Integer pageSize, MallIssue.Column... columns) {
        MallIssueExample mallIssueExample = new MallIssueExample();
        mallIssueExample.setOrderByClause("id desc");
        MallIssueExample.Criteria criteria = mallIssueExample.createCriteria();
        criteria.andQuestionLike("%" + keyword + "%");
        PageHelper.startPage(page, pageSize);
        List<MallIssue> mallIssues = issueMapper.selectByExampleSelective(mallIssueExample, columns);
        return new PageInfo(mallIssues);
    }

    public MallIssue queryById(Integer id, MallIssue.Column... columns) {
        return issueMapper.selectByPrimaryKeySelective(id, columns);
    }

    public int insertSelective(MallIssue mallIssue) {
        mallIssue.setUpdateTime(LocalDateTime.now());
        return issueMapper.insertSelective(mallIssue);
    }

    public int updateSelectiveByPrimary(MallIssue issue) {
        issue.setUpdateTime(LocalDateTime.now());
        return issueMapper.updateByPrimaryKeySelective(issue);
    }
}
