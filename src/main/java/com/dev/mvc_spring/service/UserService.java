package com.dev.mvc_spring.service;

import com.dev.mvc_spring.entity.User;

public interface UserService {
    User save(User user);
    User findByUsername(String username);
}
