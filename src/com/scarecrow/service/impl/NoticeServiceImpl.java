package com.scarecrow.service.impl;

import java.util.List;

import com.scarecrow.bean.Notice;
import com.scarecrow.service.NoticeService;

public class NoticeServiceImpl extends BaseServiceImpl<Notice> implements NoticeService {
	
	//查询最新的公告
	@Override
	public Notice getCurrentNotice() {
		return noticeDao.getCurrentNotice();
	}
	
	//模糊查询公告
	@Override
	public List<Notice> queryNoticePageList(String type,String key,String _rows,
			String page,String sort,String order) {
		int _page = Integer.parseInt(page);
		int rows = Integer.parseInt(_rows);
		int startRows = rows *(_page-1);
		return noticeDao.queryNoticePageList(type, key ,startRows, rows,sort,order);
	}
	
	//更新公告信息
	@Override
	public void updateNotice(Notice notice) {
		noticeDao.updateNotice(notice);
	}
	
	
}
