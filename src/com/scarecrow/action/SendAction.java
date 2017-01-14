package com.scarecrow.action;

import com.opensymphony.xwork2.ActionSupport;

public class SendAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		return "success";
	}
}
