<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<%@ include file="/public/head.jspf"%>
  	<link rel="stylesheet" type="text/css" href="${scarecrow}/css/admin/public.css">
  	<script type="text/javascript" src="${scarecrow}/js/admin/updateNotice.js"></script>
</head>
<body>
	<form id="ff" method="post">
	 
		<div class="eachItems">公告编号：<input type="text" name="id" readonly="readonly"> </div>
		<div class="eachItems">属管理员：<input id="cc" name="admin.id"/></div>
		<div class="eachItems">发布时间：<input type="text" name="noticeDate1" readonly="readonly"></div>
	    <div class="eachItems">公告内容：</div><textarea name="noticeContent" rows="15"; cols="43"></textarea>
	    <div>  
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">确认更新</a> 
		</div>
	</form>  
	
</body>
</html>
