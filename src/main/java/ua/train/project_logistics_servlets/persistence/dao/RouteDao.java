package ua.train.project_logistics_servlets.persistence.dao;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Route;

import java.util.List;
import java.util.Optional;

public interface RouteDao extends GenericDao<Route> {
    Optional<Route> findRouteByTwoPoints(String pointOne, String pointTwo)
            throws DataBaseFetchException;

    List<String> getCitiesOptionsEng()
            throws DataBaseFetchException;

    List<String> getCitiesOptionsUa()
            throws DataBaseFetchException;
}
