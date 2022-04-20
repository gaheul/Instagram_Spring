const input_items = document.querySelectorAll(".input-items");
const username_input = document.querySelector("#username");
const username_label = input_items[0].querySelector("label");
const password_input = document.querySelector("#password");
const password_label = input_items[1].querySelector("label");
//const username_input = input_items[0].querySelector("input"); ->쓸수있음
//const username_label = input_items[0].querySelector("label"); 
//const password_input = input_items[1].querySelector("input");
//const password_label = input_items[1].querySelector("label");

const singin_button = input_items[2].querySelector("button");



username_input.onkeypress = () => {
    username_label.style.top = "2px";
    username_label.style.fontSize = "11px";
}

username_input.onkeyup = () => { //뒤로가기(지우기)했을 때 
    if(username_input.value.length ==0){
        username_label.style.top = "10px";
        username_label.style.fontSize = "13px";
    }
}

password_input.onkeypress = () => {
    password_label.style.top = "2px";
    password_label.style.fontSize = "11px";
    
}

password_input.onkeyup = () => {
    if(password_input.value.length==0){
        password_label.style.top = "10px";
        password_label.style.fontSize = "13px";

    }
}

singin_button.onclick = () => {
    if(username_input.value.length==0  ){
        alert("아이디를 입력해주세요")      
        }else if(password_input.value.length==0){
                alert("비밀번호를 입력해주세요")
            }else{
                alert("로그인시도");
            }
    }

username_input.onkeydown = () =>{
    if(window.event.keyCode==13){
            password_input.focus();
    }else{
        username_label.style.top = "2px";
        username_label.style.fontSize = "11px";
        }
    }

password_input.onkeydown  = () => {
        if(window.event.keyCode==13){
        singin_button.click();
    }else{
        password_label.style.top = "2px";
        password_label.style.fontSize = "11px";
        }

    }


