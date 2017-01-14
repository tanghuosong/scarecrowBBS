$(function(){
	/**页面加载请求服务器数据**/
	$('#dg').datagrid({
		pagination:true,
		pageSize: 10,//每页显示的记录条数，默认为5  
		pageList: [10, 15, 20],//可以设置每页记录条数的列表  
		rownumbers:true,
		loadMsg: "数据加载中...",
		idField:"id",
		url: "notice_admin_queryNotice.action?type=id"+"&&key=",
		toolbar: [{ 
            text: '修改公告', 
            iconCls: 'icon-edit', 
            handler: function() { 
            	var rows = $('#dg').datagrid('getSelections');
            	if(rows.length==1){
		        	parent.$('#win').window({ 
		        		title:'修改公告',
		        	    width:400,    
		        	    height:450,  
		        	    content:"<iframe src='send_admin_updateNotice.action' frameborder='0' width='100%' height='100%'/>",
		        	    modal:true
		        	});
            	}else {
            		$.messager.show({
            			title:'温馨提示',
            			msg:'请选择一条信息进行修改！',
            			timeout:3000,
            			showType:'slide'
            		});
            	}
            } 
        }, '-',{ 
            text: '发布公告', 
            iconCls: 'icon-add', 
            handler: function(){
            	parent.$('#win').window({ 
            		title:'发布公告',
            	    width:430,    
            	    height:400,  
            	    content:"<iframe src='send_admin_saveNotice.action' frameborder='0' width='100%' height='100%'/>",
            	    modal:true
            	}); 
            } 
        }, '-',{ 
            text: '删除', 
            iconCls: 'icon-remove', 
            handler: function(){
		         var rows = $('#dg').datagrid('getSelections');
		         if(rows.length!=0){
		        	 var ids=rows[0].id;
		        	 for(var key=1 ;key<rows.length;key++){
		        		 ids=ids+","+rows[key].id;
		        	 }
		        	 $.messager.confirm('温馨提示', '确定删除吗？', function(r){
		        			if (r){
		        				$.post("notice_admin_deleteNoticeByIds", { ids: ids },
		        					function(data){
		        					 $.messager.show({
				            			title:'温馨提示',
				            			msg:'删除成功！',
				            			timeout:3000,
				            			showType:'slide'
					            	});
					            	 $('#dg').datagrid('reload');
					            	 $('#dg').datagrid('uncheckAll');
		        				});
		        			}
		        		});
		         }else{
		        	 $.messager.show({
            			title:'温馨提示',
            			msg:'请选择要删除的数据！',
            			timeout:3000,
            			showType:'slide'
	            	});
		         }
            } 
        }]
	});
	/**搜索数据***/
	$('#ss').searchbox({ 
		searcher:function(value,name){
			$('#dg').datagrid({
				rownumbers:true,
				idField:"id",
				pagination:true,
				pageSize: 10,//每页显示的记录条数，默认为10 
				pageList: [10, 15, 20],//可以设置每页记录条数的列表  
				url: "notice_admin_queryNotice.action?type="+name+"&&key="+encodeURI(encodeURI(value))+"",
			});
		}, 
		menu:'#mm', 
		prompt:'请输入关键字' 
	});
	var p = $('#dg').datagrid('getPager');  
	$(p).pagination({  
		pageNumber:1,
		beforePageText: '第',//页数文本框前显示的汉字  
		afterPageText: '页    共 {pages} 页',  
		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
});
function formatAdmin(val,row){    
    return row.admin.adminName;
}  