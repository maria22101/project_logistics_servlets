package ua.train.project_logistics_servlets.web.command.user;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.service.order.OrderService;
import ua.train.project_logistics_servlets.service.utility.Page;
import ua.train.project_logistics_servlets.service.utility.PaginationService;
import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class UserOrdersCommand implements Command {
    private OrderService orderService = new OrderService();
    private PaginationService paginationService = new PaginationService();

    private static final String PAGE_ATTRIBUTE = "page";
    private static final String PAGE_SIZE = "9";

    @Override
    public String execute(HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute(EMAIL_ATTRIBUTE);

        HttpSession session = request.getSession();
        String current = request.getParameter(PAGE_ATTRIBUTE);
        int currentPage = 1;
        if (current != null) {
            currentPage = Integer.parseInt(request.getParameter(PAGE_ATTRIBUTE));
        }

        try {
            Page<Order> page = paginationService
                    .getOrdersPageByEmail(email, currentPage, Integer.parseInt(PAGE_SIZE));
            session.setAttribute(PAGE_ATTRIBUTE, page);

        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return USER_ORDERS_PAGE;
    }
}