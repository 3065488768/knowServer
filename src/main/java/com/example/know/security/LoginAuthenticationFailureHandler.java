package com.example.know.security;

import com.example.know.util.AjaxResult;
import com.example.know.util.ResponseUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bookWorm
 */
public class LoginAuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        if(exception instanceof BadCredentialsException){
            ResponseUtils.renderJson(response, AjaxResult.error("密码错误"));
        }
        ResponseUtils.renderJson(response,AjaxResult.error("登录失败"));
    }
}
