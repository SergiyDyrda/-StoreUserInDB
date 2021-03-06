package com.dyrda.dao;

import com.dyrda.entity.User;

import java.util.List;

/**
 * Created by Segiy on 28.07.2016.
 */
public interface UserDao {
    long createUser(User user);
    User updateUser(User user);
    void deleteUser(long id);
    User getUserById(long id);
    List<User> getAllUsers();
    List<User> getUsersByName(String name);
}
