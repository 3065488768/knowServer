package com.example.know.service;

import com.example.know.util.AjaxResult;

/**
 * @author bookWorm
 */
public interface PlateService {
    /**
     * 获得综合评分排行的版块
     * @return
     * */
    public AjaxResult getPlateByRanking();

    /**
     * 获取默认的板块信息
     * @return
     * */
    public AjaxResult getPlateInformation();
}
