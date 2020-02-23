package ua.train.project_logistics_servlets.constant;

public interface WebConstant {

    String CONTEXT_PATH = "/";
    String SERVLET_MAIN_PATH = "/app/";
    String LOGIN_PATH = "login";
    String LOGOUT_PATH = "logout";
    String REGISTRATION_PATH = "registration";
    String CALCULATOR_RESULT_PATH = "calculate";
    String EXCEPTION_PATH = "exception";
    String DENIED_PATH = "denied";
    String AUTH_ERROR_PATH = "login/auth_error";
    String REDIRECT = "redirect:";
    String EMPTY_STRING = "";

    String USER_CABINET_PATH = "user/user_main";
    String USER_ORDERS_PATH = "user/orders";
    String USER_INVOICED_ORDERS_PATH = "user/invoiced_orders";
    String USER_INVOICED_ORDER_DETAILS_PATH = "user/invoiced_orders/order_details";
    String USER_INVOICED_ORDERS_PAYING_PATH = "user/invoiced_orders/paying";
    String USER_PLACE_ORDER_PATH = "user/place_order";

    String ADMIN_CABINET_PATH = "admin/admin_main";
    String ADMIN_ORDERS_PATH = "admin/orders";
    String ADMIN_OPEN_ORDERS_PATH = "admin/open_orders";
    String ADMIN_ISSUE_INVOICE_PATH = "admin/open_orders/invoicing";
    String ADMIN_USERS_PATH = "admin/users";
    String ADMIN_ROUTES_PATH = "admin/routes";

    String MAIN_PAGE = "/index.jsp";
    String LOGIN_PAGE = "/login.jsp";
    String REGISTRATION_PAGE = "/registration.jsp";
    String CALCULATOR_RESULT_PAGE = "/calculatorResult.jsp";

    String USER_CABINET_PAGE = "/WEB-INF/user/userMain.jsp";
    String USER_ORDERS_PAGE = "/WEB-INF/user/userOrders.jsp";
    String USER_INVOICED_ORDERS_PAGE = "/WEB-INF/user/userInvoicedOrders.jsp";
    String USER_INVOICED_ORDER_DETAILS_PAGE = "/WEB-INF/user/orderDetails.jsp";
    String USER_PLACE_ORDER_PAGE = "/WEB-INF/user/placeOrder.jsp";

    String ADMIN_CABINET_PAGE = "/WEB-INF/admin/adminMain.jsp";
    String ADMIN_ORDERS_PAGE = "/WEB-INF/admin/adminOrders.jsp";
    String ADMIN_OPEN_ORDERS_PAGE = "/WEB-INF/admin/adminOpenOrders.jsp";
    String ADMIN_USERS_PAGE = "/WEB-INF/admin/adminUsers.jsp";
    String ADMIN_ROUTES_PAGE = "/WEB-INF/admin/adminRoutes.jsp";

    String ERROR_PAGE = "/WEB-INF/errors/error.jsp";
    String AUTH_ERROR_PAGE = "/WEB-INF/errors/authError.jsp";
    String ACCESS_DENIED_PAGE = "/WEB-INF/errors/denied.jsp";
    String DB_FETCH_ERROR_PAGE = "/WEB-INF/errors/dbFetchError.jsp";
    String DB_SAVE_ERROR_PAGE = "/WEB-INF/errors/dbSaveError.jsp";
    String USER_EXISTS_ERROR_PAGE = "/WEB-INF/errors/userExists.jsp";

    String USER_RELATED_PATH_PATTERN = "user/";
    String ADMIN_RELATED_PATH_PATTERN = "admin/";

    String EMAIL_ATTRIBUTE = "email";
    String ROLE_ATTRIBUTE = "role";
    String LOGGED_USERS_ATTRIBUTE = "loggedUsers";
    String INVALID_NAME_INPUT_ATTRIBUTE = "invalidNameInput";
    String INVALID_SURNAME_INPUT_ATTRIBUTE = "invalidSurnameInput";
    String INVALID_EMAIL_INPUT_ATTRIBUTE = "invalidEmailInput";
    String INVALID_PASSWORD_INPUT_ATTRIBUTE = "invalidPasswordInput";
    String ROUTES_ATTRIBUTE = "routes";
    String CITIES_OPTION_ATTRIBUTE = "citiesOptions";
    String ORDERS_ATTRIBUTE = "orders";
    String ORDER_ATTRIBUTE = "order";
    String INVOICES_ATTRIBUTE = "invoices";
    String INVOICE_ATTRIBUTE = "invoice";
    String USERS_ATTRIBUTE = "users";
    String WEIGHT_ATTRIBUTE = "weight";
    String SUM_ATTRIBUTE = "sum";
    String ROUTE_ATTRIBUTE = "route";

    String INVALID_DISPATCH_STREET_INPUT_ATTRIBUTE = "invalidDispatchStreetInput";
    String INVALID_DISPATCH_HOUSE_INPUT_ATTRIBUTE = "invalidDispatchHouseInput";
    String INVALID_DISPATCH_APARTMENT_INPUT_ATTRIBUTE = "invalidDispatchApartmentInput";

    String INVALID_DELIVERY_STREET_INPUT_ATTRIBUTE = "invalidDeliveryStreetInput";
    String INVALID_DELIVERY_HOUSE_INPUT_ATTRIBUTE = "invalidDeliveryHouseInput";
    String INVALID_DELIVERY_APARTMENT_ATTRIBUTE = "invalidDeliveryApartmentInput";

    String INVALID_DELIVERY_DATE_INPUT_ATTRIBUTE = "invalidDeliveryDateInput";
    String INVALID_WEIGHT_INPUT_ATTRIBUTE = "invalidWeightInput";

    String LANGUAGE_ATTRIBUTE = "lang";
    String UA_LANGUAGE = "ua";
    String EN_LANGUAGE = "en";
}
