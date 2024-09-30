function checkReqStatusHandler() {
    let reqStatusList = document.querySelectorAll('[name="reqStatus"]');
    let reqCheck = document.querySelector('[name="reqCheck"]');
    let reqCheckRow = document.querySelector('#reqCheckRow');

    let approvedOptions = [
        {
            num: 1,
            text: '정정'
        }
    ];

    let deniedOptions = [
        {
            num: 10,
            text: '서류 불충분'
        }
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