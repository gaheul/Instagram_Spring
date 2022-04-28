const profileUsername = document.querySelector(".profile-username");
const passwordInputs = document.querySelectorAll(".password-input");
const submitBtn = document.querySelector(".submit-btn");


let usercode = 0;

let principal = getPrincipal(); //호출했을 때 동기-> principal이 생성되고 usercode사용

load();

function load(){
	profileUsername.textContent = principal.username;
}

function isEmpty(str){
	return str == null || str == "" || typeof str == "undefined"
}

submitBtn.onclick = () => {
	let originPassword = passwordInputs[0].value;
	let newPassword = passwordInputs[1].value;
	let newRePassword = passwordInputs[2].value;
	if(isEmpty(originPassword)){
		alert("이전 비밀번호를 입력해주세요")
	}else if(isEmpty(newPassword)){
		alert("새 비밀번호를 입력해주세요")
	}else if(newPassword != newRePassword){
		alert("새 비밀번호 일치하지 않음")
	}else if(originPassword == newPassword){
		alert("이전비밀번호와 새 비밀번호일치")
	}else{
		$.ajax({
			type: "put",
			url: "/app/profile/account/password/update",
			data: {
				password : principal.password
			},
			dataType: "text",
			success: function(data){
				if(data == "true"){
					alert("비밀번호 수정 완료");
					
				}else{
					alert("이미 존재하는 비밀번호");
				}
			},
			error:function(){
				alert("비동기 처리 오류");
			}				
		})
	}
	
	//객체를 들고옴
	/*let account = createAccount();
	console.log(account);
	$.ajax({
		type: "put",
		url: "/app/profile/account/update",
		data: JSON.stringify(account),
		contentType: "application/json;charset=utf-8", 
		dataType: "text", //응답받았을때
		success: function(data){
			if(data == "true"){
				alert("회원정보 수정 완료.");
				location.replace("/app/profile/account");
			}else{
				alert("이미 존재하는 아이디입니다.");
			}
		},
		error: function(){
			alert("비동기 처리 오류");
		}

	});*/
}

