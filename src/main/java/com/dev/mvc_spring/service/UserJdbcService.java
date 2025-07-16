package com.dev.mvc_spring.service;

import com.dev.mvc_spring.entity.UserJdbc;
import com.dev.mvc_spring.repository.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJdbcService {

    private final UserJdbcRepository repo;

    public UserJdbcService(UserJdbcRepository repo) {
        this.repo = repo;
    }

    public List<UserJdbc> getAllUsers() {
        return repo.findAll();
    }

    public void createUser(UserJdbc user) {
        // bạn có thể thêm validate logic tại đây
        repo.save(user);
    }

    public UserJdbc getUserById(int id) {
        return repo.findById(id);
    }

    public void deleteUser(int id) {
        repo.delete(id);
    }
}
