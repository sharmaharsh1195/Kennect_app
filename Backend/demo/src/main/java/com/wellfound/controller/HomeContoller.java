package com.wellfound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wellfound.entity.AddCommentRequest;
import com.wellfound.entity.Comments;
import com.wellfound.entity.CreatePostRequest;
import com.wellfound.entity.Post;
import com.wellfound.entity.User;
import com.wellfound.service.CommentService;
import com.wellfound.service.PostService;
import com.wellfound.service.UserService;


@Controller
@RequestMapping("/")
@CrossOrigin("*")
public class HomeContoller {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	
	
	@PostMapping("/adduser")
	private ResponseEntity<?> addUser(@RequestBody User user)
	{
		if(userService.addUser(user)!=null)
		{
			return ResponseEntity.ok("user created");
			
		}
		else
			return ResponseEntity.badRequest().body("error in creating user");
	}
	
	@GetMapping("/posts")
	@ResponseBody
	private List<Post> getAllPost() {
	    List<Post> posts = postService.getAllPost();

	    for (Post post : posts) {
	        User user = userService.findUserById(post.getUser().getId()); // Fetch user information
	        if (user != null) {
	            post.getUser().setName(user.getName()); // Set user's name in the Post object
	        }
	    }

	    return posts;
	}

	
	@GetMapping("/comments")
	@ResponseBody
	private List<Comments> getAllComments() {
	    List<Comments> comments = commentService.getAllComments();

	    for (Comments comment : comments) {
	        User user = userService.findUserById(comment.getUser().getId()); // Fetch user information
	        if (user != null) {
	            comment.getUser().setName(user.getName()); // Set user's name in the Comments object
	        }
	    }

	    return comments;
	}


    @GetMapping("/comments/{postId}")
    private List<Comments> getCommentsByPostId(@PathVariable Long postId) {
        return commentService.showCommentsByPostId(postId);
    }
	
	@PostMapping("/createpost")
	public ResponseEntity<?> createPost(@RequestBody CreatePostRequest request) {
		System.out.println("user on controller"+request.getUsername());
		System.out.println("post content on controller"+request.getPostData());
	    return postService.createPost(request.getUsername(), request.getPostData());
	}

	@PostMapping("/addcomment")
	public ResponseEntity<?> addComment(@RequestBody AddCommentRequest request) {
	    Long postId = request.getPostId();
	    String commentText = request.getText();
	    String username=request.getUsername();
	    System.out.println("username is "+username);
	    Post post = postService.findPostById(postId); // Replace with your actual method to find a post by ID
	    User user=userService.findByName(username);
	    if (post == null) {
	        return ResponseEntity.badRequest().body("Post not found");
	    }
	    
	    Comments comment = new Comments();
	    comment.setPost(post);
	    comment.setComment_data(commentText);
	    comment.setUser(user);
	    
	    
	    commentService.addComment(comment);
	    
	    return ResponseEntity.ok("Comment added successfully");
	}

	
	
}
