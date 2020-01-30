package ua.train.project_logistics_servlets.controller.filters;

import ua.train.project_logistics_servlets.model.entity.enums.Role;
import ua.train.project_logistics_servlets.model.service.SimpleUserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {
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

        if (path.contains("login") || role == null) {
            System.out.println("you are to enter your credentials");
            filterChain.doFilter(req, res);
            return;

        } else if (path.contains("user") && role.equals(Role.USER)) {
            System.out.println("you are user entering user's url, do enter");
            filterChain.doFilter(req, res);
            return;

        } else if (path.contains("admin") && role.equals(Role.ADMIN)) {
            System.out.println("you are admin entering admin's url, do enter");
            filterChain.doFilter(req, res);
            return;

        } else {
            res.sendRedirect("/denied");
        }

        System.out.println(session);
        System.out.println(session.getAttribute("role"));
        System.out.println(context.getAttribute("loggedUsers"));


        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
