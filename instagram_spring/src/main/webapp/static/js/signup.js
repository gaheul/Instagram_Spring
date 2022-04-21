const input_datas = document.querySelectorAll('.input-data');
const password_visible = document.querySelector('.password-visible');
const submitBtn = document.querySelector('.submit-btn');


let checkFlag = [false,false,false,false];

submitBtn.onclick = () => {
	if(checkFlag.indexOf(false) == -1){ //indexof : index번호찾음 -> false가 하나도없으면 -1
		document.querySelector('form').submit();		
	}
}


password_visible.onclick = () => {
    //input type = text (attribute) / 비밀번호표시 숨기기(innerhtml,inntertext)
    const input = input_datas[3].querySelector('input');
   // console.log(input.type);
    if(input.type == 'password'){
        input.type = 'text';
        password_visible.innerText = '숨기기';
    }else{
        input.type = 'password';
        password_visible.innerText = '비밀번호 표시';
    }
}


for(let i =0; i<input_datas.length; i++){
    const label = input_datas[i].querySelector('label');
    const input = input_datas[i].querySelector('input');

    input.onkeydown = () => {
        label.style.top = '2px';
        label.style.fontSize = '11px';
        input.style.padding = '16px 0 2px 8px';

    }

    input.onkeyup = () => {
        if(input.value.length==0){
            label.style.top = '9px';
            label.style.fontSize = '13px';
            input.style.padding = '9px 0 7px 8px';
        }
    }

    input.onblur = () => { //onblur :포커스가 벗어났을때
        const inputMsg = document.querySelectorAll('.input-msg');
        
        if(input.value.length==0 ){
            inputMsg[i].innerHTML = `<i class="fa-solid fa-circle-xmark"></i>`;   
            checkFlag[i] = false;      
        }else {
            inputMsg[i].innerHTML = `<i class="fa-solid fa-circle-check" style="color:#8e8e8e;"></i>`;
            checkFlag[i] = true;   
	        if(i==2){
				$.ajax({
					type: "get",
					url: "/app/auth/username/check",
					data: {
						"username": input.value
					},
					dataType: "text", //데이터를 보내고 받을 때 type
					success: function(data){ //(data)-> controller return값
						if(data == "true"){
							inputMsg[i].innerHTML = `<i class="fa-solid fa-circle-xmark"></i>`;   
							checkFlag[i] = false;  
						}else{
							inputMsg[i].innerHTML = `<i class="fa-solid fa-circle-check" style="color:#8e8e8e;"></i>`;
							checkFlag[i] = true;  
						}
						
					}
				});
			}
            
        }
    }
}