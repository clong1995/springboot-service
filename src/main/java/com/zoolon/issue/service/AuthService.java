package com.zoolon.issue.service;

import com.zoolon.issue.domain.one.auth.UserDetail;
import com.zoolon.issue.result.ResponseUserToken;
import com.zoolon.issue.vo.param.auth.SignParam;

/**
 * @author: JoeTao
 * createAt: 2018/9/17
 */
public interface AuthService {
    /**
     * 注册用户
     */
    UserDetail register(SignParam signParam);

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    ResponseUserToken login(String username, String password);

    /**
     * 登出
     * @param token
     */
    void logout(String token);

    /**
     * 刷新Token
     * @param oldToken
     * @return
     */
    ResponseUserToken refresh(String oldToken);

    /**
     * 根据Token获取用户信息
     * @param token
     * @return
     */
    UserDetail getUserByToken(String token);
}
