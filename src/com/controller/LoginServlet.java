package com.controller;

import com.model.user.User;
import com.service.LoginCheckImp;

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
        User u = new User();
        if(!"".equals(uname) || !"".equals(pwd)){
            //将传入的用户名和密码与数据库信息做对比 u为查找到的用户 没找到为空
            LoginCheckImp ls = new LoginCheckImp();
            u = ls.checkUserInfo(uname,pwd);
        }else {
            request.setAttribute("msg","用户名或密码不能为空");
        }
        if(u.isEmpty()){
            //用户不存在
            //获取错误信息
            if(request.getAttribute("msg") == null) {
                request.setAttribute("msg", "登录错误");
            }
            //转发到登录界面
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }else {
            //用户存在
            //将用户保存到session对象中
            request.getSession().setAttribute("user",u);
            //重定向到主页
            response.sendRedirect("/main.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
