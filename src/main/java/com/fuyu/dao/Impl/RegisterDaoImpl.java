package com.fuyu.dao.Impl;

import com.fuyu.dao.RegisterDao;
import com.fuyu.entity.Login;
import com.fuyu.utils.MysqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RegisterDaoImpl implements RegisterDao {
    Connection connection =null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    /**
     * 注册功能实现
     * @param login
     * @return
     */
    @Override
    public boolean register(Login login) {
        /**
         *  flag: 注册成功标志位
         */
        boolean flag = false;
        try {
            connection = MysqlUtils.getConnection();
            String sql="insert into login(`username`,`password`) VALUES(?,?)";
            statement = connection.prepareStatement(sql);
            System.out.println("连接数据库成功！");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库创建连接失败！"+this.getClass().getName());
        }
        //传递数据
        try {

            statement.setString(1,login.getUsername());
            statement.setString(2,login.getPassword());

            /**
             *  返回受影响行数
             */
            int i = statement.executeUpdate();

            if (i>0){
                  flag =true;
            }else {
                System.out.println("注册失败");
            }

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("登录数据获取异常"+this.getClass().getName());
        }finally {
            /**
             * 释放连接
             */
            MysqlUtils.releaseConnection(connection,statement,resultSet);
        }
        return flag;
    }
}
