package com.example.know.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.know.dao.UserDao;
import com.example.know.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * spring security的登陆认证实现
 * @author bookWorm
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName,username);
        User user = userDao.selectOne(wrapper);
        if(user == null){
            throw new RuntimeException("用户名或密码为错误");
        }
//        根据用户查询权限信息，添加到此返回信息中
        return new LoginUser(user);
    }
}
