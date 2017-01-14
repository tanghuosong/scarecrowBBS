<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<%@ include file="/public/head.jspf"%>
  	<link rel="stylesheet" type="text/css" href="${scarecrow}/css/admin/public.css">
  	<script type="text/javascript" src="${scarecrow}/js/admin/updatePost.js"></script>
</head>
<body>
	<form id="ff" method="post">
		<div class="eachItems">帖子编号：<input type="text" name="id" readonly="readonly"></div>
		<div class="eachItems">帖子标题：<input type='text' name='postTitle' readonly="readonly"></div>
		<div class="eachItems">帖子类别：<input id="cc" name="category.id"/></div>
		<div class="eachItems">所属用户：<input type='text' name='userName' readonly="readonly"/></div>
		<div class="eachItems">创建时间：<input type='text' name= 'postTime1' readonly="readonly"></div>
    	<div class="eachItems">帖子内容：</div><textarea rows='15' cols='50' name='postContent' readonly="readonly"></textarea>
	    <div>  
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">确认更新</a> 
		</div>
	</form>  
</body>
</html>
