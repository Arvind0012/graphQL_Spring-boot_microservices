package com.user.services;

import com.user.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User add(User user);
    List<User> getAll();
    User get(int id);
}
