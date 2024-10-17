<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/course_mu.css">
    <link rel="stylesheet" href="/resources/css/attendanceCalendar.css">
    <link rel="stylesheet" href="/resources/css/requestDialog.css">
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <script src="/resources/js/attendanceCalendar.js"></script>

</head>

<body>
    <div id="container">
        <jsp:include page="common/sidebar_course.jsp" />
        <main> 

         <div id="calendarHeader">
            <div id="dateBox"><button class="switchBox" id="leftMonth">◀</button><span id="yearMonth"></span><button class="switchBox" id="rightMonth">▶</button><button id="todayBox">오늘</button></div>
            <div>
            <span id="notice">* 출결 정정 요청 또는 공가 요청은 3회까지 재요청 가능합니다.</span>
            <span id="fontBox"><span id="attendFont">출석</span>, <span id="lateFont">지각</span>, <span id="absenceFont">결석</span></span>
            </div> 
			
			<dialog id="modal">
			    <div class="modal-top flex cen">
					<!--공가요청이면 공가 요청-->
			        <span class="bold">출결 정정 요청</span>
			        <span class="f24 exit">✕</span>
			    </div>
			    <div class="modal-bottom req">
					
				<form class="requestForm" method="POST" action="/attResponse">
					<div>
					<!--공가요청이면 일자 시작일~마지막일-->
	                <div class="modalFont">일자 : &nbsp <input type="date" value="2024-03-12"/> </div>
					<!--공가요청이면 공가 사유-->
					<div class="modalFont">상태 : &nbsp <span class="modalFont"></span></div>

	                <label for="textBox" id="textBoxLabel">내용 :</label>
	                <textarea id="textBox" placeholder="내용을 입력해 주세요."></textarea> 
					
	                <div id="fileBox" class="modalFont"> <div id="fileFont">증명서류: &nbsp </div>
						<label for="file">
						  <div class="btn-upload">이미지/문서 첨부</div>
						</label>					
						<input type="file" name="file" id="file">
					</div>
                	
					<div id="btnBox">
						<input type="submit" value="요청하기" />
					</div>
		        </form>
			    </div>
			</dialog>
        </div>
        
            <div id="dayBox">
            <div class="day">일</div>
            <div class="day">월</div>
            <div class="day">화</div>
            <div class="day">수</div>
            <div class="day">목</div>
            <div class="day">금</div>
            <div id="saturday">토</div>
            </div>
			
            <input type="hidden" id="c_sdate" value="${courseDate.c_sdate}" />
            <input type="hidden" id="c_edate" value="${courseDate.c_edate}" />
			
            <table id="calendarBox">
                          
            </table>
			
            <div id="calendarExplain">
                출결 정정 요청 또는 공가 요청 날짜를 클릭/드래그 해 주세요.
            </div>  
            
        </main>
        
    </div>
</body>

</html>