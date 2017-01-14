package com.scarecrow.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.scarecrow.dao.BaseDao;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private Class<?> clazz;
	public BaseDaoImpl(){
		ParameterizedType type= (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz=(Class<?>)type.getActualTypeArguments()[0];
	}
	private SessionFactory sessionFactory;
		
	protected Session getSession() {
		//获得session
		return sessionFactory.getCurrentSession();
	}
		
	public void setSessionFactory(SessionFactory sessionFactory){
			this.sessionFactory=sessionFactory;
	}
	
	//保存实体
	@Override
	public void save(T t) {
		getSession().merge(t);
	}

	//更新实体
	@Override
	public void update(T t) {
		getSession().update(t);
	}

	//根据id删除实体
	@Override
	public void delete(int id) {
		String hql = "DELETE "+clazz.getSimpleName()+" WHERE id =:id";
		getSession().createQuery(hql).setInteger("id", id).executeUpdate();	
	}
	
	//根据id s 批量删除实体
	@Override
	public void delete(String ids) {
		String hql = "DELETE "+clazz.getSimpleName()+" WHERE id in ("+ids+")";
		getSession().createQuery(hql).executeUpdate();	
	}
	
	//根据id查询实体
	@Override
	public T get(int id) {
		return (T)getSession().get(clazz, id);
	}
	
	//查询实体列表
	@Override
	public List<T> query() {
		String hql = "FROM "+clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}
	
	//模糊查询获得记录数量
	@Override
	public int getPageRowCount(String type,String key) {
		String hql = "select count(k) from "+clazz.getSimpleName()+" k where "+type+" like :key";
		Number number = (Number)getSession().createQuery(hql).setString("key", "%"+key+"%").uniqueResult();
		return number.intValue();
	}
}
