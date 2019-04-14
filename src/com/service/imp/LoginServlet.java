package com.service.imp;

import com.user.User;

public interface LoginServlet {
    User checkUserinfo(String uname,String pwd);
}
