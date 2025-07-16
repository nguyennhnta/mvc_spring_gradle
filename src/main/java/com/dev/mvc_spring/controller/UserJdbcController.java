package com.dev.mvc_spring.controller;

import com.dev.mvc_spring.entity.UserJdbc;
import com.dev.mvc_spring.service.UserJdbcService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users_jdbc")
public class UserJdbcController {

    private final UserJdbcService service;

    public UserJdbcController(UserJdbcService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserJdbc> getAll() {
        return service.getAllUsers();
    }

    @PostMapping
    public void create(@RequestBody UserJdbc user) {
        service.createUser(user);
    }

    @GetMapping("/{id}")
    public UserJdbc getById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteUser(id);
    }
}
