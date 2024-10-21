function validatePassword() {
	const m_acctpwd = document.querySelector('#newpwd');
	const confirmpw = document.querySelector('#confirmpwd');
	const passerr = document.querySelector('#passerr');
	const cfmmsg = document.querySelector('#cfmmsg');
	const cfmerr = document.querySelector('#cfmerr');
	
	const pwdUpper = /[A-Z]/.test(m_acctpwd.value);
	const pwdLower = /[a-z]/.test(m_acctpwd.value);
	const pwdNumber = /[0-9]/.test(m_acctpwd.value);
	const pwdSpecial = /[!@#$%^&*]/.test(m_acctpwd.value);
	
	let valid=true;
	let isAvail = [pwdUpper, pwdLower, pwdNumber, pwdSpecial].filter(Boolean).length;
	
	passerr.style.color = 'red';
	cfmerr.style.color = 'red';
	
	//비밀번호 입력
	if(!m_acctpwd.value.trim()) {
		passerr.innerHTML = "비밀번호를 입력하세요.";
		valid = false;
	}
	else if(m_acctpwd.value.length < 8 || m_acctpwd.value.length > 24 || isAvail < 3) {
		passerr.innerHTML = "비밀번호의 길이가 유효하지 않거나, 조합 요건을 충족하지 못했습니다.";
		valid=false;
	}
	else {
		passerr.innerHTML = "유효한 비밀번호입니다.";
		passerr.style.color = 'blue';
	}
	
	//비밀번호 확인
	if(!confirmpw.value.trim()) {
		cfmmsg.style.color= 'red';
		cfmerr.innerHTML = "";
		valid = false;
	}
	else if(m_acctpwd.value !== confirmpw.value) {
		cfmmsg.style.color= '#888888';
		cfmerr.innerHTML = "비밀번호가 일치하지 않습니다.";
		valid = false;
	}
	else {
		cfmerr.innerHTML = "";
	}
	
	return valid;
}

function init() {
	const form = document.querySelector('form');
	
	document.querySelector('#newpwd').addEventListener('input', validatePassword);
	document.querySelector('#confirmpwd').addEventListener('input', validatePassword);

    form.addEventListener('submit', function(event) {
        if (!validatePassword()) {
            event.preventDefault();
			alert('잘못된 입력입니다.');
        }
		else {
			alert('회원가입이 완료되었습니다.');
		}
    });
}

window.addEventListener('load', init);