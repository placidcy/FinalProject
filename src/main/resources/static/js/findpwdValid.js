
function findpwdValid() {
	const submit = document.querySelector('#submitBtn');
	const m_acctid = document.querySelector('#m_acctid');
	const m_email = document.querySelector('#m_email');
	
	submit.addEventListener('click', (event)=>{
		if(!m_acctid.value.trim()) {
			event.preventDefault();
			alert('아이디를 입력하세요.');			
		}
		else if(!m_email.value.trim()) {
			event.preventDefault();
			alert('이메일을 입력하세요.');			
		}
	});
}

window.addEventListener('load', findpwdValid);