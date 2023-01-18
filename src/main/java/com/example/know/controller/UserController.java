package com.example.know.controller;

import com.example.know.service.impl.UserServiceImpl;
import com.example.know.util.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户的一些操作
 * @author bookWorm
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private SendMailUtil sendMailUtil;
}
