
function getPrincipal(){
	let principal = null;
	$.ajax({
		type: "get",
		url: "/app/api/principal",
		async: false, //false->동기 /생략->비동기
		dataType: "text",
		success: function(data){
			principal = JSON.parse(data);
		},
		error: function(){
			alert("비동기 처리 오류");
		}	
	});
	return principal; 
}