package com.scarecrow.bean;

import java.io.Serializable;

public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer  id;
	private String   postTitle;
	private String   postContent;
	private String   postImage;
	private Integer  postViews=0;
	private Category category;
	private User 	 user;
	private long     postTime; 
	public Post() {
	}
	
	public Post(Integer id, long postTime, String postTitle,
			String postContent, String postImage, Integer postViews,
			Category category, User user) {
		super();
		this.id = id;
		this.postTime = postTime;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postImage = postImage;
		this.postViews = postViews;
		this.category = category;
		this.user = user;
	}
	
	public Post(Integer id, String postTitle, Integer postViews,
			Category category, long postTime) {
		super();
		this.id = id;
		this.postTitle = postTitle;
		this.postViews = postViews;
		this.category = category;
		this.postTime = postTime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public long getPostTime() {
		return postTime;
	}
	public void setPostTime(long postTime) {
		this.postTime = postTime;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostImage() {
		return postImage;
	}
	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}
	public Integer getPostViews() {
		return postViews;
	}
	public void setPostViews(Integer postViews) {
		this.postViews = postViews;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}