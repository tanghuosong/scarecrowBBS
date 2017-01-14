package com.scarecrow.dao.impl;

import java.util.List;

import com.scarecrow.bean.Category;
import com.scarecrow.dao.CategoryDao;
@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	//更新模块信息
	@Override
	public void updateCategory(Category category) {
		String hql= "update Category c set c.categoryName=:categoryName," +
				"c.categoryStatus.id=:categoryStatus ,c.categoryExplain =:categoryExplain,c.updateTime=:updateTime where id=:id";
		getSession().createQuery(hql).setString("categoryName", category.getCategoryName())
		.setInteger("categoryStatus", category.getCategoryStatus().getId())
		.setString("categoryExplain", category.getCategoryExplain()).setLong("updateTime", category.getUpdateTime())
		.setInteger("id", category.getId()).executeUpdate();
		
	}

	@Override
	public List<Category> queryCategoryPageList(String type,String key,int startRows, int _rows,
			String sort, String order) {
		String hql = "From Category c LEFT JOIN FETCH c.categoryStatus WHERE c."+type+" like :key order by c."+sort+" "+order;
		return getSession().createQuery(hql).setString("key", "%"+key+"%").setFirstResult(startRows).setMaxResults(_rows).list();
	}

}
