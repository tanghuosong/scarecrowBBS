package com.scarecrow.service;

import java.util.List;

import com.scarecrow.bean.Notice;

public interface NoticeService extends BaseService<Notice>{
	
	//查询最新的公告
	public Notice getCurrentNotice();
	
	//模糊查询公告信息列表
	public List<Notice> queryNoticePageList(String type,String key ,String rows, String page,String sort,String order);
	
	//更新公告信息
	public void updateNotice(Notice notice );
}
