var util = (function(){
	var _page,_directory;
	var setPage = function(page){this._page = page;};
	var getPage = function(){return this._page;};
	var setDirectory = function(directory){this._directory = directory;};
	var getDirectory = function(){return this._directory;};
	return{
		move : function(){
			setDirctory(directory);
			setPage(page);
			location.href = 
				sessionStorage.getItem("context")+'/'+getDirectory()+'.do?page='+getPage();
		},
	isNumber : function(value) {
		  return typeof value === 'number' && isFinite(value)
		}
	};
})();


var move = function(context,page) {
	location.href = context+'/douglas.do?page='+page;
}	

var douglas = (function(){
	  var context = sessionStorage.getItem("context");
	 return{
	     init :function() {
	   	  document.querySelector('#bt_bom').addEventListener('click', function() {move(context,'bom'); }, false);  // 콜백 함수
		  document.querySelector('#bt_dom').addEventListener('click', function() {move(context,'dom'); }, false);
		  document.querySelector('#bt_kaup').addEventListener('click', function() {move(context,'kaup');}, false);
		  document.querySelector('#bt_account').addEventListener('click', function() {move(context,'account');}, false);
		 }  // 자바의 클래스 처럼 속성(은닉)과 기능으로 ..
	 };
	})();

var account = (function(){
	var _account_no=0,_money=0;	
	var setAccountNo = function(account_no){this._account_no=account_no;}
	var getAccountNo = function(){return this._account_no;}
	var setMoney = function(money){this._money=money;}
	var getMoney = function(){return this._money;}
	
	var setAcc = function(acc){this._acc=acc;}
	var getAcc = function(){return this._acc}
	
	return { 
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		
		init : function() {
				document.querySelector('#bt_spec_show').addEventListener('click',member.spec,false);
				document.querySelector('#bt_make_account').addEventListener('click',this.spec,false);
				document.querySelector('#bt_deposit').addEventListener('click',this.deposit,false);
				document.querySelector('#bt_withdraw').addEventListener('click',this.withdraw,false);
			},
			spec : function(){
				setAccountNo(Math.floor(Math.random()*899999) + 10000), ///// setter 역할
				setMoney(0);
				document.querySelector('#result_account').innerHTML= '계좌번호 : '+ getAccountNo(); ////getter 역할  메소드 이름으로 결정하는 것이 아니는 아니라 위치로 게터 세터를 결정한다	
			},
			deposit : function(){
			var r_acc =	document.querySelector('#result_account').innerText;
			console.log('계좌번호 : ' + r_acc);	
			switch (typeof r_acc) {
			case 'number': console.log('this is number type');break;
			case 'string': console.log('this is number type');break;
			case 'undefined': console.log('this is number undefined');break;
				default: console.log('fail');break;
			}
			if(!util.isNumber(getAccountNo())){
					// r_acc ==null 값체크
					// r_acc === undefined 타입체크
					alert('통장이 개설되지 않았습니다');
				}
				var rest_money = getMoney();
				var input_money = Number(document.querySelector('#money').value);
				console.log('인풋머니 타입 체크 : '+ (typeof input_money === 'number'));
				console.log('잔액 타입 체크 : '+ (typeof rest_money === 'number'));
				setMoney(rest_money+input_money);
				console.log('입금액 : '+ (typeof getMoney() === 'number'));
				document.querySelector('#rest_money').innerHTML= getMoney() ;
			},
			withdraw : function(){
				var rest_money = getMoney();
				var input_money = Number(document.querySelector('#money').value);
				setMoney(rest_money-input_money);
				document.querySelector('#rest_money').innerHTML = getMoney() ;
			}
	};
})();


var member = (function(){
	var _ssn,_name,_gender,_age;

	var setAge = function(age){this._age=age;};
	var setGender = function(gender){this._gender=gender;};
	var setSSN = function(ssn){this._ssn=ssn;};
	var setName = function(name){this._name=name;};
	var getAge = function(){return this._age;};
	var getSSN = function(){return this._ssn;};
	var getName = function(){return this._name;};
	var getGender = function(){return this._gender;};
	
	return{
		setSSN : setSSN,
		setName : setName,
		setAge : setAge,
		setGender : setGender,
		getName : getName,
		getAge : getAge,
		getSSN : getSSN,
		getGender : getGender,
		spec : function(){
			setName(document.querySelector('#name').value);
			var ssn = document.querySelector('#ssn').value;
			var result = '';
			var now = new Date().getFullYear();
			console.log("now    "+now);
			var gender = parseInt(ssn.substring(7,8));
			var ageTemp = parseInt(ssn.substring(0,2));
			console.log("ageTemp    "+ageTemp);
			switch (gender) {
			case 1: case 5: 
				setGender("남"); 
				setAge(now-(1900+ageTemp));
				console.log("1900+ageTemp    "+(1900+ageTemp));
				break;
			case 3: case 7:
				setGender("남"); 
				setAge(now-(2000+ageTemp));
				break;
			case 2: case 6:
				setGender("여");
				setAge(now-(1900+ageTemp));
				console.log("1900+ageTemp    "+(1900+ageTemp));
				break;
			case 4: case 8:
				setGender("여");
				setAge(now-(2000+ageTemp));
				break;
			default:
				setGender = "잘못된값을 입력하셨습니다";
			}
			document.querySelector('#result_name').innerHTML=getName();
			document.querySelector('#result_age').innerHTML=getAge();
			document.querySelector('#result_gender').innerHTML=getGender();
			// 인스턴스 변수 선언하고 게터 세터 하고 끌고 오는 방식하고 똑같다
		}
	};
})();

/*kaup*/
	
var kaup = (function(){
		
	return{
			init : function (){
			var kaup_calc = document.querySelector('#kaup_calc');
	    	kaup_calc.addEventListener('click',this.calc,false);
		},
		
			calc : function (){
				alert('카우프칼크 클릭');
				var name=document.querySelector('#name').value;
				var height=document.getElementById('height').value;
				var weight=document.getElementById('weight').value;
				console.log('name'+ name);
				console.log('height'+ height);
				console.log('weight'+ weight);
				var result='';
				var kaup = weight / (height / 100) / (height / 100);

				if (kaup < 18.5) {
					result = "저체중";
				} else if (18.5 < kaup && kaup < 22.9) {
					result = "정상체중";
				} else if (23.0 < kaup && kaup < 24.9) {
					result = "위험체중";
				} else if (25.0 < kaup && kaup < 29.9) {
					result = "비만1단계";
				} else if (40 > kaup && kaup > 30) {
					result = "비만2단계";
				} else if (kaup > 40) {
					result = "비만3단계";
				}

				document.getElementById('result').innerHTML='"'+name+'"'+'님의 카우푸결과 : '+result;

				//	return name + "의 BMI지수는 " + Double.parseDouble(String.format("%.2f", kaup)) + "이고, " + result + "이다";

			}
			
		};
			
		})();


	

//function kaup_go(){location.href = getContext()+'/douglas.do?page=kaup';}


