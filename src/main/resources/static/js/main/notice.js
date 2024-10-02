/**
 * 게시글 클릭 시 공지사항 게시글 상세 조회를 제공하는 스크립트 코드
 */

let currentId = -1;

function createRowElement() {
	let tr = document.createElement('tr');
	let td = document.createElement('td');

	tr.classList.add('item');
	tr.classList.add('details');
	tr.append(td);

	return tr;
}

function clickHandler(item) {
	const itemId = item.dataset.id;
	const newRow = createRowElement();

	if (currentId === itemId) {
		return false;
	} else {
		const currentRow = document.querySelector('tr.details');
		if (currentRow !== null) {
			item.parentNode.removeChild(currentRow);
		}
		item.parentNode.insertBefore(newRow, item.nextSibling.nextSibling);
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