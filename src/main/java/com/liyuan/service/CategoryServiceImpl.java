package com.liyuan.service;

import com.liyuan.dao.MallCategoryMapper;
import com.liyuan.model.MallCategory;
import com.liyuan.model.MallCategoryExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl {

    @Resource
    private MallCategoryMapper categoryMapper;


    public List<MallCategory> listAll(MallCategory.Column... columns) {
        MallCategoryExample categoryExample = new MallCategoryExample();
        return categoryMapper.selectByExampleSelective(categoryExample, columns);
    }
}
