<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!-- 메인 사이드바 -->
<aside class="sidebar main cffffff">
    <div class="flex cen v h logo p50">
        <h1 class="f32">CHECK</h1>
        <div class="mobile" id="hamburger">
            <svg class="icon" xmlns="http://www.w3.org/2000/svg" width="30px" height="30px" viewBox="0 0 24 24"
                fill="none">
                <path d="M4 6H20M4 12H20M4 18H20" stroke="#000000" stroke-width="2" stroke-linecap="round"
                    stroke-linejoin="round" />
            </svg>
        </div>
    </div>
    <ul class="menulist" id="main">
        <a href="main.html">
            <li class="menu cffffff">코스</li>
        </a>
        <a href="checkin.html">
            <li class="menu cffffff">출석 체크</li>
        </a>
        <a href="">
            <li class="menu cffffff">수강 신청</li>
        </a>
        <a href="">
            <li class="menu cffffff">알림</li>
        </a>
        <a href="">
            <li class="menu cffffff">공지사항</li>
        </a>
        <a href="<c:url value='/mypage' />">
            <li class="menu cffffff">마이 페이지</li>
        </a>
        <a href="<c:url value='/logout' />">
            <li class="menu cffffff">로그아웃</li>
        </a>
    </ul>
</aside>