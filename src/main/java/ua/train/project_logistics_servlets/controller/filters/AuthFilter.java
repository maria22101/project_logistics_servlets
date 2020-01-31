package ua.train.project_logistics_servlets.controller.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.controller.command.LoginCommand;
import ua.train.project_logistics_servlets.model.entity.enums.Role;
import ua.train.project_logistics_servlets.model.service.SimpleUserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(AuthFilter.class);
    SimpleUserService userService = new SimpleUserService();

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
        ServletContext context = request.getServletContext();

        String path = req.getRequestURI();

        final Role role = (Role) session.getAttribute("role");
        final String username = (String) context.getAttribute("username");

        // process error ?

        if ((path.contains("login") && role == null) ||
                path.contains(("logout")) ||
                path.contains("registration")) {
            logger.info("Please proceed with login to enter the service");
            filterChain.doFilter(request, response);
            return;
        }

        if (path.contains("user") && role.equals(Role.USER)) {
            logger.info("You have User role -> you are allowed to proceed");
            filterChain.doFilter(request, response);
            return;
        }

        if (path.contains("admin") && role.equals(Role.ADMIN)) {
            logger.info("You have Admin role -> you are allowed to proceed");
            filterChain.doFilter(request, response);
            return;
        }

            logger.info("Resource forbidden for your role");
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
