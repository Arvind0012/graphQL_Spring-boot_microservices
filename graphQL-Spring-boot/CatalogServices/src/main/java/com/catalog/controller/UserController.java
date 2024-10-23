package com.catalog.controller;

import com.catalog.dto.Product;
import com.catalog.dto.User;
import com.catalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user){
        return service.addUser(user);
    }

    @GetMapping("/users")
    public List<User> viewUsers(){
        return service.viewUsers();
    }
}
