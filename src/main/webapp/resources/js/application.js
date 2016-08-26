// var application = (function(){})(); iife 패턴
	var app = (function(){
		var init = function(context) {
		
		session.init(context);
		onCreate();
		nav.init();
		member.init();
		user.init();
		admin.init();
		account.init();
		kaup.init();
		grade.init();
		};
		var context = function() {return session.getContextPath();}
		var js = function(){return session.getJavacriptPath('js');}
		var css = function(){return session.getCssPath('css');}
		var img = function(){return session.getImgPath('img');}
		var setContentView = function(){
			$('#header_brand').attr('src',app.img()+'/hanbit2.jpg').css('alt','Brand').css('width','150px').css('height','50px');
			$('#footer').addClass('bottom').addClass('footer');
			$('#global_content').addClass('box');
			$('#global_content a').addClass('cursor');
			$('#global_content_regist').text('SIGN UP').click(function(){controller.move('member','regist');});
			$('#global_content_login').text('LOG IN').click(function(){controller.move('member','login');});
			$('#global_content_admin').text('ADMIN MODE').click(function(){admin.check();});
		};
		var onCreate = function() {
			setContentView();
		$('#title').click(function() {controller.home();});
		$('#a_member').click(function() {controller.move('member','main');});
		$('#a_grade').click(function() {controller.move('grade','main');});
		$('#a_account').click(function() {controller.move('bank','main');});
		$('#abc').click(function() {controller.move('global','school_info');
		});
		};
		return{ 
			init : init,
			onCreate : onCreate,
			setContentView : setContentView, // public 메소드로 바꾸는 의미
			context : context,
			img : img,
			js : js,
			css :css
		////// 다른 jsp 에서 가져다 쓰기 위해서 app 의 리턴값으로 설정해 주면 
		///  	app.init / app.context 형식으로 불러올 수 있다
		}
		
	})();

	var admin = (function() {
		 var _pass;
		 var getPass = function(){return this._pass;};
		 var setPass = function(pass){this._pass = pass;};
		 var init = function(){onCreate();};
		 var setContentView = function(){
			 	$('#admin_content #member_mgmt').attr('src',app.img()+'/membermm.png').css('height','400px');
			 	$('#admin_content #grade_mgmt').attr('src',app.img()+'/grademm.png').css('height','400px');
			 	$('#admin_content #account_mgmt').attr('src',app.img()+'/bankmm.jpg').css('height','400px');
			 	$('#admin_content h3').addClass('text_center')
			 	
		 	};
		 var onCreate = function(){
			 setContentView();
			 
			 $('#admin_nav #member_mgmt #list').click(function(){controller.move('member','list');});
			 $('#admin_nav #member_mgmt #findBy').click(function(){controller.move('member','findBy');});
			 $('#admin_nav #member_mgmt #count').click(function(){controller.move('member','count');});
			 $('#admin_nav #account_mgmt #list').click(function(){controller.move('bank','list');});
			 $('#admin_nav #account_mgmt #open').click(function(){controller.move('bank','open');});
			 $('#admin_nav #account_mgmt #delete').click(function(){;controller.move('bank','delete');});
			 $('#admin_nav #account_mgmt #find').click(function(){controller.move('bank','find');});
			 $('#admin_nav #account_mgmt #count').click(function(){controller.move('bank','count');});
		 };
		 return {
			 init : init,
			 setContentView : setContentView,
			 onCreate : onCreate,
			 getPass : getPass,
		     setPass : setPass,
		     check : function(){
		      setPass(1);
		      var isAdmin = confirm('관리자입니까?');
		      if (!isAdmin){
		       alert('관리자만 접근 가능합니다.');
		      } else { 
		       var password = prompt('관리자 비번을 입력바랍니다.');
		       if(password == getPass()){
		    	   controller.move('admin','main');
		       } else {
		        alert('관리자 비번이 틀립니다');
		       }
		      }
		     }
		 };
		})();
		var user = (function(){
		var init = function(){onCreate();}; //생성자
		var setContentView = function(){
			$('#bank_content_img_home').attr('src',app.img()+'/home.png').css('width','30px');
		}; // UI
		var onCreate = function(){ // 이벤트 리스너
			setContentView();  
			  $('#bt_bom').click(function(){controller.move('','bom'); });  // 콜백 함수
			  $('#bt_dom').click(function(){controller.move('','dom'); });
			  $('#bt_kaup').click(function(){controller.move('','kaup');});
			  $('#bt_account').click(function() {controller.move('','account');});
			  $('#b_regist').click(function(){controller.move('bank','regist');});
				$('#b_deposit').click(function(){controller.move('bank','bank');});
				$('#b_withdraw').click(function(){controller.move('bank','withdraw');});
				$('#b_update').click(function(){controller.move('bank','withdraw');});
				$('#b_delete').click(function(){controller.move('bank','update');});
				$('#b_list').click(function(){controller.move('bank','list');});
				$('#b_search').click(function(){controller.move('bank','search');});
				$('#b_count').click(function(){controller.move('bank','count');});
//				
//				$('#bank_content_a_home').click(function(){controller.home();});
//				$('#bank_content').addClass('box').css('font-size' ,'20px');
//				$('#bank_content > article').css('width','300px')
//				.addClass('center').addClass('text_left');
//				$('#bank_content > article').css('font-size' ,'17px').addClass('cursor');
//				
//				$('#bank_content > h1').text('BANK MGMT');
//				$('#bank_content_ol > li > a').addClass('remove_underline');
//				$('#bank_content_ol > li:first > a').text('개설');
//				$('#bank_content_ol > li:nth(1) > a').text('입금');
//				$('#bank_content_ol > li:nth(2) > a').text('출금');
//				$('#bank_content_ol > li:nth(3) > a').text('비번수정');
//				$('#bank_content_ol > li:nth(4) > a').text('해지');
//				$('#bank_content_ol > li:nth(5) > a').text('목록');
//				$('#bank_content_ol > li:nth(6) > a').text('조회(이름)');
//				$('#bank_content_ol > li:nth(7) > a').text('통장수');
		
		}; 
		return{
		     init :init,  // 자바의 클래스 처럼 속성(은닉)과 기능으로 ..
				 
		 };
		})();

	var account = (function(){
		var _account_no=0,_money=0;	
		var setAccountNo = function(account_no){this._account_no=account_no;}
		var getAccountNo = function(){return this._account_no;}
		var setMoney = function(money){this._money=money;}
		var getMoney = function(){return this._money;}
//		var setAcc = function(acc){this._acc=acc;}
//		var getAcc = function(){return this._acc}
		var init = function(){onCreate();};
		var setContentView = function(){};
		var onCreate = function(){
			setContentView();
			$('#bt_spec_show').click(member.spec());
			$('#bt_make_account').click(this.spec());
			$('#bt_deposit').click(this.deposit());
			$('#bt_withdraw').click(this.withdraw());
		};
		return { 
			setAccountNo : setAccountNo,
			getAccountNo : getAccountNo,
			setMoney : setMoney,
			getMoney : getMoney,
			
			init : init,
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
		var init = function(){onCreate();};
		var setContentView = function(){
			$('#member_content_img_home').attr('alt','home').attr('src',app.img()+'/home.png').css('width','30px');
			$('#member_content_a_home').click(function(){controller.home();});
			$('#member_content').addClass('box').css('font-size' ,'15px');
			$('#member_content > article').css('width','300px')
			.addClass('center').addClass('text_left');
			$('#member_content > article a').css('font-size' ,'17px').addClass('cursor');
			$('#member_content > h1').text('MEMBER MGMT');
			$('#member_content_ol > li > a').addClass('remove_underline');
			$('#member_content_ol > li:first > a').text('SING UP');
			$('#member_content_ol > li:nth(1) > a').text('MYINFO');
			$('#member_content_ol > li:nth(2) > a').text('UPDATE MY INFO');
			$('#member_content_ol > li:nth(3) > a').text('SING OUT');
			$('#member_content_ol > li:nth(4) > a').text('LOG IN');
			$('#member_content_ol > li:nth(5) > a').text('LOG OUT');
			$('#member_content_ol > li:nth(6) > a').text('LIST');
			$('#member_content_ol > li:nth(7) > a').text('SEARCH FOR HAPPINESS');
			$('#member_content_ol > li:nth(8) > a').text('MEMBER COUNT');
			$('#member_regist').addClass('box');
			$('#member_regist #bt_join').addClass('btn').addClass('btn-primary');
			$('#member_regist #bt_cancel').addClass('btn').addClass('btn-danger');
	//
			$('#member_regist_form').addClass('form-horizontal');
			$('#member_regist_form > div').addClass('form-group').addClass('form-group-lg');
			$('#member_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
			$('#member_regist_form > div > div').addClass('col-sm-10');
			$('#member_regist_form > div > div > input').addClass('form-control');

			$('#member_regist #rd_major > label:gt(0)').addClass('radio-inline');
			$('#member_regist #ck_subject').addClass('checkbox');
			$('#member_regist #ck_subject > label').addClass('checkbox-inline');
		};
		var onCreate = function(){
			setContentView();	
			$('#regist').click(function(){controller.move('member','regist')});
			$('#detail').click(function(){controller.move('member','detail')});
			$('#update').click(function(){controller.move('member','update');});
			$('#delete').click(function(){controller.move('member','delete');});
			$('#login').click(function(){controller.move('member','login');});
			$('#logout').click(function(){controller.move('member','logout');});
			$('#list').click(function(){controller.move('member','list');});
			$('#findBy').click(function(){controller.move('member','findBy');});
			$('#count').click(function(){controller.move('member','count');});
		};
		
		
		return{
			setSSN : setSSN,
			setName : setName,
			setAge : setAge,
			setGender : setGender,
			getName : getName,
			getAge : getAge,
			getSSN : getSSN,
			getGender : getGender,
			init : init,
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
		var init = function(){onCreate();};
		var setContentView = function(){};
		var onCreate = function(){
			setContentview();
			var kaup_calc = document.querySelector('#kaup_calc');kaup_calc.addEventListener('click',this.calc,false);
		};
			
		return{
				init : init,
				calc : function (){
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
	
	var grade = (function(){
		var init = function(){onCreate();};
		var setContentView = function(){

			$('#grade_content_img_home').attr('src',app.img()+'/home.png').css('width','30px');
			$('#grade_content_a_home').click(function(){controller.home();});
			$('#grade_content').addClass('box').css('font-size' ,'20px');
			$('#grade_content > article').css('width','300px')
			.addClass('center').addClass('text_left');
			$('#grade_content > article a').css('font-size' ,'15px').addClass('cursor');
			
			$('#grade_content > h1').text('GRADE MGMT');
			$('#grade_content_ol > li > a').addClass('remove_underline');
			$('#grade_content_ol > li:first > a').text('등록');
			$('#grade_content_ol > li:nth(1) > a').text('수정');
			$('#grade_content_ol > li:nth(2) > a').text('삭제');
			$('#grade_content_ol > li:nth(3) > a').text('목록');
			$('#grade_content_ol > li:nth(4) > a').text('카운트');
			$('#grade_content_ol > li:nth(5) > a').text('검색');
			$('#grade_content').addClass('box');
			$('#img_home').css('width','100px')
			$('#grade_content > article')
			.css('width','300px')
			.css('margin','0 auto')
			.css('text-align','left')
		};
		var onCreate = function(){
			setContentView();
			$('#g_regist').click(function(){controller.move('grade','regist');});
			$('#g_update').click(function(){controller.move('grade','update');});
			$('#g_delete').click(function(){controller.move('grade','delete');});
			$('#g_list').click(function(){controller.move('grade','list');});
			$('#g_count').click(function(){controller.move('grade','count');});
			$('#g_search').click(function(){controller.move('grade','search');});
			$('#a_regist').click(function() {
				location.href = "${context}/grade.do?page=regist";
			});
			$('#a_update').click(function() {
				location.href = "${context}/grade.do?page=update";
			});
			$('#a_delete').click(function() {
				location.href = "${context}/grade.do?page=delete";
			});
			$('#a_list').click(function() {
				location.href = "${context}/grade.do?page=list";
			});
			$('#a_count').click(function() {
				location.href = "${context}/grade.do?page=count";
			});
			$('#a_search').click(function() {
				location.href = "${context}/grade.do?page=search";
			});
		};
		
		return {
			init : init,
				
		};
	})();

	var session = (function(){
		var init = function(context) {
			sessionStorage.setItem('context',context);
			sessionStorage.setItem('js',context+'/resources/js');
			sessionStorage.setItem('css',context+'/resources/css');
			sessionStorage.setItem('img',context+'/resources/img');
		};
		var getContextPath = function(){return sessionStorage.getItem('context');};
		var getJavascriptPath = function(){return sessionStorage.getItem('js');};
		var getCssPath = function(){return sessionStorage.getItem('js');};
		var getImgPath = function(){return sessionStorage.getItem('img');};
	return{
		init : init,
		getContextPath : getContextPath,
		getJavascriptPath : getJavascriptPath,
		getCssPath : getCssPath,
		getImgPath : getImgPath
		};
	})();
	
	var controller = (function(){
		var _page,_directory;
		var setPage = function(page){this._page = page;};
		var getPage = function(){return this._page;};
		var setDirectory = function(directory){this._directory = directory;};
		var getDirectory = function(){return this._directory;};
		return{
			setPage : setPage,
			getPage : getPage,
			setDirectory : setDirectory,
			getDirectory : getDirectory,
			move : function(directory,page){
				setDirectory(directory);
				setPage(page);
				location.href = 
					app.context()+'/'+getDirectory()+'/'+getPage();
			},
			home : function() {location.href=app.context()+'/'}
		};
	})();

var util = (function(){
		return {
			isNumber : function(value) {
				  return typeof value === 'number' && isFinite(value)
				}
		};
})();
	
var nav = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){

	$('#nav ul').addClass('list_style_none').addClass('over_hidden').addClass('bg_color_black').css('margin','0').css('padding','0');
	$('#nav li').addClass('float_left').addClass('display_inline').css('border-right','1px').css('solid','#bbb');
	$('#nav li:last-child').addClass('border_right_none');
	$('#nav .active').addClass('bg_color_black');
	$('#nav li a').addClass('display_block').addClass('nav_color_white').addClass('text_center')
	.addClass('text_decoration_none').css('padding','14px','16px');
	$('#nav li a:hover:not').addClass('nav_color_aaa');
	
	};
	var onCreate = function(){
		setContentView();
	};
	return {
		init : init,
		setContentView : setContentView,
		onCreate : onCreate
	};
})();


	
	
	
	
	
	
	
	
	
	
	
	
	
