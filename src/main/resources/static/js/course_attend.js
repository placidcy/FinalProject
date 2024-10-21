let today;

function getDateText(req_type, r_status){
	if(req_type==1){
		if(r_status == 1){
			return '정정 요청 승인';
		}else if(r_status == 2){
			return '정정 요청 거절';
		}else{
			return '정정 요청 진행 중';
		}
	}else if(req_type==2){
		if(r_status == 1){
			return '공가 요청 승인';
		}else if(r_status == 2){
			return '공가 요청 거절';
		}else{ 
			return '공가 요청 진행 중';
		}
	}else{
		return '';
	}
	
}

function getCalender(number){
    let yearMonth = document.querySelector('#yearMonth');
    const calendarBox = document.querySelector('#calendarBox');
	let dateTime=new Date();
	let c_sdate = new Date(document.querySelector('#c_sdate').value);
	let c_edate = new Date(document.querySelector('#c_edate').value);
	let courseDay = [document.querySelector('#d_mon').value*2, document.querySelector('#d_tue').value*3, document.querySelector('#d_wed').value*4, document.querySelector('#d_thu').value*5, document.querySelector('#d_fri').value*6]
	
	if(dateTime.getFullYear() < c_sdate.getFullYear()) {
		dateTime=c_sdate;
	}else if(dateTime.getFullYear() > c_edate.getFullYear()){
		dateTime=c_edate;
	}else if(dateTime.getFullYear() == c_edate.getFullYear() && dateTime.getMonth() > c_edate.getMonth()) {
		dateTime=c_edate;
	}else if(dateTime.getFullYear() == c_sdate.getFullYear() && dateTime.getMonth() < c_sdate.getMonth()) {
		dateTime=c_sdate;
	}
	today=dateTime;
	
    today.setMonth(today.getMonth() + number);
//자바스크립트에서 promise 객체란 비동기 방식을 처리하기위한 객체
	fetch('getStudentCalendar?c_year='+today.getFullYear()+'&c_month='+ (today.getMonth()+1)) // url만 지정하면 get 방식, 2번째 매개변수는 option객체
	.then(response => response.json()) // 비동기 처리의 결과를 then이 받는다.
	.then(obj => {
		let firstDate = new Date(new Date(obj[0].dt).getFullYear(), new Date(obj[0].dt).getMonth(), 1);
	    let lastDate= new Date(new Date(obj[0].dt).getFullYear(), new Date(obj[0].dt).getMonth()+1, 0);
	    let prevLastDate = new Date(new Date(obj[0].dt).getFullYear(), new Date(obj[0].dt).getMonth(), 0);
	    let firstDay = firstDate.getDay();
	    let lastDay = lastDate.getDay();
	    let prevLastDay = prevLastDate.getDay();
	    let weekCount = (lastDate.getDate()-(7-firstDay + lastDay+1))/7+2

	    yearMonth.innerText = today.getFullYear() + '.' + ('0'+(today.getMonth()+1)).slice(-2);
	 
	    let firstWeekBox = '<tr class="weekBox">';
	    if(firstDay!=0){
	    for(let i = prevLastDay; i >= 0; i--){
	        if(i==prevLastDay){
	            firstWeekBox += '<td class="preMonthDate-ww" >'+ (prevLastDate.getDate()-i) +'</td>';
	        }else{
	            firstWeekBox += '<td class="preMonthDate" >'+ (prevLastDate.getDate()-i) +'</td>';
	        }
	    }

	    for(let i = 1; i <= 6-prevLastDay; i++){
	        if(i==6-prevLastDay){
	            firstWeekBox += '<td class="monthDate-w">'+i+'</td>';
	        }else{
				if(new Date() - new Date(today.getFullYear(), today.getMonth(), i) >=0){
	            	firstWeekBox += '<td class="' + (obj.length>=i  && courseDay.includes(obj[i-1].d*1) ? (getDateColor(obj[i-1].a_status) + '" onclick="dialogHandler('+ obj[i-1].a_status+ ','+ obj[i-1].req_type+ ','+ obj[i-1].r_status+ ','+ (i-1) +')') :'monthDate-nc') + '">'+ i +'<div class="attReq">' + (obj.length>=i  && courseDay.includes(obj[i-1].d*1) ? getDateText(obj[i-1].req_type, obj[i-1].r_status): '') + '</div></td>';
				}else{
					firstWeekBox += '<td class="' + (obj.length>=i  && courseDay.includes(obj[i-1].d*1) ?'monthDate-c" onclick="dialogHandler2()"' : 'monthDate-nc"') + '>'+ i +'<div class="attReq">' + (obj.length>=i  && courseDay.includes(obj[i-1].d*1) ? getDateText(obj[i-1].req_type, obj[i-1].r_status): '') + '</div></td>';
				}
	            
	        }
	        
	    }
	    }else{
	        for(let i = 1; i<=7; i++){
	            if(i==1){
	                firstWeekBox += '<td class="monthDate-ww">'+i+'</td>';
	            }else if(i==7){
	                firstWeekBox += '<td class="monthDate-w">'+i+'</td>';
	            }else{
					if(new Date() - new Date(today.getFullYear(), today.getMonth(), i) >=0){
	                	firstWeekBox += '<td class="' + (obj.length>=i && courseDay.includes(obj[i-1].d*1) ? (getDateColor(obj[i-1].a_status) + '" onclick="dialogHandler('+ obj[i-1].a_status+ ','+ obj[i-1].req_type+ ','+ obj[i-1].r_status+ ','+ (i-1) +')') :'monthDate-nc') + '">'+ i +'<div class="attReq">' + (obj.length>=i && courseDay.includes(obj[i-1].d*1) ? getDateText(obj[i-1].req_type, obj[i-1].r_status): '') + '</div></td>';
					}else{
						firstWeekBox += '<td class="' + (obj.length>=i && courseDay.includes(obj[i-1].d*1) ?'monthDate-c" onclick="dialogHandler2()"' : 'monthDate-nc"') + '>'+ i +'<div class="attReq">' + (obj.length>=i && courseDay.includes(obj[i-1].d*1) ? getDateText(obj[i-1].req_type, obj[i-1].r_status): '') + '</div></td>';
					}
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
				
				if(new Date() - new Date(today.getFullYear(), today.getMonth(), lastDate.getDate()-i) >=0){
					lastWeekBox += '<td class="' + (obj.length>=lastDate.getDate()-i && courseDay.includes(obj[lastDate.getDate()-i-1].d*1) ? (getDateColor(obj[lastDate.getDate()-i-1].a_status) + '"onclick="dialogHandler('+ obj[lastDate.getDate()-i-1].a_status+ ','+ obj[lastDate.getDate()-i-1].req_type+ ','+ obj[lastDate.getDate()-i-1].r_status+ ','+ (lastDate.getDate()-i-1) +')') : 'monthDate-nc') +'">'+ (lastDate.getDate()-i) +'<div class="attReq">' + (obj.length>=lastDate.getDate()-i  && courseDay.includes(obj[lastDate.getDate()-i-1].d*1) ? getDateText(obj[lastDate.getDate()-i-1].req_type, obj[lastDate.getDate()-i-1].r_status) : '') + '</div></td>';
				}else{
					lastWeekBox += '<td class="' + (obj.length>=lastDate.getDate()-i && courseDay.includes(obj[lastDate.getDate()-i-1].d*1) ? 'monthDate-c" onclick="dialogHandler2()"' : 'monthDate-nc"') +'>'+ (lastDate.getDate()-i) +'<div class="attReq">' + (obj.length>=lastDate.getDate()-i  && courseDay.includes(obj[lastDate.getDate()-i-1].d*1) ? getDateText(obj[lastDate.getDate()-i-1].req_type, obj[lastDate.getDate()-i-1].r_status) : '') + '</div></td>';
				}
	            
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
				if(new Date() - new Date(today.getFullYear(), today.getMonth(), j) >=0){
					weekBoxs += '<td class="' + (obj.length>=j && courseDay.includes(obj[j-1].d*1) ? (getDateColor(obj[j-1].a_status) + '" onclick="dialogHandler('+ obj[j-1].a_status+ ','+ obj[j-1].req_type+ ','+ obj[j-1].r_status+ ','+ (j-1) +')') : 'monthDate-nc') + '">'+ j + '<div class="attReq">' + (obj.length>=j  && courseDay.includes(obj[j-1].d*1) ? getDateText(obj[j-1].req_type, obj[j-1].r_status) : '') + '</div></td>';
	        	}else{
					weekBoxs += '<td class="' + (obj.length>=j && courseDay.includes(obj[j-1].d*1)  ? 'monthDate-c" onclick="dialogHandler2()"' : 'monthDate-nc"') +'>'+ j + '<div class="attReq">' + (obj.length>=j  && courseDay.includes(obj[j-1].d*1) ? getDateText(obj[j-1].req_type, obj[j-1].r_status) : '') + '</div></td>';
				}
			}
	    }  
						
		calendarBox.innerHTML=firstWeekBox + weekBoxs + lastWeekBox;
	}) // 변환된 자바스크립트 객체 obj == response.json()
	.catch(error => console.log(error));
		
    
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
	let num = 0;
	let c_sdate = new Date(document.querySelector('#c_sdate').value);
	let c_edate = new Date(document.querySelector('#c_edate').value);
	
    document.querySelector('#leftMonth').addEventListener('click', (event) =>{today.getFullYear()==c_sdate.getFullYear() && today.getMonth() == c_sdate.getMonth()? event.preventDefault() : getCalender(--num)});
    document.querySelector('#rightMonth').addEventListener('click', (event) =>{today.getFullYear()==c_edate.getFullYear() && today.getMonth() == c_edate.getMonth() ? event.preventDefault() : getCalender(++num)});
    document.querySelector('#todayBox').addEventListener('click', () =>{num=0; getCalender(num)});
	getCalender(num);
    mobileHandler();
	
}

window.addEventListener('load', init);