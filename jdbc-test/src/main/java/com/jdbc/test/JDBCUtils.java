package com.jdbc.test;

import java.sql.*;
import java.util.Properties;

/**
 * @author yufei
 * @create 2018-12-09 17:22
 */
public class JDBCUtils {
    /**
     * 建立连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        Properties prop = new Properties();
        prop.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        String driverClass = prop.getProperty("driverClass");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        //加载驱动
        Class.forName(driverClass);
        //获取连接
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }

    /**
     * 关闭所有连接
     * @param conn
     * @param ps
     * @param rs
     */
    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭conn和prepare连接
     * @param conn
     * @param ps
     */
    public static void close(Connection conn, PreparedStatement ps) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
