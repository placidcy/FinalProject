<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/course_mu.css">
    <link rel="stylesheet" href="css/currentAttendance.css">
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
            <div id="allAtt" class="selectedAtt">출석 현황</div> <div id="setAtt" class="unselectedAtt"><div id="setAttText">온라인 출석부 설정</div></div>
            </div>
            <hr />

            <div id="searchArea">
                <form id="formBox">
                    <div id="searchFont">검색</div> 
                    <select name="searchType" id="searchType">
                        <option value="name">이름</option>
                        <option value="organization">소속</option>
                    </select>
                
                    <div class="search-box">
                    <input type="text" placeholder="검색어를 입력하세요.">
                    <button type="submit" class="search-button">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50" width="20px" height="20px">
                            <path
                                d="M 21 3 C 11.601563 3 4 10.601563 4 20 C 4 29.398438 11.601563 37 21 37 C 24.355469 37 27.460938 36.015625 30.09375 34.34375 L 42.375 46.625 L 46.625 42.375 L 34.5 30.28125 C 36.679688 27.421875 38 23.878906 38 20 C 38 10.601563 30.398438 3 21 3 Z M 21 7 C 28.199219 7 34 12.800781 34 20 C 34 27.199219 28.199219 33 21 33 C 13.800781 33 8 27.199219 8 20 C 8 12.800781 13.800781 7 21 7 Z" />
                        </svg>
                    </button>
                    </div>
                </form>
            </div>
            
            <div>
                <div id="infoHeader">
                    <div class="infoArea1">번호</div>
                    <div class="infoArea2">이름</div>
                    <div class="infoArea3">소속</div>
                    <div class="infoArea4">출석</div>
                    <div class="infoArea5">지각</div>
                    <div class="infoArea6">결석</div>
                    <div class="infoArea7">점수</div>
                </div>

                <!-- for문으로 처리  -->
                <!-- status-bar 컴포넌트 화 -->
                <div id="infoList">
                    <div class="infoBox">
                        <div class="infoArea1">1</div>
                        <div class="infoArea2">손흥민</div>
                        <div class="infoArea3">KDT유데미</div>
                        <div class="infoArea4"><div class="status-bar"></div>6/6</div>
                        <div class="infoArea5">0</div>
                        <div class="infoArea6">0</div>
                        <div class="infoArea7">20</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">2</div>
                        <div class="infoArea2">황희찬</div>
                        <div class="infoArea3">KDT유데미</div>
                        <div class="infoArea4"><div class="status-bar"></div>6/6</div>
                        <div class="infoArea5">0</div>
                        <div class="infoArea6">0</div>
                        <div class="infoArea7">20</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">3</div>
                        <div class="infoArea2">김연아</div>
                        <div class="infoArea3">서울대학교</div>
                        <div class="infoArea4"><div class="status-bar"></div>6/6</div>
                        <div class="infoArea5">0</div>
                        <div class="infoArea6">0</div>
                        <div class="infoArea7">20</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">4</div>
                        <div class="infoArea2">김연경</div>
                        <div class="infoArea3">홍익대학교</div>
                        <div class="infoArea4"><div class="status-bar"></div>6/6</div>
                        <div class="infoArea5">0</div>
                        <div class="infoArea6">0</div>
                        <div class="infoArea7">20</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">5</div>
                        <div class="infoArea2">류현진</div>
                        <div class="infoArea3">삼성</div>
                        <div class="infoArea4"><div class="status-bar"></div>6/6</div>
                        <div class="infoArea5">0</div>
                        <div class="infoArea6">0</div>
                        <div class="infoArea7">20</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">6</div>
                        <div class="infoArea2">이대호</div>
                        <div class="infoArea3">롯데</div>
                        <div class="infoArea4"><div class="status-bar"></div>6/6</div>
                        <div class="infoArea5">0</div>
                        <div class="infoArea6">0</div>
                        <div class="infoArea7">20</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">7</div>
                        <div class="infoArea2">강호동</div>
                        <div class="infoArea3">1반</div>
                        <div class="infoArea4"><div class="status-bar"></div>6/6</div>
                        <div class="infoArea5">2</div>
                        <div class="infoArea6">0</div>
                        <div class="infoArea7">18</div>
                    </div>

                    <div class="infoBox">
                        <div class="infoArea1">8</div>
                        <div class="infoArea2">고창석</div>
                        <div class="infoArea3">2반</div>
                        <div class="infoArea4"><div class="status-bar"></div>6/6</div>
                        <div class="infoArea5">1</div>
                        <div class="infoArea6">1</div>
                        <div class="infoArea7">16</div>
                    </div>
                    
                </div>
            </div>
            <!--자바스크립트로 버튼 활성화 비활성화-->
            <div id="page">
                <button id="minusPage">이전</button> <span id="targetPage" class="pageNumber">1</span> <span class="pageNumber">2</span> <span class="pageNumber">3</span> <button id="plusPage">다음</button>
            </div>
         </div>
        </main>
        
    </div>
</body>

</html>