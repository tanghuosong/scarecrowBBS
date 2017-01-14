$(function(){
	var userName = /^[a-zA-Z\u2E80-\u9FFF]{1,8}[0-9]{0,7}/;
	var userPassword = /^[a-zA-Z0-9]{8,16}$/;
	var emailVal = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
	var phoneVal=/^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
	$("input[name='userName']").blur(function(){
		if(!$(this).val().match(userName)){
			$(this).next(".msg").html("<font color='red'>*用户名必须是字母、汉字、数字，且以字母或汉字开头！</font>");
			return false;
		}else if(!$(this).val()){
			$(this).next(".msg").html("<font color='red'>*请输入用户名</font>");
			return false;
		}else if($(this).val().length<2||$(this).val().length>8){
			$(this).next(".msg").html("<font color='red'>*用户名长度在2到8之间</font>");
			return false;
		}else{
			$.get("user_home_checkUserName.action", { key:encodeURI(encodeURI($(this).val())) },
				  function(data){
					//查到有该用户名
					if(data=="true"){
						$("input[name='userName']").next(".msg").html("<font color='red'>*用户名已经被注册！</font>");
						return false;
					}else if(data=="false"){
						$("input[name='userName']").next(".msg").html("<font color='green'>√</font>");
					}
			},"text");
		}
	});
	$("input[name='userPassword']").blur(function(){
		if(!$(this).val().match(userPassword)){
			$(this).next(".msg").html("<font color='red'>*密码必须是字母和数字组成，且长度在8到16之间！</font>");
			return false;
		}else if(!$(this).val()){
			$(this).next(".msg").html("<font color='red'>*请输入密码</font>");
			return false;
		}else{
			$(this).next(".msg").html("<font color='green'>√</font>");
		}
	});
	$("input[name='okPassword']").blur(function(){
		if(!$(this).val()){
			$(this).next(".msg").html("<font color='red'>*请确认登录密码</font>");
			return false;
		}else if($(this).val()!=$("input[name='userPassword']").val()){
			$(this).next(".msg").html("<font color='red'>*两次密码不一致</font>");
			return false;
		}else{
			$(this).next(".msg").html("<font color='green'>√</font>");
		}
	});
	$("input[name='userEmail']").blur(function(){
		if(!$(this).val()){
			$(this).next(".msg").html("<font color='red'>*请输入电子邮件地址</font>");
			return false;
		}else if(!$("input[name='userEmail']").val().match(emailVal)){
			$(this).next(".msg").html("<font color='red'>*邮箱格式不正确！</font>");
			return false;
		}else{
			$(this).next(".msg").html("<font color='green'>√</font>");
		}	
	});
	$("input[name='userPhone']").blur(function(){
		if(!$(this).val()){
			$(this).next(".msg").html("<font color='red'>*请输入手机号</font>");
			return false;
		}else if(!$("input[name='userPhone']").val().match(phoneVal)){
			$(this).next(".msg").html("<font color='red'>*手机号码格式不正确！</font>");
			return false;
		}else{
			$(this).next(".msg").html("<font color='green'>√</font>");
		}
	});
	$("input[name='vdcode']").blur(function(){
		if(!$(this).val()){
			$(this).next("img").next(".msg").html("<font color='red'>*请输入验证码</font>");
			return false;
		}else{
			$(this).next("img").next(".msg").html("");
			$.get("user_home_checkCode.action", { vdcode:$(this).val()},function(data){
				if(data=="true"){
					$("input[name='vdcode']").next("img").next(".msg").html("<font color='green'>√</font>");
					return true;
				}else if(data=="false"){
					$("input[name='vdcode']").next("img").next(".msg").html("<font color='red'>验证码错误！</font>");
					return false;
				}
			},"text");
		}
	});
	$("#submit").click(function(){
		var userName = $("input[name='userName']");
		var userPassword = $("input[name='userPassword']");
		var okPassword = $("input[name='okPassword']");
		var userEmail = $("input[name='userEmail']");
		var userPhone = $("input[name='userPhone']");
		var vdCode = $("input[name='vdcode']");
//		var phoneVal=/^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
//		var emailVal = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		if(!userName.val()){
			userName.next(".msg").html("<font color='red'>*请输入用户名</font>");
			return false;
		}else if(userName.val().length<2||userName.val().length>8){
			$(this).next(".msg").html("<font color='red'>*用户名长度在2到8之间</font>");
			return false;
		}
		if(!userPassword.val()){
			userPassword.next(".msg").html("<font color='red'>*请输入密码</font>");
			return false;
		}
		if(!okPassword.val()){
			okPassword.next(".msg").html("<font color='red'>*请输入确认密码</font>");
			return false;
		}else if(okPassword.val()!=userPassword.val()){
			okPassword.next(".msg").html("<font color='red'>*两次密码不一致</font>");
		}else{
			okPassword.next(".msg").html("<font color='green'>√</font>");
		}
		if(!userPhone.val()){
			userPhone.next(".msg").html("<font color='red'>*请输入手机号</font>");
			return false;
		}else if(!userPhone.val().match(phoneVal)){
			userPhone.next(".msg").html("<font color='red'>*手机号码格式不正确！</font>");
			return false;
		}else{
			userPhone.next(".msg").html("<font color='green'>√</font>");
		}
		if(!userEmail.val()){
			userEmail.next(".msg").html("<font color='red'>*请输入邮箱地址</font>");
			return false;
		}else if(!userEmail.val().match(emailVal)){
			userEmail.next(".msg").html("<font color='red'>*邮箱格式不正确！</font>");
			return false;
		}else{
			userEmail.next(".msg").html("<font color='green'>√</font>");
		}	
		if(!vdCode.val()){
			vdCode.next(".msg").html("<font color='red'>*请输入验证码</font>");
			return false;
		}
	});
	$("#checkImg").click(function(){
		$(this).attr("src","${pageContext.request.contextPath}/checkImageAction.action?flag="+new Date().getTime());
	});
	
});
