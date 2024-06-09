package com.poli.redsolidaria.services;

import com.poli.redsolidaria.models.User;

public interface UserService {
    void createUser(User user);

    User findUserById(Long id);

    User findUserByEmail(String email);

    void updateUser(User user);
}