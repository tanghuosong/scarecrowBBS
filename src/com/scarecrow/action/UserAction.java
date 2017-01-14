package com.scarecrow.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.scarecrow.bean.User;
import com.scarecrow.util.MD5;

public class UserAction extends BaseAction<User>{
	
	private static final long serialVersionUID = 1L;
	
	private String result;
	public void setResult(String result) {
		this.result = result;
	}
	private String vdcode;
	public void setVdcode(String vdcode) {
		this.vdcode = vdcode;
	}
	//检测注册时用户名是否可用
	public String checkUserName() throws IOException{
		result= userService.checkUserName(URLDecoder.decode(key,"utf-8"));
		inputStream = new ByteArrayInputStream(result.getBytes());
		return "stream";
	}
	
	//验证验证码是否正确
	public String checkCode() throws IOException{
		String checkcode = (String)ActionContext.getContext().getSession().get("checkcode");
		if(vdcode.equalsIgnoreCase(checkcode)){
			//验证码正确
			result = "true";
		}else{
			//验证码错误
			result = "false";
		}
		inputStream = new ByteArrayInputStream(result.getBytes());
		return "stream";
	}
	
	//用户注册
	public String regist() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		//md5 加密密码
		String str = MD5.encoderByMd5(currentModel.getUserPassword());
		currentModel.setUserPassword(str);
		currentModel.setUserRegistdate(System.currentTimeMillis());
		currentModel.setLastLoginTime(System.currentTimeMillis());
		currentModel.setUserGrade(1);
		currentModel.setUserNtegration(0);
		userService.saveModel(currentModel);
		return "index";
	}
	
	//登录
	public String login() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		//md5加密比对
		currentModel.setUserPassword(MD5.encoderByMd5(currentModel.getUserPassword()));
		currentModel=userService.checkLogin(currentModel);
		if(currentModel==null){
			result="0";
		}else if(currentModel.getUserStatus().getId()==2){
			result = "2";
		}else{
			currentModel.setUserNtegration(currentModel.getUserNtegration()+1);
			currentModel.setLastLoginTime(System.currentTimeMillis());
			userService.updateUserLoginTime(currentModel);
			userService.updateUserNtegration(currentModel);
			ActionContext.getContext().getSession().put("user", currentModel);
			result="1";		
		}
		jsonMap.put("result", result);
		return "jsonMap";
	}
	
	//退出登录
	public void exit() {
		currentModel=(User)ServletActionContext.getContext().getSession().get("user");
		if(currentModel!=null){
			ActionContext.getContext().getSession().remove("user");
		}
	}
	
	//后台模糊查询用户信息
	public String queryUser(){
		jsonMap.put("total",userService.getPageRowCountByKey(type, key));
		jsonMap.put("rows", userService.queryUserPageList(type, key ,rows,page,sort,order));
		return "jsonMap";
	}
	
	//通过id删除用户信息
	public void deleteUserById(){
		userService.deleteModelById(currentModel.getId());
	}
	
	//通过id s删除用户信息
	public void deleteUserByIds(){
		userService.deleteModelByIds(ids);
	}
	
	//修改用户状态
	public void updateUserStatus(){
		userService.updateUserStatus(currentModel);
	}
	
	//访客进入个人空间时先查询该主人信息，返回主人信息
	public String visitPersonal(){
		ActionContext.getContext().getSession().put("personal", userService.getModel(currentModel.getId()));
		return "success";
	}
}
