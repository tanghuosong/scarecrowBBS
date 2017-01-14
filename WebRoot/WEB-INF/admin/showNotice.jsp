<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<%@ include file="/public/head.jspf"%>
  	<script type="text/javascript" src="${scarecrow}/js/admin/showNotice.js">
	</script>
  </head>
<body>
	<input id="ss" style="width:300px"></input> 
	<div id="mm" style="width:120px"> 
		<div data-options="name:'admin.adminName',iconCls:'icon-ok'">所属管理员查询</div> 
		<div data-options="name:'id',iconCls:'icon-ok'">通过帖子id查询</div> 
	</div> 
	<div id="info">
		<table id="dg" class="easyui-datagrid" >   
		    <thead>   
		        <tr> 
		        	<th data-options="field:'ck',checkbox:true"></th>
       				<th data-options="field:'id',width:50,sortable:true">编号</th>     
		            <th data-options="field:'noticeContent',width:450">公告内容</th>   
		            <th data-options="field:'noticeDate',width:200,formatter:formatTime,sortable:true">发布时间</th>   
		            <th data-options="field:'admin.id',width:60,formatter:formatAdmin">所属管理员</th>
		        </tr>   
		    </thead>   
		</table>
	</div>
</body>
</html>
