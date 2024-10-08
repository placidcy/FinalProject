function submitHandler(event){
	if(!document.querySelector('#r_details').value){
		event.preventDefault();
		alert('응답 사유를 선택해 주세요.');
	}
	
	if(document.querySelector('#responseModal').children[1].children[0].children[6].getAttribute('action')==='/attResponseUpdate'){
		 if (confirm("정말 수정하시겠습니까??") == true){    
		 }else{   
		    event.preventDefault();
		}
		
	}
	
}

function dialogHandler() {
	let dialog = document.querySelector('#responseModal');
	let correquestInfoBox = document.querySelectorAll('.correquestInfoBox');
	let lvrequestInfoBox = document.querySelectorAll('.lvrequestInfoBox');
    let exit = document.querySelector('.exit');
	let cancelModal = document.querySelector('#cancleModal');
	let reqType = document.querySelector('[name="reqType"]');
	let date = document.querySelector('[name="date"]');
    let corText=[];
	let lvText=[];
	
	correquestInfoBox.forEach((v,index) => {
		corText[index] = {"date": v.children[2].innerText, 
						  "status": v.children[1].innerText, 
						  "contents": v.children[3].getAttribute("data-text"), 
						  "attm": v.children[4].getAttribute("data-text"),
						  "r_status":v.children[6].innerText
		}
	}
	);
	
	lvrequestInfoBox.forEach((v,index) => {
			lvText[index] = {"date": v.children[2].innerText, 
							  "reason": v.children[5].getAttribute("data-text"), 
							  "contents": v.children[3].getAttribute("data-text"), 
							  "attm": v.children[4].getAttribute("data-text"),
							  "r_status":v.children[7].innerText
		}
	}
	);
	
	
	correquestInfoBox.forEach((v, index) => 	v.addEventListener('click', () => {
	        dialog.open ? dialog.open = true : dialog.open = true;
			dialog.children[1].children[0].children[0].children[0].innerText=corText[index]['date'];
			dialog.children[1].children[0].children[1].innerHTML= '출결 : &nbsp&nbsp' + corText[index]['status'];
			dialog.children[1].children[0].children[3].innerText=corText[index]['contents'];
			if(corText[index]['attm']){
			dialog.children[1].children[0].children[4].children[0].innerText=corText[index]['attm'];
			}else{
			dialog.children[1].children[0].children[4].innerText='증명서류 :  미제출';
			}
			date.value=corText[index]['date'].replaceAll('.','-');
			reqType.value=1;
			dialog.children[1].children[0].children[6].children[4].children[0].children[0].removeAttribute('checked');
			dialog.children[1].children[0].children[6].children[4].children[1].children[0].removeAttribute('checked');
			dialog.children[1].children[0].children[6].setAttribute('action','/attResponse');
			
			if(corText[index]['r_status']==='승인'){
				dialog.children[1].children[0].children[6].children[4].children[0].children[0].setAttribute('checked',true);
				dialog.children[1].children[0].children[6].setAttribute('action','/attResponseUpdate');	
			}else if(corText[index]['r_status']==='거절'){
				dialog.children[1].children[0].children[6].children[4].children[1].children[0].setAttribute('checked',true);
				dialog.children[1].children[0].children[6].setAttribute('action','/attResponseUpdate');	
				
			}

			
	}));
	
	lvrequestInfoBox.forEach((v, index) => 	v.addEventListener('click', () => {
		        dialog.open ? dialog.open = true : dialog.open = true;
				dialog.children[1].children[0].children[0].children[0].innerText=lvText[index]['date'];
				dialog.children[1].children[0].children[1].innerHTML= '사유 : &nbsp&nbsp ' + lvText[index]['reason'];
				dialog.children[1].children[0].children[3].innerText=lvText[index]['contents'];
				if(lvText[index]['attm']){
				dialog.children[1].children[0].children[4].children[0].innerText=lvText[index]['attm'];
				}else{
				dialog.children[1].children[0].children[4].innerText='증명서류 :  미제출';
				}
				date.value=lvText[index]['date'].substr(0,10).replaceAll('.','-');
				reqType.value=2;
				dialog.children[1].children[0].children[6].children[4].children[0].children[0].removeAttribute('checked');
				dialog.children[1].children[0].children[6].children[4].children[1].children[0].removeAttribute('checked');
				dialog.children[1].children[0].children[6].setAttribute('action','/attResponse');
				
				if(lvText[index]['r_status']==='승인'){
					dialog.children[1].children[0].children[6].children[4].children[0].children[0].setAttribute('checked',true);
					dialog.children[1].children[0].children[6].setAttribute('action','/attResponseUpdate');	
				}else if(lvText[index]['r_status']==='거절'){
					dialog.children[1].children[0].children[6].children[4].children[1].children[0].setAttribute('checked',true);
					dialog.children[1].children[0].children[6].setAttribute('action','/attResponseUpdate');	
					
				}
		}));
	
	
		
	cancelModal.addEventListener('click', () => {
        dialog.open = false;
    });
	
    exit.addEventListener('click', () => {
        dialog.open = false;
    });
}

function checkReqStatusHandler() {
    let reqStatusList = document.querySelectorAll('[name="r_status"]');
    let reqCheck = document.querySelector('[name="r_details"]');
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
                case '1':
                    for (option of approvedOptions) {
                        let optionElement = document.createElement('option');
                        optionElement.setAttribute('value', option.num);
                        optionElement.innerHTML = option.text;

                        reqCheck.append(optionElement);
                    }
                    break;
                case '2':
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

function menuHandler(){
	let menuList = document.querySelector('#menuList');
    let menuIcon = document.querySelector('#mobile-menu-icon');
    let menuName = document.querySelector('.menuName');
    let mobileMenu = document.querySelector('#mobile-menu');
	let backBtn = document.querySelector('#backBtn').addEventListener('click',()=>{window.history.back()});
    let className = menuName.innerHTML;
    menuIcon.addEventListener('click', () => {
        menuList.style.getPropertyValue('visibility') ==='hidden'? menuList.style.setProperty('visibility', 'visible') : menuList.style.setProperty('visibility', 'hidden');       
        menuList.style.getPropertyValue('visibility') ==='hidden'? menuName.innerHTML=className : menuName.innerHTML='CHECK';
    });
}

function init() {
	submitBtn = document.querySelector('#submitBtn').addEventListener('click', submitHandler);
	menuHandler();
	dialogHandler();
	checkReqStatusHandler();
}

window.addEventListener('load', init);