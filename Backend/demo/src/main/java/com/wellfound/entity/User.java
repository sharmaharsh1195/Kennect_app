package com.wellfound.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	List<Post>postlist=new ArrayList<>();

	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	List<Comments>commentslist=new ArrayList<>();

	public List<Comments> getCommentslist() {
		return commentslist;
	}


	public void setCommentslist(List<Comments> commentslist) {
		this.commentslist = commentslist;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Post> getPostlist() {
		return postlist;
	}


	public void setPostlist(List<Post> postlist) {
		this.postlist = postlist;
	}


	public User(Long id, String name, List<Post> postlist) {
		super();
		this.id = id;
		this.name = name;
		this.postlist = postlist;
	}


	public User() {
		super();
	}
	
	
	
}
