package com.fuyu.utils;
//mysql封装的连接工具类
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public  class MysqlUtils {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	static {
		try {
			InputStream in = MysqlUtils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(in);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			//驱动加载
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获取连接
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}


	//释放连接资源
	public static void releaseConnection(Connection conn, Statement st, ResultSet rs){
		if (rs !=null){
			try {
				rs.close();
				System.out.println("ResultSet 已关闭！");
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if (st !=null){
			try {
				st.close();
				System.out.println("Statement 已关闭！");
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if (conn !=null){
			try {
				conn.close();
				System.out.println("Connection 已关闭！");
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}
