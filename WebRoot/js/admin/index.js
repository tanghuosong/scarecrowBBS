$(function(){
	$("a[title]").click(function(){
		var text = $(this).text();
		var href = $(this).attr("title");
		if($("#tt").tabs("exists",text)){
			$("#tt").tabs("select",text);
		}else{
			$("#tt").tabs("add",{
				title:text,
				closable:true,
				content:'<iframe title='+text+' src='+href+' frameborder="0" width="100%" height="100%"/>'
			});
		}
	});
});
