package com.filters;

import com.user.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AccountFilter",urlPatterns = {"/main.jsp","/toRegister.do"})
public class AccountFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("FilterDemo1的init方法被调用");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        User u = (User) request.getSession().getAttribute("user");
        String uname = u.getUname();
        String pwd = u.getPwd();
        String url = request.getRequestURI();
        System.out.println(url);
        System.out.println("我是过滤器的"+u);
        if ("/main.jsp" == url){
            //登录规范
            //账户密码是否包含非法字符
            if(!isLetterDigit(uname) || !isLetterDigit(pwd)){
                req.setAttribute("error","账号或密码含有非法字符");
            }else if(null == u){
                req.setAttribute("empty","账号或密码不能为空");
            }
        }else if("/toRegister.do" == url){
            //注册规范
            System.out.println(u.getError());
            System.out.println("我是注册");
        }
        System.out.println("我是FilterDemo1，客户端向Servlet发送的请求被我拦截到了");
        chain.doFilter(req, resp);
        System.out.println("我是FilterDemo1，Servlet向客户端发送的响应被我拦截到了");
    }
    public void destroy() {
        System.out.println("FilterDemo1的destroy方法被调用");
    }

    public static boolean isLetterDigit(String str) {
        String regex = "^[a-z0-9A-Z]+$";
        return str.matches(regex);
    }

}
