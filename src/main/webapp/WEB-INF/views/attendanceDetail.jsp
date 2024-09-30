<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/course_mu.css">
    <link rel="stylesheet" href="css/attendanceDetail.css">
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
        <button id="allListBtn">전체 목록</button>
        <div id="infoBox-header">
            <div id="infoBox">
              <div id="infoTitle">소속</div><div id="infoContent">KDT 유데미</div>
            </div>  
            <div id="infoBox">
              <div id="infoTitle">이름</div><div id="infoContent">손흥민</div>
            </div>
            <div id="infoBox">
              <div id="infoTitle">휴대 전화</div><div id="infoContent">010-1234-5678</div>
            </div>
        </div>


        <div id="contentBox">
            <div class="content">
                <div>
                    <strong>출결 소계</strong>
                    <br />
                    <div id="summationInfoBox">
                        <div class="summationInfo">
                            <span class="summationFont">출석</span><br/> <strong>65</strong>
                        </div>
                        <div class="summationInfo">
                            <span class="summationFont">지각</span><br/> <strong>6</strong>
                        </div>
                        <div class="summationInfo">
                            <span class="summationFont">조퇴</span><br/> <strong>1</strong>
                        </div>
                        <div class="summationInfo">
                            <span class="summationFont">결석</span><br/> <strong>2</strong>
                        </div>
                    </div>
                </div>
                <div>
                    <strong>출석률</strong> &nbsp<span class="summationFont">60.2% (65/108일)</span>
                    <br />
                    <!-- 60.2%라면 -1.3%를 뺴줘야 설명 부분의 위치가 맞게 위치한다. -->
                    <div id="staticBox">
                       <div id="static-bar"><div id="static-bar-gage" style="width:60.2%"></div></div>
                       <div id="explain" style="margin-left:58.9%">▲<br /><strong>손흥민</strong><br /> 60.2%</div>
                    </div>
                </div>
            </div>

            <div class="content">
                <div>
                <div><strong>* 출석 요건: 기간내 출석 인정</strong></div>
                <div id="fontBox"><span id="attFont1">출석-[○]</span>, 지각-[▲], <span id="attFont2">결석-[X]</span></div>
                <div id="attBox">
                    <div id="infoHeader">
                        <div class="infoArea">교육 일자</div>
                        <div class="infoArea">출석 여부</div>
                        <div class="infoArea">비고</div>
                    </div>
    
                    <!-- for문으로 처리  -->
                    <div id="infoList">
                         <div class="infoBox">
                            <div class="infoArea1">3/14</div>
                            <div class="infoArea2">○</div>
                            <div class="infoArea3"></div>
                        </div>

                        <div class="infoBox">
                            <div class="infoArea1">3/16</div>
                            <div class="infoArea2">○</div>
                            <div class="infoArea3"></div>
                        </div>

                        <div class="infoBox">
                            <div class="infoArea1">3/19</div>
                            <div class="infoArea2">○</div>
                            <div class="infoArea3"></div>
                        </div>

                        <div class="infoBox">
                            <div class="infoArea1">3/21</div>
                            <div class="infoArea2">▲</div>
                            <div class="infoArea3">정정 요청</div>
                        </div>

                        <div class="infoBox">
                            <div class="infoArea1">3/23</div>
                            <div class="infoArea2">X</div>
                            <div class="infoArea3"></div>
                        </div>

                        <div class="infoBox">
                            <div class="infoArea1">3/26</div>
                            <div class="infoArea2">○</div>
                            <div class="infoArea3"></div>
                        </div>

                        <div class="infoBox">
                            <div class="infoArea1">3/28</div>
                            <div class="infoArea2">○</div>
                            <div class="infoArea3"></div>
                        </div>

                        <div class="infoBox">
                            <div class="infoArea1">3/30</div>
                            <div class="infoArea2">○</div>
                            <div class="infoArea3"></div>
                        </div>

                        <div class="infoBox">
                            <div class="infoArea1">4/04</div>
                            <div class="infoArea2"></div>
                            <div class="infoArea3">공가 요청</div>
                        </div>

                        <div class="infoBox">
                            <div class="infoArea1">4/06</div>
                            <div class="infoArea2"></div>
                            <div class="infoArea3">공가 요청</div>
                        </div>

                        <div class="infoBox">
                            <div class="infoArea1">4/08</div>
                            <div class="infoArea2"></div>
                            <div class="infoArea3">공가 요청</div>
                        </div>
                    </div>

                </div>

                
            </div>

            <div id="requestBox">
                <div>
                    <strong>출결 정정/공가 요청</strong>
                </div>
                <div id="helpComment">
                    * 요청 클릭 시 승인 관리창 생성
                </div>

                <div id="requestHeader">
                    <div class="requestArea1">요청 유형</div>
                    <div class="requestArea2">출결</div>
                    <div class="requestArea3">대상 일자</div>
                    <div class="requestArea4">요청 일자</div>
                    <div class="requestArea5">상태</div>
                </div>

                <!-- for문으로 처리 -->
                <!-- 정정 승인, 공가 승인 모달창과 연결 -->
                <div id="requestList">
                <div id="requestInfoBox">
                    <div class="requestArea6">출결 정정 요청</div>
                    <div class="requestArea7">지각</div>
                    <div class="requestArea8">2024.03.21</div>
                    <div class="requestArea9">2024.03.30</div>
                    <div class="requestArea10">요청</div>
                </div>

                <div id="requestInfoBox">
                    <div class="requestArea6">공가 요청</div>
                    <div class="requestArea7"></div>
                    <div class="requestArea8">2024.04.09~4.13</div>
                    <div class="requestArea9">2024.03.30</div>
                    <div class="requestArea10">거절</div>
                </div>

               </div>

            </div>
            
        </div>
        </main>
        
    </div>
</body>

</html>