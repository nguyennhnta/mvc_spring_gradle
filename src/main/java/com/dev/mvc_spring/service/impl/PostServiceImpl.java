package com.dev.mvc_spring.service.impl;

import com.dev.mvc_spring.entity.Post;
import com.dev.mvc_spring.dto.PostDto;
import com.dev.mvc_spring.repository.PostRepository;
import com.dev.mvc_spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Long id) {
    	Post post = postRepository.findById(id).orElse(null);
        return post != null ? convertToDto(post) : null;
    }

    @Override
    public PostDto savePost(PostDto postDto) {
        Post post = convertToEntity(postDto);
        Post savedPost = postRepository.save(post);
        return convertToDto(savedPost);
    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {
    	Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost != null) {
        	existingPost.setTitle(postDto.getTitle());
        	existingPost.setDescription(postDto.getDescription());
        	Post updatedPost = postRepository.save(existingPost);
            return convertToDto(updatedPost);
        }
        return null;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    // Convert Entity to DTO
    private PostDto convertToDto(Post post) {
        return new PostDto(post.getId(), post.getTitle(), post.getDescription());
    }

    // Convert DTO to Entity
    private Post convertToEntity(PostDto postDto) {
        return new Post(postDto.getId(), postDto.getTitle(), postDto.getDescription());
    }
}
