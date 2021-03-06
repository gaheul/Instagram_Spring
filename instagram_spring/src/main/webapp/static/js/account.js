const profileUsername = document.querySelector(".profile-username");
const textInputs = document.querySelectorAll(".text-input");
const introduceText = document.querySelector(".text-textarea");
const submitBtn = document.querySelector(".submit-btn");

//이미지 변경
const profileImgFile = document.querySelector(".profile-img-file");
const profileImgRound = document.querySelector(".profile-img-round");
const updateImgBtn = document.querySelector(".update-img-button");

let usercode = 0;

let principal = getPrincipal(); //호출했을 때 동기-> principal이 생성되고 usercode사용

load();

function load(){
	$.ajax({
		type: "get",
		url: "/app/profile/account/user",
		data: {
			usercode : principal.usercode
		},
		dataType: "text",
		success: function(data){
			let account = JSON.parse(data) //parse: 파싱해서 객체로 변환 ,stringity :객체를 텍스트로 변환
			pageLoad(account);
		},
		error: function(){
			alert("비동기 처리 오류");
		}
	});
	const profileImg = profileImgRound.querySelector('img');
	profileImg.src = getProfileImg();
}


function pageLoad(account){
	usercode = account.usercode;
	profileUsername.textContent = account.username; //username value
	textInputs[0].value = account.name;
	textInputs[1].value = account.username;
	textInputs[2].value = account.website;
	introduceText.value = account.introduce;
	textInputs[3].value = account.email;
	textInputs[4].value = account.phone;
	textInputs[5].value = account.gender;
}

submitBtn.onclick = () => {
	//객체를 들고옴
	let account = createAccount();
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

	});
}

function createAccount(){
	let account = {
		"usercode" : usercode,
		"name" : textInputs[0].value,
		"username" : textInputs[1].value,
		"website" : textInputs[2].value,
		"introduce" : introduceText.value,
		"email" : textInputs[3].value,
		"phone" : textInputs[4].value,
		"gender" : textInputs[5].value
	}
	return account;
}

profileImgRound.onclick = () => {
	imgChange();
}

updateImgBtn.onclick = () => {
	imgChange();
}

function imgChange(){
	//파일 객체 생성
	profileImgFile.click();
	
	//클릭되어졌을때
	profileImgFile.onchange = () =>{ //파일객체(태그)안에서 값이 변경되었을 때  1
		let reader = new FileReader();
		
		reader.onload = (e) => { //  3
			let profileImgUrl = e.target.result; //이벤트가 일어난 해당객체에서의 profileImgFile 결과
			let originImgUrl = profileImgRound.querySelector('img').src;
			profileImgRound.querySelector('img').src = profileImgUrl;

			if(confirm("프로필 이미지를 변경하시겠습니까?")){
				let formData = new FormData(document.querySelector(".profile-box-form1"));
				
				$.ajax({
					type: "post",
					url: "/app/profile/account/update/img",
					data: formData,
					encType: "multipart/form-data", //multipart/form-data -> entype,processdata,contenttype 항상 입력
					processData: false,
					contentType: false,
					dataType: "text",
					success: function(data){
						alert("프로필 이미지가 변경되었습니다.");
						location.reload();
					},
					error: function(){
						alert("비동기 처리 오류");
					}
				});
			}else{
				profileImgRound.querySelector('img').src = originImgUrl;
			}
		}
		
		reader.readAsDataURL(profileImgFile.files[0]); //선택한 이미지의 url  2
	}	
}



