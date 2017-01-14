package com.scarecrow.dao;

import java.util.List;

import com.scarecrow.bean.Notice;

public interface NoticeDao extends BaseDao<Notice>{
	
	//查询最新的公告
	public Notice getCurrentNotice();
	
	//更新公告信息：所属管理员和公告内容
	public void updateNotice(Notice notice);
	
	//查询所有公告信息
	public List<Notice> queryNoticeList();

	public List<Notice> queryNoticePageList(String type,String key ,int startRows, int rows,
			String sort, String order);
}
