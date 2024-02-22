package com.dietcalc.service;

import com.dietcalc.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();

    Authentication getAuthentication();

    User findById(Long id);

    User getByContext();
}
