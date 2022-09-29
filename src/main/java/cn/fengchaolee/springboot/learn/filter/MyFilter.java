package cn.fengchaolee.springboot.learn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MyFilter
 *
 * @author fengchaolee
 * @date : 2022/9/29
 */
@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("MyFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter doFilter begin...");

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String requestURI = request.getRequestURI();
        System.out.println("MyFilter doFilter requestURI " + requestURI);

        filterChain.doFilter(request,response);
        System.out.println("MyFilter doFilter end...");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("MyFilter destroy...");
    }
}
