package com.scarecrow.dao.impl;

import java.util.List;
import com.scarecrow.bean.Answer;
import com.scarecrow.dao.AnswerDao;

@SuppressWarnings("unchecked")
public class AnswerDaoImpl extends BaseDaoImpl<Answer> implements AnswerDao{
	public AnswerDaoImpl() {
	}
	//根据帖子id查询其回复
	@Override
	public List<Answer> queryAnswerByPostId(Integer postId) {
		String hqlString = "From Answer a JOIN FETCH a.post JOIN FETCH a.user where a.post.id=:postId";
		return getSession().createQuery(hqlString).setInteger("postId", postId).list();
	}
	
	//通过user id 查询该用户所有回复的数量
	@Override
	public int getAnswerCountByUserId(String Uid) {
		String hql = "select count(a) from Answer a where a.user.id=:userId";
		Number number = (Number)getSession().createQuery(hql).setString("userId", Uid).uniqueResult();
		return number.intValue();
	}
	
	//通过user id 查询该用户所有回复列表
	@Override
	public List<Answer> queryAnswerByUserId(String userId, int startRows,
			int rows) {
		String hql = "From Answer a left join fetch a.post p join fetch p.user join fetch p.category where a.user.id=:userId order by a.id desc";
		return getSession().createQuery(hql).setString("userId", userId).setFirstResult(startRows).setMaxResults(rows).list();
	}
	
}
