package com.scarecrow.bean;

import java.io.Serializable;

public class CategoryStatus implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  statusExplain;
	
	public CategoryStatus() {
		
	}
	public CategoryStatus(Integer id, String statusExplain) {
		super();
		this.id = id;
		this.statusExplain = statusExplain;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatusExplain() {
		return statusExplain;
	}
	public void setStatusExplain(String statusExplain) {
		this.statusExplain = statusExplain;
	}
	
}
