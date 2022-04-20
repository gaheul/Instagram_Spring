<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>instagram</title>
    <link rel="stylesheet" href="/app/static/css/style.css">
    <link rel="stylesheet" href="/app/static/css/auth-2.css">
    <script src="https://kit.fontawesome.com/ede2458143.js" crossorigin="anonymous"></script>
</head>

<body>
    <section class="container">
        <main class="m-container">
            <article class="a-container">
                <div class="l-content">
                    <img src="/app/static/images/auth_main-1.png" class="l-content-img">
                </div>
                <div class="r-content">
                    <div class="item-box">
                        <h1 class="b-logo"><img src="/app/static/images/logo.PNG"></h1>
                        <div class="items-group">
                            <div class="items-group-form">
                                <div class="input-items">
                                    <label for="username">전화번호, 사용자 이름 또는 이메일</label>
                                    <input type="text" id="username">
                                </div>
                                <div class="input-items">
                                    <label for="password">비밀번호</label>
                                    <input type="password" id="password">
                                </div>
                                <div class="input-items">
                                    <button type="button">로그인</button>
                                </div>
                                <div class="input-items">
                                    <div class="hr-sect"><span>또는</span></div>
                                </div>
                                <div class="input-items">
                                    <a href="#" class="facebook-login">
                                        <span><i class="fa-brands fa-facebook-square"></i>Facebook으로 로그인</span>
                                    </a>
                                </div>
                            </div>
                            <a href="#">비밀번호를 잊으셨나요?</a>
                        </div>
                    </div>
                    <div class="item-box">
                        <div class="signup-items">
                            <p>계정이 없으신가요?<a href="signup.html">가입하기</a></p>
                        </div>
                    </div>  
                    <div class="r-content-footer">                  
                            <p>앱을 다운로드하세요</p>
                            <div class="app-img">
                                <img src="/app/static/images/appstore.PNG" alt="">
                                <img src="/app/static/images/google.PNG" alt="">                       
                    </div>
                </div>
            </article>
        </main>
        <footer class="f-container">

        </footer>
    </section>
    <script src="/app/static/js/auth.js"></script>
</body>

</html>