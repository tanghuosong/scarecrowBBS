<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="/public/header.jsp"%>
	<link  rel="stylesheet" type="text/css" href="${scarecrow }/css/home/detail.css">
    <script type="text/javascript" src="${scarecrow }/js/home/detail.js"></script>
</head>
<body>
<jsp:useBean id="dateValue" class="java.util.Date"/> 
	<div class="detail">
		<strong><a href="index.action">首页</a>&gt;&gt;帖子详情</strong>
	</div>
	<div class="detail_container">
		<div class="author">
			<div class="author_info">
				<div class="author_image">
					<c:if test="${post.user.userSex=='男'}">
						<img src="${scarecrow }/image/boy.jpg">
					</c:if>
					<c:if  test="${post.user.userSex=='女'}">
						<img src="${scarecrow }/image/girl.jpg">
					</c:if></div>
				<div class="info_detail">楼主:${post.user.userName }</div>
				<div class="info_detail">等级:${post.user.userGrade }</div>
				<div class="info_detail">积分:${post.user.userNtegration }</div>
			</div>
			<div class="post_info">
				<input type="hidden" name="post.id" value="${post.id}"/>
				<div class="post_title"><h1>${post.postTitle}</h1></div>
				<div class="post_content">
					<div class="post_text"><pre>${post.postContent}</pre></div>
					<c:if test="${post.postImage!='0null0'}">
						<div class="post_image"><img alt="图片加载失败" src="${scarecrow }/${post.postImage}"/></div>
					</c:if>
				</div>
			</div>
			<div class="post_other">
				<span>阅读量【${post.postViews}】</span>
				<span>评论【${aList.size()}】</span>
				<span>发表时间：<jsp:setProperty name="dateValue" property="time" value="${post.postTime}"/>
					<fmt:formatDate value="${dateValue}" pattern="yyyy年MM月dd日 HH:mm:ss"/></span>
			</div>
			<div id="ckepop" class="post_other" style="margin-left:40px;margin-bottom:30px;">
				<a href="http://www.jiathis.com/share/?uid=902489" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank">分享到：</a>
				<a class="jiathis_button_tools_2"></a>
				<a class="jiathis_button_tools_3"></a>
				<a class="jiathis_button_tools_6"></a>
				<a class="jiathis_button_tools_7"></a>
				<a class="jiathis_button_tools_5"></a>
				<a class="jiathis_button_tools_4"></a>
				<a class="jiathis_button_tools_1"></a>
			</div>
		</div>
		<div class="discuss">
			<c:choose>
			<c:when test="${user!=null}">
			<div class="discuss_content">
				<form action="#" method="post">
					<input type="hidden" name="postId" value="${post.id}">
					<span>我要评论：</span><textarea id="textarea" rows="5" cols="90" name="answerContent"></textarea>
					<input type="button" id="submit" value="发表">
				</form>
			</div>
			</c:when>
			<c:otherwise>
				<div class="discuss_error">
					<p><img alt="#" src="${scarecrow }/image/lock.jpg">你还没有登录，<a href="#" class="userLogin">点我登录</a>后方可评论！</p>
				</div>
			</c:otherwise>
			</c:choose>
		</div>
		<div id="content"></div>
		<div id="answer_error"></div>
	</div>
</body>
<script type="text/javascript" src="http://v2.jiathis.com/code/jia.js?uid=902489" charset="utf-8"></script>
</html>