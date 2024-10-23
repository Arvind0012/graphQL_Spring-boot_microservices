package com.catalog.service;

import com.catalog.client.UserClient;
import com.catalog.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserClient userClient;

    public User addUser(User user){
        return userClient.addUser(user);
    }

    public List<User> viewUsers(){
        return userClient.viewUsers();
    }



}
