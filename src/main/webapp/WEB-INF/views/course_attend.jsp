<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>

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
                            <% 
                                Calendar calendar = new GregorianCalendar();
                                int year = 2024; 
                                int month = 7; 
                                calendar.set(year, month, 1);
                                int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                                int lastDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                                
                                for (int i = 1; i < firstDayOfWeek; i++) {
                                    out.print("<span class='prev-day'></span>");
                                }
                                for (int date = 1; date <= lastDate; date++) {
                                    if ((firstDayOfWeek + date - 1) % 7 == 0 && date != 1) {
                                        out.print("</div><div class='weeks'>");
                                    }
                                    out.print("<span class='day'>" + date + "</span>");
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
            <div class="attend_write_button">일정 등록 날짜를 클릭/드래그 해 주세요.</div>
        </main>
    </div>

</body>

</html>