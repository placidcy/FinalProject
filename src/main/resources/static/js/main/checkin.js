/**
 * 
 */

function setChart() {
	const regex = /(\d+\.\d+)/g;
	const avgPer = document.querySelector('#avgPer').innerHTML.match(regex);
	const myPer = document.querySelector('#myPer').innerHTML.match(regex);

	const bar = document.querySelector('div.bullet.bar');
	const avg = document.querySelector('#avg');
	const curr = document.querySelector('#curr');

	bar.style.width = myPer + '%';
	avg.style.left = avgPer + '%';
	curr.style.left = myPer + '%';
}

window.addEventListener('load', setChart);