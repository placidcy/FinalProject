<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CHECK-비밀번호 찾기</title>
    <link rel="stylesheet" href="resources/css/header.css" />
    <link rel="stylesheet" href="resources/css/find.css" />
    <script src="/resources/js/buttonLocation.js"></script>
    <script src="/resources/js/findpwdValid.js"></script>
</head>
<body>
    <div id="container">
 		<jsp:include page="common/find_header.jsp">
 			<jsp:param name="headerType" value="content" />
 			<jsp:param name="pageTitle" value="비밀번호 찾기"/>
        	<jsp:param name="pageContent" value="비밀번호를 잊으셨다면, 아이디와 이메일을 통해 비밀번호를 재설정할 수 있습니다."/>
 		</jsp:include>
        <main>
            <form id="findpwdProcess" action="<c:url value='/findpwdProcess' />" method="POST">
            <div class="formBox">
            	<div id="top">
	                <p>아이디과 이메일을 입력하세요.</p>
            	</div>
            	<div id="middle">
	                	<input type="hidden" name="m_role" value="${param.m_role}"/>
	                    <input type="text" name="m_acctid" id="m_acctid" placeholder="아이디 입력" />
	                    <input type="email" name="m_email" id="m_email" placeholder="이메일 입력" />
            	</div>
            	<div id="bottom">
                    <button type="submit" id="submitBtn">찾기</button>
                    <button type="button" id="cancelBtn">취소</button>
            	</div>
            </div>
            </form>
        </main>
    </div>
</body>