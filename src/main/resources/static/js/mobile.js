function init() {
    let mobileMenuIcon = document.querySelector('#hamburger');
    let menulist = document.querySelector('.menulist#main');

    mobileMenuIcon.addEventListener('click', () => {
        menulist.classList.toggle('show');
    });
}

window.addEventListener('load', init);