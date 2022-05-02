const profileImg = document.querySelector(".profile-img");
const bLogo = document.querySelector(".b-logo");

load();

function load(){
	profileImg.src = getProfileImg();
}

bLogo.onclick = () => {
	location.href= "/app/";
}

profileImg.onclick= () =>{
	location.href= "/app/account/profile";
}

