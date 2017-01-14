$(function(){
	$('#cc').combobox({    
	    url:'categoryStatus_admin_queryCategoryStatus.action',    
	    valueField:'id',    
	    textField:'statusExplain',
	    panelHeight:'auto',
	    editable:false
	}); 
	 $('#btn').click(function(){    
		 $('#ff').form('submit', {
		    url:'category_admin_saveCategory.action',   
		    success:function(data){    
		        parent.$('#win').window('close');
		        parent.$("iframe[title='模块管理']").get(0).contentWindow.$("#dg").datagrid("reload");
		    }    
		}); 
	  });   
});