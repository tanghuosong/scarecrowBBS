<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<%@ include file="/public/head.jspf"%>
  	<script type="text/javascript" src="${scarecrow}/js/admin/showCategory.js"></script>
  </head>
<body>
	<div id="content">
		<div id="info">
			<table id="dg" class="easyui-datagrid" >   
			    <thead>   
			        <tr> 
			        	<th data-options="field:'ck',checkbox:true"></th>
	       				<th data-options="field:'id',width:30,sortable:true">编号</th>     
			            <th data-options="field:'categoryName',width:150">模块名称</th>
			            <th data-options="field:'createTime',width:150,formatter:formatTime,sortable:true">创建时间</th>
			            <th data-options="field:'updateTime',width:150,formatter:formatTime,sortable:true">修改时间</th>
			            <th data-options="field:'categoryStatus',width:80,formatter:formatCategoryStatus">模块状态</th>
			            <th data-options="field:'categoryExplain',width:600">模块说明</th>
			        </tr>   
			    </thead>   
			</table>  
		</div>
	</div>
</body>
</html>
