<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CHECK-아이디 찾기</title>
    <link rel="stylesheet" as="style" crossorigin
		href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <link rel="stylesheet" href="resources/css/header.css" />
    <link rel="stylesheet" href="resources/css/find.css" />
</head>
<body>
    <div id="container">
 		<jsp:include page="common/find_header.jsp">
 			<jsp:param name="headerType" value="content" />
 			<jsp:param name="pageTitle" value="아이디 찾기" />
        	<jsp:param name="pageContent" value="아이디를 잊으셨다면, 이름과 이메일을 통해 아이디를 찾을 수 있습니다." />
 		</jsp:include>
        <main>
        
			<div class="formBox">
				<div id="top" >
					<p>고객님의 정보와 일치하는 아이디입니다.</p>
				</div>
				
			    <c:choose>
			        <c:when test="${not empty result}">
						<div id="middle">
							${result}
						</div>
						<div id="bottom">
							<a href="/login">
							<button id="submitBtn">로그인하러 가기</button>
							</a>
							<a href="/findpwd">
							<button id="cancelBtn">비밀번호 찾기</button>
							</a>
						</div>
			        </c:when>
			        <c:otherwise>
						<div id="middle">
							${error}
						</div>
						<div id="bottom">
							<a href="/login">
							<button id="submitBtn">로그인하러 가기</button>
							</a>
							<a href="/findcheck">
							<button id="cancelBtn">아이디/비밀번호 찾기</button>
							</a>
						</div>
			        </c:otherwise>
			    </c:choose>
			    
			</div>
		</main>
		</div>
</body>