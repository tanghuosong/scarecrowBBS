package com.scarecrow.bean;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer  id;
	private String   userName;
	private String   userPassword;
	private String   userSex;
	private String	 userPhone;
	private String	 userEmail;
	private Integer	 userGrade;
	private Integer  userNtegration;
	private long 	 userRegistdate;
	private long 	 lastLoginTime;
	private UserStatus  userStatus;
	
	public User() {}
	
	public User(String userName, String userPassword, String userSex,
			String userPhone, String userEmail, Integer userGrade,
			Integer userNtegration, long userRegistdate, long lastLoginTime,
			UserStatus userStatus) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userGrade = userGrade;
		this.userNtegration = userNtegration;
		this.userRegistdate = userRegistdate;
		this.lastLoginTime = lastLoginTime;
		this.userStatus = userStatus;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Integer getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(Integer userGrade) {
		this.userGrade = userGrade;
	}
	public Integer getUserNtegration() {
		return userNtegration;
	}
	public void setUserNtegration(Integer userNtegration) {
		this.userNtegration = userNtegration;
	}
	public long getUserRegistdate() {
		return userRegistdate;
	}
	public void setUserRegistdate(long userRegistdate) {
		this.userRegistdate = userRegistdate;
	}
	public long getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
	public UserStatus getUserStatus() {
		return userStatus;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserSex() {
		return userSex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userSex=" + userSex + ", userPhone="
				+ userPhone + ", userEmail=" + userEmail + ", userGrade="
				+ userGrade + ", userNtegration=" + userNtegration
				+ ", userRegistdate=" + userRegistdate + ", lastLoginTime="
				+ lastLoginTime + ", userStatus=" + userStatus + "]";
	}
	
}