package com.scarecrow.action;

import com.scarecrow.bean.CategoryStatus;

public class CategoryStatusAction extends BaseAction<CategoryStatus>{
	
	private static final long serialVersionUID = 1L;

	public String queryCategoryStatus(){
		jsonList = categoryStatusService.queryModel();
		return "jsonList";
	}
}
