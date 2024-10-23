function setTimer(duration) {
	let timer = duration, minutes, seconds;
	const timerElement = document.getElementById('timer');
	const interval = setInterval(function() {
		minutes = parseInt(timer / 60, 10);
		seconds = parseInt(timer % 60, 10);

		minutes = minutes < 10 ? "0" + minutes : minutes;
		seconds = seconds < 10 ? "0" + seconds : seconds;

		timerElement.innerHTML = minutes + ":" + seconds;

		if (--timer < 0) {
			clearInterval(interval);
			alert('인증 시간이 만료되었습니다.');
			document.querySelector('#verification-section').style.display = 'none';
		}
	}, 1000);
}

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

function verifyCodeResponseHandler(error, response) {
	if (error === null) {
		if (response.res) {
			alert('이메일 인증이 완료되었습니다.');
			document.querySelector('#m_email').setAttribute('readonly', 'readonly');
			document.querySelector('#confirm-msg').innerText = '이메일 인증 완료';
			document.querySelector('#auth').remove();
			document.querySelector('#verification-section').remove();
		}
	} else {
		responseHandler(error, response);
	}
}

function createVerificationSection() {
	const verificationSection = document.createElement('div');
	verificationSection.classList.add('flex');
	verificationSection.classList.add('g10');
	verificationSection.classList.add('cen');
	verificationSection.id = 'verification-section';

	const code = document.createElement('input');
	code.type = 'number';
	code.id = 'e_code';
	code.required = '';

	const confirm = document.createElement('div');
	confirm.classList.add('btn');
	confirm.id = 'confirm';
	confirm.innerText = '확인';
	confirm.addEventListener('click', checkCode);

	const timer = document.createElement('timer');
	timer.id = 'timer';

	verificationSection.appendChild(code);
	verificationSection.appendChild(confirm);
	verificationSection.appendChild(timer);

	return verificationSection;
}

function sendEmailResponseHandler(error, response) {
	if (error === null) {
		if (response.res) {
			// 이메일 전송에 성공한 경우
			alert(response.msg);
			const emailSection = document.querySelector('#emailSection');
			emailSection.appendChild(createVerificationSection());
			setTimer(180);
		} else {
			// 이메일 전송에 실패한 경우
			alert(response.msg);
			document.querySelector('#m_email').focus();
		}
	} else {
		responseHandler(error, response);
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
	sendRequest(url, 'GET', sendEmailResponseHandler);
}

function verifyCode(email, code) {
	const url = `/api/signup/verifyCode?email=${email}&code=${code}`;
	sendRequest(url, 'GET', verifyCodeResponseHandler);
}

function validateEmail(email) {
	const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	return emailPattern.test(email);
}

function checkInput(event) {
	event.preventDefault();
	const emailInput = document.querySelector('#m_email');
	const emailValue = emailInput.value;

	if (validateEmail(emailValue)) {
		sendEmail(emailValue);
	} else {
		alert('잘못된 이메일 형식입니다. 다시 입력해주세요.');
	}
}

function validateCode(code) {
	const codePattern = /^\d{6}$/; // 6자리 숫자 정규식
	return codePattern.test(code);
}

function checkCode(event) {
	event.preventDefault();
	const codeInput = document.querySelector('#e_code');
	const codeValue = codeInput.value;
	const emailInput = document.querySelector('#m_email');
	const emailValue = emailInput.value;

	if (!validateEmail(emailValue)) {
		alert('잘못된 이메일 형식입니다. 다시 입력해주세요.');
		return false;
	} else if (!validateCode(codeValue)) {
		alert('잘못된 인증코드 형식입니다. 6자리 숫자를 입력해주세요.');
	} else {
		verifyCode(emailValue, codeValue);
	}
}

function init() {
	const authBtn = document.querySelector('#auth');
	authBtn.addEventListener('click', checkInput);
}

window.addEventListener('load', init);