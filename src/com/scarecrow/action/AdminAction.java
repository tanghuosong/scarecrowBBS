package com.scarecrow.action;

import com.opensymphony.xwork2.ActionContext;
import com.scarecrow.bean.Admin;

public class AdminAction extends BaseAction<Admin> {
	
	private static final long serialVersionUID = 1L;
	//登录
	public String login(){
		currentModel=adminService.checkLogin(currentModel);
		if(currentModel==null){
			session.put("message", "用户名或密码错误！");
			return "login";
		}
		ActionContext.getContext().getApplication().put("admin", currentModel);
		return "index";
	}
	
	//查询所有的管理员
	public String queryAdmin(){
		jsonList = adminService.queryModel();
		return "jsonList";
	}
}
