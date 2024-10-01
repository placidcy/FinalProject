function cancelHandler() {
	location.href='/findcheck';
}
function submitHandler() {
	let findProcess = document.querySelector('#findProcess');
	
	findProcess.submit();
}

function init() {
	let cancel = document.querySelector('#cancelBtn');
	let submit = document.querySelector('#searchBtn');

	submit.addEventListener('click', submitHandler);
	cancel.addEventListener('click', cancelHandler);	
}
window.addEventListener('load', init);