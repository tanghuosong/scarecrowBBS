package com.scarecrow.service.impl;

import java.util.List;

import com.scarecrow.bean.Answer;
import com.scarecrow.service.AnswerService;

public class AnswerServiceImpl extends BaseServiceImpl<Answer> implements AnswerService {
	
	//根据帖子id查询其回复
	@Override
	public List<Answer> queryAnswerByPostId(Integer postId) {
		return answerDao.queryAnswerByPostId(postId);
	}
	
	//
	@Override
	public int getAnswerCountByUserId(String userId) {
		return answerDao.getAnswerCountByUserId(userId);
	}
	
	//
	@Override
	public List<Answer> queryAnswerByUserId(String userId, String rows, String page) {
		int _page = Integer.parseInt(page);
		int _rows = Integer.parseInt(rows);
		int startRows = _rows *(_page-1);
		return answerDao.queryAnswerByUserId(userId, startRows, _rows);
	}
}
