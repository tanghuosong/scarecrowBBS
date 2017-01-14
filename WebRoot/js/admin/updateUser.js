$(function(){
	var dg = parent.$("iframe[title='用户管理']").get(0).contentWindow.$("#dg");
	var rows = dg.datagrid("getSelections");
	$('#cc').combobox({    
	    url:'userStatus_admin_queryUserStatus.action',    
	    valueField:'id',    
	    textField:'statusExplain',
	    panelHeight:'auto',
	    editable:false
	}); 
	
	$('#ff').form('load',{
		id:rows[0].id,
		userName:rows[0].userName,
		userSex:rows[0].userSex,
		userPhone:rows[0].userPhone,
		userEmail:rows[0].userEmail,
		userGrade:rows[0].userGrade,
		userNtegration:rows[0].userNtegration,
		'userStatus.id':rows[0].userStatus.id,
		userRegistdate1:formatTime(rows[0].userRegistdate),
		lastLoginTime1:formatTime(rows[0].lastLoginTime)
	});
	 
	 $('#btn').click(function(){    
		 $('#ff').form('submit', {
			    url:'user_admin_updateUserStatus.action',   
			    success:function(data){    
			        parent.$('#win').window('close');
			        dg.datagrid("reload");
			    }    
		}); 
	  });   
});


