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
			
			/*
			impleBtn.addEventListener('click', ()=>{
				form.submit();
			});
			*/
		}
	});
	
	exit.addEventListener('click', ()=>{
		dialog.close();
	})
	
}

function init() {
	dialogHandler();
}
window.addEventListener('load', init);