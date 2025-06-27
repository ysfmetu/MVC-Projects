package com.ysf.personel.service;

import java.util.Set;

import com.ysf.personel.model.UserInfo;
import com.ysf.personel.model.security.UserRole;

public interface UserService {

    UserInfo createUser(UserInfo user, Set<UserRole> userRoles);

    UserInfo saveUser(UserInfo user);

}
