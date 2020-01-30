package ua.train.project_logistics_servlets.controller.filters;

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

        String localeName = request.getParameter("lang");
        if (localeName != null) {
            req.getSession().setAttribute("lang", localeName);
        }



        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
