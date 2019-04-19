package com.service;

import com.dao.UserDaoImp;
import com.model.user.User;
import com.service.imp.RegisterCheck;


public class RegisterCheckImp implements RegisterCheck {
    private UserDaoImp ud = null;
    public RegisterCheckImp(){
        ud = new UserDaoImp();
    }
    @Override
    public int checkUserRepeat(String uname, String pwd) {

        int checknum = ud.addUser(uname,pwd);
        return checknum;
    }
}
