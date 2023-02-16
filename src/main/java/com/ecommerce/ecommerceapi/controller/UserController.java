package com.ecommerce.ecommerceapi.controller;

import com.ecommerce.ecommerceapi.entity.User;
import com.ecommerce.ecommerceapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @PostMapping("/user")
    public User createNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Long userId) {
        return userService.findUserById(userId);
    }

    @PutMapping("/user")
    public User editUser(@RequestBody User user) {
        return userService.editUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
    }

}
