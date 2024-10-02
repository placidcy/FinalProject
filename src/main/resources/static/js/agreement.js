/**
 * 전체 선택을 누르면 모든 체크박스 활성화
 * 한 개의 체크박스라도 비활성화 되면 전체 선택도 비활성화
 */

function init() {
	const allAgree = document.querySelector('#allagree');
	const memberAgree = document.querySelector('#memberagree');
	const personalAgree = document.querySelector('#personalagree');
	const checkboxes = document.querySelectorAll('#agreementForm input[type="checkbox"]:not(#allagree)');
	const submit = document.querySelector('#submitBtn');
	
	const updateBtnStatus = ()=>{
		submit.disabled = !(memberAgree.checked && personalAgree.checked);
	};
	
	allAgree.addEventListener('change', () => {
		checkboxes.forEach(checkbox=>{
			checkbox.checked = allAgree.checked;
		});
		updateBtnStatus();
	});
	
	checkboxes.forEach(checkbox => {
	    checkbox.addEventListener('change', () => {
	        if (Array.from(checkboxes).every(cb => cb.checked)) {
	            allAgree.checked = true;
	        } else {
	            allAgree.checked = false;
	        }
	        updateBtnStatus();
	    });
	});
	
	memberAgree.addEventListener('change', updateBtnStatus);
	personalAgree.addEventListener('change', updateBtnStatus);
}

window.addEventListener('load', init);