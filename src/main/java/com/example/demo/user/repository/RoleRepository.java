package com.example.demo.user.repository;

import com.example.demo.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByUserRole(String member);
}
