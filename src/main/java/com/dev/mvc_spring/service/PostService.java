package com.dev.mvc_spring.service;

import org.springframework.stereotype.Service;

import java.util.List;
import com.dev.mvc_spring.dto.PostDto;


@Service
public interface PostService {

    List<PostDto> getAllPosts();
    PostDto getPostById(Long id);
    PostDto savePost(PostDto postDto);
    PostDto updatePost(Long id, PostDto postDto); 
    void deletePost(Long id);
}
