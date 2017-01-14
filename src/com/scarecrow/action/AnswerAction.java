package com.scarecrow.action;

import com.scarecrow.bean.Answer;
import com.scarecrow.util.StringFiter;

public class AnswerAction extends BaseAction<Answer> {
	
	private static final long serialVersionUID = 1L;
	
	//保存回复内容
	public void save(){
		currentModel.setAnswerContent(StringFiter.encodeFiter(currentModel.getAnswerContent()));
		currentModel.setAnswerTime(System.currentTimeMillis());
		answerService.saveModel(currentModel);
	}
	
	//查询某个用户的所有帖子
	public String getUserAnswerList(){
		jsonMap.put("totalTwo", (int)(Math.ceil(answerService.getAnswerCountByUserId(key)/Double.parseDouble(rows))));
		jsonMap.put("aList",answerService.queryAnswerByUserId( key, rows, page));
		jsonMap.put("pageTwo", page);
		return "jsonMap";
	}
	
	//根据id删除回复
	public void deleteAnswerById(){
		answerService.deleteModelById(currentModel.getId());
	}
	
	//根据帖子id查询所有的回复
	public String findAnswerByPostId(){
		jsonMap.put("list", answerService.queryAnswerByPostId(currentModel.getPost().getId()));
		return "jsonMap";
	}
}
