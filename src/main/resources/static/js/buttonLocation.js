/*submit 기능 연결 및 버튼 로케이션 설정*/

function cancelHandler() {
	location.href='/findcheck';
}
function submitHandler() {
	let findidProcess = document.querySelector('#findidProcess');
	let findpwdProcess = document.querySelector('#findpwdProcess');
	
	//findidProcess.submit();
	findpwdProcess.submit();
}

function init() {
	let cancel = document.querySelector('#cancelBtn');
	let submit = document.querySelector('#submitBtn');

	submit.addEventListener('click', submitHandler);
	cancel.addEventListener('click', cancelHandler);
}
window.addEventListener('load', init);