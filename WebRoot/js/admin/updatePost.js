$(function(){
	var dg = parent.$("iframe[title='帖子管理']").get(0).contentWindow.$("#dg");
	var rows = dg.datagrid("getSelections");
	$('#cc').combobox({    
	    url:'category_admin_queryCategory.action',    
	    valueField:'id',    
	    textField:'categoryName',
	    panelHeight:'auto',
	    editable:false
	}); 
	$('#ff').form('load',{
		id:rows[0].id,
		postTitle:rows[0].postTitle,
		userName:rows[0].user.userName,
		postTime1:formatTime(rows[0].postTime),
		'category.id':rows[0].category.id,
		postContent:rows[0].postContent
	});
	 
	 $('#btn').click(function(){    
		 $('#ff').form('submit', {
			    url:'post_admin_updatePost.action',   
			    success:function(data){    
			        parent.$('#win').window('close');
			        dg.datagrid("reload");
			    }    
		}); 
	  });   

});
