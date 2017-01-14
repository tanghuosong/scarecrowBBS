package com.scarecrow.dao.impl;

import java.util.List;
import com.scarecrow.bean.Notice;
import com.scarecrow.dao.NoticeDao;

@SuppressWarnings("unchecked")
public class NoticeDaoImpl extends BaseDaoImpl<Notice> implements NoticeDao {
	
	//查询最新的公告
	@Override
	public Notice getCurrentNotice() {
		String hql= "From Notice n LEFT JOIN FETCH n.admin  order by n.noticeDate desc";
		return (Notice) getSession().createQuery(hql).setFirstResult(0).setMaxResults(1).uniqueResult();
	}
	
	//更新公告信息
	@Override
	public void updateNotice(Notice notice) {
		String hql= "update Notice n set n.admin = :admin ,n.noticeContent = :noticeContent where id=:id";
		getSession().createQuery(hql).setParameter("admin", notice.getAdmin()).setString("noticeContent", notice.getNoticeContent())
		.setInteger("id", notice.getId()).executeUpdate();
		
	}

	//查询所有公告信息
	@Override
	public List<Notice> queryNoticeList() {
		String hql= "From Notice n LEFT JOIN FETCH n.admin  order by n.id desc";
		return getSession().createQuery(hql).list();
	}

	@Override
	public List<Notice> queryNoticePageList(String type,String key ,int startRows, int rows,
			String sort, String order) {
		String hql = "From Notice n LEFT JOIN FETCH n.admin WHERE n."+type+" like :key order by n."+sort+" "+order;
		return getSession().createQuery(hql).setString("key", "%"+key+"%").setFirstResult(startRows).setMaxResults(rows).list();
	}
}
