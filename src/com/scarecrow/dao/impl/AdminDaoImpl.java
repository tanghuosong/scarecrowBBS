package com.scarecrow.dao.impl;

import com.scarecrow.bean.Admin;
import com.scarecrow.dao.AdminDao;
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {
	
	//后台登录用户检测
	@Override
	public Admin checkLogin(Admin admin) {
		String hql = "From Admin where adminName=:adminName And adminPassword=:adminPassword";
		return (Admin) getSession().createQuery(hql)
				.setString("adminName", admin.getAdminName())
				.setString("adminPassword",admin.getAdminPassword())
				.uniqueResult();
	}
	
}
