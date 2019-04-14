package com.service;

import com.service.imp.LoginServlet;
import com.sql.Jdbc;
import com.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServletimp implements LoginServlet {
    @Override
    public User checkUserinfo(String uname,String pwd) {
        User u = null;
        Connection conn = Jdbc.conn();
        PreparedStatement pts = null;
        ResultSet rs = null;

        String sql = "select username,password from `user` where username = ? and password = ?";
        try {
            pts = conn.prepareStatement(sql);
            pts.setString(1,uname);
            pts.setString(2,pwd);

            rs = pts.executeQuery();
            while (rs.next()){
                u = new User();
                u.setUname(rs.getString("username"));
                u.setPwd(rs.getString("password"));
            }
            //打印用户名和密码
            System.out.println("登录用户"+u);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Jdbc.closeAllResource(conn, pts, rs);
        }
        return u;
    }
}
