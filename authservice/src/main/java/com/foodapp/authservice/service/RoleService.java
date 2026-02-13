package com.foodapp.authservice.service;
import com.foodapp.authservice.model.Role;
public interface RoleService {
  Role createRole(String roleName);

  Role getRoleByName(String roleName);
}
