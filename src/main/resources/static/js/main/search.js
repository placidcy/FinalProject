/**
 * 공지사항 또는 수강신청 화면의 검색바에 대한 스크리븥 함수 정의
 */

function submitHandler(event) {
	event.preventDefault();
	let keyword = event.target.querySelector('input[name="keyword"]');

	if (keyword.value.trim() === '') {
		keyword.value = '';
		keyword.validity.valueMissing = true;
		keyword.reportValidity();
	} else {
		event.target.submit();
	}
	keyword.setCustomValidity('');
}

function searchHandler() {
	let searchBox = document.querySelector('form.search.box');
	searchBox.addEventListener('submit', submitHandler);
}

window.addEventListener('load', searchHandler);