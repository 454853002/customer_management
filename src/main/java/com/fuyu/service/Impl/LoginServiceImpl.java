package com.fuyu.service.Impl;

import com.fuyu.dao.Impl.LoginDaoImpl;
import com.fuyu.dao.LoginDao;
import com.fuyu.entity.Login;
import com.fuyu.service.Interface.LoginService;


public class LoginServiceImpl  implements LoginService {
   private LoginDao loginDao = new LoginDaoImpl();
    @Override
    public Login login(Login login) {
        return loginDao.login(login);
    }
}

