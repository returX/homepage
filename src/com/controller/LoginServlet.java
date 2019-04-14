package com.controller;

import com.service.LoginServletimp;
import com.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        //System.out.println("uname="+uname);
        //System.out.println("pwd="+pwd);
        //将传入的用户名和密码与数据库信息做对比
        LoginServletimp ls = new LoginServletimp();
        User u = ls.checkUserinfo(uname,pwd);
        //交给过滤器检查
        request.getSession().setAttribute("user",u);
        response.sendRedirect("/main.jsp");
        //System.out.println(u);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
