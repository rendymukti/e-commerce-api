package com.ecommerce.ecommerceapi.service;

import com.ecommerce.ecommerceapi.entity.User;
import com.ecommerce.ecommerceapi.exception.BadRequestException;
import com.ecommerce.ecommerceapi.exception.ResourceNotFoundException;
import com.ecommerce.ecommerceapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createNewUser(User user) {

        System.out.println("user : " + user);

        if (userRepository.existsById(user.getUserId())) {
            throw new BadRequestException("UserId " + user.getUserId() + " registered");
        }

        if (!StringUtils.hasText(user.getUserEmail())) {
            throw new BadRequestException("Email must filled");
        }

        if (userRepository.existsByUserEmail(user.getUserEmail())) {
            throw new BadRequestException("Email " + user.getUserEmail() + " registered");
        }



        user.setIsActive(true);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long userId) {

    }

    @Override
    public User editUser(User user) {
        return null;
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not available"));
    }





}
