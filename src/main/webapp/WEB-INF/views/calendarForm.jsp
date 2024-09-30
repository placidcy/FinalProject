<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <link href="/resources/css/course_attend_write.css" rel="stylesheet" />
    <link rel="stylesheet" href="/resources/css/course_mu.css">
    <script src="/resources/js/course.js"></script>
    <title>Document</title>
</head>

<body>
    <div id="container">
        <jsp:include page="common/sidebar_course.jsp" />

        <main>
            <div class="attend_write">
                <h1>강의 일정 등록</h1>

                <div class="buttons">
                    <a href="">
                        <div class="save_button">저장</div>
                    </a>
                    <a href="">
                        <div class="cancel_button">취소</div>
                    </a>
                </div>

                <hr>

                <div class="course-title">
                    <span class="title">강의</span>
                    <span class="course_write">HTML의 기초</span>
                </div>

                <br>

                <div class="coruse-day">
                    <div class="start-day">
                        <span class="title">일시</span>
                        <span class="days">2024.08.26</span>
                        <span class="times">오전 11:00</span>
                        <span class="text">▼</span>
                    </div>
                    <div class="coruse-day-texts">
                        <span class="texts">----</span>
                    </div>
                    <div class="end-day">
                        <span class="days">2024.08.26</span>
                        <span class="times">오전 11:00</span>
                        <span class="text">▼</span>
                    </div>

                    <div class="all-day">
                        <input type="checkbox">
                        <span>종일</span>
                    </div>
                </div>

                <br>

                <div class="course-content">
                    <span class="title">설명</span>
                    <textarea class="content" placeholder="설명을 작성해주세요."></textarea>
                </div>

                <br>

                <div class="alerts">
                    <span class="alert">알림</span>
                    <input type="checkbox">
                    <span class="mail">메일</span>
                </div>

                <div class="buttons-mobile">
                    <a href="">
                        <div class="save_button">저장</div>
                    </a>
                    <a href="">
                        <div class="cancel_button">취소</div>
                    </a>
                </div>
            </div>
        </main>
    </div>

</body>

</html>