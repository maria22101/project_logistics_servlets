package ua.train.project_logistics_servlets.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private static final String SERVLET_CONTENT_TYPE="text/html;charset=UTF-8";
    private static final String SERVLET_CHAR_ENCODING="UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        servletResponse.setContentType(SERVLET_CONTENT_TYPE);
        servletResponse.setCharacterEncoding(SERVLET_CHAR_ENCODING);
        servletRequest.setCharacterEncoding(SERVLET_CHAR_ENCODING);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
