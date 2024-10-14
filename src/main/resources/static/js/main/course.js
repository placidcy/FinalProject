function init() {
	const courseItems = document.querySelectorAll('.tab.course .item');
	for (const item of courseItems) {
		const courseId = item.dataset.id;
		const enterBtn = item.querySelector('.enter');

		enterBtn.addEventListener('click', (event) => {
			window.location.href = '/goCourseHome?courseId=' + courseId;
		});
	}
}

window.addEventListener('load', init);