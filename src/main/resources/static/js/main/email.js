function responseHandler(error, response) {
	if (error === null) {
		if (response.res) {
			alert('요청이 정상적으로 처리되었습니다.')
		} else {
			alert(response.msg);
		}
		window.location.reload();
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

function sendEmail() {
	const email = document.querySelector('input[name="email"]');
	const code = document.querySelector('input[name="code"]');

	const url = `/checkEmail?email=${email}&code=${code}`;
	sendRequest(url, POST, responseHandler);
}

function init() {
	const confirmButton = document.querySelector('#confirmButton');
	confirmButton.addEventListener('click', sendEmail);
}

window.addEventListener('load', init);