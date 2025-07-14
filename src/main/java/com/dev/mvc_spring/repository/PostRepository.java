package com.dev.mvc_spring.repository;

import com.dev.mvc_spring.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
	
}
