package com.sergiomercado.projects.MovieManagement.service;

import com.sergiomercado.projects.MovieManagement.persistence.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findAllByName(String name);
    User findOneByUsername(String username);
    User saveOne(User user);
    User updateOneByUsername(String username, User user);
    void deleteOnByUsername(String username);
}
