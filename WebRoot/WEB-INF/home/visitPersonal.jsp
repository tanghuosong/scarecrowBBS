<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<link  rel="stylesheet" type="text/css" href="${scarecrow}/css/home/visitPersonal.css">
    <script type="text/javascript" src="${scarecrow}/js/home/visitPersonal.js"></script>
</head>
<body>
	<div class="visit_personal">
		<strong><a href="index.action">首页</a>&gt;&gt; ${personal.userName}的个人主页</strong>
	</div>
	<div class="visit_container">
		<input type="hidden" name="user.id" value="${personal.id}"/>
		<div class="container_left">
			<div class="left_top">
				${personal.userName }
			</div>
			<div class="left_bottom">分类的列表</div>
		</div>
		<div id="container_right" class="container_right"></div>
	</div>
</body>
</html>