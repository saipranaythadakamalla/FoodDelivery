package com.foodapp.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.authservice.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Find role by name (ROLE_USER, ROLE_ADMIN, etc.)
    Optional<Role> findByName(String name);

    // Check if role already exists
    boolean existsByName(String name);
}
