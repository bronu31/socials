package com.example.demo.service;

import com.example.demo.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPost();

    Post savePost(Post post);

    Post updatePost(Post post);

    Post getPostById(Long id);

    void deletePost(Long id);

}
