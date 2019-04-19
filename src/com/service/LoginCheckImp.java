package com.service;

import com.dao.UserDaoImp;
import com.model.user.User;
import com.service.imp.LoginCheck;


public class LoginCheckImp implements LoginCheck {
    private UserDaoImp ud = null;
    public LoginCheckImp(){
        ud = new UserDaoImp();
    }
    //返回检索到的用户 如果没找到 返回用户名和密码为空
    @Override
    public User checkUserInfo(String uname, String pwd) {
        User u = new User();

        u.setUname(uname);
        u.setPwd(pwd);

        User us = ud.selectone(u);
        return us;
    }

}
