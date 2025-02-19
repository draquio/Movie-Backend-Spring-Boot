package com.sergiomercado.projects.MovieManagement.controller;

import com.sergiomercado.projects.MovieManagement.persistence.entity.User;
import com.sergiomercado.projects.MovieManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll(@RequestParam(required = false) String name){
        if(StringUtils.hasText(name)){
            return userService.findAllByName(name);
        }
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{user}")
    public User findOneByUsername(@PathVariable("user") String username){
        return userService.findOneByUsername(username);
    }
}
