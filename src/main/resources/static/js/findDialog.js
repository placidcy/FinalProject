/**
 * 결과창 모달 팝업
 */

function dialogHandler() {
	const submit = document.querySelector('#submitBtn');
	const dialog = document.querySelector('dialog');
	const exit = document.querySelector('.exit');
	const m_name = document.querySelector('#m_name');
	const m_email = document.querySelector('#m_email');
	
	submit.addEventListener('click', (event)=>{
		if(!m_name.value.trim()) {
			event.preventDefault();
			alert('이름을 입력하세요.');			
		}
		else if(!m_email.value.trim()) {
			event.preventDefault();
			alert('이메일을 입력하세요.');			
		}
		else {
			event.preventDefault();
			dialog.showModal();
		}
	});
	
	exit.addEventListener('click', ()=>{
		dialog.close();
	})
	
	// 페이지 로딩 시 result 값이 있을 경우 모달 열기
	    window.onload = function() {
	        var result = "${result}"; // 서버에서 받은 result 값
	        if (result) {
	            // 모달 열기
	            document.getElementById('resultModal').showModal();
	        }
	    };

	    // 모달 닫기 버튼
	    document.querySelector(".exit").onclick = function() {
	        document.getElementById('resultModal').close();
	    };
	
}

function dialog() {
	dialogHandler();
}
window.addEventListener('load', dialog);