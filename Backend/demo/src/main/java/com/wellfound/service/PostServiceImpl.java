	package com.wellfound.service;
	
	import java.util.List;
	import java.util.Optional;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Service;
	
	import com.wellfound.Repository.PostRepository;
	import com.wellfound.Repository.UserRepository;
	import com.wellfound.entity.Post;
	import com.wellfound.entity.User;
	
	@Service
	public class PostServiceImpl implements  PostService{
	
		
		
		@Autowired
		private PostRepository postRepository;
	
		
		@Autowired
		private UserRepository userRepository;
		
		@Override
		public List<Post> getAllPost() {
			// TODO Auto-generated method stub
			return postRepository.showAllPost();
		}
	
		@Override
		public List<Post> showPostById(Long id) {
		
				
			return null;
		}
		
		
	
		public ResponseEntity<?> createPost(String name, String post_data) {
		    User user = userRepository.findByname(name);
		    System.out.println(user);
		    if (user != null) {
		        Post post = new Post();
		        post.setUser(user);
		        post.setPost_data(post_data);
		        
		        postRepository.save(post);
		        
		        return ResponseEntity.ok("Post created successfully");
		    } else {
		        return ResponseEntity.badRequest().body("User not found");
		    }
		}

	
		@Override
		public Post findPostById(Long postId) {
		    // TODO Auto-generated method stub
		    Optional<Post> optionalPost = postRepository.findById(postId);
		    return optionalPost.orElse(null); // Return null if not found
		}
	
	}
