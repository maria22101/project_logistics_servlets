package ua.train.project_logistics_servlets.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;

public class OrderService {
    private static final Logger LOGGER = LogManager.getLogger(OrderService.class);

    DaoFactory daoFactory = DaoFactory.getInstance();
}
