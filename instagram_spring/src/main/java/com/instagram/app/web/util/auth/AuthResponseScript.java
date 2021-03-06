package com.instagram.app.web.util.auth;

public class AuthResponseScript {
	
	public String signupScirpt(boolean result) {
		StringBuilder script = new StringBuilder();
		if(result) {
			script.append("<script>");
			script.append("alert(\"회원가입 완료.\");");
			script.append("location.replace(\"/app/auth/signin\");"); 
			//replace : 이전의 데이터(history)를 지우고(초기화) 새로운데이터 = sendredirect - href: 뒤로가기 가능(history 가지고있음) = forward
			script.append("</script>");
		}else {
			script.append("<script>");
			script.append("alert(\"회원가입 실패.\");");
			script.append("history.back();"); //다시 회원가입 창으로 돌아감 
			script.append("</script>");
		}
		
		return script.toString();
	}
	
	public String signinValidScript(String msg) {
			StringBuilder script = new StringBuilder();
		
			script.append("<script>");
			script.append("alert(\""+msg+"\");");
			script.append("location.replace(\"/app/auth/signin\");"); 
			script.append("</script>");
			
			return script.toString();
	}
}
