package com.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author yufei
 * @create 2018-12-09 18:05
 */
public class Jdbc {


    public static String getList(String sql,Object...args) throws Exception {

        //1.建立连接
        Connection connection = JDBCUtils.getConnection();

        //2.设计sql语言
        PreparedStatement ps = connection.prepareStatement(sql);

        //3.填充占位符
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1,args[i]);
        }

        //4.执行查询语句
        ResultSet rs = ps.executeQuery();
        String userName = null;
        while(rs.next()) {
            userName = rs.getString("user_Name");
        }

        //5.关闭连接
        JDBCUtils.closeAll(connection,ps,rs);

        return userName;
    }

    /**
     * 通用增删改
     * @return
     */
    public static int update(String sql , Object...args) throws Exception {
        //1.建立连接
        Connection connection = JDBCUtils.getConnection();

        //2.创建sql语句
        PreparedStatement ps = connection.prepareStatement(sql);

        //3.填充占位符
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1,args[i]);
        }

        //4.执行sql
        int row = 0;
        row = ps.executeUpdate();

        //关闭连接
        JDBCUtils.close(connection,ps);
        return row;
    }
}
