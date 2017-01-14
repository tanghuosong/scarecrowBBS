package com.scarecrow.service.impl;

import java.util.List;

import com.scarecrow.bean.Post;
import com.scarecrow.service.PostService;

public class PostServiceImpl extends BaseServiceImpl<Post> implements PostService {
	
	//通过帖子id查询帖子，并且抓取查询发帖用户
	@Override
	public Post getPostFetchUserByPostId(Integer id) {
		return postDao.getPostByPostId(id);
	}
	
	//查询每个分类下的前十个最新发表的帖子
	@Override
	public List<Post> queryEachCategoryPostTopTen(){
		return postDao.queryEachCategoryPostTopTen();
	}
	
	//根据分类id获取某个分类下的帖子数量
	@Override
	public int getPageRowCount(String categoryId) {
		return postDao.getRowCount(categoryId);
	}
	
	//获取当前页信息
	@Override
	public List<Post> queryPostByPage(String categoryId , String page ,String rows) {
		int _page = Integer.parseInt(page);
		int _rows = Integer.parseInt(rows);
		int startRows = _rows *(_page-1);
		return postDao.queryPostByPage(categoryId, startRows, _rows);
	}
	
	//通过用户id 获取帖子列表总数
	@Override
	public int getPostCountByUserId(String userId) {
		return postDao.getPostCountByUserId(userId);
	}
	
	//通过用户id获取帖子列表
	@Override
	public List<Post> queryPostByUserId(String userId, String rows, String page) {
		int _page = Integer.parseInt(page);
		int _rows = Integer.parseInt(rows);
		int startRows = _rows *(_page-1);
		return postDao.queryPostByUserId(userId, startRows, _rows);
	}

	//后台获取模糊查询当前分页的帖子列表
	@Override
	public List<Post> queryPostPageList(String type,String key ,String rows,
			String page,String sort,String order) {
		int _page = Integer.parseInt(page);
		int _rows = Integer.parseInt(rows);
		int startRows = _rows *(_page-1);
		return postDao.queryPostPageList( type, key ,startRows,_rows,sort,order);
	}

	//更新帖子浏览量
	@Override
	public void updatePostViews(Post post) {
		postDao.updatePostViews(post);
	}
	
	//更新帖子分类信息
	@Override
	public void updatePostCategory(Post post) {
		postDao.updatePostCategory(post);
	}

}
