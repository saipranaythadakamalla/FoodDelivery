package com.foodapp.authservice.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.authservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    // Find by email (for email login)
    Optional<User> findByEmail(String email);

    // Find by phone (for OTP login)
    Optional<User> findByPhone(String phone);

    // Used to check duplicates during registration
    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

}
