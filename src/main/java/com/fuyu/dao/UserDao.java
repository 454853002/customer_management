package com.fuyu.dao;

import com.fuyu.entity.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao {
    /**
     * 查找所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 添加用户
     * @return
     */
    boolean  addUser(User user);
    /**
     * 查找所有用户
     * @return
     */
    ResultSet searchUsers();

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
     * @param user
     * @return
     */
    ResultSet searchBySelect(User user);
}
