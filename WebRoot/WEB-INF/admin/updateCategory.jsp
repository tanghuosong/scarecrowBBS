<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<%@ include file="/public/head.jspf"%>
  	<link rel="stylesheet" type="text/css" href="${scarecrow}/css/admin/public.css">
  	<script type="text/javascript" src="${scarecrow}/js/admin/updateCategory.js"></script>
</head>
<body>
	<form id="ff" method="post">
		<div class="eachItems">模块编号：<input type="text" name="id" readonly="readonly"></div>
		<div class="eachItems">模块名称：<input type='text' name='categoryName'></div>
		<div class="eachItems">模块状态：<input id="cc" name='categoryStatus.id'></div>
		<div class="eachItems">创建时间：<input type='text' name= 'createTime1' readonly="readonly"></div>
    	<div class="eachItems">模块说明：</div><textarea rows='20' cols='60' name='categoryExplain'></textarea>
	    <div>  
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">确认修改</a> 
		</div>
	</form>  
</body>
</html>
