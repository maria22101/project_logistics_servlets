package ua.train.project_logistics_servlets.model.service;

import ua.train.project_logistics_servlets.model.dao.DaoFactory;
import ua.train.project_logistics_servlets.model.dao.RouteDao;
import ua.train.project_logistics_servlets.model.dao.UserDao;
import ua.train.project_logistics_servlets.model.entity.Route;
import ua.train.project_logistics_servlets.model.entity.User;

import java.util.List;

public class RouteService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Route> getAllRoutes() {
        try(RouteDao dao = daoFactory.createRouteDao()) {
            return dao.findAll();
        }
    }

//    public static void main(String[] args) {
//        RouteService routeService = new RouteService();
//        List<Route> routes = routeService.getAllRoutes();
//        System.out.println(routes);
//    }
}
