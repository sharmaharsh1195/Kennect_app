package com.wellfound.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellfound.entity.Comments;
import com.wellfound.entity.User;


@Repository
public interface CommentRepository extends JpaRepository<Comments,Long> {

	
//	List<Comments> findAllByUser(User user);
//	
	  List<Comments> findAllByPostId(Long postId);
	  
	  
	}
	
	
	

