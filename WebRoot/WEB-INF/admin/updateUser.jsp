<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<%@ include file="/public/head.jspf"%>
  	<link rel="stylesheet" type="text/css" href="${scarecrow}/css/admin/public.css">
  	<script type="text/javascript" src="${scarecrow}/js/admin/updateUser.js"></script>
</head>
<body>
	<form id="ff" method="post">
		<div class="eachItems">用户编号：<input type="text" name="id" readonly="readonly"></div>
		<div class="eachItems">用户名称：<input type='text' name='userName' readonly="readonly"></div>
		<div class="eachItems">性　　别：<input type='text' name='userSex' readonly="readonly"/></div>
		<div class="eachItems">手　　机：<input type='text' name='userPhone' readonly="readonly"/></div>
		<div class="eachItems">邮　　箱：<input type='text' name='userEmail' readonly="readonly"/></div>
		<div class="eachItems">等　　级：<input type='text' name='userGrade' readonly="readonly"/></div>
		<div class="eachItems">用户积分：<input type='text' name='userNtegration' readonly="readonly"/></div>
		<div class="eachItems">用户状态：<input id="cc" name="userStatus.id"/></div>
		<div class="eachItems">注册时间：<input type='text' name= 'userRegistdate1' readonly="readonly"></div>
		<div class="eachItems">最近登录：<input type='text' name= 'lastLoginTime1' readonly="readonly"></div>
	    <div>  
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">确认更新</a> 
		</div>
	</form>  
</body>
</html>
