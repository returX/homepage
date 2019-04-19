package com.controller;

import com.service.RegisterCheckImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        int checknum = 0;
        //将传入的用户名和密码与数据库信息做对比
        if(!"".equals(uname) || !"".equals(pwd)){
            RegisterCheckImp rc = new RegisterCheckImp();
            checknum = rc.checkUserRepeat(uname,pwd);
        }else {
            request.setAttribute("msg","用户名不能为空");
        }
        //判断user是否存在
        System.out.println(checknum);
        if(checknum > 0){
            //用户注册成功
            request.setAttribute("msg","注册成功");
            //重定向到登录页面
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }else {
            //用户已被注册
            System.out.println(request.getAttribute("msg"));
            if(request.getAttribute("msg") == null){
                request.setAttribute("msg","用户已被注册");
            }
            //转发到错误页面
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
