package com.wellfound.service;

import java.util.List;

import com.wellfound.entity.Comments;
import com.wellfound.entity.Post;

public interface CommentService {

	List<Comments> showCommentsByPostId(Long id);

	void addComment(Comments comment);

	List<Comments> getAllComments();



//	List<Comments> showCommentsByPostId(Long id);

}
