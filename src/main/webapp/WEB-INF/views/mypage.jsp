<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CHECK-마이페이지</title>
	<link rel="stylesheet" href="/resources/css/common.css">
	<link rel="stylesheet" href="/resources/css/main/main.css">
    <link rel="stylesheet" href="/resources/css/mypage.css" />
    <link rel="stylesheet" as="style" crossorigin
		href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
	<script src="/resources/js/main/mobile.js"></script>
	<script src="/resources/js/main/mobile.js"></script>
	<script src="/resources/js/findDialog.js"></script>
	<!--<script src="/resources/js/main/token.js"></script>-->
</head>

<body>
    <div class="container flex">
    	<c:choose>
		    <c:when test="${m_role == '학생'}">
		    	<jsp:include page="common/side_main.jsp" />
		    </c:when>
		    
		    <c:when test="${m_role == '강사'}">
		    	<jsp:include page="common/side_main_i.jsp" />
		    </c:when>
		</c:choose>
        <main class="contents bgf2f2f2">
            <div id="header">
                <span class="title">마이페이지</span>
                <hr>
            </div>
            <div>
                <table>
                    <tr>
                        <th>프로필 이미지</th>
                        <td>
                            <div id="profileBox">
                                <img class="emptyImg" src="/resources/img/emptyimg.png" alt="프로필 사진" /><br>
                                <label for="uploadImg">이미지 변경</label>
                                <input type="file" name="uploadImg" id="uploadImg" accept="image/*" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td>${m_name}</td>
                    </tr>
                    <tr>
                        <th>소속/조직</th>
                        <td>${m_dept}</td>
                    </tr>
                    <tr>
                        <th>회원 분류</th>
                        <td>${m_role}</td>
                    </tr>
                    <tr>
                        <th>아이디</th>
                        <td>${m_acctid}</td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td>
                        	<form action="<c:url value='/changeM_email' />" method="GET">
	                        	${m_email} 
	                            <button type="submit" id="change-mail" class="a">변경</button>
	                            <input type="hidden" name="member_id" value="${member_id}" required />
	                            
                        	</form>
                        </td>
                    </tr>
                    <tr>
                        <th>비밀번호 변경</th>
                        <td>
                            <form action="<c:url value='/changepwd' />" method="GET">
	                            <button type="submit" class="a">비밀번호 변경하기</button>
	                            <input type="hidden" name="member_id" value="${member_id}" required />
                            </form>
                        </td>
                    </tr>
                </table>
                <hr>
                <table>
                    <tr>
                        <th>회원 탈퇴</th>
                        <td>
                            <form action="<c:url value='/leave' />" method="GET">
	                            <button type="submit" id="leave" class="a">회원 탈퇴하기</button>
	                            <input type="hidden" name="member_id" value="${member_id}" required />
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </main>
    </div>
</body>
</html>