function responseHandler(error, response) {
	if (error === null) {
		if (response.res) {
			alert(response.msg)
		} else {
			alert(response.msg);
		}
	} else {
		console.error(error);
	}
}

function sendRequest(url, method, callback) {
	const xhr = new XMLHttpRequest();
	xhr.open(method, url, true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				const response = JSON.parse(xhr.responseText);
				callback(null, response);
			} else {
				callback(new Error(`AJAX 요청 실패: ${xhr.status}`));
			}
		}
	};

	xhr.send();
}

function sendEmail(email) {
	const url = `/api/signup/sendEmail?email=${email}`;
	sendRequest(url, 'GET', responseHandler);
}

function verifyCode(email) {
	const url = `/api/signup/check?email=${email}&code=${code}`;
	sendRequest(url, 'GET', responseHandler);
}

function checkInput(event) {
	// submit 이벤트 방지
	event.preventDefault();
	const emailInput = document.querySelector('#m_email');
	const emailValue = emailInput.value;

	// 이메일 형식 검사
	const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	if (emailPattern.test(emailValue)) {
		sendEmail(emailValue);
	} else {
		alert('잘못된 이메일 형식입니다. 다시 입력해주세요.');
	}
}

function init() {
	const authBtn = document.querySelector('#auth');
	authBtn.addEventListener('click', checkInput);
}

window.addEventListener('load', init);