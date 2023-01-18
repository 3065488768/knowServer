package com.example.know.security;

import com.example.know.dao.UserDao;
import com.example.know.entity.User;
import com.example.know.security.LoginUser;
import com.example.know.service.impl.UserServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;

/**
 * @author bookWorm
 */
public class JwtTokenUserDetailsService implements UserDetailsService {

    @Resource
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.selectOfUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return new LoginUser(user);
    }
}
