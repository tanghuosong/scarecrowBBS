$(function(){
	var dg = parent.$("iframe[title='公告管理']").get(0).contentWindow.$("#dg");
	var rows = dg.datagrid("getSelections");
	$('#cc').combobox({    
	    url:'admin_admin_queryAdmin.action',    
	    valueField:'id',    
	    textField:'adminName',
	    panelHeight:'auto',
	    editable:false
	}); 
	$('#ff').form('load',{
		id:rows[0].id,
		'admin.id':rows[0].admin.id,
		noticeDate1:formatTime(rows[0].noticeDate),
		noticeContent:rows[0].noticeContent
	});
	 $('#btn').click(function(){    
		 $('#ff').form('submit', {
			    url:'notice_admin_updateNotice.action',   
			    success:function(data){    
			        parent.$('#win').window('close');
			        dg.datagrid("reload");
			    }    
		}); 
	  });   
});