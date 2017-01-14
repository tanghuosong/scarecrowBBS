package com.scarecrow.bean;

import java.io.Serializable;

public class Admin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String  adminName;
	private String  adminPassword;
	private int		adminPermission;
	
	public Admin() {
	}
	public Admin(Integer id, String adminName, String adminPassword,
			int adminPermission) {
		this.id = id;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminPermission = adminPermission;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName
				+ ", adminPassword=" + adminPassword + ", adminPermission="
				+ adminPermission + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public int getAdminPermission() {
		return adminPermission;
	}
	public void setAdminPermission(int adminPermission) {
		this.adminPermission = adminPermission;
	}
}
