package com.fuyu.dao.Impl;

import com.fuyu.dao.LoginDao;
import com.fuyu.entity.Login;
import com.fuyu.utils.MysqlUtils;
import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    Connection connection =null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Login loginnew = new Login();
    @Override
    public Login login(Login login) {
        try {
            connection = MysqlUtils.getConnection();
            String sql="select * from login where username=? and password=?";
            statement = connection.prepareStatement(sql);
            System.out.println("连接成功！");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库创建连接失败！"+this.getClass().getName());
        }
        //传递数据
        try {
            statement.setString(1,login.getUsername());
            statement.setString(2,login.getPassword());
            resultSet = statement.executeQuery();
            System.out.println("数据传递成功！");
            if (resultSet.next()) {
                System.out.println("返回结果成功！");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                loginnew.setUsername(username);
                loginnew.setPassword(password);
            }else {
                System.out.println("结果返回失败！");
                loginnew.setUsername("None");
                loginnew.setPassword("None");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("登录数据获取异常"+this.getClass().getName());
        }finally {
            MysqlUtils.releaseConnection(connection,statement,resultSet);
        }
        return loginnew;
    }
}
