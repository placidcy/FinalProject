function init() {
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

window.addEventListener('load', init);