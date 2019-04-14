package com.controller;

import com.service.RegisterServletimp;
import com.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User us = (User) request.getSession().getAttribute("user");
        String uname = us.getUname();
        String pwd = us.getPwd();
        //将传入的用户名和密码与数据库信息做对比
        RegisterServletimp rs = new RegisterServletimp();
        User u = rs.checkUserinfo(uname,pwd);
        System.out.println("我是Registerservlet");
        //判断user是否存在
        //System.out.println(u);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
