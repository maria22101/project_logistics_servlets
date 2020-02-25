package ua.train.project_logistics_servlets.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.dao.RouteDao;
import ua.train.project_logistics_servlets.persistence.domain.Route;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RouteServiceTest {

    private static final Route ROUTE_1 = new Route
            (1, "Kyiv", "Київ", "Lviv", "Львів", new BigDecimal("30.00"));
    private static final Route ROUTE_2 = new Route
            (1, "Kyiv", "Київ", "Kyiv", "Київ", new BigDecimal("19.00"));
    private static final Route ROUTE_3 = new Route
            (1, "Lviv", "Львів", "Lviv", "Львів", new BigDecimal("18.00"));
    private static final Route ROUTE_4 = new Route(
            2, "Lviv", "Odesa", "Lviv", "Одеса", new BigDecimal("42.00"));
    private static final Route ROUTE_5 = new Route(
            3, "Odesa", "Одеса", "Odesa", "Одеса", new BigDecimal("19.00"));
    private static final Route ROUTE_6 = new Route(
            3, "Kyiv", "Київ", "Odesa", "Одеса", new BigDecimal("35.00"));

    private List<Route> routes = new ArrayList<>();

    @InjectMocks
    private RouteService instance;

    @Mock
    private RouteDao routeDao;

    @Before
    public void setUp() throws Exception {
        routes.add(ROUTE_1);
        routes.add(ROUTE_2);
        routes.add(ROUTE_3);
        routes.add(ROUTE_4);
        routes.add(ROUTE_5);
        routes.add(ROUTE_6);
    }

    @Test
    public void shouldReturnAllRoutesList() throws DataBaseFetchException {
        when(routeDao.findAll()).thenReturn(routes);
        List<Route> result = instance.getAllRoutes();

        Assert.assertEquals(routes, result);
    }

    @Test
    public void shouldReturnRouteByTwoPoints() throws DataBaseFetchException {
        when(routeDao.findRouteByTwoPoints("Київ", "Одеса"))
                .thenReturn(Optional.of(ROUTE_6));
        Route result1 = instance.getRouteByTwoPoints("Київ", "Одеса");

        when(routeDao.findRouteByTwoPoints("Одеса", "Київ"))
                .thenReturn(Optional.of(ROUTE_6));
        Route result2 = instance.getRouteByTwoPoints("Одеса", "Київ");

        Assert.assertEquals(ROUTE_6, result1);
        Assert.assertEquals(ROUTE_6, result2);
    }

    @Test
    public void shouldReturnCitiesOptionsEngList() throws DataBaseFetchException {
        List<String> expectedResult = Arrays.asList
                (ROUTE_1.getPointOne(), ROUTE_2.getPointOne(), ROUTE_3.getPointOne(),
                        ROUTE_4.getPointOne(), ROUTE_5.getPointOne(), ROUTE_6.getPointOne());

        when(routeDao.getCitiesOptionsEng()).thenReturn(expectedResult);

        List<String> result = instance.getCitiesOptionsEng();

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldReturnCitiesOptionsUaList() throws DataBaseFetchException {
        List<String> expectedResult = Arrays.asList
                (ROUTE_1.getPointOneUA(), ROUTE_2.getPointOneUA(), ROUTE_3.getPointOneUA(),
                        ROUTE_4.getPointOneUA(), ROUTE_5.getPointOneUA(), ROUTE_6.getPointOneUA());

        when(routeDao.getCitiesOptionsUa()).thenReturn(expectedResult);

        List<String> result = instance.getCitiesOptionsUa();

        Assert.assertEquals(expectedResult, result);
    }
}