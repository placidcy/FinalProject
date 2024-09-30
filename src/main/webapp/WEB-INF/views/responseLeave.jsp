<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="kr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/dialog.css">
    <link rel="stylesheet" href="css/request.css">
    <link rel="stylesheet" href="css/response.css">
    <script src="script/dialog.js"></script>
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
</head>

<body>
    <button id="dialogBtn">다이얼로그 버튼</button>
    <dialog open>
        <div class="modal-top flex cen">
            <span class="bold">공가 인승</span>
            <span class="f24 exit">✕</span>
        </div>
        <div class="modal-bottom req">
            <form class="grid g10 requestForm" action="">
                <input type="hidden" name="date" value="2024.03.21">
                <table class="spacing">
                    <tr>
                        <td>일자:</td>
                        <td>2024.04.09-2024.04.12</td>
                    </tr>
                    <tr>
                        <td>공가 사유:</td>
                        <td>예비군 훈련</td>
                    </tr>
                    <tr>
                        <td colspan="2">사유:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <pre class="textarea">예비군 훈련으로 해당 기간 참여가 불가능합니다.</pre>
                        </td>
                    </tr>
                    <tr>
                        <td>증명서류:</td>
                        <td><a class="file" href="">파일</a></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td>요청 상태:</td>
                        <td class="flex g20">
                            <div>
                                <input type="radio" name="reqStatus" id="approved" value="approved">
                                <label for="approved">승인</label>
                            </div>
                            <div>
                                <input type="radio" name="reqStatus" id="denied" value="denied">
                                <label for="denied">거부</label>
                            </div>
                        </td>
                    </tr>
                    <tr class="hidden" id="reqCheckRow">
                        <td>사유:</td>
                        <td><select class="border w120" name="reqCheck" id="">
                                <option value="">서류 불충분</option>
                            </select></td>
                    </tr>
                </table>
                <div class="flex g20 je">
                    <input class="impleBtn f16  smallBtn" type="button" value="요청처리">
                    <input type="button" class="deleteBtn f16 smallBtn" value="취소">
                </div>
            </form>
        </div>
    </dialog>
</body>

</html>