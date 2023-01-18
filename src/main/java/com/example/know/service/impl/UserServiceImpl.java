package com.example.know.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.know.dao.AccessDao;
import com.example.know.dao.CommentDao;
import com.example.know.dao.PostDao;
import com.example.know.dao.UserDao;
import com.example.know.entity.Post;
import com.example.know.entity.User;
import com.example.know.service.UserService;
import com.example.know.util.AjaxResult;
import com.example.know.util.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户业务层实现类
 * @author bookWorm
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private PostDao postDao;

    @Resource
    private AccessDao accessDao;

    @Resource
    private CommentDao commentDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisTemplate redisTemplate;


    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public boolean checkUserNameUnique(String userName) {
        if(StringUtils.isBlank(userName)){
            return false;
        }
        return userDao.checkOfUserNameUnique(userName) == null;
    }

    @Override
    public boolean checkNickNameUnique(String nickName) {
        return userDao.checkOfNickNameUnique(nickName) == null;
    }

    @Override
    public boolean checkEmailUnique(String email) {
        return userDao.checkOfEmailUnique(email) == null;
    }

    @Override
    public AjaxResult emailOfUserName(String userName) {
        if(!this.checkUserNameUnique(userName)){
            return AjaxResult.success(userDao.selectOfUserName(userName).getEmail());
        }else{
            return new AjaxResult(AjaxResult.Type.USER_ACCOUNT_NOT_EXIST,"查无用户");
        }
    }

    @Override
    public AjaxResult forgetPassword(String userName) {
        User user = userDao.selectOfUserName(userName);
        user.setPassword(Md5Utils.hash(user.getSalt()+"@123456"));
        userDao.updateUser(user);
        return AjaxResult.success("重置成功");
    }

    @Override
    public AjaxResult register(User user) {
        user.setSalt(Md5Utils.hash(user.getCreateIp()+System.currentTimeMillis()));
        user.setPassword(Md5Utils.hash(user.getSalt()+user.getPassword()));
        user.setNickName(user.getUserName());
        try{
            userDao.insertUser(user);
            return AjaxResult.success("注册成功");
        }catch (Exception e){
            logger.error("注册失败"+e);
            return AjaxResult.error("注册失败");
        }
    }

    @Override
    public AjaxResult ModifyData(User user) {
        userDao.updateUser(user);
        return AjaxResult.success("修改成功");
    }

    @Override
    public AjaxResult postOfUser(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("create_by",user.getUserId());
        List<Post> list = postDao.selectList(queryWrapper);
        return AjaxResult.success(list);
    }

    @Override
    public AjaxResult commentOfUser(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("comment_by",user.getUserId());
        List<Post> list = commentDao.selectList(queryWrapper);
        return AjaxResult.success(list);
    }

    @Override
    public AjaxResult accessOfUser(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("access_by",user.getUserId());
        List<Post> list = accessDao.selectList(queryWrapper);
        return AjaxResult.success(list);
    }

    @Override
    public AjaxResult userOfRanking() {
        return AjaxResult.success(userDao.userOfRanking());
    }

    @Override
    public Long getCountNumber() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status",'0');
        return userDao.selectCount(queryWrapper);
    }
}
