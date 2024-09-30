<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CHECK-아이디/비밀번호 찾기</title>
    <link rel="stylesheet" href="resources/css/header.css" />
    <link rel="stylesheet" href="resources/css/findcheck.css" />
</head>
<body>
    <div id="container">
        <header>
            <div id="header1">
                <a href="#">
                    <h1>CHECK</h1>
                </a>
            </div>
            <div id="header2">
                <p>아이디 / 비밀번호 찾기</p>
                <hr>
                <div id="header2msg">
                    <img class="lockImg" src="resources/img/lock.png" />
                    <span>회원가입 시 입력한 개인정보를 통해 아이디 또는 비밀번호를 찾을 수 있습니다.</span>
                </div>
            </div>
        </header>

        <main>
            <div class="box">
                <div class="top">
                    <img class="roleImg" src="./image/boy.png">
                    <span>학생</span>
                </div>
                <div class="btnBox">
                    <button>아이디 찾기</button>
                    <button>비밀번호 찾기</button>
                </div>
                <div class="bottom">
                    <p>학생 회원은 이 서비스를 이용하세요.</p>
                </div>
            </div>
            <div class="box">
                <div class="top">
                    <img class="roleImg" src="./image/school.png">
                    <span>강사</span>
                </div>
                <div class="btnBox">
                    <button>아이디 찾기</button>
                    <button>비밀번호 찾기</button>
                </div>
                <div class="bottom">
                    <p>강사 회원은 이 서비스를 이용하세요.</p>
                </div>
            </div>
        </>
    </div>
</body>
</html>