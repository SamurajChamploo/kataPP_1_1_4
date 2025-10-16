package org.example;

import org.example.dao.UserDao;
import org.example.dao.UserDaoHibernateImpl;
import org.example.model.User;
import org.example.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Util.getConnection();

        UserDao userDao = new UserDaoHibernateImpl();

        userDao.createUsersTable();

        userDao.saveUser("Name1", "LastName1", (byte) 20);
        System.out.println("User c именем Name1 добавлен в базу данных");
        userDao.saveUser("Name2", "LastName2", (byte) 25);
        System.out.println("User c именем Name2 добавлен в базу данных");
        userDao.saveUser("Name3", "LastName3", (byte) 31);
        System.out.println("User c именем Name3 добавлен в базу данных");
        userDao.saveUser("Name4", "LastName4", (byte) 38);
        System.out.println("User c именем Name4 добавлен в базу данных");

        userDao.removeUserById(1);

        List<User> list = userDao.getAllUsers();
        for (User u : list) {
            System.out.println(u);
        }

        userDao.cleanUsersTable();

        userDao.dropUsersTable();
    }
}