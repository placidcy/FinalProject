function sendScanResult(decodedText, keyword) {
	const url = `/api/checkin/update?keyword=${keyword}&code=${decodedText}`;
	sendRequest(url, 'GET', responseHandler);
}

function callScanner(window, keyword) {
	const html5QrCode = new Html5Qrcode("reader");
	const qrCodeSuccessCallback = (decodedText) => {
		// QR 코드 스캔 성공 시 호출되는 콜백 함수
		html5QrCode.stop().then((ignore) => {
			sendScanResult(decodedText, keyword);
			window.setAttribute('open', false);
		}).catch((err) => {
			console.log("Error stopping QR Code scanning: " + err);
		});
	};
	const config = { fps: 10, qrbox: { width: 200, height: 200 } };	// 후면 카메라를 사용하여 QR 코드 스캔 시작

	html5QrCode.start({ facingMode: "environment" }, config, qrCodeSuccessCallback)
		.catch(err => {
			// QR 코드 스캐너 시작 중 오류 발생 시 처리
			console.error("Error starting QR code scanner: ", err);
		});
}