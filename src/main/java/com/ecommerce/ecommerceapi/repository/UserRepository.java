package com.ecommerce.ecommerceapi.repository;

import com.ecommerce.ecommerceapi.entity.Category;
import com.ecommerce.ecommerceapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsByUserEmail(String email);
}
