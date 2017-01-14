<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf" %>
	<link rel="icon" href="${scarecrow}/image/logo.jpg">
	<link rel="stylesheet" type="text/css" href="${scarecrow}/css/admin/index.css">
	<script type="text/javascript" src="${scarecrow}/js/admin/index.js"></script>
</head>
<body>
   	<div id="cc" class="easyui-layout" style="width:100%;height:100%;">  
	    <div id="header_title" data-options="region:'north',title:'欢迎来到稻草人论坛后台管理系统',split:false,collapsible:false" style="height:160px;">
	    	<div id="title">稻草人论坛后台管理系统</div>
	    	<div id="admin">管理员：${admin.adminName}</div>
	    </div>   
	    <div data-options="region:'west',title:'系统操作',split:false,collapsible:false" style="width:200px;">
	    	<!--以下是左菜单选项 -->
			<div id="aa" class="easyui-accordion"   style="width:190px;">  
				<div title="公告管理"  data-options="iconCls:'icon-tip',selected:true"  style="padding:5px;">
			    	<ul>
						<li><a href="#" title="send_admin_showNotice.action">公告管理</a></li>
					</ul>
			    </div>  
			    <div title="模块管理"  data-options="iconCls:'icon-filter'"  style="padding:5px;">
			    	<ul>
						<li><a href="#" title="send_admin_showCategory.action">模块管理</a></li>
					</ul>
			    </div> 
			    <div title="用户管理" data-options="iconCls:'icon-man'"  style="padding:5px;">
					<ul>
						<li><a href="#" title="send_admin_showUser.action">用户管理</a></li>
					</ul>
			    </div>    
			    <div title="帖子管理" data-options="iconCls:'icon-post'"  style="padding:5px;">
			    	<ul>
						<li><a href="#" title="send_admin_showPost.action">帖子管理</a></li>
					</ul>
			    </div>   
			</div>  
	    </div>   
	    <div data-options="region:'center',title:'操作展示'"  style="padding:1px;background:#fff;">
	    	<div id="tt" class="easyui-tabs" data-options="fit:true">   
			    <div title="系统缺省页面" style="padding:20px;">   
			       	欢迎来到稻草人论坛后台管理系统
			    </div>   
			</div>  
	    </div>  
	</div>  
	<div id="win" data-options="draggable:false,collapsible:false,minimizable:false,maximizable:false,modal:true"></div> 
</body>
</html>
