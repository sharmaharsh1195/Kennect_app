package com.wellfound.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=10000)
	private String post_data;
	
	
	public Post() {
		super();
	}


	public Post(Long id, String post_data, List<Comments> commentlist, User user) {
		super();
		this.id = id;
		this.post_data = post_data;
		this.commentlist = commentlist;
		this.user = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPost_data() {
		return post_data;
	}


	public void setPost_data(String post_data) {
		this.post_data = post_data;
	}


	public List<Comments> getCommentlist() {
		return commentlist;
	}


	public void setCommentlist(List<Comments> commentlist) {
		this.commentlist = commentlist;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@OneToMany(mappedBy="post")
	List<Comments>commentlist=new ArrayList<>();
	
	
	@ManyToOne
//	@JsonIgnore
	private User user;
	
}
