package com.controller;

import com.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "CustomerServlet",urlPatterns = {"*.do"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletpath:  /*.do
        String servletpath = request.getServletPath();
        //去除/和.do
        String methodName = servletpath.substring(1);
        methodName = methodName.substring(0,methodName.length()-3);
        //获取methodName对应的的方法
        try {
            Method method = this.getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class,HttpServletResponse.class);
            //利用反射调用方法
            //System.out.println(methodName);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发
        request.getRequestDispatcher("/LoginServlet").forward(request,response);
    }

    private void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //重定向到注册页面
        response.sendRedirect("/Register.jsp");
    }

    private void toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发到index.jsp
        String uname = request.getParameter("uanme");
        String pwd = request.getParameter("pwd");
        User u =new User(uname,pwd);
        request.getSession().setAttribute("user",u);
        request.getRequestDispatcher("/RegisterServlet").forward(request,response);
    }
}
