package ua.train.project_logistics_servlets.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.dao.AddressDao;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.RouteDao;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.service.order.SumCalculationService;
import ua.train.project_logistics_servlets.web.dto.OrderDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RouteService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    private static final Logger LOGGER = LogManager.getLogger(SumCalculationService.class);

    public List<Route> getAllRoutes() {
        try(RouteDao dao = daoFactory.createRouteDao()) {
            return dao.findAll();
        }
    }

    public Route getRouteFromDb(String dispatchCity, String deliveryCity)
            throws DataBaseFetchException {

        LOGGER.info("Inside RouteService...");
        LOGGER.info("Inside getRouteFromDb()...");

        try(RouteDao dao = daoFactory.createRouteDao()) {
            return dao.findRouteByTwoPoints(dispatchCity, deliveryCity)
                    .orElseThrow(DataBaseFetchException::new);
        }
    }

    public List<String> getCitiesOptionsEng()
            throws DataBaseFetchException {

        try {
            return Stream.concat(
                    getAllRoutes()
                            .stream()
                            .map(Route::getPointOne),
                    getAllRoutes()
                            .stream()
                            .map(Route::getPointTwo))
                    .distinct()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new DataBaseFetchException();
        }
    }

    public List<String> getCitiesOptionsUa()
            throws DataBaseFetchException {

        try {
            return Stream.concat(
                    getAllRoutes()
                            .stream()
                            .map(Route::getPointOneUA),
                    getAllRoutes()
                            .stream()
                            .map(Route::getPointTwoUA))
                    .distinct()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new DataBaseFetchException();
        }
    }
}
