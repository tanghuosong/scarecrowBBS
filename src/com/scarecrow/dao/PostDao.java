package com.scarecrow.dao;

import java.util.List;

import com.scarecrow.bean.Post;

public interface PostDao extends BaseDao<Post> {

	//查询每个分类下的前十个最新发表的帖子
	public List<Post> queryEachCategoryPostTopTen();
	
	//根据分类id查询帖子数量
	public int getRowCount(String categoryId);
	
	//分页查询帖子信息
	public List<Post> queryPostByPage(String categoryId, int pageStart, int pageSize);
	
	//更新帖子浏览量
	public void updatePostViews(Post post);
	
	//通过用户id查询帖子列表记录总数
	public int getPostCountByUserId(String userId);
	
	//通过用户id查询帖子列表
	public List<Post> queryPostByUserId(String userId, int startRows, int rows);

	public void updatePostCategory(Post post);

	//根据帖子id查询帖子详细信息
	public Post getPostByPostId(Integer id);

	//后台查询当前页信息
	public List<Post> queryPostPageList(String type,String key ,int startRows, int _rows, String sort,
			String order);
}
