<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CHECK-아이디 찾기</title>
    <link rel="stylesheet" href="resources/css/header.css" />
    <link rel="stylesheet" href="resources/css/find.css" />
    <script src="/resources/js/buttonLocation.js"></script>
    <!-- 모달 -->
    <link rel="stylesheet" href="/resources/css/checkin.css" />
    <link rel="stylesheet" href="/resources/css/admin-form.css" />
    <link rel="stylesheet" href="/resources/css/dialog.css" />
    <link rel="stylesheet" href="/resources/css/request.css" />
    <link rel="stylesheet" href="/resources/css/member.css" />
    <script src="/resources/js/dialog.js"></script>
</head>
<body>
    <div id="container">
<%--     
        <header>
            <div id="header1">
                <a href="<c:url value='/login' />">
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
         --%>
 		<jsp:include page="common/find_header.jsp">
 			<jsp:param name="headerType" value="content" />
 			<jsp:param name="pageTitle" value="아이디 찾기" />
        	<jsp:param name="pageContent" value="아이디를 잊으셨다면, 이름과 이메일을 통해 아이디를 찾을 수 있습니다." />
 		</jsp:include>
        <main>
            <div class="formBox">
                <div id="top">
                    <p>이름과 이메일을 입력하세요.</p>
                </div>
                <div id="middle">
                    <form id="findProcess" action="<c:url value='/findidProcess' />" method="POST">
                    	<input type="hidden" name="m_role" value=${param.m_role} />
                        <input type="text" name="m_name" placeholder="이름 입력" required />
                        <input type="email" name="m_email" placeholder="이메일 입력" required />
                    </form>
                </div>
                <div id="bottom">
                    <button type="submit" id="submitBtn" >찾기</button>
                    <button id="cancelBtn">취소</button>
                </div>
			    <dialog class="modal" open>
			        <div class="modal-top flex cen">
			            <span class="bold">CHECK</span>
			            <span class="f24 exit">✕</span>
			        </div>
			        <div class="modal-bottom">
			            <div class="grid g10 findId">
			                <p>아이디 찾기</p>
			                <div class="hr"></div>
			                <p class="flex g20 ac"><svg xmlns="http://www.w3.org/2000/svg" fill="gray" width="20px" height="20px"
			                        viewBox="0 0 32 32" version="1.1">
			                        <path
			                            d="M25 12h-1v-3.816c0-4.589-3.32-8.184-8.037-8.184-4.736 0-7.963 3.671-7.963 8.184v3.816h-1c-2.206 0-4 1.794-4 4v12c0 2.206 1.794 4 4 4h18c2.206 0 4-1.794 4-4v-12c0-2.206-1.794-4-4-4zM10 8.184c0-3.409 2.33-6.184 5.963-6.184 3.596 0 6.037 2.716 6.037 6.184v3.816h-12v-3.816zM27 28c0 1.102-0.898 2-2 2h-18c-1.103 0-2-0.898-2-2v-12c0-1.102 0.897-2 2-2h18c1.102 0 2 0.898 2 2v12zM16 18c-1.104 0-2 0.895-2 2 0 0.738 0.405 1.376 1 1.723v3.277c0 0.552 0.448 1 1 1s1-0.448 1-1v-3.277c0.595-0.346 1-0.985 1-1.723 0-1.105-0.895-2-2-2z" />
			                    </svg> 고객님의 정보와 일치하는 아이디입니다.</p>
			                <div class="textarea flex g20 cen">
			                    <span>${result}</span>
			                </div>
			                <input class="impleBtn cen w150 mtb20" type="button" value="확인">
			            </div>
			        </div>
			    </dialog>
            </div>
        </main>
    </div>
</body>