package com.foodapp.authservice.service;

import java.util.UUID;
import com.foodapp.authservice.model.User;
import com.foodapp.authservice.repository.UserRepository;

public interface UserService {
  User registerUser(String username, String email, String password);

  User assignRoleToUser(UUID userId, String roleName);

  User getUserByEmail(String email);
}
