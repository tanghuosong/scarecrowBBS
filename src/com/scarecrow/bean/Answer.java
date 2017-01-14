package com.scarecrow.bean;

import java.io.Serializable;


public class Answer implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer	  id;
	private String    answerContent;
	private long      answerTime;
	private User	  user;
	private Post	  post;
	public Answer() {
	}
	
	public Answer(Integer id, String answerContent, long answerTime, User user,
			Post post) {
		super();
		this.id = id;
		this.answerContent = answerContent;
		this.answerTime = answerTime;
		this.user = user;
		this.post = post;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public long getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(long answerTime) {
		this.answerTime = answerTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
