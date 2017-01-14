<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="/public/header.jsp"%>
	<link  rel="stylesheet" type="text/css" href="${scarecrow}/css/home/post.css">
    <script type="text/javascript" src="${scarecrow}/js/home/post.js"></script>
</head>
<body>
	<div class="post">
		<strong><a href="index.action">首页</a>&gt;&gt;发帖</strong>
	</div>
	<div class="post_container">
		<form action="post_home_save.action" method="post" enctype="multipart/form-data">
			<ul>
				<input type="hidden" name="user.id" value="${user.id }">
				<li><label>主题:</label><input type="text" name="postTitle" id="postContent" ><span class="message"></span></li>
				<li><label>类别:</label>
					<select name="category.id">
						<c:forEach items="${clist}" var="category" >
							<option value="${category.id}">${category.categoryName}</option>
						</c:forEach>
					</select>
				</li>
				<li><label>我想说:</label><pre><textarea rows="20" cols="80" name="postContent" ></textarea></pre></li>
				<li><label>图片:</label><input type="file" name="fileImage" id="fileImage"/></li>
				<li><span id="fileType"></span>　　<span id="fileSize"></span></li>
				<li><input type="submit" value="发表"></li>
			</ul>
		</form>
	</div>
</body>
</html>