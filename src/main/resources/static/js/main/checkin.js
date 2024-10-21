/**
 * 
 */
function getCurrentTime() {
	const now = new Date();
	const hours = now.getHours();
	const minutes = now.getMinutes();

	const ampm = hours >= 12 ? '오후' : '오전';
	const formattedHours = hours % 12 || 12;
	const formattedMinutes = minutes < 10 ? `0${minutes}` : minutes;

	const currentTimeString = `${ampm} ${formattedHours}시 ${formattedMinutes}분`;

	return currentTimeString;
}

function responseHandler(error, response) {
	if (error === null) {
		if (response.res) {
			alert('요청이 정상적으로 처리되었습니다.')
		} else {
			alert(response.msg);
		}
		window.location.reload();
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

function clickHandler(event) {
	const qrDialog = document.querySelector('#scanner');
	const id = event.target.id;
	let keyword = '';

	switch (id) {
		case 'cinBtn':
			keyword = '입실';
			break;
		case 'coutBtn':
			keyword = '퇴실';
			break;
		case 'soutBtn':
			keyword = '외출';
			break;
		case 'retBtn':
			keyword = '복귀';
			break;
	}

	const confirmMsg = `현재 시각 ${getCurrentTime()}입니다.\n(서버 시간을 기준)\n\n${keyword} 처리 하시겠습니까?`;

	if (confirm(confirmMsg)) {
		qrDialog.setAttribute('open', true);
		callScanner(qrDialog, keyword);
	}
}

function qrBtnHandler(event) {
	const id = event.target.id;
	const url = '/api/checkin/createQR';

	if (!confirm('QR코드를 발급하시겠습니까?')) {
		return;
	};
	switch (id) {
		case 'new':
			sendRequest(url, 'GET', responseHandler);
			break;
	}
}

function calculatePosition(size, percentage) {
	return size / 100 * percentage;
}

function setChart() {
	const chart = document.querySelector('.chart');
	const chartSize = parseFloat(window.getComputedStyle(chart).width);

	const regex = /(\d+\.\d+)/g;

	const avgPer = document.querySelector('#avgPer').innerHTML.match(regex);
	const myPer = document.querySelector('#myPer').innerHTML.match(regex);

	const bar = document.querySelector('div.bullet.bar');
	const avg = document.querySelector('#avg');
	const curr = document.querySelector('#curr');

	bar.style.width = `${calculatePosition(chartSize, avgPer)}px`;
	bar.style.backgroundColor = '#24c2a2';
	avg.style.transform = `translateX(${calculatePosition(chartSize, avgPer)}px)`;
	curr.style.transform = `translateX(${calculatePosition(chartSize, myPer)}px)`;
}

function setButtons() {
	const btns = document.querySelectorAll('.btn.attend');
	const qrBtns = document.querySelectorAll('.qrBtn');

	for (const btn of btns) {
		btn.addEventListener('click', clickHandler);
	}

	for (const btn of qrBtns) {
		btn.addEventListener('click', qrBtnHandler);
	}
}

function calculateTimer(duration, display) {
	let timer = duration, hours, minutes, seconds;

	const timerPromise = new Promise((resolve) => {
		const interval = setInterval(() => {
			hours = Math.floor(timer / 3600);
			minutes = Math.floor((timer % 3600) / 60);
			seconds = Math.floor(timer % 60);

			hours = hours < 10 ? "0" + hours : hours;
			minutes = minutes < 10 ? "0" + minutes : minutes;
			seconds = seconds < 10 ? "0" + seconds : seconds;

			display.textContent = hours + "시 " + minutes + "분 " + seconds + "초";

			if (--timer < 0) {
				clearInterval(interval);
				resolve();
			}
		}, 1000);
	});

	timerPromise.then(() => {
		alert('QR코드 유효기간이 만료되어 페이지를 새로고침 합니다.');
		window.location.reload();
	});
}

function setTimer() {
	const display = document.querySelector('#timeLimit');

	const startTime = new Date();

	const endDate = new Date(display.dataset.date);
	const endLimitMillis = parseInt(display.dataset.limit) * 60 * 1000;

	const endTime = new Date(endDate.getTime() + endLimitMillis);
	const duration = (endTime - startTime) / 1000;

	calculateTimer(duration, display);
}

function setFloatingIcon() {
	const floatingIcon = document.querySelector('.floating-icon');
	const subMenu = floatingIcon.querySelector('.sub-menu');
	const list = subMenu.querySelectorAll('li');

	floatingIcon.addEventListener('click', function() {
		floatingIcon.classList.toggle('clicked');
		subMenu.classList.toggle('hidden');

		for (let i = 0; i < list.length; i++) {
			setTimeout(() => {
				list[i].classList.toggle('show');
			}, i * 200); // 200ms(0.2초) 간격으로 실행
		}
	});

	window.addEventListener('resize', () => {
		if (window.innerWidth > 768) {
			floatingIcon.classList.remove('clicked');
			subMenu.classList.add('hidden');

			for (let i = 0; i < list.length; i++) {
				list[i].classList.remove('show');
			}
		}
	})
}

function setDday() {
	const dday = document.querySelector('#dday');
	const dValue = dday.dataset.value;

	dday.innerHTML = dValue > 0 ? `D-${Math.abs(dValue)}` : `D+${Math.abs(dValue)}`;
}

function init() {
	try {
		setDday();
	} catch (e) {
		console.error('디데이 설정 과정에서 오류가 발생하였습니다.');
	}
	try {
		setChart();
	} catch (e) {
		console.error('출석 차트 설정 과정에서 오류가 발생하였습니다.');
	}
	try {
		setButtons();
	} catch (e) {
		console.error('버튼 설정 과정에서 오류가 발생하였습니다.');
	}
	try {
		setTimer();
	} catch (e) {
		console.error('타이머를 불러오는 과정에서 오류가 발생하였습니다.');
	}
	try {
		setFloatingIcon();
	} catch (e) {
		console.error('플로팅 아이콘을 불러오는 과정에서 오류가 발생하였습니다.');
	}
}

window.addEventListener('load', init);