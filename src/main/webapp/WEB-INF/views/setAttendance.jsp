<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/course_mu.css">
    <link rel="stylesheet" href="/resources/css/setAttendance.css">
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <script src="/resources/js/course.js"></script>
</head>

<body>
    <div id="container">
       <jsp:include page="common/sidebar_course.jsp" />
      
        <main> 
         <div id="contentBox">
            <div id="attBox">
            <a href="/currentAttendance" id="allAtt" class="unselectedAtt">출석 현황</a> <a href="/setAttendance" id="setAtt" class="selectedAtt"><div id="setAttText">온라인 출석부 설정</div></a>
			<button id="setAttScore">출석 점수 설정</button>
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