package com.scarecrow.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scarecrow.service.AdminService;
import com.scarecrow.service.AnswerService;
import com.scarecrow.service.CategoryService;
import com.scarecrow.service.CategoryStatusService;
import com.scarecrow.service.NoticeService;
import com.scarecrow.service.PostService;
import com.scarecrow.service.UserService;
import com.scarecrow.service.UserStatusService;
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware, ApplicationAware, ModelDriven<T>{
	private static final long serialVersionUID = 1L;
/**
 * 这是基本的action，封装了所有action的共同特性
 * 
 * **/
	//service 层注入
	protected UserService 	userService;
	protected AdminService 	adminService;
	protected CategoryService categoryService;
	protected NoticeService	noticeService;
	protected PostService 	postService;
	protected AnswerService	answerService;
	protected UserStatusService userStatusService;
	protected CategoryStatusService categoryStatusService;
	//模型驱动注入，自动获取当前类
	protected T currentModel;
	//域对象注入
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	//json对象
	protected Map<String, Object> jsonMap = new HashMap<String, Object>();//json对象
	protected List<T> jsonList = new ArrayList<T>();
	protected InputStream inputStream;
	//图片上传参数注入
	protected File		fileImage;
	protected String 	fileImageFileName;
	//模糊查询参数注入
	protected String key;//查找的关键字
	protected String type;//查找的类型
	//后台EasyUI分页参数注入
	protected String rows;//每页显示的记录数  
	protected String page;//当前第几页  
	protected String sort="id";
	protected String order="desc";
	//批量删除id注入
	protected  String ids;
	public void setIds(String ids) {
		this.ids = ids;
	}
	/**
	 * get、set方法
	 * */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}
	public void setUserStatusService(
			UserStatusService userStatusService) {
		this.userStatusService = userStatusService;
	}
	public UserStatusService getUserStatusService() {
		return userStatusService;
	}
	public void setCategoryStatusService(
			CategoryStatusService categoryStatusService) {
		this.categoryStatusService = categoryStatusService;
	}
	@SuppressWarnings("unchecked")
	@Override
	public T getModel() {
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		Class<?> clazz=(Class<?>) type.getActualTypeArguments()[0];
		try {
			currentModel= (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return currentModel;
	}

	@Override
	public void setSession(Map<String, Object> request) {
		this.request = request;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setRequest(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	public Map<String, Object> getApplication() {
		return application;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public List<T> getJsonList() {
		return jsonList;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setFileImage(File fileImage) {
		this.fileImage = fileImage;
	}
	public void setFileImageFileName(String fileImageFileName) {
		this.fileImageFileName = fileImageFileName;
	}
	public void setFileImageContentType(String postImageContentType) {
	}
	public void setKey(String key) throws UnsupportedEncodingException {
		this.key = URLDecoder.decode(key,"utf-8");
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public void setOrder(String order) {
		this.order = order;
	}	
}
