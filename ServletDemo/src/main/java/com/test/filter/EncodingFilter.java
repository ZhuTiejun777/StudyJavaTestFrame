package com.test.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class EncodingFilter implements Filter {

    public EncodingFilter () {
        System.out.println("过滤器构造");
    }

    public void destroy () {
        System.out.println("过滤器销毁");
    }

    public void doFilter (ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8"); //将编码改为utf-8
        response.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(request, response);

    }

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    public boolean isLoggable(LogRecord record) {
        return true;
    };

}
