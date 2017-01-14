<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<%@ include file="/public/header.jsp" %>
 	<link rel="stylesheet" type="text/css" href="${scarecrow}/css/home/postList.css">
	<script type="text/javascript" src="${scarecrow}/js/home/postList.js"></script>
</head>
<body>
	<div class="category_list">
		<div class="category_title">
			<strong><a href="index.action">首页</a>&gt;&gt;分类</strong>
		</div>
		<div id="content"></div>
		<div id="error"></div>
		<div id="pp" style="background:#efefef;border:1px solid #ccc;"></div> 
	</div>
</body>
</html>
