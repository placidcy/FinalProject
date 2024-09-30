<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="kr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../main/css/checkin.css">
    <link rel="stylesheet" href="../admin/css/admin-form.css">
    <link rel="stylesheet" href="css/dialog.css">
    <link rel="stylesheet" href="css/request.css">
    <script src="js/attendanceCalender.js"></script>
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
</head>

<body>
    <button class="dialogBtn">다이얼로그 버튼</button>
    <dialog>
        <div class="modal-top flex cen">
            <span class="bold" id="reqType">공가 요청</span>
            <span class="f24 exit">✕</span>
        </div>
        <div class="modal-bottom req">
            <form class="grid g10 requestForm" action="">
                <table>
                    <tr>
                        <td>신청 일자:</td>
                        <td><input class="border w120" type="date" name="startdate">
                            <span>-</span>
                            <input class="border w120" type="date" name="enddate">
                        </td>
                    </tr>
                    <tr>
                        <td>상태:</td>
                        <td><select class="border w120" name="" id="">
                                <option value="1">개인사유</option>
                                <option value="2">경조사</option>
                                <option value="3">병원방문</option>
                                <option value="4">관공서 및 은행방문</option>
                                <option value="5">국내/해외 여행</option>
                                <option value="5">건강상 이유</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td colspan="2">사유:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <textarea class="textarea" name="" id=""></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>증명서류:</td>
                        <td><input type="file"></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="message">
                            * 증명서류가 여러 개인 경우 하나의 파일(.zip)로 압축하여 제출하세요.
                        </td>
                    </tr>
                </table>
                <input class="btn f20" type="button" value="요청하기">
            </form>
        </div>
    </dialog>
</body>

</html>