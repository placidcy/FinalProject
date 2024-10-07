<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/course_mu.css">
    <link rel="stylesheet" href="/resources/css/attendanceDetail.css">
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <script src="/resources/js/course.js"></script>
</head>

<body>
    <div id="container">
       <jsp:include page="common/sidebar_course.jsp" />
        <main> 
		<a href="currentAttendance?course_id=2">
        <button id="allListBtn">전체 목록</button>
		</a>
        <div id="infoBox-header">
			
            <div id="infoBox">
			 <c:choose>
			  <c:when test="${studentAtt.m_dept == null}">
				<div id="infoTitle">소속</div><div id="infoContent">-</div>
			  </c:when>
			  <c:otherwise>
               <div id="infoTitle">소속</div><div id="infoContent">${studentAtt.m_dept}</div>
			  </c:otherwise>
			 </c:choose>	 
            </div>  
			
            <div id="infoBox">
              <div id="infoTitle">이름</div><div id="infoContent">${studentAtt.m_name}</div>
            </div>
			
			<div id="infoBox">
		 	 <c:choose>
			  <c:when test="${studentAtt.m_tel == null}">
				<div id="infoTitle">휴대 전화</div><div id="infoContent">-</div>
			   </c:when>
			   <c:otherwise>
	            <div id="infoTitle">휴대 전화</div><div id="infoContent">${studentAtt.m_tel}</div>
			   </c:otherwise>
	  		  </c:choose>	 

            </div>
			
			
        </div>


        <div id="contentBox">
            <div class="content">
                <div>
                    <strong>출결 소계</strong>
                    <br />
                    <div id="summationInfoBox">
                        <div class="summationInfo">
                            <span class="summationFont">출석</span><br/> <strong>${studentAtt.c}</strong>
                        </div>
                        <div class="summationInfo">
                            <span class="summationFont">지각</span><br/> <strong>${studentAtt.l}</strong>
                        </div>
                        <div class="summationInfo">
                            <span class="summationFont">조퇴</span><br/> <strong>${studentAtt.d}</strong>
                        </div>
                        <div class="summationInfo">
                            <span class="summationFont">결석</span><br/> <strong>${studentAtt.ab}</strong>
                        </div>
                    </div>
                </div>
                <div>
                    <strong>출석률</strong> &nbsp<span class="summationFont">${Math.round((studentAtt.c+studentAtt.d)*10000/(studentAtt.c+studentAtt.l+studentAtt.d+studentAtt.ab))/100}% (${studentAtt.c+studentAtt.d}/${(studentAtt.c+studentAtt.l+studentAtt.d+studentAtt.ab)}일)</span>
                    <br />
                    <!-- 60.2%라면 -1.3%를 뺴줘야 설명 부분의 위치가 맞게 위치한다. -->
                    <div id="staticBox">
                       <div id="static-bar"><div id="static-bar-gage" style="width:${Math.round((studentAtt.c+studentAtt.d)*10000/(studentAtt.c+studentAtt.l+studentAtt.d+studentAtt.ab))/100}%"></div></div>
                       <div id="explain" style="margin-left:${Math.round((studentAtt.c+studentAtt.d)*10000/(studentAtt.c+studentAtt.l+studentAtt.d+studentAtt.ab))/100-1.3}%">▲<br /><strong>${studentAtt.m_name}</strong><br /> ${Math.round((studentAtt.c+studentAtt.d)*10000/(studentAtt.c+studentAtt.l+studentAtt.d+studentAtt.ab))/100}%</div>
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
						<c:forEach items="${attList}" var="att"> 
                         <div class="infoBox">
                            <div class="infoArea1">${att.getZero(att.a_date.getMonthValue())}/${att.getZero(att.a_date.getDayOfMonth())}</div>
                            <div class="infoArea2">${att.getEmblem(att.a_status)}</div>
                            <div class="infoArea3"></div>
                        </div>
						</c:forEach> 
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