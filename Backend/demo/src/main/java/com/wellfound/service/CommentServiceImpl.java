package com.wellfound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellfound.Repository.CommentRepository;
import com.wellfound.entity.Comments;
import com.wellfound.entity.Post;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository commentRepository;


	@Override
    public List<Comments> showCommentsByPostId(Long id) {
        return commentRepository.findAllByPostId(id);
    }
	
	@Override
    public void addComment(Comments comment) {
        commentRepository.save(comment);
    }

	@Override
	public List<Comments> getAllComments() {
		// TODO Auto-generated method stub
		return commentRepository.findAll();
	}

}
