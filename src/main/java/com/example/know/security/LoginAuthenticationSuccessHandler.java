package com.example.know.security;

import cn.hutool.jwt.JWTUtil;
import com.example.know.entity.User;
import com.example.know.util.AjaxResult;
import com.example.know.util.EncryptUtil;
import com.example.know.util.Md5Utils;
import com.example.know.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bookWorm
 */
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private EncryptUtil encryptUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain chain,
                                        Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = encryptUtil.AESencode(user.getUserName(),"DES");
        //在上面token过期后解密或者上面token
        String refreshToken = encryptUtil.AESdecode(accessToken,"DES");
        Map map = new HashMap();
        map.put("accessToken",accessToken);map.put("refreshToken",refreshToken);
        renderToken(response,map);
    }
    public void renderToken(HttpServletResponse response, Map token){
        ResponseUtils.renderJson(response,AjaxResult.success(token));
    }
}
