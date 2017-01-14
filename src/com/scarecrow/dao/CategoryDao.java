package com.scarecrow.dao;

import java.util.List;

import com.scarecrow.bean.Category;

public interface CategoryDao  extends BaseDao<Category>{

	public void updateCategory(Category category);

	public List<Category> queryCategoryPageList(String type, String key, int startRows, int _rows,
			String sort, String order);
}
