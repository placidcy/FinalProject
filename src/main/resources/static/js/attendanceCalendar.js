function dialogHandler() {
    let dialog = document.querySelector('#modal');
    let dateBoxArr = document.querySelectorAll('.weekBox>td');
    let reqType = document.querySelector('#reqType');
    let reqDate = document.querySelector('#reqDate');
    let exit = document.querySelector('.exit');
    let yearMonth = document.querySelector('#yearMonth');

    for(let dateBox of dateBoxArr){
        dateBox.addEventListener('mousedown', () => {
            console.log(dateBox.innerHTML);
        }
        );
        dateBox.addEventListener('mouseup', (event) => {
            console.log(dateBox.innerHTML);
            if(dateBox.getAttribute('class') === 'monthDate-l' || dateBox.getAttribute('class') === 'monthDate-ab'){
                dialog.open=true ;
                reqType.innerHTML='출결 정정 요청';
                reqDate.innerHTML= yearMonth.innerText + '.' + dateBox.firstChild.innerText;
            } 
        }
        );
    }
    
    

    exit.addEventListener('click', () => {
        dialog.open = false;
    });


}

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
let num =0;
function getCalender(number){
    const yearMonth = document.querySelector('#yearMonth');
    const calendarBox = document.querySelector('#calendarBox');
    let today = new Date();
    today.setMonth(today.getMonth() + number);
    let firstDate = new Date(today.getFullYear(), today.getMonth(), 1);
    let lastDate= new Date(today.getFullYear(), today.getMonth()+1, 0);
    let prevLastDate = new Date(today.getFullYear(), today.getMonth(), 0);
    let firstDay = firstDate.getDay();
    let lastDay = lastDate.getDay();
    let prevLastDay = prevLastDate.getDay();
    let weekCount = (lastDate.getDate()-(7-firstDay + lastDay+1))/7+2
    
    yearMonth.innerText = today.getFullYear() + '.' + ('0'+(today.getMonth()+1)).slice(-2);
    
    let firstWeekBox = '<tr class="weekBox">';
    if(firstDay!=0){
    for(let i = prevLastDay; i >= 0; i--){
        if(i==prevLastDay){
            firstWeekBox += '<td class="preMonthDate-ww">'+ (prevLastDate.getDate()-i) +'</td>';
        }else{
            firstWeekBox += '<td class="preMonthDate">'+ (prevLastDate.getDate()-i) +'</td>';
        }
    }

    for(let i = 1; i <= 6-prevLastDay; i++){
        if(i==6-prevLastDay){
            firstWeekBox += '<td class="monthDate-w">'+i+'</td>';
        }else{
            firstWeekBox += '<td class="monthDate-nc">'+i+'</td>';
        }
        
    }
    }else{
        for(let i = 1; i<=7; i++){
            if(i==1){
                firstWeekBox += '<td class="monthDate-ww">'+i+'</td>';
            }else if(i==7){
                firstWeekBox += '<td class="monthDate-w">'+i+'</td>';
            }else{
                firstWeekBox += '<td class="monthDate-nc">'+i+'</td>';
            }
        }
    }
    firstWeekBox +='</tr>';


    let lastWeekBox ='<tr class="weekBox">';

    for(let i = lastDay; i >= 0; i--){
        if(i==lastDay){
            lastWeekBox += '<td class="monthDate-ww">'+ (lastDate.getDate()-i) +'</td>';
        }else if(lastDay==6 && i==0){
            lastWeekBox += '<td class="monthDate-w">'+ (lastDate.getDate()) +'</td>';
        }else{
            lastWeekBox += '<td class="monthDate-nc">'+ (lastDate.getDate()-i) +'</td>';
        }
    }

    if(lastDay != 6){
        for(let i = 1; i <= 6-lastDay; i++){
            lastWeekBox += '<td class="preMonthDate">'+i+'</td>';
        }
    }
    lastWeekBox +='</tr>';
                    
    
    let weekBoxs='';
    for(j = 8-firstDay; j < lastDate.getDate()-lastDay; j++){ 
        if(j%7==(8-firstDay)%7){
            weekBoxs += '<tr class="weekBox"><td class="monthDate-ww">'+ j +'</td>';
        }else if(j%7==(14-firstDay)%7){
            weekBoxs += '<td class="monthDate-w">'+ j +'</td></tr>';
        }else{
            weekBoxs += '<td class="monthDate-nc">'+ j +'</td>';
        }
        
    }  
    calendarBox.innerHTML=firstWeekBox + weekBoxs + lastWeekBox;
}

function mobileHandler(){
    let menuList = document.querySelector('#menuList');
    let menuIcon = document.querySelector('#mobile-menu-icon');
    let menuName = document.querySelector('.menuName');
    let mobileMenu = document.querySelector('#mobile-menu');
    let className = menuName.innerHTML;
    menuIcon.addEventListener('click', () => {
        menuList.style.getPropertyValue('visibility') ==='hidden'? menuList.style.setProperty('visibility', 'visible') : menuList.style.setProperty('visibility', 'hidden');       
        menuList.style.getPropertyValue('visibility') ==='hidden'? menuName.innerHTML=className : menuName.innerHTML='CHECK';
    });
}

function init() {
    document.querySelector('#leftMonth').addEventListener('click', () =>{num--; getCalender(num)});
    document.querySelector('#rightMonth').addEventListener('click', () =>{num++; getCalender(num)});
    document.querySelector('#todayBox').addEventListener('click', () =>{num=0; getCalender(num)});
    getCalender(0);
    mobileHandler();
    dialogHandler();
    checkReqStatusHandler();
    todayDate();
}

window.addEventListener('load', init);