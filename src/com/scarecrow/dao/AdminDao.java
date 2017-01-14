package com.scarecrow.dao;

import com.scarecrow.bean.Admin;

public interface AdminDao extends BaseDao<Admin> {

	public Admin checkLogin(Admin admin);
	
	
}
