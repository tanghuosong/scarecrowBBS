var userId = document.getElementById("user.id").value;
$(function(){
	$.post("post_home_getUserPostList.action",{type:"user.id",key:userId,rows:rows,page:1},function(data){
		showPost(data);
		$.post("answer_home_getUserAnswerList.action",{type:"user.id",key:userId,rows:rows,page:1},function(data){
			showAnswer(data);
		});
	});
});

function showPost(data){
	var postContent ="<li>" +
	"<span class='cols1'>帖子标题</span>" +
	"<span class='cols2'>发帖时间</span>" +
	"<span class='cols3'>浏览量</span>" +
	"<span class='cols4'>所属分类</span>" +
	"<span class='cols3'>删除</span>" +
	"</li>";
	for(var index in data.pList){
		postContent += "<li>" +
			"<span class='cols1'><a href='post_home_detail.action?id="+data.pList[index].id+"'>"+data.pList[index].postTitle+"</a></span>" +
			"<span class='cols2'>"+formatTime(data.pList[index].postTime)+"</span>" +
			"<span class='cols3'>"+data.pList[index].postViews+"</span>" +
			"<span class='cols4'>"+data.pList[index].category.categoryName+"</span>" +
			"<span class='cols3'><a  href='javascript:void(0)' onclick='deletePost(this)' title='post_home_deletePost?id="+data.pList[index].id+"'>删除</a></span>" +
			"</li>";
	}
	var pageContent = "<span>共"+data.totalOne+"页,</span>" +
			"<span>当前第"+data.pageOne+"页</span>";
	if(data.pageOne!=1){
		pageContent+="<a href='javascript:void(0)' onclick='upPage(this.title)' title='post_home_getUserPostList.action?type=user.id&&key="+userId+"&&rows=5&&page="+subOne(data.pageOne)+"'>上一页</a>";
	}
	if(data.pageOne<data.totalOne){
		pageContent+="<a href='javascript:void(0)' onclick='upPage(this.title)' title='post_home_getUserPostList.action?type=user.id&&key="+userId+"&&rows=5&&page="+addOne(data.pageOne)+"'>下一页</a>";
	}
	$("#post_list ul").html(postContent);
	$("#personal_post .page_info").html(pageContent);
}
function showAnswer(data){
	var answerContent ="<li>" +
	"<span class='cols1'>帖子标题</span>" +
	"<span class='cols3'>作者</span>" +
	"<span class='cols2'>回帖时间</span>" +
	"<span class='cols4'>所属分类</span>" +
	"<span class='cols3'>删除</span>" +
	"</li>";
	for(var index in data.aList){
		answerContent += "<li>" +
			"<span class='cols1'><a href='post_home_detail.action?id="+data.aList[index].post.id+"'>"+data.aList[index].post.postTitle+"</a></span>" +
			"<span class='cols3'>"+data.aList[index].post.user.userName+"</span>" +
			"<span class='cols2'>"+formatTime(data.aList[index].answerTime)+"</span>" +
			"<span class='cols4'>"+data.aList[index].post.category.categoryName+"</span>" +
			"<span class='cols3'><a  href='javascript:void(0)' onclick='deletePost(this)' title='answer_home_deleteAnswer?id="+data.aList[index].id+"'>删除</a></span>" +
			"</li>";
	}
	var pageAnswerContent = "<span>共"+data.totalTwo+"页,</span>" +
			"<span>当前第"+data.pageTwo+"页</span>";
	if(data.pageTwo!=1){
		pageAnswerContent+="<a href='javascript:void(0)' onclick='upAnswerPage(this.title)' title='answer_home_getUserAnswerList.action?type=user.id&&key="+userId+"&&rows=5&&page="+subOne(data.pageTwo)+"'>上一页</a>";
	}
	if(data.pageTwo<data.totalTwo){
		pageAnswerContent+="<a href='javascript:void(0)' onclick='upAnswerPage(this.title)' title='answer_home_getUserAnswerList.action?type=user.id&&key="+userId+"&&rows=5&&page="+addOne(data.pageTwo)+"'>下一页</a>";
	}
	$("#answer_list ul").html(answerContent);
	$("#personal_answer .page_info").html(pageAnswerContent);
}

function deletePost(obj){
	var href = obj.title;
	if(confirm("确定删除吗？")){
		$.ajax({
			   type: "POST",
			   url: href,
			   success: function(msg){
				   $(obj).parent().parent().remove();
			   }
		});
	}
}
function upPage(href){
	$.ajax({
		   type: "POST",
		   url: href,
		   dataType:"json",
		   success: function(data){
			   showPost(data);
		   }  
	});
}
function upAnswerPage(href){
	$.ajax({
		   type: "POST",
		   url: href,
		   dataType:"json",
		   success: function(data){
			   showAnswer(data);
		   }  
	});
}
function addOne(page){
	return parseInt(page)+1;
}
function subOne(page){
	return parseInt(page)-1;
}
function formatTime(milliseconds) {
    if (milliseconds != "" && milliseconds != null
            && milliseconds != "null") {
        var datetime = new Date();
        datetime.setTime(milliseconds);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1 < 10 ? "0"
                + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var date = datetime.getDate() < 10 ? "0" + datetime.getDate()
                : datetime.getDate();
        var hour = datetime.getHours() < 10 ? "0" + datetime.getHours()
                : datetime.getHours();
        var minute = datetime.getMinutes() < 10 ? "0"
                + datetime.getMinutes() : datetime.getMinutes();
        var second = datetime.getSeconds() < 10 ? "0"
                + datetime.getSeconds() : datetime.getSeconds();
        return year + "-" + month + "-" + date + " " + hour + ":" + minute
                + ":" + second;
    } else {
        return "";
    }
}