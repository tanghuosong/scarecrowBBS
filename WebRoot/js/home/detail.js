$(function(){
	var postId=$("input[name='post.id']").val();
	$.post("answer_home_findAnswerByPostId.action",{'post.id':postId},function(data){
		if(data.list[0] != null){
			showAnswerList(data);
		}else{
			$("#answer_error").html("还没有任何评论！");
		}
	},'json');
	$("#submit").click(function(){
		var userId = $("input[name='userId']").val();
		var answerContent = $("#textarea").val();
		if(!answerContent){
			alert("请输入内容！");
			return false;
		}
		$.post("answer_home_save.action", 
				{ 'user.id':userId,'post.id':postId,'answerContent':answerContent },
				function(data){
					/**清空文本域内容*/
					$("#textarea").val("");
					/**ajax刷新***/
					$.post("answer_home_findAnswerByPostId.action",{'post.id':postId},function(data){
						$("#answer_error").html("");
						showAnswerList(data);
					},'json');
		});
	});
});
function showAnswerList(data){
	var content="";
	for(var key in data.list){
		content+="<div class='answer_info'><div class='answer_other'>" +
			"<div class='answer_user'>"+(parseInt(key)+1)+"#:&nbsp;"+data.list[key].user.userName+"</div>" +
			"<div class='answer_user'>等级："+data.list[key].user.userGrade+"</div>" +
			"<div class='answer_user'>积分："+data.list[key].user.userNtegration+"</div></div>" +
			"<div class='answer'>" +
			"<div class='answer_content'>"+data.list[key].answerContent+"</div>"+
			"<div class='answer_time'>回复时间："+formatTime(data.list[key].answerTime)+"</div></div></div>";
	}
	/**清空原先内容，再显示新的内容*/
	$("#content").html("");
	$("#content").append(content);
}
