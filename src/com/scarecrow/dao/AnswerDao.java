package com.scarecrow.dao;

import java.util.List;

import com.scarecrow.bean.Answer;

public interface AnswerDao extends BaseDao<Answer> {
	
	//根据帖子id查询其回复
	public List<Answer> queryAnswerByPostId(Integer postId);
	
	//根据用户id查询回帖数量
	public int getAnswerCountByUserId(String userId);

	//根据用户id查询回帖列表
	public List<Answer> queryAnswerByUserId(String userId, int startRows, int rows);

	
}
