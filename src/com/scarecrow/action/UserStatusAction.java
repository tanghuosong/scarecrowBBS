package com.scarecrow.action;

import com.scarecrow.bean.UserStatus;

public class UserStatusAction extends BaseAction<UserStatus>{
	
	private static final long serialVersionUID = 1L;

	public String queryUserStatus(){
		jsonList = userStatusService.queryModel();
		return "jsonList";
	}
}
