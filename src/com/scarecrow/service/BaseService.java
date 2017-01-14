package com.scarecrow.service;

import java.util.List;

public interface BaseService<T> {
	
	public void saveModel(T t);
	
	public T getModel(Integer id);
	
	public List<T> queryModel();
	
	public void deleteModelById(Integer id);

	public void deleteModelByIds(String ids);
	
	public void updateModel(T t);
	
	public int getRowCount(String type, String key);
}
