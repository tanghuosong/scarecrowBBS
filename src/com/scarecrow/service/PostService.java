package com.scarecrow.service;

import java.util.List;

import com.scarecrow.bean.Post;

public interface PostService extends BaseService<Post>{
	
	//查询每个分类下的前十个最新发表的帖子
	public List<Post> queryEachCategoryPostTopTen();
	
	//通过帖子id查询帖子详情，并且抓取查询发帖用户
	public Post getPostFetchUserByPostId(Integer id);
	
	//根据分类id获取当前分类的记录总数
	public int getPageRowCount(String categoryId);
	
	//查询当前页的信息
	public List<Post> queryPostByPage(String categoryId,String page ,String rows);
	
	//更新帖子浏览量
	public void updatePostViews(Post post);
	
	//通过用户id查询帖子记录数
	public int getPostCountByUserId(String userId);
	
	//通过用户id查询帖子列表
	public  List<Post> queryPostByUserId(String userId,String rows,String page);
	
	//后台获取模糊查询当前页的帖子
	public List<Post> queryPostPageList(String type,String key ,String rows,String page,String sort,String order);

	//更新帖子分类信息
	public void updatePostCategory(Post post);
}
