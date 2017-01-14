package com.scarecrow.dao;

import java.util.List;


public interface BaseDao<T> {
	
	public void save(T t);
	
	public void update(T t);

	public void delete(int id);
	
	public void delete(String ids);
	
	public T get(int id);
	
	public List<T> query();
	
	public int getPageRowCount(String type,String key);
	
}
