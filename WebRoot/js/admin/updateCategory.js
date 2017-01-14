$(function(){
	var dg = parent.$("iframe[title='模块管理']").get(0).contentWindow.$("#dg");
	var rows = dg.datagrid("getSelections");
	$('#cc').combobox({    
	    url:'categoryStatus_admin_queryCategoryStatus.action',    
	    valueField:'id',    
	    textField:'statusExplain',
	    panelHeight:'auto',
	    editable:false
	}); 
	$('#ff').form('load',{
		id:rows[0].id,
		"categoryStatus.id":rows[0].categoryStatus.id,
		createTime1:formatTime(rows[0].createTime),
		categoryName:rows[0].categoryName,
		categoryExplain:rows[0].categoryExplain
	});
	 $('#btn').click(function(){    
		 $('#ff').form('submit', {
			    url:'category_admin_updateCategory.action',   
			    success:function(data){    
			        parent.$('#win').window('close');
			        dg.datagrid("reload");
			    }    
		}); 
	  });   

});
