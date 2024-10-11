function checkReqStatusHandler() {
    let reqStatusList = document.querySelectorAll('[name="reqStatus"]');
    let reqCheck = document.querySelector('[name="reqCheck"]');
    let reqCheckRow = document.querySelector('#reqCheckRow');

    let approvedOptions = [
        {
            num: 1,
            text: '훈련'
        },
		{
            num: 2,
            text: '시험'
        },
		{
            num: 3,
            text: '면접'
        },
		{
		    num: 4,
		    text: '예비군'
		},
		{
		    num: 5,
		    text: '결혼'
		},
		{
		    num: 6,
		    text: '시험'
		},
		{
		    num: 7,
		    text: '사망'
		},
		{
		    num: 8,
		    text: '질병'
		},
		{
		    num: 8,
		    text: '입원'
		},
		{
		    num: 9,
		    text: '개인 사정'
		}
    ];

    let deniedOptions = [
        {
            num: 10,
            text: '서류 불충분'
        },
		{
		    num: 11,
		    text: '사유 부적합'
		},
		
    ];

    for (reqStatus of reqStatusList) {
        reqStatus.addEventListener('click', (event) => {
            reqCheckRow.classList.remove('hidden');

            reqCheck.options.length = 0;

            switch (event.target.value) {
                case 'approved':
                    for (option of approvedOptions) {
                        let optionElement = document.createElement('option');
                        optionElement.setAttribute('value', option.num);
                        optionElement.innerHTML = option.text;

                        reqCheck.append(optionElement);
                    }
                    break;
                case 'denied':
                    for (option of deniedOptions) {
                        let optionElement = document.createElement('option');
                        optionElement.setAttribute('value', option.num);
                        optionElement.innerHTML = option.text;

                        reqCheck.append(optionElement);
                    }
                    break;
            }
        });
    }
}

function dialogHandler() {
    let dialog = document.querySelector('.modal');
    let dialogBtn = document.querySelector('.dialogBtn');
    let exit = document.querySelector('.exit');

    dialogBtn.addEventListener('click', () => {
        dialog.open ? dialog.open = false : dialog.open = true;
    })

    exit.addEventListener('click', () => {
        dialog.open = false;
    });
}

function init() {
    dialogHandler();
    checkReqStatusHandler();
}

window.addEventListener('load', init);