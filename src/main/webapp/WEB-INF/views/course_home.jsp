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
    <script src="/resources/js/course.js"></script>

</head>

<body>
    <div id="container">
        <jsp:include page="common/side_course.jsp" />
      
        <main>
            <div id="homeBox">
                <div class="course-notice-title">
                    <h3>공지 목록</h3>
                    <a href="">
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
                        <h3>HTML의 기초</h3>
                        <h4>설명: </h4>
                        <h4>기간: 2024.03.12~2024.06.30</h4>
                    </div>

                    <div id="linkBtnBox">
                        <div id="memoBtnBox">
                        <button id="memoBtn">필기하기</button>
                        </div>

                        <div>
                        <button id="classBtn">입장하기</button>
                        </div>
                    </div>

                </div>

                <h3>노트 필기</h3>
                <div id="noteListBox">
                    
                    <!-- 등록된 필기가 없다면 다음의 문구를 보여준다.-->
                    <!--
                    <h3>현재 등록된 노트 필기가 없습니다.</h3> 
                    -->
                    <div id="noteBox">
                        <div class="noteDate">작성일: 2024-12-30 13:20</div>  

                        <div class="noteContent">
                            법관은 탄핵 또는 금고 이상의 형의 선고에 의하지 아니하고는 파면되지 아니하며, 징계처분에 의하지 아니하고는 정직·감봉 기타 불리한 처분을 받지 아니한다. 헌법재판소는 법률에 저촉되지 아니하는 범위안에서 심판에 관한 절차, 내부규율과 사무처리에 관한 규칙을 제정할 수 있다. 국가는 건전한 소비행위를 계도하고 생산품의 품질향상을 촉구하기 위한 소비자보호운동을 법률이 정하는 바에 의하여 보장한다. 법률이 헌법에 위반되는 여부가 재판의 전제가 된 경우에는 법원은 헌법재판소에 제청하여 그 심판에 의하여 재판한다. 국가유공자·상이군경 및 전몰군경의 유가족은 법률이 정하는 바에 의하여 우선적으로 근로의 기회를 부여받는다.
                            재판의 심리와 판결은 공개한다. 다만, 심리는 국가의 안전보장 또는 안녕질서를 방해하거나 선량한 풍속을 해할 염려가 있을 때에는 법원의 결정으로 공개하지 아니할 수 있다. 모든 국민은 인간다운 생활을 할 권리를 가진다. 헌법재판소 재판관은 탄핵 또는 금고 이상의 형의 
                        </div>
                    </div>

                    <div id="noteBox">
                        <div class="noteDate">작성일: 2024-12-30 13:20</div>  

                        <div class="noteContent">
                            법관은 탄핵 또는 금고 이상의 형의 선고에 의하지 아니하고는 파면되지 아니하며, 징계처분에 의하지 아니하고는 정직·감봉 기타 불리한 처분을 받지 아니한다. 헌법재판소는 법률에 저촉되지 아니하는 범위안에서 심판에 관한 절차, 내부규율과 사무처리에 관한 규칙을 제정할 수 있다. 국가는 건전한 소비행위를 계도하고 생산품의 품질향상을 촉구하기 위한 소비자보호운동을 법률이 정하는 바에 의하여 보장한다. 법률이 헌법에 위반되는 여부가 재판의 전제가 된 경우에는 법원은 헌법재판소에 제청하여 그 심판에 의하여 재판한다. 국가유공자·상이군경 및 전몰군경의 유가족은 법률이 정하는 바에 의하여 우선적으로 근로의 기회를 부여받는다.
                            재판의 심리와 판결은 공개한다. 다만, 심리는 국가의 안전보장 또는 안녕질서를 방해하거나 선량한 풍속을 해할 염려가 있을 때에는 법원의 결정으로 공개하지 아니할 수 있다. 모든 국민은 인간다운 생활을 할 권리를 가진다. 헌법재판소 재판관은 탄핵 또는 금고 이상의 형의 
                        </div>
                    </div>

                    <div id="noteBox">
                        <div class="noteDate">작성일: 2024-12-30 13:20</div>  

                        <div class="noteContent">
                            법관은 리와 판결은 공개한다. 다만, 심리는 국가의 안전보장 또는 안녕질서를 방해하거나 선량한 풍속을 해할 염려가 있을 때에는 법원의 결정으로 공개하지 아니할 수 있다. 모든 국민은 인간다운 생활을 할 권리를 가진다. 헌법재판소 재판관은 탄핵 또는 금고 이상의 형의 
                        </div>
                    </div>
                </div>
            </div>
           
        </main>
    </div>
</body>

</html>