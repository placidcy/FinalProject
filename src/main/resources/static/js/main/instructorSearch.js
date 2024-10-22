function submitHandler(event) {
    event.preventDefault();
    let keyword = event.target.querySelector('input[name="keyword"]');

    if (keyword.value.trim() === '') {
        keyword.value = '';
        keyword.validity.valueMissing = true;
        keyword.reportValidity();
    } else {
        // 폼의 action과 method를 명확히 설정
        event.target.action = '/instructor/search';
        event.target.method = 'get';
        event.target.submit();
    }
}

function searchHandler() {
    let searchBox = document.querySelector('form.search.box');
    if (searchBox) {
        searchBox.addEventListener('submit', submitHandler);
    } else {
        console.error("검색 폼을 찾을 수 없습니다.");
    }
}

window.addEventListener('load', searchHandler);
