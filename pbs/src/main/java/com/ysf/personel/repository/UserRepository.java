package com.ysf.personel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysf.personel.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);

}
