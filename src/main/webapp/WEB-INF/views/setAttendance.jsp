<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/course_mu.css" />
    <link rel="stylesheet" href="/resources/css/setAttendance.css" />
	<link rel="stylesheet" href="/resources/css/setAttDialog.css" />
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <script src="/resources/js/setAttendance.js"></script>
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
			<dialog id="setAttScoreModal">
			       <div class="modal-top flex cen">
			           <span class="bold">출석 점수 설정</span>
			           <span class="f24 exit">✕</span>
			       </div>
			       <div class="modal-bottom req">
			           <form class="grid g10 requestForm" method="POST" action="setAttendanceScore">
			               <table>
			                   <tr>
								<p class="modal-text">*출석점수는 0에서 20점 사이의 값이어야 합니다.</p>
								<p class="modal-text">*지각, 결석 점수는 -10에서 10점 사이의 값이어야 합니다.</p>
			                       <td>출석점수</td>
			                       <td><input type="number" id="c_prsscore" name="c_prsscore" value="${courseScore.c_prsscore}"></td>
			                   </tr>
							   
							   <tr>
	   		                       <td>지각점수</td>
	   		                       <td><input type="number" id="c_trdscore" name="c_trdscore" value="${courseScore.c_trdscore}"></td>
							   </tr>

								<tr>
			                       <td>결석점수</td>
			                       <td><input type="number" id="c_absscore" name="c_absscore" value="${courseScore.c_absscore}"></td>
							   </tr>
			               </table>
			               <input id="submitBtn" class="btn f20" type="submit" value="설정하기">
			           </form>
			       </div>
			   </dialog>
            <hr />
            
            <div>
                <div id="infoHeader">
                    <div class="infoArea1">주차</div>
                    <div class="infoArea2">시작일</div>
                    <div class="infoArea2">종료일</div>
                    <div class="infoArea3">입실 인정 시간</div>
                    <div class="infoArea3">퇴실 인정 시간</div>
                </div>

                <!-- for문으로 처리 12개 -->
                <!-- 입실시간, 퇴실시간 눌렀을때 모달창 처리 -->
                <div id="infoList">
					
					<c:forEach items="${courseDateInfo}" var="dateInfo" varStatus="status" begin="${setAttPage*12}" end="${setAttPage*12 + 11}">
                    <div class="infoBox">
                        <div class="infoArea1">${setAttPage*12+status.count}</div>
						<div class="infoArea2">${dateInfo.s_sdate.getYear()}-${dateInfo.getZero(dateInfo.s_sdate.getMonthValue())}-${dateInfo.getZero(dateInfo.s_sdate.getDayOfMonth())}</div>
						<div class="infoArea2">${dateInfo.s_edate.getYear()}-${dateInfo.getZero(dateInfo.s_edate.getMonthValue())}-${dateInfo.getZero(dateInfo.s_edate.getDayOfMonth())}</div>
                        <div class="infoArea3">${dateInfo.getCtime(dateInfo.s_stime, -dateInfo.s_cinterm)}</div>
                        <div class="infoArea3">${dateInfo.getCtime(dateInfo.s_etime, dateInfo.s_coutterm)}</div>
                    </div>
					</c:forEach>
				
				</div>
            </div>
			
            <div id="page">
				
				<c:choose>
					<c:when test="${setAttPage==0}">
						<button id="minusPage" disabled>이전</button>
					</c:when>
					<c:otherwise>
						<a href="/setAttendance?setAttPage=${setAttPage-1}"><button id="minusPage" style="cursor:pointer">이전</button></a>	
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${courseDateInfo.size()==0}">
						<span id="targetPage" class="pageNumber">1</span>
					</c:when>
					<c:otherwise>
						<c:forEach  begin="0" end="${Math.floor((courseDateInfo.size()-1)/12)}" varStatus="status">
							<a href="/setAttendance?setAttPage=${status.count-1}"><span id="targetPage" class="pageNumber">${status.count}</span></a>
						</c:forEach>
					</c:otherwise>
				</c:choose>
					
				<c:choose>
					<c:when test="${courseDateInfo.size()==0 || Math.floor((courseDateInfo.size()-1)/12) == setAttPage}">
						<button id="plusPage" disabled>다음</button>
					</c:when>
					<c:otherwise>
						<a href="/setAttendance?setAttPage=${setAttPage+1}"><button id="plusPage" style="cursor:pointer">다음</button></a>
					</c:otherwise>
				</c:choose>

            </div>
         </div>
        </main>
        
    </div>
</body>

</html>