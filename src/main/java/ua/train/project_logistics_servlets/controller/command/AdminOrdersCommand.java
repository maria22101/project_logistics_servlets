package ua.train.project_logistics_servlets.controller.command;

import ua.train.project_logistics_servlets.model.entity.Route;
import ua.train.project_logistics_servlets.model.service.RouteService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AdminOrdersCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/adminOrders.jsp";
    }
}
