package com.user.controllers;

import com.user.dto.UserInput;
import com.user.models.User;
import com.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService services;

//    @PostMapping
    @MutationMapping
    public User Create(@Argument UserInput user){
        if (user == null) {
            System.out.println("Received null UserInput");
            throw new IllegalArgumentException("UserInput cannot be null");
        }
        User newUser = new User(user.getName(), user.getEmail(), user.getPassword());
        return services.add(newUser);
    }

//    @GetMapping
    @QueryMapping
    public List<User> GetAllUser(){
        return services.getAll();
    }

//    @GetMapping("{id}")
    @QueryMapping
    public User getUserById(@Argument int id){
        return services.get(id);
    }

}
