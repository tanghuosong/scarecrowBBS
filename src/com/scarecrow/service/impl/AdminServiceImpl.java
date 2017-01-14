package com.scarecrow.service.impl;

import com.scarecrow.bean.Admin;
import com.scarecrow.service.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

	@Override
	public Admin checkLogin(Admin admin) {
		
		return adminDao.checkLogin(admin);
	}
}
