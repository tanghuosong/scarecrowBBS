package com.scarecrow.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.scarecrow.bean.Post;
import com.scarecrow.util.StringFiter;

public class PostAction extends BaseAction<Post> {
	private static final long serialVersionUID = 1L;
	
	//保存帖子信息
	public String save() throws IOException{
		currentModel.setPostTitle(StringFiter.encodeFiter(currentModel.getPostTitle()));
		currentModel.setPostContent(StringFiter.encodeFiter(currentModel.getPostContent()));
		currentModel.setPostTime(System.currentTimeMillis());
		if(fileImage!=null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/postPicture");
			//定义新的名称:user_id_当前时间戳.后缀名
			String newName =currentModel.getUser().getId()+"_"+ new Date().getTime()+"."+fileImageFileName.substring(fileImageFileName.lastIndexOf(".")+1); 
			File diskFile = new File(realPath+"//"+newName);
			FileUtils.copyFile(fileImage, diskFile);
			currentModel.setPostImage("postPicture/"+newName);
		}else{
			currentModel.setPostImage("0null0");
		}
		postService.saveModel(currentModel);
		return "save";
	}
	
	//获取某个分类下的帖子分页处理
	public String queryPostListByCategoryId(){
		//获取总记录数
		jsonMap.put("total", postService.getPageRowCount(key));
		//获取当前页记录列表
		jsonMap.put("pList1", postService.queryPostByPage(key, page, rows));
		return "jsonMap";
	}
	
	//查询帖子详情
	public String detail(){
		Post post=postService.getPostFetchUserByPostId(currentModel.getId());
		post.setPostViews(post.getPostViews()+1);
		postService.updatePostViews(post);
		ActionContext.getContext().put("aList", answerService.queryAnswerByPostId(currentModel.getId()));
		ActionContext.getContext().put("post", post);
		return "success";
	}
	
	//关键字查询帖子信息
	public String queryPost(){
		jsonMap.put("total",postService.getRowCount(type, key));
		jsonMap.put("rows", postService.queryPostPageList(type,key ,rows,page,sort,order));
		return "jsonMap";
	}
	
	//通过id删除帖子
	public void deletePostById(){
		postService.deleteModelById(currentModel.getId());
	}
	
	//通过id s删除帖子
	public void deletePostByIds(){
		postService.deleteModelByIds(ids);
	}
	
	//查询某个用户的所有帖子
	public String getUserPostList(){
		jsonMap.put("totalOne", (int)(Math.ceil(postService.getPostCountByUserId(key)/Double.parseDouble(rows))));
		jsonMap.put("pList",postService.queryPostByUserId( key, rows, page));
		jsonMap.put("pageOne", page);
		return "jsonMap";
	}
	
	//更新帖子信息
	public void updatePost(){
		postService.updatePostCategory(currentModel);
	}
}
