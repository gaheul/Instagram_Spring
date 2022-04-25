const profileImg = document.querySelector(".profile-img");
const bLogo = document.querySelector(".b-logo");

bLogo.onclick = () => {
	location.href= "/app/";
}

profileImg.onclick= () =>{
	location.href= "/app/account/profile";
}

