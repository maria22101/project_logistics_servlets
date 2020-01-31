package ua.train.project_logistics_servlets.model.service;

import ua.train.project_logistics_servlets.model.dao.DaoFactory;
import ua.train.project_logistics_servlets.model.dao.UserDao;
import ua.train.project_logistics_servlets.model.entity.User;
import ua.train.project_logistics_servlets.model.entity.enums.Role;

import java.util.List;


public class UserService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<User> getAllUsers() {
        try(UserDao dao = daoFactory.createUserDao()) {
            return dao.findAll();
        }
    }
}
