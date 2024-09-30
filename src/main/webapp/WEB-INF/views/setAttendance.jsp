<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/course_mu.css">
    <link rel="stylesheet" href="css/setAttendance.css">
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <script src="js/course.js"></script>
</head>

<body>
    <div id="container">
        <aside>
            <div class="course-sidebar-left">
                <ul class="sidebar-menu">
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/mypage.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/course.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/attend.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/register.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/alert.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/notice.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/logout.png" alt="">
                        </a>
                    </li>
                </ul>
            </div>

            <div class="course-sidebar-right">
                <div class="sidebar-logo">
                    <a href=""><h1>CHECK</h1></a>
                    <h3>HTML의 기초</h3>
                        <hr>
                </div>

                <div id="mobile-menu">
                    <h1 id="backBtn">◀</h1>
                    <h1 class="menuName">HTML의 기초</h1>
                    <div id="mobile-menu-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" width="30px" height="30px" viewBox="0 0 24 24" fill="none">
                            <path d="M4 6H20M4 12H20M4 18H20" stroke="#000000" stroke-width="2" stroke-linecap="round"
                                stroke-linejoin="round" />
                        </svg>
                    </div>
                </div>
                <!-- 강사/학생에 따라 인라인 css 적용 -->
                <ul class="sidebar-menu">
                    <a href="" class="sidebar-menu-selected" style="width:25%"><li>홈</li></a>
                    <a href="" class="sidebar-menu-unselected" style="width:25%"><li>강의 게시판</li></a>
                    <a href="" class="sidebar-menu-unselected" style="width:25%"><li>출결 확인</li></a>
                    <a href="" class="sidebar-menu-unselected" style="width:25%"><li>수강 신청 관리</li></a>
                    <a href="" class="sidebar-menu-unselected" style="width:25%"><li>강의 일정 관리</li></a>
                </ul>

                <ul id="menuList" style="visibility: hidden;">
                    <li>코스</li>
                    <li>출석 체크</li>
                    <li>수강 신청</li>
                    <li>알림</li>
                    <li>공지사항</li>
                    <li>마이 페이지</li>
                    <li>로그아웃</li>
                </ul>
            </div>

            
        </aside>
      
        <main> 
         <div id="contentBox">
            <div id="attBox">
            <div id="allAtt" class="unselectedAtt">출석 현황</div> <div id="setAtt" class="selectedAtt"><div id="setAttText">온라인 출석부 설정</div></div><button id="setAttScore">출석 점수 설정</button>
            </div>
            <hr />
            
            <div>
                <div id="infoHeader">
                    <div class="infoArea1">주차</div>
                    <div class="infoArea2">시작일</div>
                    <div class="infoArea2">종료일</div>
                    <div class="infoArea3">입실 인정 시간</div>
                    <div class="infoArea3">퇴실 인정 시간</div>
                </div>

                <!-- for문으로 처리  -->
                <!-- 입실시간, 퇴실시간 눌렀을때 모달창 처리 -->
                <div id="infoList">
                    <div class="infoBox">
                        <div class="infoArea1">1</div>
                        <div class="infoArea2">2024-03-01</div>
                        <div class="infoArea2">2024-03-07</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">2</div>
                        <div class="infoArea2">2024-03-10</div>
                        <div class="infoArea2">2024-03-16</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">3</div>
                        <div class="infoArea2">2024-03-19</div>
                        <div class="infoArea2">2024-03-25</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">4</div>
                        <div class="infoArea2">2024-03-28</div>
                        <div class="infoArea2">2024-04-03</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">5</div>
                        <div class="infoArea2">2024-04-06</div>
                        <div class="infoArea2">2024-04-12</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">6</div>
                        <div class="infoArea2">2024-04-15</div>
                        <div class="infoArea2">2024-04-21</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">7</div>
                        <div class="infoArea2">2024-04-24</div>
                        <div class="infoArea2">2024-04-30</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">8</div>
                        <div class="infoArea2">2024-05-03</div>
                        <div class="infoArea2">2024-05-09</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">9</div>
                        <div class="infoArea2">2024-05-12</div>
                        <div class="infoArea2">2024-05-18</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">10</div>
                        <div class="infoArea2">2024-05-21</div>
                        <div class="infoArea2">2024-05-27</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">11</div>
                        <div class="infoArea2">2024-05-30</div>
                        <div class="infoArea2">2024-06-05</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">12</div>
                        <div class="infoArea2">2024-06-08</div>
                        <div class="infoArea2">2024-06-14</div>
                        <div class="infoArea3">09:10</div>
                        <div class="infoArea3">17:50</div>
                    </div>
                    
                </div>
            </div>
            <!--자바스크립트로 버튼 활성화 비활성화-->
            <!-- 12개의 목록마다 1페이지 -->
            <div id="page">
                <button id="minusPage">이전</button> <span id="targetPage" class="pageNumber">1</span> <span class="pageNumber">2</span> <span class="pageNumber">3</span> <button id="plusPage">다음</button>
            </div>
         </div>
        </main>
        
    </div>
</body>

</html>