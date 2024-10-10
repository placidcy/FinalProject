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
<%--   
    <header>
      <a href="<c:url value='/login' />">
        <h1>CHECK</h1>
      </a>
    </header>
 --%>
 
 	<jsp:include page="common/find_header.jsp" />
    <main>
      <form action="loginProcess" method="POST" id="loginForm">
        <input type="text" name="m_acctid" placeholder="아이디 입력" required />
        <input type="password" name="m_acctpwd" placeholder="비밀번호 입력" required />
        <button type="submit">로그인</button>
      </form>
      <div id="text-tag">
        <a href="<c:url value='/findcheck' />">
          <span>아이디 / 비밀번호 찾기</span>
        </a>
        <a href="<c:url value='/agreement' />">
          <span id="signup">회원가입</span>
        </a>
      </div>
    </main>
  </div>
</body>
</html>