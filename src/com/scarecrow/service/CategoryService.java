package com.scarecrow.service;

import java.util.List;

import com.scarecrow.bean.Category;

public interface CategoryService extends BaseService<Category>{
	
	//获取记录总数
	public int getPageRowCount(String type,String key); 
	
	//后台分页查询分类列表
	public List<Category> queryCategoryPageList(String type, String key,String rows,String page,String sort,String order);
	
	
	public void updateCategory(Category category);
}
