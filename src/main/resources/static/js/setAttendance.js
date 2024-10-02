function submitHandler(event){
	let c_prsscore = document.querySelector('#c_prsscore');
	let c_absscore = document.querySelector('#c_absscore');
	let c_trdscore = document.querySelector('#c_trdscore');
		
	if(!c_prsscore.value.trim() || !c_absscore.value.trim() || !c_trdscore.value.trim()){
		alert('점수를 입력해 주세요.');
		event.preventDefault();
	}else if(c_prsscore.value>20 || c_prsscore.value < 0){
		alert('출석점수는 0에서 20점 사이의 값이어야 합니다.');
		event.preventDefault();
	}else if(c_absscore.value>0 || c_absscore.value < -10){
		alert('결석점수는 -10에서 0점 사이의 값이어야 합니다.');
		event.preventDefault();
	}else if(c_trdscore.value>0 || c_trdscore.value < -10){
		alert('지각점수는 -10에서 0점 사이의 값이어야 합니다.');
		event.preventDefault();
	}
	
	alert('입력하신 출결 점수가 설정되었습니다.');
}

function dialogHandler() {
	let dialog = document.querySelector('#setAttScoreModal');
	let dialogBtn = document.querySelector('#setAttScore');
    let exit = document.querySelector('.exit');

    dialogBtn.addEventListener('click', () => {
        dialog.open ? dialog.open = false : dialog.open = true;
    })

    exit.addEventListener('click', () => {
        dialog.open = false;
    });
}

function menuHandler(){
	let menuList = document.querySelector('#menuList');
    let menuIcon = document.querySelector('#mobile-menu-icon');
    let menuName = document.querySelector('.menuName');
    let mobileMenu = document.querySelector('#mobile-menu');
    let className = menuName.innerHTML;
    menuIcon.addEventListener('click', () => {
        menuList.style.getPropertyValue('visibility') ==='hidden'? menuList.style.setProperty('visibility', 'visible') : menuList.style.setProperty('visibility', 'hidden');       
        menuList.style.getPropertyValue('visibility') ==='hidden'? menuName.innerHTML=className : menuName.innerHTML='CHECK';
    });
}

function init() {
	submitBtn = document.querySelector('#submitBtn').addEventListener('click', submitHandler);
	menuHandler();
	dialogHandler();
	    
}

window.addEventListener('load', init);