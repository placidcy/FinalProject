function clickButtonHandler(event) {
	const id = event.target.id;
	switch (id) {
		case 'write':
			window.location.href = "/admin/notice/write";
			break;
		case 'delete':
			console.log('delete');
			break;
		case 'list':
			window.location.href = `/admin/notice?page=${event.target.dataset.page}`;
	}
}

function clickPostHandler(item) {
	const postId = item.dataset.id;
	const page = document.querySelector('.page.selected').innerHTML;
	window.location.href = `/admin/notice/details?postId=${postId}&page=${page}`;
}

function cancelHandler(event) {
	event.preventDefault();
	const form = document.querySelector('form');
	const formData = new FormData(form);
	let allBlank = true;

	for (let [key, value] of formData.entries()) {
		if (value.trim()) {
			allBlank = false;
			break;
		}
	}
	if (!allBlank) {
		if (confirm('작성했던 내용이 지워집니다. 글 작성을 취소하시겠습니까?')) {
			window.history.back();
		} else {
			return false;
		}
	} else {
		widnow.history.back();
	}
}

function init() {
	try {
		const items = document.querySelectorAll('.tab.notice .item');
		for (const item of items) {
			item.addEventListener('click', () => {
				clickPostHandler(item);
			});
		}
	} catch (e) {
		console.error(e);
	}

	try {
		const btns = document.querySelector('.btn');
		btns.addEventListener('click', clickButtonHandler);
	} catch (e) {
		console.error(e);
	}
	try {
		const cancelBtn = document.querySelector('#cancel');
		cancelBtn.addEventListener('click', cancelHandler);
	} catch (e) {
		console.error(e);
	}
}

window.addEventListener('load', init);