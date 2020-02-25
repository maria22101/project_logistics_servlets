package ua.train.project_logistics_servlets.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.RouteDao;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.service.order.SumCalculationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RouteService {
    private RouteDao routeDao = DaoFactory.getInstance().createRouteDao();

    private static final Logger LOGGER = LogManager.getLogger(SumCalculationService.class);

    public List<Route> getAllRoutes()
            throws DataBaseFetchException {
        return routeDao.findAll();
    }

    public Route getRouteByTwoPoints(String dispatchCity, String deliveryCity)
            throws DataBaseFetchException {
        return routeDao.findRouteByTwoPoints(dispatchCity, deliveryCity)
                .orElseThrow(DataBaseFetchException::new);
    }

    public List<String> getCitiesOptionsEng()
            throws DataBaseFetchException {
        return routeDao.getCitiesOptionsEng();
    }

    public List<String> getCitiesOptionsUa()
            throws DataBaseFetchException {
        return routeDao.getCitiesOptionsUa();
    }
}
