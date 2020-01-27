package ua.train.project_logistics_servlets.model.dao;

import ua.train.project_logistics_servlets.model.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract RouteDao createRouteDao();
    public abstract OrderDao createOrderDao();
    public abstract InvoiceDao createInvoiceDao();
    public abstract AddressDao createAddressDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
