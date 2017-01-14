package com.scarecrow.dao.impl;

import java.util.List;

import com.scarecrow.bean.User;
import com.scarecrow.dao.UserDao;
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	public UserDaoImpl(){	
	}
	
	//登录验证
	@Override
	public User checkLogin(User user) {
		String hql= "FROM User WHERE userName=:userName AND userPassword=:userPassword ";
		return (User) getSession().createQuery(hql).setString("userName", user.getUserName()).setString("userPassword", user.getUserPassword()).uniqueResult(); 
	}
	
	//查询最新注册的五个用户
	@Override
	public List<User> queryNewUserTopFive() {
		String hql = "FROM User order by id desc";
		List<User> ulist = getSession().createQuery(hql).setFirstResult(0).setMaxResults(5).list();
		return ulist;
	}
	
	//检测用户名是否存在
	@Override
	public User checkUserName(String username) {
		String hql = "From User where userName=:username";
		return (User) getSession().createQuery(hql).setString("username", username).uniqueResult();
	}
	
	//修改用户状态
	@Override
	public void updateUserStatus(User user) {
		String hql= "update User u set u.userStatus = :userStatus where id=:id";
		getSession().createQuery(hql).setParameter("userStatus", user.getUserStatus()).setInteger("id", user.getId()).executeUpdate();
	}
	
	//更新用户登录时间
	@Override
	public void updateUserLoginTime(User user) {
		String hql= "update User u set u.lastLoginTime=:lastLoginTime where id=:id";
		getSession().createQuery(hql).setLong("lastLoginTime", user.getLastLoginTime()).setInteger("id", user.getId()).executeUpdate();
	}
	
	//更新用户积分
	@Override
	public void updateUserNtegration(User user) {
		String hql= "update User u set userNtegration =:userNtegration where id=:id";
		getSession().createQuery(hql).setInteger("userNtegration", user.getUserNtegration()).setInteger("id", user.getId()).executeUpdate();
	}

	@Override
	public List<User> queryUserPageList(String type,String key ,int startRows, int _rows, String sort,
			String order) {
		String hql = "From User u LEFT JOIN FETCH u.userStatus WHERE u."+type+" like :key order by u."+sort+" "+order;
		return getSession().createQuery(hql).setString("key", "%"+key+"%").setFirstResult(startRows).setMaxResults(_rows).list();
	}
}