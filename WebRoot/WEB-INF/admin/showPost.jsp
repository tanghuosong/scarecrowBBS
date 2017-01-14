<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<script type="text/javascript" src="${scarecrow}/js/admin/showPost.js"></script>
</head>
<body>
	<input id="ss" style="width:300px"/> 
	<div id="mm" style="width:120px"> 
		<div data-options="name:'user.userName',iconCls:'icon-ok'">通过用户名查询</div> 
		<div data-options="name:'category.categoryName',iconCls:'icon-ok'">通过分类查询</div>
		<div data-options="name:'id',iconCls:'icon-ok'">通过id查询</div>
	</div> 
	<table id="dg" class="easyui-datagrid">   
	    <thead>   
	        <tr> 
	        	<th data-options="field:'ck',width:50,checkbox:true"></th>
      			<th data-options="field:'id',width:50,sortable:true">编号</th>     
	            <th data-options="field:'postTitle',width:180">标题</th>   
	            <th data-options="field:'postContent',width:400">内容</th>   
	            <th data-options="field:'postImage',width:200">图片</th>
	            <th data-options="field:'postViews',width:80,sortable:true">浏览量</th>
	            <th data-options="field:'category',width:100,formatter:formatCategory">分类</th>
	            <th data-options="field:'user',width:50,formatter:formatUser">用户</th>
	            <th data-options="field:'postTime',width:130,formatter:formatTime,sortable:true">发帖时间</th>
	        </tr>   
	    </thead>
	</table>  
</body>
</html>
