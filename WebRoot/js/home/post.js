$(function(){
	var userId = $("input[name='user.id']").val();
	$(":submit").click(function(){
		if(userId==""||userId==null){
			alert("您还没有登录，请先登录！");
			return false;
		}
		var postTitle = $("input[name='postTitle']");
		if(postTitle.val()==""||postTitle.val()==null){
			postTitle.next(".message").html("<font color='red'>*请填写标题</font>");
			return false;
		}else if(postTitle.val().length<4||postTitle.val().length>24){
			postTitle.next(".message").html("<font color='red'>*标题字数不少于4且不大于24</font>");
			return false;
		}else{
			postTitle.next(".message").html(" ");
			return true;
		}
	});
	$("input[name='postTitle']").blur(function(){
		if(!$(this).val()){
			$(this).next(".message").html("<font color='red'>*请填写标题</font>");
		}else if($(this).val().length<4||$(this).val().length>24){
			$(this).next(".message").html("<font color='red'>*标题字数不少于4且不大于24</font>");
		}else{
			$(this).next(".message").html(" ");
		}
	});
	$("#fileImage").change(function () {
        var filepath = $("input[name='fileImage']").val();
        var extStart = filepath.lastIndexOf(".");
        var ext = filepath.substring(extStart, filepath.length).toUpperCase();
        if(ext != ".BMP" && ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
		      alert("图片限于bmp,png,gif,jpeg,jpg格式");
		      $("#fileType").text("");
		      $("#fileSize").text("");
		      return false;
        }else{
        	 $("#fileType").text("图片格式："+ext);
        }
        var file_size = 0;
        if ($.browser.msie) {
          var img = new Image();
          img.src = filepath;
          while (true) {
	            if (img.fileSize > 0) {
		              if (img.fileSize > 3*1024*1024) {
		            	  	alert("图片不大于100MB。");
		              } else{
			                var num03 = img.fileSize / 1024;
			                num04 = num03.toFixed(2);
			                $("#fileSize").text(num04 + "KB");
		              }
		           break;
	            }
          }
        } else {
	          file_size = this.files[0].size;
	          var size = file_size / 1024;
	          if (size > 2048) {
		            alert("上传的图片大小不能超过2M！");
		            return false;
	          } else {
		            var num01 = file_size / 1024;
		            num02 = num01.toFixed(2);
		            $("#fileSize").text("图片大小："+num02 + " KB");
	          }
        }
        return true;
      });
});