<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>稻草人论坛后台管理系统</title>
	<%@include file="/public/head.jspf" %>
	<link rel="stylesheet" type="text/css" href="${scarecrow}/css/admin/login.css">
</head>
<body>
 	<div id="header">
		<div class="header_title">
			<span class="title_con">稻草人论坛后台管理系统</span>
		</div>
	</div>
	<div id="content">
	<center>
		<div class="con">
			<div class="con_title">
				<span class="con_title_sp">欢迎登录稻草人论坛后台管理系统</span>
			</div>
			<div class="con_panel">
				<form action="admin_admin_login.action" method="post">
					<div class="con_input">
						<span>用户名：</span><input name="adminName" type="text"/>
					</div>
					<div class="con_input">
						<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input name="adminPassword" type="password"/>
					</div>
					<div class="con_select">
						<input type="radio" name="adminPermisson" value="普通管理员" />普通管理员
						<input type="radio" name="adminPermisson" value="超级管理员" />超级管理员
					</div>
					<div class="message"> ${message}</div>
					<input type="reset" value="重    置" class="submit-btn"/>
					<input type="submit" value="登    录" class="submit-btn"/>
				</form>
			</div>
		</div>
	</center>
	</div>
</body>
</html>
