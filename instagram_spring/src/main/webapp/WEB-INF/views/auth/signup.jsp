<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>instagram</title>
    <link rel="stylesheet" href="/app/static/css/style.css"> <!-- web->서버로 보낼땐 /app/무조건넣어야함 -->
    <link rel="stylesheet" href="/app/static/css/signup.css">
    <script src="https://kit.fontawesome.com/a29a2deeae.js" crossorigin="anonymous"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <section class="container">
        <main class="m-container">
            <div class="content-box">
                <div class="item-box">
                    <div class="item-group">
                        <h1 class="b-logo">
                            <img src="/app/static/images/logo.PNG" alt="">
                        </h1>
                        <form action="/app/auth/signup" method="post">
                            <div class="signup-items">
                                <h2 class="signup-title">친구들의 사진과 동영상을 보려면 가입하세요.</h2>
                                <div class="facebook-login">
                                    <button type="button" class="facebook-login-btn">
                                        <i class="fa-brands fa-facebook-square"></i>Facebook으로 로그인
                                    </button>
                                </div>
                                <div class="signup-or">
                                    <div class="hr-sect"><span>또는</span></div>
                                </div>
                                <div class="signup-item">
                                    <div class="input-group">
                                        <div class="input-data">
                                            <label for="phone-or-email">휴대폰 번호 또는 이메일 주소</label>
                                            <input type="text" id="phone-or-emai" name="phoneOrEmail">
                                        </div>
                                        <div class="input-msg">
                                            
                                        </div>
                                    </div>
                                    <div class="input-group">
                                        <div class="input-data">
                                            <label for="name">성명</label>
                                            <input type="text" id="name" name="name">
                                        </div>
                                        <div class="input-msg">
                                            
                                        </div>
                                    </div>
                                    <div class="input-group">
                                        <div class="input-data">
                                            <label for="username">사용자이름</label>
                                            <input type="text" id="username" name="username">
                                        </div>
                                        <div class="input-msg">
                                            
                                        </div>
                                    </div>
                                    <div class="input-group">
                                        <div class="input-data">
                                            <label for="password">비밀번호</label>
                                            <input type="password" id="password" name="password">
                                        </div>
                                        <div class="input-msg">
                                        </div>
                                        <div class="password-visible">비밀번호 표시</div>
                                    </div>
                                    <button type="button" class="submit-btn">가입</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="item-group">
                        <p>계정이 있으신가요?<a href="/app/auth/signin">로그인</a></p>
                    </div>
                    <div class="download-img">
                        <img src="/app/static/images/download.PNG" alt="">
                    </div>
                </div>
            </div>
        </main>
    </section>
    <script src="/app/static/js/signup.js"></script>
</body>

</html>