package ua.train.project_logistics_servlets.web.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        LOGGER.info("Inside AuthFilter");

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        ServletContext context = request.getServletContext();

        String path = req.getRequestURI();

        final Role role = (Role) session.getAttribute("role");
        final String username = (String) context.getAttribute("username");

        // process error ?

        if ((path.contains("login") && role == null) ||
                path.contains(("logout")) ||
                path.contains("registration")) {
            LOGGER.info("Please proceed with login to enter the service");
            filterChain.doFilter(request, response);
            return;
        }

        if (path.contains("user") && role.equals(Role.USER)) {
            LOGGER.info("You have User role -> you are allowed to proceed");
            filterChain.doFilter(request, response);
            return;
        }

        if (path.contains("admin") && role.equals(Role.ADMIN)) {
            LOGGER.info("You have Admin role -> you are allowed to proceed");
            filterChain.doFilter(request, response);
            return;
        }

            LOGGER.info("Resource forbidden for your role");
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
