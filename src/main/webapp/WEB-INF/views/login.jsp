<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>CHECK-login</title>
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
      <form action="#" method="POST" name="loginForm">
        <input type="text" name="inputid" placeholder="아이디를 입력하세요" required />
        <input type="password" name="inputpw" placeholder="비밀번호를 입력하세요" required />
        <button type="submit">로그인</button>
      </form>
      <div id="text-tag">
        <a href="<c:url value='/findidpw' />">
          <span>아이디/비밀번호 찾기</span>
        </a>
        <a href="<c:url value='/agreement' />">
          <span id="join-member">회원가입</span>
        </a>
      </div>
    </main>
  </div>
</body>
</html>