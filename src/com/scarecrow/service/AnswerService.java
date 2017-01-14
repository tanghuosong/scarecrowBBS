package com.scarecrow.service;

import java.util.List;

import com.scarecrow.bean.Answer;

public interface AnswerService extends BaseService<Answer>{
	
	//通过帖子id查询帖子的回复
	public List<Answer> queryAnswerByPostId(Integer postId);
	
	//根据用户id获取回帖数量
	public int getAnswerCountByUserId(String key);
	
	//根据用户id查询贴子列表
	public List<Answer> queryAnswerByUserId(String key, String rows, String page);
}
