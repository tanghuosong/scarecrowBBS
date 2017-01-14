package com.scarecrow.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.scarecrow.bean.Category;
import com.scarecrow.bean.Notice;
import com.scarecrow.bean.Post;
import com.scarecrow.bean.User;

public class IndexAction extends BaseAction<Category>{

	private static final long serialVersionUID = 1L;
	public String execute(){
		//一，查询当前公告
		Notice notice = noticeService.getCurrentNotice();
		ActionContext.getContext().getSession().put("notice", notice);
		//二，查询所有的分类
		List<Category> cList=categoryService.queryModel();
		ActionContext.getContext().getSession().put("clist", cList);
		//三、查询每个分类下的最新发表的十个帖子
		List<Post> pList = postService.queryEachCategoryPostTopTen();
		ActionContext.getContext().getSession().put("pList", pList);
		//三，查询最新注册的前五个人
		List<User> uList = userService.queryNewUserTopFive();
		ActionContext.getContext().getSession().put("ulist", uList);
		return "success";
	}
}
