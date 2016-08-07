package com.dyrda.dao.impl;

import com.dyrda.dao.UserDao;
import com.dyrda.entity.User;
import com.dyrda.utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sergiy on 28.07.2016.
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    HibernateUtil hibernateUtil;

    @Override
    public long createUser(User user) {
        Long userId = (Long) hibernateUtil.createEntity(user);
        return userId;
    }

    @Override
    public User updateUser(User user) {
        User updatedUser = hibernateUtil.updateEntity(user);
        return updatedUser;
    }

    @Override
    public void deleteUser(long id) {
        hibernateUtil.deleteEntity(id, User.class);
    }

    @Override
    public User getUserById(long id) {
        return hibernateUtil.getEntityById(id, User.class);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allEntities = hibernateUtil.getAllEntities(User.class);
        return allEntities;
    }

    @Override
    public List<User> getUsersByName(String name) {
        return hibernateUtil.getEntitiesByEntityParam(User.class, "name", name);
    }

    public List<User> getUsersByName_2(String name) {
        String sqlQuery = "SELECT * FROM Users WHERE name LIKE '%" + name + "%'";
        List<Object[]> usersByName = hibernateUtil.getEntitiesBySQLQuery(sqlQuery);
        List<User> resultList = new ArrayList<>(usersByName.size());
        for (Object[] userArr : usersByName) {
            BigInteger userId = (BigInteger) userArr[0];
            Long user_id = Long.valueOf(userId.toString());
            String userName = (String) userArr[1];
            int userAge = (int) userArr[2];
            boolean isAdmin = (boolean) userArr[3];
            Date createdDate = (Date) userArr[4];


            User user = new User(user_id, userName, userAge, isAdmin, createdDate);
            resultList.add(user);
        }
        return resultList;
    }
}
