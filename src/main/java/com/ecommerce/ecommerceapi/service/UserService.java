package com.ecommerce.ecommerceapi.service;

import com.ecommerce.ecommerceapi.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAllUser();

    User findUserById(Long categoryId);

    User createNewUser(User category);

    void deleteUserById(Long categoryId);

    User editUser(User category);
}
