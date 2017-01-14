<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/public/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="${scarecrow}/css/home/regist.css"/>
	<script type="text/javascript" language="javascript" src="${scarecrow}/js/home/regist.js" ></script>
</head>
<body>
	<div class="regtitle">
		<strong><a href="index.action">首页</a>&gt;&gt;用户注册</strong>
	</div>
	<div class="regmain">
		<div class="right">
			<dl>
				<dt>注册须知：</dt>
				<dd>在本站注册的会员，必须遵守《互联网电子公告服务管理规定》，不得在本站发表诽谤他人，侵犯他人隐私，侵犯他人知识产权，传播病毒，政治言论，商业讯息等信息。</dd>
				<dd>在所有在本站发表的文章，本站都具有最终编辑权，并且保留用于印刷或向第三方发表的权利，如果你的资料不齐全，我们将有权不作任何通知使用你在本站发布的作品。</dd>
			</dl>	
		</div>
		<div class="left">
			<form  action="user_home_regist.action" method="post">
				<input type="hidden" name="userStatus.id" value="1"/>
				<table cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td class="td1">用户名：</td>
						<td>
							<input name="userName" type="text" id="textfield" size="30" maxlength="8" />
							<span class="msg"></span>
						</td>
					</tr>
					<tr>
						<td class="td1">密码：</td>
						<td><input name="userPassword" type="password" id="textfield2" size="30" maxlength="12" /> <span class="msg"></span></td>
					</tr>
					<tr>
						<td class="td1">确认密码：</td>
						<td><input name="okPassword" type="password" id="textfield" size="30" maxlength="12" /> <span class="msg"></span></td>
					</tr>
					<tr>
						<td class="td1">性别：</td>
						<td>
							<input type="radio" name="userSex" id="sex1" value="男" checked="checked"/><label for="sex1">男</label>
							<input type="radio" name="userSex" id="sex2" value="女" /><label for="sex2">女</label>
						</td>
					</tr>
					<tr>
						<td class="td1">手机：</td>
						<td><input name="userPhone" type="text" id="textfield" size="30" maxlength="11" /> <span class="msg"></span></td>
					</tr>
					<tr>
						<td class="td1" >电子邮箱：</td>
						<td><input name="userEmail" type="text" id="textfield" size="30" maxlength="30" /> <span class="msg"></span></td>
					</tr>
					<tr>
						<td class="td1">验证码：</td>
						<td><input name="vdcode" type="text" id="textfield" size="8" maxlength="4" />
							<img id="checkImg" class="captchaImage" src="checkImageAction"  title="点击更换验证码">
							 <span class="msg"></span>
						</td>
					</tr>
					<tr>
						<td class="td1">&nbsp;</td>
						<td colspan="2" align="left" valign="middle" height="50">
							<input id="submit" type="image" src="${scarecrow}/image/reg_but1.jpg" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>