package com.ysf.personel.service.Impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysf.personel.model.UserInfo;
import com.ysf.personel.model.security.UserRole;
import com.ysf.personel.repository.RoleRepository;
import com.ysf.personel.repository.UserRepository;
import com.ysf.personel.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepo;


    public UserInfo createUser(UserInfo user, Set<UserRole> userRoles) {
        final Logger LOG = LoggerFactory.getLogger(UserService.class);

        UserInfo localUser = userRepo.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (UserRole ur : userRoles) {
                roleRepo.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);


            localUser = userRepo.save(user);
        }

        return localUser;
    }

    public UserInfo saveUser(UserInfo user) {
        return userRepo.save(user);
    }


}
