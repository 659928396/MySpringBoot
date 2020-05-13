package com.lj.springboot.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 被springboot的servletfilter注册器注册
 */
public class HeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("HeFilter过滤器执行");
        servletResponse.setContentType("text/html;charset=gbk");
        servletResponse.getWriter().print("HeFilter过滤器执行");
        //filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
