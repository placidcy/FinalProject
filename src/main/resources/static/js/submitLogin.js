function submitLoginForm(event) {
	event.preventDefault();

	const formData = {
		m_acctid: document.querySelector('#m_acctid').value,
		m_acctpwd: document.querySelector('#m_acctpwd').value
	};

	const token = sessionStorage.getItem('jwtToken');

	fetch('loginProcess', {
		method: 'POST',
			headers: {
			'Content-Type': 'application/json',
			},
			body: JSON.stringify(formData)
		})
		.then(response => response.json())
		.then(data => {
			if (data.token) {
			sessionStorage.setItem('token', data.token);

			if (data.m_role === 1) {
			window.location.href = '/mypage';
			}
			else if (data.m_role === 2) {
			window.location.href = '/main/index_i';
			}
			else {
			window.location.href = '/adminMain';
			}
			}
			else {
			alert(data.message || '로그인 실패');
			}
		})
		.catch(error => {
			console.error('로그인 중 오류 발생:', error);
			alert('로그인 중 오류가 발생했습니다.');
		});

}