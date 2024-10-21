function validateM_email() {
	const m_email = document.querySelector('#m_email');
	const emailmsg = document.querySelector('#emailmsg');
	const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

	let valid = true;
		
	emailmsg.style.color = 'red';
	
	if(!m_email.value.trim()) {
		emailmsg.innerHTML = "이메일을 입력하세요.";
		valid=false;
	}
	else if(!emailPattern.test(m_email.value)) {
		emailmsg.innerHTML = "올바른 형식의 이메일을 입력하세요.";
		valid=false;
	}
	else {
		emailmsg.innerHTML = "";
		checkEmailDuplication(m_email.value, function(isDuplicate) {
			if (isDuplicate) {
				emailmsg.innerHTML = "이미 사용 중인 이메일입니다.";
				emailmsg.style.color = 'red';
				valid = false;
			} else {
				emailmsg.innerHTML = "사용 가능한 이메일입니다.";
				emailmsg.style.color = 'blue';
			}
		});
	}
	return valid;
}

function checkEmailDuplication(email) {
	const xhr = new XMLHttpRequest();
	xhr.open('GET', `/checkM_emailDuplicate?m_email=${encodeURIComponent(email)}`, true);
	
	xhr.onload = function() {
		if(xhr.status === 200) {
			const isDuplicate = JSON.parse(xhr.responseText);
			callback(isDuplicate);
		}
		else {
			alert('이메일 확인 중 오류가 발생했습니다.');
		}
	};
	
	xhr.onerror = function() {
		alert('서버와의 통신에 실패했습니다.');
	};
	
	xhr.send();
}

function init() {
	const form = document.querySelector('form');
	document.querySelector('#m_email').addEventListener('input', validateM_email);

    form.addEventListener('submit', function(event) {
        if (!validateM_email() || isDuplicate) {
            event.preventDefault();
			alert('잘못된 입력입니다.');
        }
		else {
			alert('이메일을 변경하였습니다.');
		}
    });
}

window.addEventListener('load', init);