/**
 * 전체 선택을 누르면 모든 체크박스 활성화
 * 한 개의 체크박스라도 비활성화 되면 전체 선택도 비활성화
 */

const allAgree = document.querySelector('#allagree');
const memberAgree = document.querySelector('#memberagree');
const personalAgree = document.querySelector('#personalagree');
const submit = document.querySelector('#submitBtn');
const checkboxes = document.querySelectorAll('#agreementForm input[type="checkbox"]:not(#allagree)');

function allChecked() {
	if(memberAgree.checked && personalAgree.checked) {
		submit.disabled = false;
	}
	else {
		submit.disabled = true;
	}
}
function init() {
	
	allAgree.addEventListener('change', () => {
		checkboxes.forEach(checkbox=>{
			checkbox.checked = allAgree.checked;
		});
		allChecked();
	});
	
	memberAgree.addEventListener('change', allChecked);
	personalAgree.addEventListener('change', allChecked);
}

window.addEventListener('load', init);