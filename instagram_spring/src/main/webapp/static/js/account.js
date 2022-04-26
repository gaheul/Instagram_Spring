$.ajax({
	type: "get",
	url: "/app/profile/account/user",
	data: {
		usercode : 13
	},
	dataType: "text",
	success: function(data){
		alert(data);
	},
	error: function(data){
		alert("비동기 처리 오류");
	}
})