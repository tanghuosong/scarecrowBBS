package com.scarecrow.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import com.scarecrow.dao.AdminDao;
import com.scarecrow.dao.AnswerDao;
import com.scarecrow.dao.BaseDao;
import com.scarecrow.dao.CategoryDao;
import com.scarecrow.dao.CategoryStatusDao;
import com.scarecrow.dao.NoticeDao;
import com.scarecrow.dao.PostDao;
import com.scarecrow.dao.UserDao;
import com.scarecrow.dao.UserStatusDao;
import com.scarecrow.service.BaseService;

@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements BaseService<T> {
	
	private Class<?> clazz;
	
	public BaseServiceImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<?>) type.getActualTypeArguments()[0];
	}
	
	@PostConstruct
	public void Init(){
		String clazzName = clazz.getSimpleName();
		String daoName = clazzName.substring(0, 1).toLowerCase()+clazzName.substring(1)+"Dao";
		try {
			Field classField = this.getClass().getSuperclass().getDeclaredField(daoName);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, classField.get(this));
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@SuppressWarnings("rawtypes")
	protected BaseDao baseDao;
	protected AdminDao adminDao;
	protected UserDao  userDao;
	protected UserStatusDao  userStatusDao;
	protected CategoryDao categoryDao;
	protected CategoryStatusDao  categoryStatusDao;
	protected NoticeDao noticeDao;
	protected PostDao	postDao;
	protected AnswerDao answerDao;
	
	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public AnswerDao getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}
	
	public void setUserStatusDao(UserStatusDao userStatusDao) {
		this.userStatusDao = userStatusDao;
	}
	public UserStatusDao getUserStatusDao() {
		return userStatusDao;
	}
	public void setCategoryStatusDao(
			CategoryStatusDao categoryStatusDao) {
		this.categoryStatusDao = categoryStatusDao;
	}

	@Override
	public void saveModel(T t) {
		baseDao.save(t);
	}

	@Override
	public T getModel(Integer id) {
		return (T) baseDao.get(id);
	}

	@Override
	public List<T> queryModel() {
		return baseDao.query();
	}

	@Override
	public void deleteModelById(Integer id) {
		baseDao.delete(id);
	}

	@Override
	public void deleteModelByIds(String ids) {
		baseDao.delete(ids);
	}

	@Override
	public void updateModel(T t) {
		baseDao.update(t);
	}

	@Override
	public int getRowCount(String type, String key) {
		return baseDao.getPageRowCount(type, key);
	}
}
