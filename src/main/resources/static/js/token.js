sessionStorage.setItem('token', data.token);

fetch('/mypage', {
  method: 'GET',
  headers: {
    'Authorization': `Bearer ${sessionStorage.getItem('token')}`,
	'Content-Type': 'application/json',
  }
})
.then(response => response.json())
.then(data => {
  console.log(data);
})
.catch(error => console.error('Error:', error));