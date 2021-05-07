package com.fuyu.utils;

import com.fuyu.service.Impl.LoginServiceImpl;
import com.fuyu.service.Interface.LoginService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
  public static void main(String[] args) {
            Connection connection =null;
            Statement statement = null;
            ResultSet resultSet = null;

            try {
                //获取数据库连接
                connection = MysqlUtils.getConnection();
                statement = connection.createStatement();
                //SQL语句
                String sql="select * from login";
                //获取返回的数据
                resultSet = statement.executeQuery(sql);
                while (resultSet.next())
                {
                    System.out.println(resultSet.getString("username"));
                }
            }catch (SQLException e)
            {
                e.printStackTrace();
            }finally {
                MysqlUtils.releaseConnection(connection,statement,resultSet);
            }

        }

}

