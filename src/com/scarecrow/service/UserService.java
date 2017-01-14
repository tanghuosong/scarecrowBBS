package com.scarecrow.service;

import java.util.List;

import com.scarecrow.bean.User;

public interface UserService extends BaseService<User> {
	
	//验证登录
	public User checkLogin(User user);
	
	//获取最新注册的五个用户
	public List<User> queryNewUserTopFive();
	
	//验证用户名是否可用
	public String checkUserName(String username);

	//通过关键字模糊查询用户信息数量
	public int getPageRowCountByKey(String type,String key );
	
	//通过关键字模糊查询用户信息
	public List<User> queryUserPageList(String type,String key ,String rows,String page,String sort,String order);
	
	//修改登录时间
	public void updateUserLoginTime(User user);
		
	//更新用户状态
	public void updateUserStatus(User user);
	
	//更新用户积分
	public void updateUserNtegration(User user);
	
}
