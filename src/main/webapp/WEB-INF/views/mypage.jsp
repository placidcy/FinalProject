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
</head>

<body>
    <div class="container flex">
    	<jsp:include page="common/side_main.jsp" />
        <main class="contents">
            <div id="header">
                <span class="title">마이페이지</span>
                <button id="profile-cancel">취소</button>
                <button id="profile-save" type="submit">저장</button>
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
                        <td>${m_email} <a href="<c:url value='/change-mail' />" id="change-mail">변경</a></td>
                    </tr>
                    <tr>
                        <th>비밀번호 변경</th>
                        <td>
                            <a href="<c:url value='/change-pw' />">비밀번호 변경하기</a>
                        </td>
                    </tr>
                </table>
                <hr>
                <table>
                    <tr>
                        <th>회원 탈퇴</th>
                        <td><a href="<c:url value='/leave' />" id="leave">회원 탈퇴하기</a></td>
                    </tr>
                </table>
            </div>
        </main>
    </div>
</body>
</html>