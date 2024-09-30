<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CHECK-아이디 찾기</title>
    <link rel="stylesheet" href="resources/css/header.css" />
    <link rel="stylesheet" href="resources/css/find.css" />
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
                <p>아이디 찾기</p>
                <hr>
                <div id="header2msg">
                    <img class="lockImg" src="resources/img/lock.png" />
                    <span>아이디를 잊으셨다면, 이름과 이메일을 통해 아이디를 찾을 수 있습니다.</span>
                </div>
            </div>
        </header>

        <main>
            <div class="formBox">
                <div id="top">
                    <p>이름과 이메일을 입력하세요.</p>
                </div>
                <div id="middle">
                    <form action="" method="POST">
                        <input type="text" name="inputname" placeholder="이름 입력" required />
                        <input type="email" name="inputemail" placeholder="이메일 입력" required />
                    </form>
                </div>
                <div id="bottom">
                    <button type="submit" id="searchBtn">찾기</button>
                    <button id="cancelBtn">취소</button>
                </div>
            </div>
        </main>
    </div>
</body>