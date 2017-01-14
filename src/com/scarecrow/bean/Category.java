package com.scarecrow.bean;

import java.io.Serializable;

public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String  categoryName;
	private long 	createTime;
	private long 	updateTime;
	private CategoryStatus 	categoryStatus;
	private String  categoryExplain;
	public Category() {
	}
	
	public Category(String categoryName, long createTime, long updateTime,
			CategoryStatus categoryStatus, String categoryExplain) {
		super();
		this.categoryName = categoryName;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.categoryStatus = categoryStatus;
		this.categoryExplain = categoryExplain;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	public CategoryStatus getCategoryStatus() {
		return categoryStatus;
	}
	public void setCategoryStatus(CategoryStatus categoryStatus) {
		this.categoryStatus = categoryStatus;
	}
	public String getCategoryExplain() {
		return categoryExplain;
	}
	public void setCategoryExplain(String categoryExplain) {
		this.categoryExplain = categoryExplain;
	}
	
}
