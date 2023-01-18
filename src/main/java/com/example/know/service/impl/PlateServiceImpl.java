package com.example.know.service.impl;

import com.example.know.dao.PlateDao;
import com.example.know.service.PlateService;
import com.example.know.util.AjaxResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 版块
 * @author bookWorm
 */
@Service
public class PlateServiceImpl implements PlateService {
    @Resource
    private PlateDao plateDao;

    @Override
    public AjaxResult getPlateByRanking() {
        return AjaxResult.success(plateDao.getPlateByRanking());
    }

    @Override
    public AjaxResult getPlateInformation() {
        return AjaxResult.success(plateDao.getPlateInformation());
    }
}
