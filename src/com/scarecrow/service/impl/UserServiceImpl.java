package com.scarecrow.service.impl;

import java.util.List;

import com.scarecrow.bean.User;
import com.scarecrow.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	//验证登录
	@Override
	public User checkLogin(User user) {
		return userDao.checkLogin(user);
	}
	
	//获取最新注册的五个用户
	@Override
	public List<User> queryNewUserTopFive() {
		return userDao.queryNewUserTopFive();
	}
	
	//验证用户名是否可用
	@Override
	public String checkUserName(String username) {
		String result;
		//查询到有该用户存在！
		if(userDao.checkUserName(username)!=null){
			result = "true";
		}else{
			result = "false";
		}
		return result;
	}
	
	//通过关键字模糊查询用户信息数量
	@Override
	public int getPageRowCountByKey(String type,String key){
		return userDao.getPageRowCount(type, key);
	}
	
	//通过关键字模糊查询用户信息
	@Override
	public List<User> queryUserPageList(String type,String key ,String rows,String page,String sort,String order) {
		int _page = Integer.parseInt(page);
		int _rows = Integer.parseInt(rows);
		int startRows = _rows *(_page-1);
		return userDao.queryUserPageList(type, key, startRows, _rows,sort,order);
	}

	//更新用户状态
	@Override
	public void updateUserStatus(User user) {
		userDao.updateUserStatus(user);
	}
	
	//更新用户登录时间
	@Override
	public void updateUserLoginTime(User user) {
		userDao.updateUserLoginTime(user);
	}

	//更新用户积分
	@Override
	public void updateUserNtegration(User user) {
		userDao.updateUserNtegration(user);
	}
	
}
