package com.dev.mvc_spring.repository;


import com.dev.mvc_spring.entity.UserJdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<UserJdbc> userMapper = (rs, rowNum) -> {
        UserJdbc user = new UserJdbc();
        user.setId((long) rs.getInt("id"));
        user.setUsername(rs.getString("user_name"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        return user;
    };

    public List<UserJdbc> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", userMapper);
    }

    public void save(UserJdbc user) {
        String sql = "INSERT INTO users (user_name, password, role) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getRole());
    }

    public UserJdbc findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, userMapper, id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }
}
