package com.example.know.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.know.dao.DigestDao;
import com.example.know.service.DigestService;
import com.example.know.util.AjaxResult;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DigestServiceImpl implements DigestService {

    @Resource
    DigestDao digestDao;
    @Override
    public AjaxResult getDigestOfRecommend() {
        PageHelper.startPage( 0,10);
        return AjaxResult.success(digestDao.getDigestAndBook());
    }

    @Override
    public Long getCountNumber() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status",'0');
        return digestDao.selectCount(queryWrapper);
    }
}
