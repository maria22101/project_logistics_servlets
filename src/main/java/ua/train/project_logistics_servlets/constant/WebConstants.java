package ua.train.project_logistics_servlets.constant;

public interface WebConstants {

    String CONTEXT_PATH = "/";
    String SERVLET_MAIN_PATH = "/app/";
    String LOGIN_PATH = "login";
    String LOGOUT_PATH = "logout";
    String REGISTRATION_PATH = "registration";
    String EXCEPTION_PATH = "exception";
    String DENIED_PATH = "denied";
    String AUTH_ERROR_PATH = "login/auth_error";

    String USER_CABINET_PATH = "user/user_main";
    String USER_ORDERS_PATH = "user/orders";
    String USER_INVOICED_ORDERS_PATH = "user/invoiced_orders";
    String USER_PLACE_ORDER_PATH = "user/place_order";

    String ADMIN_CABINET_PATH = "admin/admin_main";
    String ADMIN_ORDERS_PATH = "admin/orders";
    String ADMIN_OPEN_ORDERS_PATH = "admin/open_orders";
    String ADMIN_USERS_PATH = "admin/users";
    String ADMIN_ROUTES_PATH = "admin/routes";

    String ADMIN_CABINET_PAGE = "/WEB-INF/admin/adminMain.jsp";
    String ADMIN_ORDERS_PAGE = "/WEB-INF/admin/adminOrders.jsp";
    String ADMIN_OPEN_ORDERS_PAGE = "/WEB-INF/admin/adminOpenOrders.jsp";
    String ADMIN_USERS_PAGE = "/WEB-INF/admin/adminUsers.jsp";
    String ADMIN_ROUTES_PAGE = "/WEB-INF/admin/adminRoutes.jsp";

    String MAIN_PAGE = "/index.jsp";
    String LOGIN_PAGE = "/login.jsp";
    String REGISTRATION_PAGE = "/registration.jsp";
    String ERROR_PAGE = "/WEB-INF/error.jsp";
    String AUTH_ERROR_PAGE = "/WEB-INF/authError.jsp";
    String ACCESS_DENIED_PAGE = "/WEB-INF/denied.jsp";
    String USER_CABINET_PAGE = "/WEB-INF/user/userMain.jsp";
    String USER_ORDERS_PAGE = "/WEB-INF/user/userOrders.jsp";
    String USER_INVOICED_ORDERS_PAGE = "/WEB-INF/user/userInvoicedOrders.jsp";
    String USER_PLACE_ORDER_PAGE = "/WEB-INF/user/placeOrder.jsp";

    String USER_RELATED_PATH_PATTERN = "user/";
    String ADMIN_RELATED_PATH_PATTERN = "admin/";
    String EMAIL = "email";
    String PASSWORD = "password";

    String EMAIL_ATTRIBUTE = "email";
    String ROLE_ATTRIBUTE = "role";
    String LOGGED_USERS_ATTRIBUTE = "loggedUsers";

    String REDIRECT = "redirect:";
}
