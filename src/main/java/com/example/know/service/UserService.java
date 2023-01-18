package com.example.know.service;

import com.example.know.entity.User;
import com.example.know.util.AjaxResult;

/**
 * 用户业务接口层
 * @author bookWorm
 */
public interface UserService {

    /**
     * 校验用户名是否存在
     * @param userName 用户名
     * @return true-合格，可使用 false-违规,已存在
     * */
    public boolean checkUserNameUnique(String userName);

    /**
     * 校验昵称是否存在
     * @param nickName 昵称
     * @return true-合格，可使用 false-违规,已存在
     * */
    public boolean checkNickNameUnique(String nickName);

    /**
     * 校验邮箱是否存在
     * @param email 邮箱
     * @return true-合格，可使用 false-违规,已存在
     * */
    public boolean checkEmailUnique(String email);

    /**
     * 根据用户名返回邮箱用于重置密码时进行验证
     * @param userName 根据用户名查看邮箱
     * @return 返回一个自定义的ajax信息
     * */
    public AjaxResult emailOfUserName(String userName);

    /**
     * 校验邮箱是否存在
     * @param userName 用户名
     * @return true-成功，可使用 false-失败
     * */
    public AjaxResult forgetPassword(String userName);

    /**
     * 注册
     * @param user 用户信息
     * @return
     * */
    public AjaxResult register(User user);

    /**
     * 修改资料
     * @param user 用户资料
     * @return 自定义ajax信息
     * */
    public AjaxResult ModifyData(User user);

    /**
     * 返回当前用户的帖子list
     * @param user 用户信息
     * @return 返回匹配用户信息的帖子，用于管理自己的帖子信息
     * */
    public AjaxResult postOfUser(User user);

    /**
     * 返回当前用户的评论信息
     * @param user 用户信息
     * @return
     * */
    public AjaxResult commentOfUser(User user);

    /**
     * 返回用户的访问记录
     * @param user 用户信息
     * @return
     * */
    public AjaxResult accessOfUser(User user);

    /**
     * 获得综合得分点用户排行
     * @return
     * */
    public AjaxResult userOfRanking();

    /**
     * 返回站内用户数量
     * @return
     * */
    public Long getCountNumber();
}
