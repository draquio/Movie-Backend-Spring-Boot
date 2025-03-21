package com.sergiomercado.projects.MovieManagement.service.impl;

import com.sergiomercado.projects.MovieManagement.exception.ObjectNotFoundException;
import com.sergiomercado.projects.MovieManagement.persistence.entity.User;
import com.sergiomercado.projects.MovieManagement.persistence.repository.UserCrudRepository;
import com.sergiomercado.projects.MovieManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public List<User> findAll() {
        return userCrudRepository.findAll();
    }

    @Override
    public List<User> findAllByName(String name) {
        return userCrudRepository.findByNameContaining(name);
    }

    @Override
    public User findOneByUsername(String username) {
        return userCrudRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("{user: " + username + "}"));
    }

    @Override
    public User saveOne(User user) {
        return userCrudRepository.save(user);
    }

    @Override
    public User updateOneByUsername(String username, User user) {
        User oldUser = this.findOneByUsername(username);
        oldUser.setName(user.getName());
        oldUser.setPassword(user.getPassword());
        return userCrudRepository.save(oldUser);
    }

    @Override
    public void deleteOnByUsername(String username) {
        if(userCrudRepository.deleteByUsername(username) != 1){
            throw new ObjectNotFoundException("{user: " + username + "}");
        }
    }
}
