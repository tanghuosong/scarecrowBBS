<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
  	<script type="text/javascript" src="${scarecrow}/js/admin/showUser.js"></script>
</head>
<body>
	<input id="ss" style="width:300px"></input> 
	<div id="mm" style="width:120px"> 
		<div data-options="name:'userName',iconCls:'icon-ok'">通过用户名查询</div> 
		<div data-options="name:'id',iconCls:'icon-ok'">通过编号查询</div>
	</div> 
	<table id="dg" class="easyui-datagrid">   
	    <thead>   
	        <tr> 
	        	<th data-options="field:'ck',width:50,checkbox:true"></th>
      				<th data-options="field:'id',width:50,sortable:true">编号</th>     
	            <th data-options="field:'userName',width:150">用户名</th>      
	            <th data-options="field:'userSex',width:50">性别</th>
	            <th data-options="field:'userPhone',width:150">手机</th>
	            <th data-options="field:'userEmail',width:150">邮箱</th>
	            <th data-options="field:'userGrade',width:50,sortable:true">等级</th>
	            <th data-options="field:'userNtegration',width:50,sortable:true">积分</th>
	            <th data-options="field:'userRegistdate',width:150,formatter:formatTime,sortable:true">注册时间</th>
	            <th data-options="field:'lastLoginTime',width:150,formatter:formatTime,sortable:true">上次登录时间</th>
	            <th data-options="field:'userStatus',width:60,formatter:formatUserStatus" >用户状态</th> 
	        </tr>   
	    </thead>   
	</table>
</body>
</html>
