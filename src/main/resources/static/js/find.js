/*form 안에 submit 없을 시 연결 및 버튼 클릭 로케이션 설정*/

function cancelHandler() {
	location.href='/findcheck';
}
function submitHandler() {
	let findProcess = document.querySelector('#findProcess');
	
	findProcess.submit();
}

function init() {
	let cancel = document.querySelector('#cancelBtn');
	let submit = document.querySelector('#submitBtn');

	submit.addEventListener('click', submitHandler);
	cancel.addEventListener('click', cancelHandler);	
}
window.addEventListener('load', init);