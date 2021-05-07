package com.fuyu.service.Impl;

import com.fuyu.dao.Impl.RegisterDaoImpl;
import com.fuyu.dao.RegisterDao;
import com.fuyu.entity.Login;
import com.fuyu.service.Interface.RegisterService;

public class RegisterServiceImpl implements RegisterService {

   private RegisterDao registerDao = new RegisterDaoImpl();

    /**
     * 注册
     * @param login
     * @return
     */
    @Override
    public boolean register(Login login) {
        return registerDao.register(login);
    }
}
