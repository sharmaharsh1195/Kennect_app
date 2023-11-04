package com.wellfound.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wellfound.entity.Post;

public interface PostService {

public 	List<Post> getAllPost();

public List<Post> showPostById(Long id);

public ResponseEntity<?> createPost(String name,String post_data);

public Post findPostById(Long postId);

}
