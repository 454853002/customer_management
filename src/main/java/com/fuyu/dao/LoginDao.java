package com.fuyu.dao;

import com.fuyu.entity.Login;

public interface LoginDao {

    /**
     * 验证登录
     */
    Login login(Login login);


}
