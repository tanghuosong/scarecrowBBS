package com.scarecrow.service;

import com.scarecrow.bean.Admin;

public interface AdminService extends BaseService<Admin>{

	Admin checkLogin(Admin admin);
	
}
