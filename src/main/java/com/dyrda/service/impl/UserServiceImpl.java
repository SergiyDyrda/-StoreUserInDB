package com.dyrda.service.impl;

import com.dyrda.dao.UserDao;
import com.dyrda.entity.User;
import com.dyrda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Segiy on 28.07.2016.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public long createUser(User user) {
        user.setCreatedDate(new Date());
        return userDao.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userDao.getUsersByName(name);
    }
}
