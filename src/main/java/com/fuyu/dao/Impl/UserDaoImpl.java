package com.fuyu.dao.Impl;

import com.fuyu.dao.UserDao;
import com.fuyu.entity.User;
import com.fuyu.utils.MysqlUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection connection =null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    /**
     * 查找所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            connection = MysqlUtils.getConnection();
            String sql="select * from user ";
            statement = connection.prepareStatement(sql);
            System.out.println("连接成功！");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库创建连接失败！"+this.getClass().getName());
        }
        try {
            //执行结果
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("sex"));
                System.out.println(resultSet.getString("birth"));
                System.out.println(resultSet.getString("phone"));
                System.out.println(resultSet.getString("note"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("登录数据获取异常"+this.getClass().getName());
        }finally {
            MysqlUtils.releaseConnection(connection,statement,resultSet);
        }
        return  users;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        try {
            connection = MysqlUtils.getConnection();
            String sql="insert into user(`name`,`sex`,`birth`,`phone`,`note`) VALUE(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库创建连接失败！"+this.getClass().getName());
        }
        try {
            statement.setString(1,user.getName());
            statement.setString(2,user.getSex());
            statement.setString(3,user.getBirth());
            statement.setString(4,user.getPhone());
            statement.setString(5,user.getNote());
            int i = statement.executeUpdate();

            if (i>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public ResultSet searchUsers() {
        try {
            String sql = "select * from user";
            connection = MysqlUtils.getConnection();
            statement  = connection.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        //获取返回的数据
        try {
            resultSet = statement.executeQuery();
        }catch (SQLException e){
            System.out.println("查询失败"+e.getMessage());
        }
        return resultSet;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag = false;
        try {
            connection = MysqlUtils.getConnection();
            String sql="update  user  set `name`=?,`sex`=?,`birth`=?, `phone`=?,`note`=? where `id`=?";
            statement = connection.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库创建连接失败！"+this.getClass().getName());
        }
        try {
            statement.setString(1,user.getName());
            statement.setString(2,user.getSex());
            statement.setString(3,user.getBirth());
            statement.setString(4,user.getPhone());
            statement.setString(5,user.getNote());
            statement.setInt(6,user.getId());
            int i = statement.executeUpdate();

            if (i>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public boolean deleteById(int id) {
        boolean flag = false;
        try {
            connection = MysqlUtils.getConnection();
            String sql="delete from user where `id`=?";
            statement = connection.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库创建连接失败！"+this.getClass().getName());
        }
        try {
            statement.setInt(1,id);
            int i = statement.executeUpdate();
            if (i>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据条件查询
     * @param user
     * @return
     */
    @Override
    public ResultSet searchBySelect(User user) {
        ResultSet resultSet=null;
        Field[] fields = User.class.getDeclaredFields();
        System.out.println(user.getSex());
        System.out.println(fields.length);
        String sql= "select * from user where ";
        String sql2 = "select * from user where sex='m'";
        boolean flag = true;

        for (Field field : fields) {
            field.setAccessible(true);
           // System.out.println("进入");
            try {
                Object o = field.get(user);
                System.out.println(o == null);
                if (o!=""&&!o.equals(0)&& flag)
                {
                  //  System.out.println("123154");
                    flag=false;
                  sql=  sql+ field.getName() +"='"+o+"'";
                }else if (o !="" &&!o.equals(0)&& !flag ){
                    sql=  sql+ " and "+field.getName() +"='"+o+"'";
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sql);
        try {
            connection = MysqlUtils.getConnection();
            statement = connection.prepareStatement(sql);
             resultSet = statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库创建连接失败！"+this.getClass().getName());
        }

        return resultSet;
    }

}

