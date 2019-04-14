package com.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter",urlPatterns = {"*"},initParams = {
                @WebInitParam(name = "encoding",value = "utf-8")
})
public class CharacterEncodingFilter implements Filter {
    private String encoding = null;
    FilterConfig filterConfig = null;

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if(null != encoding){
            req.setCharacterEncoding(encoding);
            resp.setContentType("text/html;charset="+encoding);
        }
        chain.doFilter(req, resp);
    }
    public void destroy() {
        this.encoding = null;
        this.filterConfig = null;
    }

}
