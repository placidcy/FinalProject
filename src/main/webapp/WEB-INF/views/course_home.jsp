<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>home</title>
    <link rel="stylesheet" href="/resources/css/course_mu.css">
    <link rel="stylesheet" href="/resources/css/course_home.css">
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <!-- 모달 css -->
    <link rel="stylesheet" href="/resources/css/dialog.css" />
    <link rel="stylesheet" href="/resources/css/request.css" />
    <link rel="stylesheet" href="/resources/css/member.css" />
    <link rel="stylesheet" href="/resources/css/requestDialog.css">
    <!-- 자바 스크립트 -->
    <script src="/resources/js/course.js"></script>
    <script src="/resources/js/homeMemo.js"></script>
</head>

<body>
    <div id="container">
        <jsp:include page="common/sidebar_course.jsp" />
      
        <main>
            <div id="homeBox">
                <div class="course-notice-title">
                    <h3>공지 목록</h3>
                    <a href="http://localhost:3000/notices?courseId=8080">
                        <span>더보기</span>
                    </a>
                </div>
                <table class="course-notice">
                    <tr>
                        <th>공지</th>
                        <a href="">
                            <td>일정 안내</td>
                        </a>
                    </tr>
                    <tr>
                        <th>공지</th>
                        <a href="">
                            <td>12일 피드백 사인업</td>
                        </a>
                    </tr>
                </table>

                <h3>강의 링크</h3>
                <div id="courseLinkBox">
                    <div id="linkContent">
                        <h3>${c_name}</h3>
                        <h4>설명: ${c_desc}</h4>
                        <h4>기간: ${c_sdate} ~ ${c_edate}</h4>
                    </div>

                    <div id="linkBtnBox">
                        <div>
                        	<button id="classBtn">입장하기</button>
                        </div>
                        <div id="memoBtnBox">
                        	<button id="memoBtn">필기하기</button>
                        </div>
                    </div>

                </div>
                
                <dialog id="modal">
			        <div class="modal-top flex cen">
			            <span class="bold">CHECK</span>
			            <span class="f24 exit">✕</span>
			        </div>
			        <div class="modal-bottom post">
			            <textarea class="textarea"></textarea>
			            <div class="flex cen mtb20">
				            <input class="btn f20" id="saveNoteBtn" type="button" value="기록하기">
			            </div>
			        </div>
			    </dialog>

                <h3>노트 필기</h3>
                <div id="noteListBox">
                    <!-- 등록된 필기가 없다면 다음의 문구를 보여준다.-->
                	<!-- 
                    <h3>현재 등록된 노트 필기가 없습니다.</h3>
                    <div id="noteBox">
                        <div class="noteDate"><span>작성일: 2024-12-30 13:20</span> <button id="deleteBtn">삭제</button></div>
                        <div class="noteContent">글 내용</div>
                    </div>
                     -->
                </div>
            </div>
           
        </main>
    </div>
</body>

</html>