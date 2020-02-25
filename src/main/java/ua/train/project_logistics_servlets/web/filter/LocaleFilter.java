package ua.train.project_logistics_servlets.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.train.project_logistics_servlets.constant.WebConstant.LANGUAGE_ATTRIBUTE;

public class LocaleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        String localeName = req.getParameter(LANGUAGE_ATTRIBUTE);
        if (localeName != null) {
            req.getSession().setAttribute(LANGUAGE_ATTRIBUTE, localeName);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
