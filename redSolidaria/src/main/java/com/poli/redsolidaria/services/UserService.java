package com.poli.redsolidaria.services;

import com.poli.redsolidaria.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
}
