function menuHandler(){
	let menuList = document.querySelector('#menuList');
    let menuIcon = document.querySelector('#mobile-menu-icon');
    let menuName = document.querySelector('.menuName');
    let mobileMenu = document.querySelector('#mobile-menu');
	let backBtn = document.querySelector('#backBtn').addEventListener('click',()=>{window.history.back()});
    let className = menuName.innerHTML;
    menuIcon.addEventListener('click', () => {
        menuList.style.getPropertyValue('visibility') ==='hidden'? menuList.style.setProperty('visibility', 'visible') : menuList.style.setProperty('visibility', 'hidden');       
        menuList.style.getPropertyValue('visibility') ==='hidden'? menuName.innerHTML=className : menuName.innerHTML='CHECK';
    });
}

function submitHandler(event){
	let searchText = document.querySelector('#searchText');
		
	if(!searchText.value.trim()){
		alert('검색어를 입력해 주세요.');
		event.preventDefault();
	}
}



function init() {
	document.querySelector('#submitBtn').addEventListener('click', submitHandler);
	menuHandler();
	    
}

window.addEventListener('load', init);