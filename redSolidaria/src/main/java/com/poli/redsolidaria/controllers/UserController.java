package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.poli.redsolidaria.services.UserService;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/signup")
    public String createUser(@RequestBody User newUser){
        userService.createUser(newUser);
        return "redirect:/pages/signup?success";
    }
}
