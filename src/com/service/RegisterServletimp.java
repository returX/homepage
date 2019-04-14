package com.service;

import com.service.imp.LoginServlet;
import com.sql.Jdbc;
import com.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterServletimp implements LoginServlet {
    @Override
    public User checkUserinfo(String uname, String pwd) {
        User u = null;
        Connection conn = Jdbc.conn();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "INSERT INTO `user`(username,password) VALUES(?,?)";
        try {
            u = new User();
            pst = conn.prepareStatement(sql);
            pst.setString(1,uname);
            pst.setString(2,pwd);
            pst.execute();
            //判断
//            rs = pst.executeQuery();
//            while (rs.next()){
//                u = new User();
//                u.setUname(rs.getString("username"));
//                u.setUname(rs.getString("password"));
//            }
            u.setUname(uname);
            u.setPwd(pwd);
            System.out.println("注册用户"+u);
        } catch (Exception e) {
            e.getMessage();
            u.setError("用户名已被注册");
        }finally {
            Jdbc.closeAllResource(conn,pst,rs);
        }
        return u;
    }
}
