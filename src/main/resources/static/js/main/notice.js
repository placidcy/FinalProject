/**
 * 게시글 클릭 시 공지사항 게시글 상세 조회를 제공하는 스크립트 코드
 */

let currentId = -1;

function createRow() {
	let tr = document.createElement('tr');
	let td = document.createElement('td');

	/* tr 태그에 대한 속성 추가 */
	tr.classList.add('item');
	tr.classList.add('details');

	/* tr 태그의 자식인 td 태그에 대한 속성 추가 */
	tr.append(td);

	return tr;
}

function insertAfter(parent, newRow, currentRow) {
	parent.insertBefore(newRow, currentRow.nextSibling);
}

function responseHandler(error, response) {
	console.log(response);
}

function sendRequest(url, method, callback) {
	const xhr = new XMLHttpRequest();
	xhr.open(method, url, true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				const response = JSON.parse(xhr.responseText);
				callback(null, response);
			} else {
				callback(new Error(`AJAX 요청 실패: ${xhr.status}`));
			}
		}
	};

	xhr.send();
}

function clickHandler(item) {
	const itemId = item.dataset.id;
	const parent = item.parentNode;
	const newRow = createRow();

	if (currentId === itemId) {
		return false;
	} else {
		const details = document.querySelector('tr.details');
		if (details !== null) {
			const url = '/api/notice/getItem?noticeId=' + itemId;
			parent.removeChild(details);
			sendRequest(url, 'GET', responseHandler);
		}
		insertAfter(parent, newRow, item);
	}
}

function noticeHandler() {
	let items = document.querySelectorAll('tr.item');

	for (let item of items) {
		item.addEventListener('click', () => {
			clickHandler(item);
		});
	}
}

window.addEventListener('load', noticeHandler);