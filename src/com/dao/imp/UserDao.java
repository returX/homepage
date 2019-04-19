package com.dao.imp;

import com.model.user.User;

import java.util.List;

public interface UserDao {
    public int addUser(String uname,String pwd);

    public List<User> selects();

    public int delete(User u);

    public int update(User u,String pwd);

    public User selectone(User u);
}
