package com.sql;

import java.sql.*;

public class Jdbc {
    public static Connection conn(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/java?serverTimezone=GMT%2B8";

        String username = "root";
        String password = "root";
        Connection conn = null;
        try{
            Class.forName(driver); //classloader,加载对应驱动
            //System.out.println("驱动注册成功");
            conn = (Connection) DriverManager.getConnection(url, username, password);
            //System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeAllResource(Connection conn,PreparedStatement st,ResultSet rs) {
        if (conn!=null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (st!=null) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (rs!=null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeAllResource(Connection conn,PreparedStatement st) {
        if (conn!=null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (st!=null) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
