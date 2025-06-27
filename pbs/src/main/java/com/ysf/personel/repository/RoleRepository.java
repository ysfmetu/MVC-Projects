package com.ysf.personel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysf.personel.model.security.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);

}
