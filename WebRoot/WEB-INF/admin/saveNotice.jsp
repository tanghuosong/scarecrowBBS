<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<%@ include file="/public/head.jspf"%>
  	<link rel="stylesheet" type="text/css" href="${scarecrow}/css/admin/public.css">
  	<script type="text/javascript" src="${scarecrow}/js/admin/saveNotice.js"></script>
</head>
<body>
	<form id="ff" method="post">   
	    <div class="eachItems">公告内容：</div><textarea name="noticeContent" rows="15"; cols="50"></textarea>   
	    <input type="hidden" name="admin.id" value="${admin.id}">
	    <div>  
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">发布公告</a> 
		</div>
	</form>  
</body>
</html>
