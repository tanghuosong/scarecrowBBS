package com.scarecrow.action;

import com.scarecrow.bean.Notice;

public class NoticeAction extends BaseAction<Notice>{

	private static final long serialVersionUID = 1L;
	
	//保存公告信息
	public void saveNotice(){
		currentModel.setNoticeDate(System.currentTimeMillis());
		noticeService.saveModel(currentModel);
	}
	
	//模糊查询公告信息
	public String queryNotice(){
		jsonMap.put("total",noticeService.getRowCount(type, key));
		jsonMap.put("rows", noticeService.queryNoticePageList(type,key, rows,page,sort,order));
		return "jsonMap";
	}
	
	//更新公告信息
	public void updateNotice(){
		noticeService.updateNotice(currentModel);
	}
	
	//通过id删除公告信息
	public void deleteNotice(){
		noticeService.deleteModelById(currentModel.getId());
	}
	
	//通过id s删除公告信息
	public void deleteNoticeByIds(){
		noticeService.deleteModelByIds(ids);
	}
}
