<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <link href="/resources/css/alert.css" rel="stylesheet" />
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/common.css">
    <script src="/resources/js/mobile.js"></script>
    <title>CHECK-알림</title>
</head>

<body>
    <div class="container flex">
        <jsp:include page="common/side_main.jsp" />
        <main class="contents bgf2f2f2">
            <h1>알림 목록</h1>

            <a href="" class="alert_list">
                <img class="sidebar-icon" src="/resources/img/alert_list.png" alt="">
                <div class="alerts">
                    <span class="alert_title">HTML의 기초</span>
                    <span class="alert_content">새 강의자료가(이) 등록되었습니다.</span>
                    <span class="alert_time">1시간 전</span>
                </div>
            </a>

            <a href="" class="alert_list">
                <img class="sidebar-icon" src="/resources/img/alert_list.png" alt="">
                <div class="alerts">
                    <span class="alert_title">HTML의 기초</span>
                    <span class="alert_content">새 공지사항이(가) 등록되었습니다.</span>
                    <span class="alert_time">08.26</span>
                </div>
            </a>

            <a href="" class="alert_list">
                <img class="sidebar-icon" src="/resources/img/alert_list.png" alt="">
                <div class="alerts">
                    <span class="alert_title">소프트웨어 개발도구의 이해와 응용</span>
                    <span class="alert_content">새 강의자료가(이) 등록되었습니다.</span>
                    <span class="alert_time">08.26</span>
                </div>
            </a>

            <a href="" class="alert_list">
                <img class="sidebar-icon" src="/resources/img/alert_list.png" alt="">
                <div class="alerts">
                    <span class="alert_title">소프트웨어 개발도구의 이해와 응용</span>
                    <span class="alert_content">새 공지사항이(가) 등록되었습니다.</span>
                    <span class="alert_time">08.26</span>
                </div>
            </a>

            <a href="" class="alert_list">
                <img class="sidebar-icon" src="/resources/img/alert_list.png" alt="">
                <div class="alerts">
                    <span class="alert_title">데이터베이스 기초 및 설계</span>
                    <span class="alert_content">새 공지사항이(가) 등록되었습니다.</span>
                    <span class="alert_time">08.26</span>
                </div>
            </a>

            <a href="" class="alert_list">
                <img class="sidebar-icon" src="/resources/img/alert_list.png" alt="">
                <div class="alerts">
                    <span class="alert_title">데이터베이스 기초 및 설계</span>
                    <span class="alert_content">새 강의자료가(이) 등록되었습니다.</span>
                    <span class="alert_time">08.26</span>
                </div>
            </a>

            <a href="" class="alert_list">
                <img class="sidebar-icon" src="/resources/img/alert_list.png" alt="">
                <div class="alerts">
                    <span class="alert_title">데이터베이스 기초 및 설계</span>
                    <span class="alert_content">새 강의자료가(이) 등록되었습니다.</span>
                    <span class="alert_time">08.26</span>
                </div>
            </a>

            <div class="paging_list">
                <a href=""><span class="prev_paging">이전</span></a>
                <a href=""></a><span class="paging active">1</span></a>
                <a href=""><span class="paging">2</span></a>
                <a href=""><span class="paging">3</span></a>
                <a href=""><span class="next_paging">다음</span></a>
            </div>
        </main>
    </div>

</body>

</html>
