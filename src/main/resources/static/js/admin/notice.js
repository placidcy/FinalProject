function clickHandler() {
	window.location.href = "/admin/notice/write";
}

function init() {
	try {
		const writeBtn = document.querySelector('#write');
		writeBtn.addEventListener('click', clickHandler);
	} catch (e) {
		console.error(e);
	}
}

window.addEventListener('load', init);