package com.scarecrow.bean;

import java.io.Serializable;

public class Notice implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  noticeContent;
	private long    noticeDate;
	private Admin admin;
	
	public Notice() {
	}
	
	public Notice(Integer id, String noticeContent, long noticeDate, Admin admin) {
		super();
		this.id = id;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.admin = admin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public long getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(long noticeDate) {
		this.noticeDate = noticeDate;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
