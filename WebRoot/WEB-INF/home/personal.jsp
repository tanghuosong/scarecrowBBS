<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:import url="/public/header.jsp"/>
	<title>个人主页</title>
	<link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home/personal.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/home/personal.js"></script>
</head>
<body>
	<div class="personal">
			<strong><a href="index.action">首页</a>&gt;&gt;个人主页</strong>
		</div>
	<c:choose>
	<c:when test="${user!=null}">
		<div id="personal_container">
			<div id="personal_info">
				<div class="personal_title">
					<span class="title_left">我的信息</span>
					<span class="title_right"><a href="#">修改资料</a></span>
				</div>
				<div id="my_info">
					<div class="info_left">
						<div class="center_each"><span>我的名字:</span>${user.userName}</div>
						<div class="center_each"><span>我的头像:</span></div>
						<div class="head_image"></div>	
					</div>
					<div class="info_center">
						<div class="center_each"><span>我的性别:</span>${user.userSex}</div>
						<div class="center_each"><span>我的等级:</span>${user.userGrade}</div>
						<div class="center_each"><span>我的积分:</span>${user.userNtegration}</div>
						<div class="center_each"><span>我的邮箱:</span>${user.userEmail}</div>
						<div class="center_each"><span>我的手机:</span>${user.userPhone}</div>
					</div>
					<div class="info_right"></div>
				</div>
			</div>
			<div id="personal_post">
				<div class="personal_title">
					<span class="title_left">我的帖子</span>
					<span class="title_right"><a href="send_home_post.action">
						<img src="${pageContext.request.contextPath}/image/pen.jpg">我要发帖</a>
					</span>
				</div>
				<div id="post_list">
					<ul></ul>
				</div>
				<div class="page_info"></div>
			</div>
			<div id="personal_answer">
				<div class="personal_title">
					<span class="title_left">我的回帖</span>
				</div>
				<div id="answer_list">
					<ul></ul>
				</div>
				<div class="page_info"></div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div id="error_info">抱歉！您已经退出登录，个人信息无法显示！</div>
	</c:otherwise>
	</c:choose>
</body>
</html>