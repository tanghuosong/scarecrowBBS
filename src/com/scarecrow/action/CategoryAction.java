package com.scarecrow.action;

import com.scarecrow.bean.Category;

public class CategoryAction extends BaseAction<Category>{
	private static final long serialVersionUID = 1L;
	
	//添加分类
	public void saveCategory(){
		currentModel.setCreateTime(System.currentTimeMillis());
		currentModel.setUpdateTime(System.currentTimeMillis());
		categoryService.saveModel(currentModel);
	}
	
	//后台分页显示分类
	public String showCategory(){
		jsonMap.put("total",categoryService.getPageRowCount(type,key));
		jsonMap.put("rows", categoryService.queryCategoryPageList(type,key,rows,page,sort,order));
		return "jsonMap";
	}
	
	//查询所有类别信息
	public String queryCategory(){
		jsonList= categoryService.queryModel();
		return "jsonList";
	}
	
	//通过id删除分类信息
	public void deleteCategoryById(){
		categoryService.deleteModelById(currentModel.getId());
	}
	
	//通过id删除分类信息
	public void deleteCategoryByIds(){
		categoryService.deleteModelByIds(ids);
	}
	
	//更新类别
	public void updateCategory(){
		currentModel.setUpdateTime(System.currentTimeMillis());
		categoryService.updateCategory(currentModel);
	}
}
