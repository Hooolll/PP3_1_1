package com.example.chance.service;


import com.example.chance.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    void addUser(User user);
    List<User> getUsers();
    User getUserById(int id);
    void update(User updateUser);
    void delete(int id);
}
