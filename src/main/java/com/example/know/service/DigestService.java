package com.example.know.service;

import com.example.know.util.AjaxResult;

/**
 * 书摘
 * @author bookWorm
 */
public interface DigestService {

    /**
     * 获取推荐的书摘
     * @return
     * */
    public AjaxResult getDigestOfRecommend();

    /**
     * 返回表内数据量
     *
     * @return
     */
    public Long getCountNumber();
}
