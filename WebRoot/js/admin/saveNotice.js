$(function(){
	$('#btn').click(function(){    
		$('#ff').form('submit', {
			url:'notice_admin_saveNotice.action',   
			success:function(data){    
				parent.$('#win').window('close');
				var aaaa=parent.$("iframe[title='公告管理']").get(0).contentWindow.$("#dg").datagrid("reload");
			}    
		}); 
	});   
});