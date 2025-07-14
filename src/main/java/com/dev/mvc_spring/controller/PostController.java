package com.dev.mvc_spring.controller;

import com.dev.mvc_spring.dto.PostDto;
import com.dev.mvc_spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    // GET all posts
    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    // GET post by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id") Long id) {
    	PostDto postDto = postService.getPostById(id);
        return postDto != null ? ok(postDto) : ResponseEntity.notFound().build();
    }
    

    // POST create post
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto) {
    	PostDto createdPost = postService.savePost(postDto);
        return ok(createdPost);
    }

    // PUT update post
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable("id") Long id, @RequestBody PostDto postDto) {
    	PostDto updatedPost = postService.updatePost(id, postDto);
        return updatedPost != null ? ok(updatedPost) : ResponseEntity.notFound().build();
    }

    // DELETE post
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletepost(@PathVariable("id") Long id) {
    	postService.deletePost(id);
        return ok("Delete success");
    }
}
