package com.scarecrow.service.impl;

import java.util.List;

import com.scarecrow.bean.Category;
import com.scarecrow.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	
	//后台获取记录总数
	@Override
	public int getPageRowCount(String type,String key) {
		return categoryDao.getPageRowCount(type, key);
	}
	
	//后台分页查询分类列表
	@Override
	public List<Category> queryCategoryPageList(String type,String key, String rows,String page,String sort,String order) {
		int _page = Integer.parseInt(page);
		int _rows = Integer.parseInt(rows);
		int startRows = _rows *(_page-1);
		return categoryDao.queryCategoryPageList(type,key,startRows, _rows,sort,order);
	}
	
	//更新类别
	@Override
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}
	
}
