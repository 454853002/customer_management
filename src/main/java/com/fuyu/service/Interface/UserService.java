package com.fuyu.service.Interface;

import com.fuyu.entity.User;

import java.sql.ResultSet;


public interface UserService {

    /**
     * 查找用户
     * @return
     */
    ResultSet searchUsers();

    /**
     * 添加用户
     */
    boolean  addUser(User user);

    /**
     * 修改用户
     */
    boolean  updateUser(User user);
    /**
     * 删除用户
     */
    boolean  deleteById(int id);
    /**
     * 根据条件查询
     */
    ResultSet searchBySelect(User user);


}
