package ua.train.project_logistics_servlets.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

//        req.getSession().setAttribute("lang", "ua");

        String localeName = req.getParameter("lang");
        if (localeName != null) {
            req.getSession().setAttribute("lang", localeName);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
