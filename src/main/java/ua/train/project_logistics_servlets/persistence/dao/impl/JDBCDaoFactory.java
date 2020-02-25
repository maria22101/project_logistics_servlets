package ua.train.project_logistics_servlets.persistence.dao.impl;

import ua.train.project_logistics_servlets.persistence.dao.*;

public class JDBCDaoFactory extends DaoFactory {

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao();
    }

    @Override
    public RouteDao createRouteDao() {
        return new JDBCRouteDao();
    }

    @Override
    public OrderDao createOrderDao() {
        return new JDBCOrderDao();
    }

    @Override
    public InvoiceDao createInvoiceDao() {
        return new JDBCInvoiceDao();
    }

    @Override
    public AddressDao createAddressDao() {
        return new JDBCAddressDao();
    }
}
