package com.scarecrow.dao;

import java.util.List;

import com.scarecrow.bean.User;

public interface UserDao extends BaseDao<User> {
	
	//登录检测
	public User checkLogin(User user);
	
	//获取最新注册的五个用户
	public List<User> queryNewUserTopFive();
	
	//验证用户名是否可用
	public User checkUserName(String username);
	
	//更新用户状态
	public void updateUserStatus(User user);
	
	//修改用户状态
	public void updateUserLoginTime(User user);
	
	//更新用户积分
	public void updateUserNtegration(User user);

	public List<User> queryUserPageList(String type,String key ,int startRows, int _rows, String sort,
			String order);
}
