const profileUsername = document.querySelector(".profile-username");
const passwordInputs = document.querySelectorAll(".password-input");
const submitBtn = document.querySelector(".submit-btn");
const boxItemLefts = document.querySelectorAll(".box-item-left");


let usercode = 0;

let principal = getPrincipal(); //호출했을 때 동기-> principal이 생성되고 usercode사용

load();

function load(){
	profileUsername.textContent = principal.username;
}

function isEmpty(str){ //결과 true,flase
	return str == null || str == "" || typeof str == "undefined";
}

submitBtn.onclick = () => {
	for(let i =0; i<passwordInputs.length; i++){
		if(isEmpty(passwordInputs[i].value)){
			const labelName = boxItemLefts[i+1].querySelector("label").textContent;
			alert(labelName + "(을)를 입력해주세요.");
			return;
		}else if(i == 1 && passwordInputs[i].value != passwordInputs[i+1].value){
			alert("새 비밀번호가 서로 일치하지 않습니다.");
			return;
		}else if(i==2 && passwordInputs[i-2].value == passwordInputs[i-1].value){
			alert("기존의 비밀번호와 동일한 비밀번호 입니다.");
			return;
		}
	}
	
	$.ajax({
		type: "put",
		url: "/app/profile/account/password/update",
		data: JSON.stringify({
			originPassword: passwordInputs[0].value,
			newPassword: passwordInputs[1].value,
		}),
		contentType: "application/json;charset=utf-8",
		dataType: "text", //응답받았을때
		success: function(data){
			if(data == "true"){
				alert("비밀번호 변경 완료. 다시 로그인 하세요");
				location.replace("/app/logout");
			}else{
				alert("이전 비밀번호가 일치하지 않습니다.");
			}
		},
		error: function(){
			alert("비동기 처리 오류");
		}

	});
}

