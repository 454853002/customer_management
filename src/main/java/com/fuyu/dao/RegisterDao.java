package com.fuyu.dao;

import com.fuyu.entity.Login;

public interface RegisterDao {
    /**
     * 注册账号
     */

    boolean register(Login login);

}
