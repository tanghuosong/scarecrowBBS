$(function(){
	var url=location.href;
	var categoryId=url.split("?")[1];
	$.post("post_home_queryPostListByCategoryId.action",{"key":categoryId.split("=")[1],"page":1,"rows":10},function(data){
		
		if(data.total>0){
			showList(data);
			$('#pp').pagination({
				total:data.total,
				pageSize:10,
				pageList: [10,20,30],
				onSelectPage:function(pageNumber, pageSize){
					$(this).pagination('loading');
					$.post("post_home_queryPostListByCategoryId.action",{"key":categoryId.split("=")[1],"page":pageNumber,"rows":pageSize},function(data){
						showList(data);
					},'json');
					$(this).pagination('loaded');
				}
			});
		}else{
			$("#content").html("<img src='image/list_error.jpg'/>");
		}
	},'json');
});
function showList(data){
	var content ="";
	for(var index in data.pList1){
		content += "<div class='each_list'>" +
			"<div class='list_title'>"+data.pList1[index].postTitle+"</div>" +
			"<pre><div class='list_content'>" +
			"<a href='post_home_detail.action?id="+data.pList1[index].id+"&userId="+data.pList1[index].user.id+"'>"+data.pList1[index].postContent+"</a>" +
			"</div></pre>"+
			"<div class='list_other'><span>浏览人数("+data.pList1[index].postViews+")</span>" +
			"<span>"+formatTime(data.pList1[index].postTime)+"</span>"+
			"</div>"+
			"</div>";
	}
	$("#content").html("");
	$("#content").html(content);
}