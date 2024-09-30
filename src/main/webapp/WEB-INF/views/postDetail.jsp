<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/course_mu.css">
    <link rel="stylesheet" href="css/postDetail.css">
    <link rel="stylesheet" href="css/dialog.css">
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <script src="js/postDetail.js"></script>

</head>

<body>
    <div id="container">
        <jsp:include page="common/sidebar_course.jsp" />
        <main>
            <div class="">
                <dialog id="modal">
                    <div class="modal-top flex cen">
                        <span class="bold">신고하기</span>
                        <span class="f24 exit">✕</span>
                    </div>
                    <div class="modal-bottom">
                        <input type="hidden" name="reportId" value="">
                        <table>
                            <tr>
                                <td class="modal-text">작성자</td>
                                <td>gild****</td>
                            </tr>
                            <tr>
                                <td class="modal-text">내용</td>
                                <td id="dialogContent"></td>
                            </tr>
                        </table>
                        <hr>
                        <form class="grid g10 ac" action="">
                            <p class="bold">사유 선택</p>
                            <div>
                                <input type="radio" name="신고사유" id="1">
                                <label class="bold" for="1">스팸</label>
                            </div>
                            <div>
                                <input type="radio" name="신고사유" id="2">
                                <label class="bold" for="2">음란물</label>
                            </div>
                            <div>
                                <input type="radio" name="신고사유" id="3">
                                <label class="bold" for="3">욕설 및 비방</label>
                            </div>
                            <div>
                                <input type="radio" name="신고사유" id="4">
                                <label class="bold" for="4">불법정보 포함</label>
                            </div>
                            <div>
                                <input type="radio" name="신고사유" id="5">
                                <label class="bold" for="5">청소년에게 유해한 표현</label>
                            </div>
                            <div>
                                <input type="radio" name="신고사유" id="6">
                                <label class="bold" for="6">명예훼손 및 저작권 침해</label>
                            </div>
                            <div>
                                <input type="radio" name="신고사유" id="7">
                                <label class="bold" for="7">불법 촬영물 포함</label>
                            </div>
                            <input class="btn f20 report" type="submit" value="신고">
                        </form>
                    </div>
                </dialog>
                <div class="header">
                    <div class="button">전체 목록</div>
                    <div class="button active">공지 사항</div>
                    <div class="button">강의 자료</div>
                    <div class="button">질문</div>
                </div>
                
                <div class="postDetail">
                <span id="postTitle">배운 내용 질문</span> <button class="postBtn">삭제</button> <button class="postBtn">수정</button>
                
                <p id="postDate">게시일: 2024-12-30 13:20</p>

                <p id="postContent">
                    법관은 탄핵 또는 금고 이상의 형의 선고에 의하지 아니하고는 파면되지 아니하며, 징계처분에 의하지 아니하고는 정직·감봉 기타 불리한 처분을 받지 아니한다. 헌법재판소는 법률에 저촉되지 아니하는 범위안에서 심판에 관한 절차, 내부규율과 사무처리에 관한 규칙을 제정할 수 있다. 국가는 건전한 소비행위를 계도하고 생산품의 품질향상을 촉구하기 위한 소비자보호운동을 법률이 정하는 바에 의하여 보장한다. 법률이 헌법에 위반되는 여부가 재판의 전제가 된 경우에는 법원은 헌법재판소에 제청하여 그 심판에 의하여 재판한다. 국가유공자·상이군경 및 전몰군경의 유가족은 법률이 정하는 바에 의하여 우선적으로 근로의 기회를 부여받는다.
                    재판의 심리와 판결은 공개한다. 다만, 심리는 국가의 안전보장 또는 안녕질서를 방해하거나 선량한 풍속을 해할 염려가 있을 때에는 법원의 결정으로 공개하지 아니할 수 있다. 모든 국민은 인간다운 생활을 할 권리를 가진다. 헌법재판소 재판관은 탄핵 또는 금고 이상의 형의 선고에 의하지 아니하고는 파면되지 아니한다. 혼인과 가족생활은 개인의 존엄과 양성의 평등을 기초로 성립되고 유지되어야 하며, 국가는 이를 보장한다. 대법원은 법률에 저촉되지 아니하는 범위안에서 소송에 관한 절차, 법원의 내부규율과 사무처리에 관한 규칙을 제정할 수 있다. 국무회의는 정부의 권한에 속하는 중요한 정책을 심의한다.
                    법관은 탄핵 또는 금고 이상의 형의 선고에 의하지 아니하고는 파면되지 아니하며, 징계처분에 의하지 아니하고는 정직·감봉 기타 불리한 처분을 받지 아니한다. 헌법재판소는 법률에 저촉되지 아니하는 범위안에서 심판에 관한 절차, 내부규율과 사무처리에 관한 규칙을 제정할 수 있다. 국가는 건전한 소비행위를 계도하고 생산품의 품질향상을 촉구하기 위한 소비자보호운동을 법률이 정하는 바에 의하여 보장한다. 법률이 헌법에 위반되는 여부가 재판의 전제가 된 경우에는 법원은 헌법재판소에 제청하여 그 심판에 의하여 재판한다. 국가유공자·상이군경 및 전몰군경의 유가족은 법률이 정하는 바에 의하여 우선적으로 근로의 기회를 부여받는다.
                </p>
                </div>

                <div class="commentDetail">
                    <form>
                        <input type="text" name="comment" id="comment" placeholder="댓글을 입력해 주세요."/>
                        <input type="submit" id="commentSubmitBtn" value="작성"/>
                    </form>
                    <p id="commentCount">댓글: 5</p>
                    <!-- for문으로 처리 -->
                    <div class="commentBox">
                        <div class="comment-lBox">
                        <strong>김범수</strong>&nbsp&nbspKDT유데미
                        <p class="commentContent">그거 저도 어렵더라구요. 화이팅 입니다.</p>
                        </div>
                        <div class="comment-rBox">
                        <button class="commentBtn">삭제</button><button class="commentBtn">수정</button>
                        <div class="replyCount">답글: 0</div>
                        </div>
                    </div>

                    <div class="commentBox">
                        <div class="comment-lBox">
                        <strong>손흥민</strong>&nbsp&nbspKDT유데미
                        <p class="commentContent">관련 책 소개해드립니다. “ 공산주의 법이론(한스 켈젠)(장경학, 명지사, 1983)"</p>
                        </div>
                        <div class="comment-rBox">
                            <button class="dialogBtn">신고</button><button class="commentBtn">답글</button>
                            <div class="replyCount">답글: 0</div>
                        </div>
                    </div>

                    <div class="commentBox">
                        <div class="comment-lBox">
                        <strong>김연아</strong>&nbsp&nbsp서울대학교
                        <p class="commentContent">저만 어려운게 아니었군요!</p>
                        </div>
                        <div class="comment-rBox">
                            <button class="dialogBtn">신고</button><button class="commentBtn">답글</button>
                            <div class="replyCount">답글: 1</div>
                        </div>
                    </div>

                    <!--답글 클릭시 해당 댓글 아래로 답글 생성-->
                    <div class="replyBox">
                        <div class="reply-lBox">
                        <strong>김범수</strong>&nbsp&nbspKDT유데미
                        <p class="commentContent">연아님 같이 스터디 하실래요?연아님 같이 스터디 하실래요연아님 같이 스터디 하실래요</p>
                        </div>
                        <div class="reply-rBox">
                            <button class="dialogBtn">신고</button><button class="commentBtn">답글</button>
                            <div class="replyCount">답글: 0</div>
                        </div>
                    </div>

                    <!--자바스크립트로 버튼 활성화 비활성화-->
                    <div id="page">
                        <button id="minusPage">이전</button> <span id="targetPage" class="pageNumber">1</span> <span class="pageNumber">2</span> <span class="pageNumber">3</span> <button id="plusPage">다음</button>
                    </div>

                    
                </div>

                

            </div>
        </main>
    </div>
</body>

</html>