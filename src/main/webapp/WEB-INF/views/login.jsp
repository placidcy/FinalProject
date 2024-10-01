<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>CHECK-로그인</title>
  <link rel="stylesheet" href="resources/css/login.css" />
</head>
<body>
  <div id="container">
    <header>
      <a href="<c:url value='/login' />">
        <h1>CHECK</h1>
      </a>
    </header>

    <main>
      <form action="<c:url value='/loginProcess' />" method="POST" name="loginForm">
        <input type="text" name="inputid" placeholder="아이디 입력" required />
        <input type="password" name="inputpw" placeholder="비밀번호 입력" required />
        <button type="submit">로그인</button>
      </form>
      <div id="text-tag">
        <a href="<c:url value='/findidpw' />">
          <span>아이디 / 비밀번호 찾기</span>
        </a>
        <a href="<c:url value='/signup-agreement' />">
          <span id="signup">회원가입</span>
        </a>
      </div>
    </main>
  </div>
</body>
</html>