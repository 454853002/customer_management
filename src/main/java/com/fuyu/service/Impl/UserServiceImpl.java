package com.fuyu.service.Impl;

import com.fuyu.dao.Impl.UserDaoImpl;
import com.fuyu.dao.UserDao;
import com.fuyu.entity.User;
import com.fuyu.service.Interface.UserService;

import java.sql.ResultSet;


public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();


    @Override
    public ResultSet searchUsers() {
        return userDao.searchUsers();
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public ResultSet searchBySelect(User user) {
        return userDao.searchBySelect(user);
    }

}
