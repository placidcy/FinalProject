<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <link href="/resources/css/calendarForm.css" rel="stylesheet" />
    <link rel="stylesheet" href="/resources/css/course_mu.css">
    <script src="/resources/js/calendarForm.js"></script>
    <title>Document</title>
</head>

<body>
    <div id="container">
        <jsp:include page="common/sidebar_course.jsp" />

        <main>		
            <form id="attend_write" method="POST" enctype="multipart/form-data">
				<div id="formHeader">
					<c:choose>
						<c:when test="${formText != null}">
							<div id="formTitle">강의 일정 수정</div>
						</c:when>
						
						<c:otherwise>
							<div id="formTitle">강의 일정 등록</div>
						</c:otherwise>
					</c:choose>
				</div>
				<div id="topLine">
					<hr/>
				</div>
				
                <div class="course-title">
                    <span class="title">제목</span>
                    <input type="text" name="s_title" id="s_title" class="course_write" placeholder="제목을 작성해 주세요." value="${formText.s_title}" required/>
				</div>
				
				<div class="course-day">
                    <span class="title">일시</span>
                    <input type="datetime-local" name="sdate" class="dateInput" value="${formText.sdate}" required/> ~ <input type="datetime-local" name="edate" class="dateInput" value="${formText.edate}" required/> 					
                </div>

                <br>

                <div class="course-content">
                    <span class="title">설명</span>
                    <textarea class="content" placeholder="설명을 작성해 주세요." name="s_memo">${formText.s_memo}</textarea>
                </div>
				
				<div class="course-content">
                    <span class="title">파일</span>
                    <a href="${formText.s_attm}" ><input type="file" name="attm" /></a>
                </div>

				<c:choose>
					<c:when test="${formText != null}">
						<input type="hidden" name="i_schedule_id" value="${formText.i_schedule_id}" />
						<div id="buttonBox">
							<input type="submit" formaction="/attendUpdateProcess" class="save_button" value="수정" style="width:25%"/>
							<a href="/attendDeleteProcess?i_schedule_id=${formText.i_schedule_id}" class="delete_button">삭제</a>
						    <a href="/courseAttend" class="cancel_button" style="width:25%">취소</a>
						</div>
					</c:when>
					
					<c:otherwise>
						<div id="buttonBox">
							<input type="submit" formaction="/attendWriteProcess" class="save_button" value="저장" />
						    <a href="/courseAttend" class="cancel_button">취소</a>
						</div>	
					</c:otherwise>
				</c:choose>

            </form>
        </main>
    </div>

</body>

</html>