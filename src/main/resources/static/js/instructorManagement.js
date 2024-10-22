document.addEventListener('DOMContentLoaded', () => {
    console.log("JavaScript 로드됨");

    const openIssueModalBtn = document.getElementById('openIssueModalBtn');
    if (!openIssueModalBtn) {
        console.error("발급 버튼을 찾을 수 없습니다.");
        return;
    }

    console.log("발급 버튼 존재함");
    openIssueModalBtn.addEventListener('click', () => {
        console.log("발급 버튼 클릭됨");

 /*      const checkedBoxes = document.querySelectorAll('.instructorTable .checkbox:checked');
        if (checkedBoxes.length === 0) {
            alert('강사를 선택해 주세요.');
            return;
        }

        
        const selectedRow = checkedBoxes[0].closest('tr');
        document.getElementById('name').value = selectedRow.cells[2].textContent.trim();
        document.getElementById('email').value = selectedRow.cells[5].textContent.trim();
        document.getElementById('department').value = selectedRow.cells[3].textContent.trim();
		*/
        document.getElementById('issueInstructorModal').showModal();
    });

    const closeIssueModal = document.getElementById('closeIssueModal');
    if (closeIssueModal) {
        closeIssueModal.addEventListener('click', () => {
            console.log("모달 닫기 버튼 클릭됨");
            document.getElementById('issueInstructorModal').close();
        });
    } else {
        console.error("모달 닫기 버튼을 찾을 수 없습니다.");
    }

    const issueInstructorForm = document.getElementById('issueInstructorForm');
    if (!issueInstructorForm) {
        console.error("발급 폼을 찾을 수 없습니다.");
        return;
    }

    issueInstructorForm.addEventListener('submit', (event) => {
        event.preventDefault(); 
        console.log("발급 폼 제출됨");

        const formData = new FormData(issueInstructorForm);
        
        fetch('/issueInstructorId', {
            method: 'POST',
            body: formData
        })
		.then(response => {
		    console.log('응답 상태 코드:', response.status); // 상태 코드 출력
		    return response.json();
		})
		.then(data => {
		    console.log('서버 응답 데이터:', data); // 서버에서 받은 응답 데이터 출력
		    if (data.success) {
		        alert('강사 승인 완료되었습니다.');
		        document.getElementById('issueInstructorModal').close();
		        location.reload();
		    } else {
		        alert('발급 중 오류가 발생했습니다.');
		    }
		})

        .catch(error => {
            console.error('Error:', error);
            alert('서버와의 통신 중 문제가 발생했습니다.');
        });
    });
});
