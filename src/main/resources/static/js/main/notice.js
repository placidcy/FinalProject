/**
 * 게시글 클릭 시 공지사항 게시글 상세 조회를 제공하는 스크립트 코드
 */

let currentId = -1;

function getFileNameFromUrl(url) {
	// URL의 마지막 부분을 추출하여 파일 이름을 반환합니다.
	return url.substring(url.lastIndexOf('/') + 1);
}

function createPreview(link) {
	const previewDiv = document.createElement('div');
	previewDiv.classList.add('preview');
	previewDiv.id = 'preview';

	link.addEventListener('click', function(event) {
		event.preventDefault();
		const url = link.href;
		const ext = url.split('.').pop().toLowerCase();
		if (['jpg', 'jpeg', 'png', 'gif'].includes(ext)) {
			const img = document.createElement('img');
			img.src = url;
			img.alt = 'Image Preview';
			img.style.maxWidth = '100%';
			previewDiv.appendChild(img);
		} else if (ext === 'pdf') {
			const embed = document.createElement('embed');
			embed.src = url;
			embed.type = 'application/pdf';
			embed.style.width = '100%';
			embed.style.height = '600px';
			previewDiv.appendChild(embed);
		} else if (ext === 'mp4') {
			const video = document.createElement('video');
			video.src = url;
			video.controls = true;
			video.style.width = '100%';
			previewDiv.appendChild(video);
		} else if (ext === 'txt' || ext === 'html') {
			fetch(url)
				.then(response => response.text())
				.then(text => {
					const pre = document.createElement('pre');
					pre.textContent = text;
					previewDiv.appendChild(pre);
				});
		} else {
			previewDiv.textContent = '해당 유형의 파일은 미리보기를 제공하지 않습니다.';
		}
	});

	return previewDiv;
}

function createPost(item) {
	const post = document.createElement('div');
	const contents = document.createElement('pre');
	const attms = document.createElement('ul');

	post.classList.add('post');
	contents.classList.add('content');
	attms.classList.add('attms');

	if (item.postContents === null) {
		item.postContents = '';
	}

	if (item.attms !== null) {
		for (let attm of item.attms) {
			let li = document.createElement('li');
			let a = document.createElement('a');

			a.innerHTML = '[첨부파일] ' + attm.fileName;
			a.href = attm.url;
			a.download = attm.fileName;

			li.appendChild(a);
			li.appendChild(createPreview(a));
			attms.appendChild(li);
		}
	}

	contents.innerHTML = item.postContents.trim() !== '' ? item.postContents : item.postTitle;

	post.appendChild(contents);
	post.appendChild(document.createElement('hr'));
	post.appendChild(attms);

	return post;
}

function createRow(item) {
	let tr = document.createElement('tr');
	let td = document.createElement('td');

	/* tr 태그에 대한 속성 추가 */
	tr.classList.add('item');
	tr.classList.add('details');

	/* tr 태그의 자식인 td 태그에 대한 속성 추가 */
	td.appendChild(createPost(item));
	tr.append(td);

	td.classList.add('fade-in');

	return tr;
}

function insertAfter(parent, newRow, currentRow) {
	parent.insertBefore(newRow, currentRow.nextSibling);
}

let parentNode, currentNode;

function responseHandler(error, response) {
	if (error === null) {
		currentNode.querySelector('.toggle').classList.add('selected');
		insertAfter(parentNode, createRow(response), currentNode);
	} else {
		console.error(error);
	}
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
	const details = document.querySelector('tr.details');
	if (currentNode != null) {
		currentNode.querySelector('.toggle').classList.remove('selected');
	}
	currentNode = item;
	parentNode = item.parentNode;

	if (currentId === itemId) {
		currentId = -1;
		parentNode.removeChild(details);
	} else {
		currentId = itemId;
		if (details !== null) {
			parentNode.removeChild(details);
		}
		const url = '/api/notice/getItem?noticeId=' + itemId;
		sendRequest(url, 'GET', responseHandler);
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