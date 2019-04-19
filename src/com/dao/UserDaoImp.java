package com.dao;

import com.dao.imp.UserDao;
import com.model.user.User;
import com.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    //初始化
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    //添加
    @Override
    public int addUser(String uname, String pwd){
        int a = 0;
        try{
            //连接数据库
            conn = JdbcUtil.conn("java");
            String sql = "INSERT INTO `user`(username,password) VALUES(?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,uname);
            pst.setString(2,pwd);
            //返回语句的行数，如果语句无返回就返回0
            a = pst.executeUpdate(); //如果用户存在就会报错
        }catch (SQLIntegrityConstraintViolationException s){
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAllResource(conn,pst,rs);
        }
        return a;
    }
    //选择全部
    @Override
    public List<User> selects() {
        List<User> list = new ArrayList<>();
        try{
            //连接数据库
            conn = JdbcUtil.conn("java");
            String sql = "select username,password from `user` where username = ? and password = ?";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setUname(rs.getString("username"));
                u.setPwd(rs.getString("password"));
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAllResource(conn,pst,rs);
        }
        return list;
    }
    //删除
    @Override
    public int delete(User u) {
        int a = 0;
        String uname = u.getUname();
        String pwd = u.getPwd();
        try{
            conn = JdbcUtil.conn("java");
            String sql = "delete from `user` where username = ? and password = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,uname);
            pst.setString(2,pwd);
            a = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAllResource(conn,pst,rs);
        }
        return a;
    }
    //修改密码
    @Override
    public int update(User u,String pwd) {
        int a = 0;
        try{
            conn = JdbcUtil.conn("java");
            String sql = "update `user` set password = ? where username = ?";
            pst =  conn.prepareStatement(sql);
            pst.setString(1,pwd);
            pst.setString(2,u.getUname());
            a = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAllResource(conn,pst,rs);
        }
        return a;
    }
    //选择一个
    @Override
    public User selectone(User u) {
        User us = new User();
        try{
            conn = JdbcUtil.conn("java");
            String sql = "select username,password from `user` where username = ? and password = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,u.getUname());
            pst.setString(2,u.getPwd());
            rs = pst.executeQuery();
            if (rs.next()){
                us.setUname(rs.getString("username"));
                us.setPwd(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAllResource(conn,pst,rs);
        }
        return us;
    }
}
