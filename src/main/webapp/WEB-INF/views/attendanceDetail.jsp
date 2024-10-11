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
	<link rel="stylesheet" href="/resources/css/attendanceDetailDialog.css">
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <script src="/resources/js/attendanceDetail.js"></script>
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
		<dialog id="responseModal">
			    <div class="modal-top flex cen">
					<!--공가요청이면 공가 요청 승인-->
			        <span class="bold">출결 정정 승인</span>
			        <span class="f24 exit">✕</span>
			    </div>
			    <div class="modal-bottom req">
					     <div>
							<!--공가요청이면 일자 시작일~마지막일-->
			                <div class="modalFont">일자 : &nbsp&nbsp <span class="modalFont"></span></div>
							<!--공가요청이면 공가 사유-->
							<div class="modalFont">출결 : &nbsp&nbsp <span class="modalFont"></span></div>
	
			                <label for="textBox" id="textBoxLabel">내용 :</label>
			                <textarea id="textBox" disabled>일전에 있던 3월 23일 수업에 교통사고로 인해 불가피하게 지각하였습니다.</textarea> 
							
			                <div class="modalFont"> 증명서류: &nbsp&nbsp <a class="file" href="">파일</a></div>
		                <hr />
				<form class="requestForm" method="POST" action="/attResponse">
		            <input type="hidden" name="date" value="2024.03.21" />
					<input type="hidden" name="reqType" value="1" />
					<input type="hidden" name="student_id" value="${studentAtt.student_id}" />
					
                    <label id="radioLabel" for="radioBox">응답 상태:</label>
                    <div id="radioBox">
                        <div>
                            <input type="radio" name="r_status" id="approved" value="1">
                            <label for="approved" class="modalFont">승인</label>
                        </div>
                        <div>
                            <input type="radio" name="r_status" id="denied" value="2">
                            <label for="denied" class="modalFont">거부</label>
                        </div>
                    </div>
					
	                <div class="hidden" id="reqCheckRow">
	                    <label class="modalFont">응답 사유:</label>
						<select name="r_details" id="r_details"></select>
		            </div>

		            <div class="btnBox">
		                <input type="submit" class="modalBtn" id="submitBtn" value="요청처리" />
		                <input type="button" class="modalBtn" id="cancleModal" value="취소" />
		            </div>
		        </form>
			    </div>
			</dialog>

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
                <div id="attRatio">
					<c:choose>
						
						<c:when test="${studentAtt.c+studentAtt.l+studentAtt.d+studentAtt.ab==0}">
							<strong>출석률</strong> &nbsp<span class="summationFont">(0일/0일)</span>
							<br />
							<!-- 60.2%라면 -1.3%를 뺴줘야 설명 부분의 위치가 맞게 위치한다. -->
							<div id="staticBox">
							   <div id="static-bar"><div id="static-bar-gage" style="width:0%"></div></div>             	
							</div>
						</c:when>
						
						<c:otherwise>
							<strong>출석률</strong> &nbsp<span class="summationFont">${Math.round((studentAtt.c+studentAtt.d)*10000/(studentAtt.c+studentAtt.l+studentAtt.d+studentAtt.ab))/100}% (${studentAtt.c+studentAtt.d}/${(studentAtt.c+studentAtt.l+studentAtt.d+studentAtt.ab)}일)</span>
							<br />
							<!-- 60.2%라면 -1.3%를 뺴줘야 설명 부분의 위치가 맞게 위치한다. -->
							<div id="staticBox">
							   <div id="static-bar"><div id="static-bar-gage" style="width:${Math.round((studentAtt.c+studentAtt.d)*10000/(studentAtt.c+studentAtt.l+studentAtt.d+studentAtt.ab))/100}%"></div></div>
							   <div id="explain" style="margin-left:${Math.round((studentAtt.c+studentAtt.d)*10000/(studentAtt.c+studentAtt.l+studentAtt.d+studentAtt.ab))/100-1.3}%">▲<br /><strong>${studentAtt.m_name}</strong><br /> ${Math.round((studentAtt.c+studentAtt.d)*10000/(studentAtt.c+studentAtt.l+studentAtt.d+studentAtt.ab))/100}%</div>               	
							</div>
						</c:otherwise>
						
					</c:choose>						
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
                            
						<c:choose>
							
							<c:when test="${att.a_request == '정정승낙'}">
								<div class="infoArea2">○</div>
							</c:when>
							
							<c:otherwise>
								<div class="infoArea2">${att.getEmblem(att.a_status)}</div>
							</c:otherwise>	
							
						</c:choose>
                            <div class="infoArea3">${att.a_request}</div>
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
                    <div class="requestArea3">대상 일자</div>
                    <div class="requestArea4">요청 일자</div>
					<div class="requestArea4">응답일자</div>
                    <div class="requestArea5">상태</div>
                </div>

                <!-- for문으로 처리 -->
                <!-- 정정 승인, 공가 승인 모달창과 연결 -->
                <div id="requestList">
				<c:forEach items="${correqList}" var="correq">
                <div class="correquestInfoBox">
                    <div class="requestArea6">출결 정정</div>
                    <div class="requestArea8">${correq.a_date.getYear()}.${correq.getZero(correq.a_date.getMonthValue())}.${correq.getZero(correq.a_date.getDayOfMonth())}</div>
					<input type="hidden" data-text="${correq.contents}" />
					<input type="hidden" data-text="${correq.attm}" />
                    <div class="requestArea9">${correq.getZero(correq.req_date.getMonthValue())}.${correq.getZero(correq.req_date.getDayOfMonth())}</div>
					
					<c:choose>	
						<c:when test="${correq.res_date != null}">
							<div class="requestArea7">${correq.getZero(correq.res_date.getMonthValue())}.${correq.getZero(correq.res_date.getDayOfMonth())}</div>
						</c:when>
						
						<c:otherwise>
							<div class="requestArea7"></div>
						</c:otherwise>	
					</c:choose>
					
                    <div class="requestArea10">${correq.getRstatus(correq.r_status)}</div>
                </div>
				</c:forEach>
				
				<c:forEach items="${lvreqList}" var="lvreq">
                <div class="lvrequestInfoBox">
                    <div class="requestArea6">공가</div>
                    <div class="requestArea8">${lvreq.l_sdate.getYear()}.${lvreq.getZero(lvreq.l_sdate.getMonthValue())}.${lvreq.getZero(lvreq.l_sdate.getDayOfMonth())}~${lvreq.getZero(lvreq.l_edate.getMonthValue())}.${lvreq.getZero(lvreq.l_edate.getDayOfMonth())}</div>
					<input type="hidden" data-text="${lvreq.contents}" />
					<input type="hidden" data-text="${lvreq.attm}" />
					<input type="hidden" data-text="${lvreq.l_reason}" />
					<div class="requestArea9">${lvreq.getZero(lvreq.req_date.getMonthValue())}.${lvreq.getZero(lvreq.req_date.getDayOfMonth())}</div>
					
					<c:choose>
						<c:when test="${lvreq.res_date != null}">
							<div class="requestArea7">${lvreq.getZero(lvreq.res_date.getMonthValue())}.${lvreq.getZero(lvreq.res_date.getDayOfMonth())}</div>
						</c:when>
						
						<c:otherwise>
							<div class="requestArea7"></div>
						</c:otherwise>
					</c:choose>

                    <div class="requestArea10">${lvreq.getRstatus(lvreq.r_status)}</div>
                </div>
				</c:forEach>
               </div>

            </div>
            
        </div>
        </main>
        
    </div>
</body>

</html>