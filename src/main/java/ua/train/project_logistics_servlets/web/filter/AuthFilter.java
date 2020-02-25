package ua.train.project_logistics_servlets.web.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;
import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class AuthFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String path = req.getRequestURI();
        final Role role = (Role) session.getAttribute(ROLE_ATTRIBUTE);

        if (isUserLogged(session)) {

            if (isPathAllowedForAll(path)) {
                req.getRequestDispatcher(SERVLET_MAIN_PATH + LOGOUT_PATH).forward(req, res);
                return;
            } else if (isPathAllowedForRole(role, path)) {
                filterChain.doFilter(req, res);
                return;
            } else {
                throw new SecurityException();
            }
        }

        if (isPathAllowedForAll(path)) {
            filterChain.doFilter(req, res);
        } else {
            res.sendRedirect(SERVLET_MAIN_PATH + LOGIN_PATH);
        }
    }

    private boolean isPathAllowedForAll(String path) {
        return path.contains(SERVLET_MAIN_PATH + LOGIN_PATH) ||
                path.contains(SERVLET_MAIN_PATH + LOGOUT_PATH) ||
                path.contains(SERVLET_MAIN_PATH + REGISTRATION_PATH) ||
                path.contains(CALCULATOR_RESULT_PATH) ||
                path.equals(CONTEXT_PATH);
    }

    private boolean isPathAllowedForRole(Role role, String path) {
        boolean isAllowedPath = false;

        if (role.equals(Role.USER) &&
                path.contains(USER_RELATED_PATH_PATTERN)) {
            isAllowedPath = true;

        } else if (role.equals(Role.ADMIN) &&
                path.contains(ADMIN_RELATED_PATH_PATTERN)) {
            isAllowedPath = true;
        }

        return isAllowedPath;
    }

    private boolean isUserLogged(HttpSession session) {
        return nonNull(session) &&
                nonNull(session.getAttribute(ROLE_ATTRIBUTE)) &&
                nonNull(session.getAttribute(EMAIL_ATTRIBUTE));
    }

    @Override
    public void destroy() {
    }
}
