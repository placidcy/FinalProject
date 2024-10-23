/*submit 기능 연결 및 버튼 로케이션 설정*/

function cancelHandler() {
	location.href='/findcheck';
}

function locationInit() {
	let cancel = document.querySelector('#cancelBtn');

	cancel.addEventListener('click', cancelHandler);
}
window.addEventListener('load', locationInit);