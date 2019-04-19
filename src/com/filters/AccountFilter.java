package com.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AccountFilter",urlPatterns = {"/LoginServlet","/RegisterServlet"},dispatcherTypes = {DispatcherType.FORWARD})
public class AccountFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String url = request.getRequestURI();
        System.out.println(url);
        System.out.println(uname.length());
        System.out.println(uname);
        System.out.println(pwd);
        System.out.println(uname == null || "".equals(uname));
        if (url.equals("/LoginServlet")){
            //登录规范
            //账户密码是否包含非法字符
            if(uname == null || "".equals(uname)){
                req.setAttribute("msg","账号不能为空");
            }else if(pwd == null || "".equals(pwd)){
                req.setAttribute("msg","密码不能为空");
            }else if(!isLetterDigit(uname) || !isLetterDigit(pwd)){
                req.setAttribute("msg","账号或密码格式不正确");
            }
        }else if(url.equals("/RegisterServlet")){
            //注册规范
            //账户密码是否包含非法字符
            if(uname == null || "".equals(uname)) {
                req.setAttribute("msg","账号不能为空");
            }else if(pwd == null || "".equals(pwd)){
                req.setAttribute("msg","密码不能为空");
            }else if(6 > uname.length() || 18 < uname.length()){
                req.setAttribute("msg","账号长度应在6~18");
            }else if(!isLetterDigit(uname) || !isLetterDigit(pwd)){
                req.setAttribute("msg", "账号或密码含有非法字符");
            }
        }
        chain.doFilter(req, resp);
    }
    public void destroy() {
    }

    public static boolean isLetterDigit(String str) {
        //只允许出现数字和字母
        String regex = "^[a-z0-9A-Z]+$";
        return str.matches(regex);
    }

}
