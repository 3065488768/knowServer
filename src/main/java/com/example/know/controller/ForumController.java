package com.example.know.controller;

import com.example.know.service.PlateService;
import com.example.know.service.impl.PlateServiceImpl;
import com.example.know.service.impl.PostServiceImpl;
import com.example.know.service.impl.UserServiceImpl;
import com.example.know.util.AjaxResult;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 对于论坛的简易信息返回
 * @author bookWorm
 */
@RestController
@RequestMapping("/forum")
public class ForumController {
    @Resource
    private PostServiceImpl postService;

    @Resource
    private PlateServiceImpl plateService;

    @Resource
    private UserServiceImpl userService;

    @GetMapping("/getExhibitionPost")
    public AjaxResult getExhibitionPost(String parameter,int type,int[] plateId,char postType,int begin,int number,int rankType){
        return postService.getExhibitionPost(parameter,type,plateId,postType,begin,number,rankType,null,null);
    }
    @GetMapping("/getSimplePostAndAuthor")
    public AjaxResult getFuzzySearchPost(int flag){
        return postService.getSimplePostAndAuthor(flag);
    }

    @GetMapping("/getPlateByRanking")
    public AjaxResult getPlateByRanking(){
        return plateService.getPlateByRanking();
    }
    @GetMapping("/getUserOfRanking")
    public AjaxResult getUserOfRanking(){
        return userService.userOfRanking();
    }
}
