<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:import url="/public/header.jsp"/>
    <title>稻草人论坛</title>
    <link href="${pageContext.request.contextPath}/css/home/index.css" rel="stylesheet" type="text/css" /> 
    <script  type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/home/index.js"></script>  
</head>
<body>
	<s:action name="index"/>
    <div class="index_container" >
    	 <div class="index_info">
            <div class="index_notice">
            	<span class="index_span">论　坛　公　告</span>
				<p>　　${notice.noticeContent}</p>
            </div>
            <div class="index_roll">
            	<span class="index_span" >新　人　报　道</span>
            	<div id="FontScroll">
				    <ul>
				    	<c:forEach items="${ulist}" var="user">
				    		<li>欢迎--><a href="javascript:void(0);">${user.userName}</a>-加入稻草人</li>
				    	</c:forEach>
				    </ul>
				</div>
            </div>
            <div class="index_stick">
                <span  class="index_span">我　要　发　帖</span>
                <a href="send_home_post.action">
	                <div class="stick_circle">
	                	<img src="${pageContext.request.contextPath}/image/pen.jpg">
	                </div>
                </a>
            </div>
        </div>
        <c:forEach items="${clist}" var="category">
        <div class="index_module">
            <div class="module_title">
                <span class="title_left">${category.categoryName}</span>
                <span class="title_right"><a href="send_home_postList.action?key=${category.id}">更多&gt;&gt;</a></span>
            </div>
            <div class="module_content">
                <ol>
					<c:forEach items="${pList}" var="post">
						<c:if test="${post.category.id==category.id}">
		                  	<li><a href="post_home_detail.action?id=${post.id}&userId=${post.user.id}">${post.postTitle}</a></li>
		                </c:if>
	   				</c:forEach>
                </ol>
            </div>
        </div>
        </c:forEach>
        <div class="footer">
		</div>
    </div>  
</body>
</html>