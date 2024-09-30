<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <link href="/resources/css/course_attend.css" rel="stylesheet" />
    <link rel="stylesheet" href="/resources/css/course_mu.css">
    <script src="/resources/js/course.js"></script>
    <title>Document</title>
</head>

<body>
    <div id="container">
       <jsp:include page="common/sidebar_course.jsp" />

        <main>
            <div class="calendar">
                <div class="calendar-header">
                    <span class="prev-month">◀</span>
                    <span class="current_month">2024.08</span>
                    <span class="next-month">▶</span>
                    <span class="today">오늘</span>
                </div>
                <div class="calendar-body">
                    <div class="day-names">
                        <span class="day-name">일</span>
                        <span class="day-name">월</span>
                        <span class="day-name">화</span>
                        <span class="day-name">수</span>
                        <span class="day-name">목</span>
                        <span class="day-name">금</span>
                        <span class="day-name">토</span>
                    </div>
                    <div class="month">
                        <div class="weeks">
                            <span class="prev-day sun">28</span>
                            <span class="prev-day">29</span>
                            <span class="prev-day">30</span>
                            <span class="prev-day">31</span>
                            <span class="day">1</span>
                            <div class="day class">2
                                <span class="times">12:00 ~ 14:30</span>
                            </div>
                            <span class="day sat">3</span>
                        </div>

                        <div class="weeks">
                            <span class="day sun">4</span>
                            <div class="day class">2
                                <span class="times">12:00 ~ 14:30</span>
                                <span class="students">손흥민, 이영자</span>
                            </div>
                            <span class="day">6</span>
                            <div class="day class">7
                                <span class="times">12:00 ~ 14:30</span>
                                <span class="students">박재범</span>
                            </div>
                            <span class="day">8</span>
                            <div class="day class">9
                                <span class="times">12:00 ~ 14:30</span>
                            </div>
                            <span class="day sat">10</span>
                        </div>

                        <div class="weeks">
                            <span class="day sun">11</span>
                            <div class="day class">12
                                <span class="times">12:00 ~ 14:30</span>
                            </div>
                            <span class="day">13</span>
                            <div class="day class">14
                                <span class="times">15:00 ~ 17:30</span>
                            </div>
                            <span class="day">15</span>
                            <div class="day class">16
                                <span class="times">12:00 ~ 14:30</span>
                            </div>
                            <span class="day sat">17</span>
                        </div>

                        <div class="weeks">
                            <span class="day sun">18</span>
                            <div class="day class">19
                                <span class="times">12:00 ~ 14:30</span>
                            </div>
                            <span class="day">20</span>
                            <div class="day class">21
                                <span class="times">15:00 ~ 17:30</span>
                            </div>
                            <span class="day">22</span>
                            <div class="day class">23
                                <span class="times">12:00 ~ 14:30</span>
                            </div>
                            <span class="day sat">24</span>
                        </div>

                        <div class="weeks">
                            <span class="day sun">25</span>
                            <div class="day class">26
                                <span class="times">12:00 ~ 14:30</span>
                            </div>
                            <span class="day">27</span>
                            <div class="day class">28
                                <span class="times">15:00 ~ 17:30</span>
                            </div>
                            <span class="day">29</span>
                            <div class="day class">30
                                <span class="times">12:00 ~ 14:30</span>
                            </div>
                            <span class="day sat">31</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="attend_write_button">일정 등록 날짜를 클릭/드래그 해 주세요.</div>
        </main>
    </div>

</body>

</html>