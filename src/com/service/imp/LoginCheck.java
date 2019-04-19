package com.service.imp;

import com.model.user.User;

public interface LoginCheck {
    User checkUserInfo(String uname,String pwd);

}
