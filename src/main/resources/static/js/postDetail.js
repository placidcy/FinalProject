function dialogHandler() {
    let dialog = document.querySelector('#modal');
    let dialogBtnArr = document.querySelectorAll('.dialogBtn');
    let exit = document.querySelector('.exit');
    let dialogContent = document.querySelector('#dialogContent');

    for(let dialogBtn of dialogBtnArr){
        dialogBtn.addEventListener('click', (event) => {
            dialog.open ? dialog.open = true : dialog.open = true;
            if(dialog.open) {
                dialogContent.innerHTML=dialogBtn.parentElement.parentElement.firstElementChild.lastElementChild.innerText;
                // 작성자 id 받아오기 기능 추가해야함
            }
    
        })
    }
    

    exit.addEventListener('click', () => {
        dialog.open = false;
    });
}

function init() {
    let menuList = document.querySelector('#menuList');
    let menuIcon = document.querySelector('#mobile-menu-icon');
    let menuName = document.querySelector('.menuName');
    let mobileMenu = document.querySelector('#mobile-menu');
    let className = menuName.innerHTML;
    menuIcon.addEventListener('click', () => {
        menuList.style.getPropertyValue('visibility') ==='hidden'? menuList.style.setProperty('visibility', 'visible') : menuList.style.setProperty('visibility', 'hidden');       
        menuList.style.getPropertyValue('visibility') ==='hidden'? menuName.innerHTML=className : menuName.innerHTML='CHECK';
    });

    dialogHandler();
}

window.addEventListener('load', init);