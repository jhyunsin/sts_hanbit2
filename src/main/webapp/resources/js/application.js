// var application = (function(){})(); IIfe 패턴

var app = (function(){
		var init = function(context) {
		session.init(context);
		nav.init();
		onCreate();
		user.init();
		member.init();
		admin.init();
		account.init();
		grade.init();
		};
		var context = function() {return session.getContextPath();}
		var js = function(){return session.getJavacriptPath('js');}
		var css = function(){return session.getCssPath('css');}
		var img = function(){return session.getImgPath('img');}
		var setContentView = function(){
			$('#header_brand').attr('src',app.img()+'/default/hanbit2.jpg').css('alt','Brand').css('width','150px').css('height','50px').addClass('cursor');
			$('#footer').addClass('bottom').addClass('footer');
			$('#global_content').addClass('box');
			$('#global_content a').addClass('cursor');
			$('#global_content_regist').text('SIGN UP').click(function(){member.pub_sign_up_form();});
			$('#global_content_login').text('LOG IN').click(function(){member.pub_login_form();});
			$('#global_content_admin').text('ADMIN MODE').click(function(){admin.check();});
		};
		var onCreate = function() {
			setContentView();
		$('#title').click(function() {controller.home();});
		$('#a_member').click(function() {controller.move('member','main');});
		$('#a_grade').click(function() {controller.move('grade','main');});
		$('#a_account').click(function() {controller.move('bank','main');});
		$('#abc').click(function() {controller.move('global','school_info');});
		$('#way').click(function() {controller.move('global','way');});
		$('#free_board_table .name').click(function(){alert('name');controller.moveWithKey('member','a_detail','lee');});
		$('#free_board_table .regist').click(function(){alert('regist');controller.moveWithKey('grade','regist','lee');});
		$('#free_board_table .update').click(function(){alert('regist');controller.moveWithKey('grade','update','lee');});
		$('#go_public_home').click(function(){controller.home();});
		$('#school_info').click(function(){controller.move('public','school_info');});
		$('#contact').click(function(){controller.move('public','contact');});
		$('#free_board').click(function(){controller.move('public','free_board');});
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
			 	$('#admin_content #member_mgmt').attr('src',app.img()+'/default/membermm.png').css('height','400px');
			 	$('#admin_content #grade_mgmt').attr('src',app.img()+'/default/grademm.png').css('height','400px');
			 	$('#admin_content #account_mgmt').attr('src',app.img()+'/default/bankmm.jpg').css('height','400px');
			 	$('#admin_content h3').addClass('text_center')
				$('#admin_nav').css('height','50px');
		 	};
		 var onCreate = function(){
			 setContentView();
			 $('#admin_nav #member_mgmt #list').click(function(){user.student_list(1);});
			 $('#admin_nav #member_mgmt #findBy').click(function(){controller.move('member','findBy');});
			 $('#admin_nav #member_mgmt #count').click(function(){controller.move('member','count');});
			 $('#admin_nav #account_mgmt #list').click(function(){controller.move('bank','list');});
			 $('#admin_nav #account_mgmt #open').click(function(){controller.move('bank','open');});
			 $('#admin_nav #account_mgmt #delete').click(function(){;controller.move('bank','delete');});
			 $('#admin_nav #account_mgmt #find').click(function(){controller.move('bank','find');});
			 $('#admin_nav #account_mgmt #count').click(function(){controller.move('bank','count');});
			 $('#admin_nav #grade_mgmt #list').click(function(){controller.move('grade','list');});
			 $('#admin_nav #grade_mgmt #regist').click(function(){controller.move('grade','regist');});
			 $('#admin_nav #grade_mgmt #update').click(function(){controller.move('grade','update');});
			 $('#admin_nav #grade_mgmt #delete').click(function(){controller.move('grade','delete');});
			 $('#admin_nav #grade_mgmt #count').click(function(){controller.move('grade','count');});
			 $('#admin_nav #grade_mgmt #find').click(function(){controller.move('grade','find');});
				$('#grade_mgmt #regist').click(function(){alert('등록을 위해 회원리스트로 이동합니다');controller.move('member','list');});
				$('#grade_mgmt #update').click(function(){alert('수정을 위해 회원리스트로 이동합니다');controller.move('member','list');});
				$('#account_mgmt #list').click(function(){controller.move('bank','list');});
				$('#account_mgmt #find').click(function(){controller.move('bank','find');});
				$('#account_mgmt #count').click(function(){controller.move('bank','count');});
				$('#account_list_table .name').click(function(){controller.moveWithKey('member', 'a_detail', 'hong');});
				$('#grade_list_table .name').click(function(){controller.moveWithKey('member', 'a_detail', 'hong');});
		 };
		 var _pass;
			var getPass = function(){return this._pass;};
			var setPass = function(pass){this._pass = pass;};
		 return {
			 init : init,
			 setContentView : setContentView,
			 onCreate : onCreate,
			 getPass : getPass,
		     setPass : setPass,
		     check : function(){
		    	controller.move('admin','main'); 
		     },
		     check2 : function(){
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
		     },
		     member_list : function(){
			    	location.href = app.context() + '/member/list/1';
			    }
		 };
		})();

	var user = (function(){
		 var key = $('#user_content_subject #major_subject_1 input[type="hidden"]').val();
		var init = function(){onCreate();}; //생성자
		var setContentView = function(){
			$('#bank_content_img_home').attr('src',app.img()+'/home.png').css('width','30px');
			 $('#user_header').css('height','50px');
			 $('.navbar-header').css('height','50px');
			 $('#user_content #rock_scissor_paper').addClass('cursor').click(function(){controller.move("member", "rock_scissor_paper");});	
				$('#user_content #lotto').addClass('cursor').click(function(){controller.move("member", "lotto");});
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
				 $('#user_header #logout').click(function(){controller.home();});
				 $("#user_header #account li:eq(0) a").click(function(){alert('계좌목록클릭');controller.move('bank', 'detail');}); 
				 $("#user_header #account li:eq(1) a").click(function(){controller.move('bank', 'open');});
				 $("#user_header #account li:eq(2) a").click(function(){controller.move('bank', 'transaction');}); 
				 $("#user_header #account li:eq(3) a").click(function(){controller.move('bank', 'delete');}); 
				 $("#user_header #grade li:eq(0) a").click(function(){alert('성적목록클릭');controller.move('grade', 'detail');}); 
				 $("#user_header #grade li:eq(1) a").click(function(){controller.move('grade', 'find');}); 
				 $('#user_header #a_mypage').click(function(){controller.move('member', 'content');});
				 $('#user_header #a_detail').click(function(){controller.move('member', 'detail');});
				 $('#user_header #a_update').click(function(){controller.move('member', 'update');});
				 $('#user_header #a_delete').click(function(){controller.move('member', 'delete');});
				 $('#go_user_home').click(function(){controller.move('member', 'content');});
				 $('#user_content #kaup').addClass('cursor').click(function(){controller.move("member", "kaup");});	
		 		 $('#user_content_subject #major_subject_1 input[type="button"]').click(function(){controller.moveWithKey('subject', 'detail', key);});
		 		 $('#user_content #major_subject_2').click(function(){});
				 $('#user_content #major_subject_3').click(function(){});
		
		}; 
		return{
		     init :init,  // 자바의 클래스 처럼 속성(은닉)과 기능으로 ..
		     student_list : function(pgNum){
		    	 $('#adm_header').empty().load(app.context()+'/admin/header');
				$('#adm_nav').empty().load(app.context()+'/admin/nav');
					$('#adm_article').empty();
					$.getJSON(app.context() + '/member/list/' + pgNum, function(data){
						var frame ='';
						var startPg = data.startPg;
						var lastPg = data.lastPg;
						var pgSize = data.pgSize;
						var totPg = data.totPg;
						var groupSize = data.groupSize;
						console.log('스타트 Page'+startPg);
						console.log('라스트 Page'+startPg);
						console.log('토탈페이지 Page'+totPg);
						console.log('그룹사이즈 Page'+groupSize);
					var student_list = '<div class ="box" style="padding-top: 0; width: 90%">'
						+'<section style="height: 150px">'
						+'<ul class="list-group">'
						+'<li class="list-group-item">총 학생수 : ' + data.totCount + '</li>'
						+'</ul>'
						+'<div class="panel panel-success">'
						+'<div class="panel-heading" style="font-size: 25px;color: black">학생 목록</div>'
						+'<table id="member_list_table">'
						+'<tr>'
						+'<th>ID</th>'
						+'<th>성명</th>'
						+'<th>등록일</th>'
						+'<th>SSN</th>'
						+'<th>이메일</th>'
						+'<th>전화번호</th>'
						+'<th>성적</th>'
						+'</tr>'
						+'<tbody>';
					if (data.count==0) {
						student_list+='<tr><td colpan=7>등록된 학생이 없습니다</td></tr>'
					} else {
						$.each(data.list,function(i,member){
							student_list +=
								'<tr>'
								+'<td>'+member.id+'</td>'
								+'<td><a class="name">'+member.name+'</a></td>'
								+'<td>'+member.regDate+'</td>'
								+'<td>'+member.ssn+'</td>'
								+'<td>'+member.email+'</td>'
								+'<td>'+member.phone+'</td>'
								+'<td><a class="regist">등록</a> / <a class="update">수정</a></td>'
								+'</tr>';
						});
					}
					student_list += '</tbody></table>';
						var pagination= 
						 '<nav aria-label="Page navigation">'
						+'<ul class="pagination">';
					//////
						if((startPg-lastPg) > 0){
							pagination += 
								'<li>'
								+'<a href="'+app.context()+'/member/list/'+(startPg-lastPg)+'" aria-label="Previous">'
								+'<span aria-hidden="true">&laquo;</span>'
								+'</a>'
								+'</li>';
						}
						for(var i=startPg; i<=lastPg; i++){
							if(i==pgNum){
								pagination +='<font color="red">'+i+'</font>';
							}else{
								pagination += '<a href="#" onclick="user.student_list('+i+')">'+i+'</a>';
							}
						}
						if(startPg + pgSize <= totPg){
							pagination += 
								'<li>'
								+'<a href="'+app.context()+'/member/list/'+(startPg-pgSize)+'" aria-label="Next">'
								+ '<span aria-hidden="true">&raquo;</span>'
								+'</a>'
								+'</li>';
						}
						pagination += '</ul></nav>'
						var search_form =
							'<div align="center">'
							+'<form action="'+app.context()+'/member/search" method="post">'
							+'<select name="keyField" id="keyField">'
							+'<option value="name" selected>이름</option>'
							+'<option value="mem_id">ID</option>'
							+'</select>'
							+'<input type="text" name="keyword">'
							+'<input type="submit" value="검색">'
							+'</form>'
							+'</div>'
							+'</div>'
							+'</div>'
							+'</section></div>';
					///////	
					frame += student_list;
					frame += pagination;
					frame += search_form;
						$('#adm_article').html(frame);
						$('#find_submit').click(function(){
							if ($('#keyword').val().length>0) {
								user.find_student($('#keyword').val());
							} else {
								alert('검색어를 입력해주세요');
								$('#keyword').focus();
								return false;
							}
						});
					});
		     },
		     find_student : function(keyword){
		    	 alert('검색어'+keyword);
		     }
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
			$('#account_list_table .name').click(function(){alert('name');controller.moveWithKey('account','a_detail','lee');});
			$('#account_list_table .regist').click(function(){alert('regist');controller.moveWithKey('account','regist','lee');});
			$('#account_list_table .update').click(function(){alert('regist');controller.moveWithKey('account','update','lee');});
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
			$('#member_regist #check_dup').addClass('btn').addClass('btn-danger');////////////
				//
			$('#member_regist_form').addClass('form-horizontal');
			$('#member_regist_form > div').addClass('form-group').addClass('form-group-lg');
			$('#member_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
			$('#member_regist_form > div > div').addClass('col-sm-10');
			$('#member_regist_form > div > div > input').addClass('form-control');

			$('#member_regist #rd_major > label:gt(0)').addClass('radio-inline');
			$('#member_regist #ck_subject').addClass('checkbox');
			$('#member_regist #ck_subject > label').addClass('checkbox-inline');
			$('#member_find_form').attr('action',sessionStorage.getItem('context')+'/member/search');
			$('#member_find_form input[type="hidden"]').attr('name','context').attr('value',app.context());
			$('#member_login_form').attr('method','post').attr('action',sessionStorage.getItem('context')+'/member/login');
			$('#member_login_form input[type=hidden]').attr('value',app.context());
		};
		var onCreate = function(){
			setContentView();	
			$('#regist').click(function(){controller.move('member','regist')});
			$('#detail').click(function(){controller.move('member','detail')});
			$('#update').click(function(){controller.move('member','update');});
			$('#delete').click(function(){controller.move('member','delete');});
			$('#login').click(function(){controller.move('member','login');});
			$('#logout').click(function(){controller.move('member','logout');});
//			$('#list').click(function(){controller.move('member','list');});
			$('#findBy').click(function(){controller.move('member','findBy');});
			$('#count').click(function(){controller.move('member','count');});
			$('#member_find_form input[type="submit"]').click(function(){$('#member_find_form').submit();});
			$('#member_list_table .name').click(function(){alert('name');controller.moveWithKey('member','a_detail','lee');});
			$('#member_list_table .regist').click(function(){alert('regist');controller.moveWithKey('grade','regist','lee');});
			$('#member_list_table .update').click(function(){alert('regist');controller.moveWithKey('grade','update','lee');});
			$('#member_login_form input[type=submit]').click(function() {$('#member_login_form').submit();});
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
				var setName = document.querySelector('#name').val();
				var ssn = document.querySelector('#ssn').val();
				var result = '';
				var now = new Date().getFullYear();
				console.log("now    "+now);
				var gender = parseInt(ssn.substring(7,8));
				var ageTemp = parseInt(ssn.substring(0,2));
				console.log("ageTemp    "+ageTemp);
				switch (gender) {
				case 1: case 5: setGender("남"); setAge(now-(1900+ageTemp));console.log("1900+ageTemp "+(1900+ageTemp));break;
				case 3: case 7:setGender("남"); setAge(now-(2000+ageTemp));break;
				case 2: case 6:setGender("여");setAge(now-(1900+ageTemp));console.log("1900+ageTemp "+(1900+ageTemp));break;
				case 4: case 8:setGender("여");setAge(now-(2000+ageTemp));break;
				default:setGender = "잘못된값을 입력하셨습니다";}
				document.querySelector('#result_name').innerHTML=getName();
				document.querySelector('#result_age').innerHTML=getAge();
				document.querySelector('#result_gender').innerHTML=getGender();
				// 인스턴스 변수 선언하고 게터 세터 하고 끌고 오는 방식하고 똑같다
			},
			pub_login_form : function(){
			
				$('#pub_article').html(LOGIN_FORM);
				$('#login_btn').click(function(e){
					e.preventDefault();
					$.ajax({
						url : app.context()+'/member/login',
						type : 'POST',
						data : {'id':$('#id').val(),'pw':$('#pw').val()},
						dataType : 'json',
						success : function(data){
							if (data.id==='NONE') {
								alert('잘못된 정보입니다');	
							} else {
								alert('사랑합니다 '+data.name+'님');
							
							$('#pub_header').empty().load(app.context()+'/member/logined/header');
							$('#pub_article').html(STUDENT_MAIN);
							//// .on은 다중적인 이벤트를 발생시킬때 쓴당
							}
						},
						error : function(xhr,status,msg){
							alert('로그인실패이유'+msg);
						}
					});
				});
			},
			pub_sign_up_form : function() {
				$('#pub_article').empty().append(SIGN_UP_FORM);
				member.init();
				$('#check_dup').click(function(e){
					e.preventDefault();
					if (util.pwChecker($('#id').val())==='yes') {
						$.ajax({
							url : app.context()+'/member/check_dup/'+$('#id').val(),
							success : function(data){
								alert('중복체크결과'+data.message)
								if (data.flag==='TRUE') {
									$('#id_box').html('<input type="text" id="id" placeholder="'+data.message+'"><input type="button" id="re_check" name="re_check" value="다시조회"/>');
									member.init();
								} else {
									$('#id_box').html('<input type="text" id="id" value="'+data.temp+'"><input type="button" id="use_input_id" name="use_input_id" value="그대로사용"/>');
									member.init();
									var use_id = data.temp;
									var password = $('#password').val();
									$('#bt_join').click(function(e){
										alert('조인33');
										e.preventDefault();
										alert('조인');
										var join_info = {
										'name': $('#username').val(),
										'id' : $('#id').val(),
										'pw' : $('#password').val(),
										'ssn' : $('#ssn').val(),
										'email' : $('#email').val(),
										'phone' : $('#phone').val()
										};
										//$('#radio').val()
										//$('#ck_subject').val()
										$.ajax({
											url : app.context()+'/member/signup',
											type : 'post',
											contentType : 'application/json',
											data : JSON.stringify(join_info),
											dataType : 'json',
											success : function(data){
												alert('결과 : '+data.message);
												if (data.message==='success') {
													alert('success');
													member.pub_login_form();
													
												} else {
													alert('회원가입시 알수없는 에러가 발생했습니다');
												}
											},
											error : function(xhr,status,msg){
												alert('회원가입 시 에러발생'+msg); 
											}
										});
									});
								}
								},
							error : function(x,s,e){
								alert('id 중복체크에러')
								}
						});
					} else {
						alert('정규식에 맞지 않음');
						$('#id').val('').focus();
											}
				
				});
				 $(function() {
			            $('#password').keyup(function() {
			               $('font[name=check]').text('');
			            });
			            $('#chpass').keyup(function() {
			               if($('#password').val()!=$('#chpass').val()){
			                  $('#id_font').text('');
			                  $('#id_font').html('<font name="check"size="2"color="red">비밀번호가 일치하지않습니다');
			               }else{
			                  $('#id_font').text('');
			                  $('#id_font').html('<font name="check"size="2"color="green">비밀번호가 일치합니다');
			               }
			            });
			         
			      });
			      },
			      detail : function(){
			    	  $('#pub_header').empty().load(app.context()+'/member/logined/header');			    	  
			    	  $('#pub_article').html(DETAIL_FORM);			    	  
				    	  $.getJSON(app.context()+'/member/detail',function(data){
								  $('#member_detail #img').attr('src',app.img()+'/member/'+data.profileImg);
						    	  $('#member_detail #id').text(data.id);
						    	  $('#member_detail #name').text(data.name);
						    	  $('#member_detail #gender').text(data.gender);
						    	  $('#member_detail #u_email').text(data.email);
						    	  $('#member_detail #major').text('전공');
						    	  $('#member_detail #subject').text('과목');
						    	  $('#member_detail #birth').text('생일');
						    	  $('#member_detail #reg_date').text(data.regDate);
						    	  $('#go_update').click(function(){
							    	 alert('업데이트진입2');
						    		  $('#member_detail #u_pw').html('<input type="text" id="pw" value="'+data.pw+'">');
							    	  $('#member_detail #u_email').html('<input type="text" id="email" value="'+data.email+'">');
							    	//$('#member_detail #u_major').text('<input type="text" id="email" value="'+data.email+'">');
							    	//$('#member_detail #u_subject').text('<input type="text" id="email" value="'+data.email+'">');
						    	  $('#bt_box').html('<input type="button" value="확인" id="confirm" /><input type="button" value="취소" id="cancel" />');
						    	  $('#confirm').click(function(){
						    		  alert('확인버튼진입2');
						    		  alert('변경 id : '+$('#member_detail #id').html());
					    			  alert('변경 pw : '+$('#pw').val());
					    			  alert('변경 이메일 : '+$('#email').val());
						    		  var confirm_info = {
											'id': $('#member_detail #id').html(),
						    				  'pw' : $('#pw').val(),
						    				  'email' : $('#email').val()
												};
						    		  
						    		  $.ajax({
						    		  url : app.context()+'/member/update',
						    		  type : 'post',
						    		  contentType : 'application/json',
						    		  data : JSON.stringify(confirm_info),
						    		  dataType : 'json',
						    		  async : false,
						    		  success : function(data){
						    			  
						    			  if (data.message==='success') {
											member.detail();
										} else {
											alert('서버다녀왔는데실패함');
										}  
						    		  },
						    		  error : function(x,s,m){
						    			  alert('업데이트에러'+m);
						    		  }
						    		  
						    		  
						    		  });
						    	  });
						    	  });
						    	  $('#go_unregist').click(function(){
						    		  $('#pub_article').html(UNREGIST_FORM);
						    	 $('#unregist_bt').click(function(e){
						    		 e.preventDefault();
						    		alert('탈퇴버튼');
						    		 $.ajax({							
							    			url : app.context()+'/member/unregist',
							    		  	type : 'post',
							    		  	data : {'pw':$('#unregist_pw').val()},
							    		  	dataType : 'json',
							    		  	success : function(data){
							    		  		alert('비번비교');
							    		  		if (data.message==='fail') {
							    		  		  $('#pub_header').empty().load(app.context()+'/member/logined/header');	
							    		  			$('#pub_article').html(UNREGIST_FORM);
												} else {
													location.href = app.context()+'/';
												}
							    		  	},
							    			error : function(xhr,status,msg){
												alert('회원탈퇴 시 에러발생'+msg); 
											}
							    		  });
									});
						    	  
						    	  });
				    	  });
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
			$('#a_regist').click(function() {location.href = "${context}/grade.do?page=regist";});
			$('#a_update').click(function() {location.href = "${context}/grade.do?page=update";});
			$('#a_delete').click(function() {location.href = "${context}/grade.do?page=delete";});
			$('#a_list').click(function() {location.href = "${context}/grade.do?page=list";});
			$('#a_count').click(function() {location.href = "${context}/grade.do?page=count";});
			$('#a_search').click(function() {location.href = "${context}/grade.do?page=search";});
			$('#grade_list_table .name').click(function(){alert('name');controller.moveWithKey('member','a_detail','lee');});
			$('#grade_list_table .regist').click(function(){alert('regist');controller.moveWithKey('grade','regist','lee');});
			$('#grade_list_table .update').click(function(){alert('regist');controller.moveWithKey('grade','update','lee');});
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
		var _page,_directory,key;
		var setPage = function(page){this._page = page;};
		var setKey = function(key){this._key = key;};
		var getPage = function(){return this._page;};
		var getKey = function(){return this._key;};
		var setDirectory = function(directory){this._directory = directory;};
		var getDirectory = function(){return this._directory;};
		
		return{
			setPage : setPage,
			getPage : getPage,
			setDirectory : setDirectory,
			getDirectory : getDirectory,
			setKey : setKey,
			getKey : getKey,
			moveWithKey : function(directory,page,key){
				setDirectory(directory);
				setPage(page);
				setKey(key);
				location.href = 
					app.context()+'/'+getDirectory()+'/'+getPage()+'?key='+getKey();
			},
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
				},
			pwChecker : function(value) {
				var pw_regex = /^.*(?=.{3,10})(?=.*[a-zA-Z0-9]).*$/;
				return pw_regex.test(value)?"yes":"no";
			}	
		};
})();
var LOGIN_FORM = ' <div class="box">'
	 +' <form id="member_login_form" class="form-signin">'
	 +'<h2 class="form-signin-heading">Please sign in</h2>'
	 +' <label for="inputEmail" class="sr-only">USER ID</label>'
	 +' <input id="id" type="text" name="id" class="form-control" placeholder="User ID" required autofocus>'
	 +'<label for="inputPassword" class="sr-only">Password</label>'
	 +'   <input id="pw" type="password" name="pw" id="inputPassword" class="form-control" placeholder="Password" required>'
	 +' <input type="hidden" name="context">'
	 +'  <div class="checkbox">'
	 +' <label><input type="checkbox" name="remember_me" value="remember-me"> Remember me</label>'
	 +'</div> <input id="login_btn" class="btn btn-lg btn-primary btn-block" type="submit" value="Sign in"/> </form></div>';

var SIGN_UP_FORM = 
		   '<section id="member_regist">'
		  +'<form  id="member_regist_form">'
 		  +'<div><label for="exampleInputEmail1">이름</label>'
		  +'<div><input type="text" class="form-control" id="username" placeholder="NAME"></div></div>'
		  +'<div ><label for="exampleInputEmail1">ID</label>'
		  +'<div id="id_box"><input type="text" id="id" placeholder="문자 혹은 숫자로 4~10자 입력가능"><input type="button" id="check_dup" name="check_dup" value="중복체크"/></div></div>'
		  +'<div><label for="exampleInputPassword1">비밀번호</label><div><input type="password" id="password" placeholder="PASSWORD"></div></div>'
		  +'<div><label for="exampleInputPassword1">비밀번호확인</label><div><input type="password" id="chpass" placeholder="chpass"size="10"/></div><div id="id_font"><font name="check"size="2"color="red"></font></div></div>'
		  +'<div><label for="exampleInputEmail1">SSN</label>'
		  +'<div><input type="text" id="ssn" placeholder="ex)800101-2"></div></div>'
		  +'<div><label for="exampleInputEmail1">EMAIL</label>'
		  +'<div><input type="text" id="email" placeholder="EMAIL"></div></div>'
		  +'<div ><label for="exampleInputEmail1">PHONE</label>'
		  +'<div><input type="text" id="phone" placeholder="PHONE"></div></div>'
		  +'<div id="rd_major">'
		  +'<label for="exampleInputEmail1">전공</label><br />' 
		  +'<div>'
		  +'<label> <input type="radio" name="major" value="computer">컴공학부</label>' 
		  +'<label> <input type="radio" name="major" value="mgmt">경영학부</label>' 
		  +'<label> <input type="radio" name="major" value="math">수학부</label>' 
		  +'<label> <input type="radio" name="major" value="eng">영문학부</label>'
		  +'</div>'
		  +'</div>'
		  +'<div>'
		  +'<label for="exampleInputEmail1">수강과목</label><br/>'
		  +'<div>'
		  +'<div id="ck_subject" >'
		  +'<label> <input type="checkbox" name="subject" value="java"> JAVA</label>' 
		  +'<label> <input type="checkbox" name="subject" value="sql">SQL</label>' 
		  +'<label> <input type="checkbox" name="subject" value="cpp">C++</label>' 
		  +'<label> <input type="checkbox" name="subject" value="python">파이썬</label>'
		  +'<label> <input type="checkbox" name="subject" value="cpp">델파이</label>' 
		  +'<label> <input type="checkbox" name="subject" value="html">HTML</label> '
		  +'</div>'
		  +'</div>'
		  +'</div>'
		  +'<br /><br />'
		  +'<input id="bt_join" type="submit"  value="회원가입"/>'
		  +'<input id="bt_cancel" type="reset"  value="취소"/>'
		  +'<br /><br /><br />'
		  +'<p><a id="member_content_a_home" ><img id="member_content_img_home"/></a></p>'
		  +'</form>'
		  +'</section>';

var STUDENT_MAIN = 
	'<section id="user_content_service" class="box section-padded">'
		+'<div>'
		+'<div class="row text-center title">'
		+'<h2>Services</h2>'
		+'<h4 class="light muted">Achieve the best results with our wide variety of training options!</h4>'
		+'</div>'
		+'<div class="row services">'
		+'<div class="col-md-4">'
		+'<div id="kaup" class="service">'
		+'<div class="icon-holder">'
		+'<img src="'+app.img()+'/icons/guru-blue.png" alt="" class="icon">'
		+'</div>'
		+'<h4 class="heading">KAUP INDEX</h4>'
		+'<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>'
		+'</div>'
		+'</div>'
		+'<div class="col-md-4">'
		+'<div id="rock_scissor_paper" class="service">'
		+'<div class="icon-holder">'
		+'<img src="'+app.img()+'/icons/heart-blue.png" alt="" class="icon">'
		+'</div>'
		+'<h4 class="heading">ROCK SCISSOR PAPER</h4>'
		+'<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>'
		+'</div>'
		+'</div>'
		+'<div class="col-md-4">'
		+'<div id="lotto" class="service">'
		+'<div class="icon-holder">'
		+'<img src="'+app.img()+'/icons/weight-blue.png" alt="" class="icon">'
		+'</div>'
		+'<h4 class="heading">LOTTO DRAWING</h4>'
		+'<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>'
		+'</div>'
		+'</div>'
		+'</div>'
		+'</div>'
		+'<div class="cut cut-bottom"></div>'
		+'</section>'
		+'<section id="user_content_subject" class="section gray-bg">'
		+'<div class="container">'
		+'<div class="row title text-center">'
		+'<h2 class="margin-top">Major Subject</h2>'
		+'<h4 class="light muted">TOP 3</h4>'
		+'</div>'
		+'<div class="row">'
		+'<div class="col-md-4">'
		+'<div id="major_subject_1" class="team text-center">'
		+'<div class="cover" style="background:url('+app.img()+'/team/java-cover.jpg); background-size:cover;">'
		+'<div class="overlay text-center">'
		+'<h3 class="white">Java </h3>'
		+'<h5 class="light light-white">1 - 5 sessions / month</h5>'
		+'</div>'
		+'</div>'
		+'<img src="'+app.img()+'/team/java.jpg" alt="Java Image" class="avatar" style="width: 120px" height="120px">'
		+'<div class="title">'
		+'<h4>JAVA</h4>'
		+'<h5 class="muted regular">Server Program Language</h5>'
		+'</div>'
		+'<input type="hidden" name="major_subject_1" value="java"/>'
		+'<input type="button" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill" value="과목 정보"/>'
		+'</div>'
		+'</div>'
		+'<div class="col-md-4">'
		+'<div id="major_subject_2" class="team text-center">'
		+'<div class="cover" style="background:url('+app.img()+'/team/javascript-cover.jpg); background-size:cover;">'
		+'<div class="overlay text-center">'
		+'<h3 class="white">Javascript</h3>'
		+'<h5 class="light light-white">1 - 5 sessions / month</h5>'
		+'</div>'
		+'</div>'
		+'<img src="'+app.img()+'/team/javascript.jpg" alt="Javascript Image" class="avatar" style="width: 120px" height="120px">'
		+'<div class="title">'
		+'<h4>Javascript</h4>'
		+'<h5 class="muted regular">UI Program Language</h5>'
		+'</div>'
		+'<input type="hidden" name="major_subject_2"/>'
		+'<input type="button" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill" value="과목 정보"/>'
		+'</div>'
		+'</div>'
		+'<div class="col-md-4">'
		+'<div id="major_subject_3" class="team text-center">'
		+'<div class="cover" style="background:url('+app.img()+'/team/sql-cover.jpg); background-size:cover;">'
		+'<div class="overlay text-center">'
		+'<h3 class="white">SQL</h3>'
		+'<h5 class="light light-white">1 - 5 sessions / month</h5>'
		+'</div>'
		+'</div>'
		+'<img src="'+app.img()+'/team/sql.jpg" alt="SQL Image" class="avatar" style="width: 120px" height="120px">'
		+'<div class="title">'
		+'<h4>SQL</h4>'
		+'<h5 class="muted regular">Database Management Language</h5>'
		+'</div>'
		+'<input type="hidden" name="major_subject_3"/>'
		+'<input type="button" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill" value="과목 정보"/>'
		+'</div>'
		+'</div>'
		+'</div>'
		+'</div>'
		+'</section>';
//var STUDENT_LIST_TH = 
//	'<div class ="box" style="padding-top: 0; width: 90%">'
//	+'<section style="height: 150px">'
//	+'<ul class="list-group">'
//	+'<li class="list-group-item">총 학생수는??? : ${totCount}</li>'
//	+'</ul>'
//	+'<div class="panel panel-success">'
//	+'<div class="panel-heading" style="font-size: 25px;color: black">학생 목록</div>'
//	+'<table id="member_list_table">'
//	+'<tr>'
//	+'<th>ID</th>'
//	+'<th>성명</th>'
//	+'<th>등록일</th>'
//	+'<th>SSN</th>'
//	+'<th>이메일</th>'
//	+'<th>전화번호</th>'
//	+'<th>성적</th>'
//	+'</tr>'
//	+'<tbody>';
//var STUDENT_LIST_ROW = 
////	+'<c:forEach items="${list}" var="member">'
//	 '<tr>'
//	+'<td>${member.id}</td>'
//	+'<td><a class="name">${member.name}</a></td>'
//	+'<td>${member.regDate}</td>'
//	+'<td>${member.ssn}</td>'
//	+'<td>${member.email}</td>'
//	+'<td>${member.phone}</td>'
//	+'<td><a class="regist">등록</a> / <a class="update">수정</a></td>'
//	+'</tr>';
////	+'		  </c:forEach>'
//var STUDENT_LIST_END = 
//	 '</tbody>'
//	+'</table>';
//var aaaaa = 
//	'<nav aria-label="Page navigation">'
//	+'<ul class="pagination">'
//	+'<c:if test="${startPg - pgSize gt 0}">'
//	+'<li>'
//	+'<a href="${context}/member/list/${startPg-pgSize}" aria-label="Previous">'
//	+'<span aria-hidden="true">&laquo;</span>'
//	+'</a>'
//	+'</li>'
//	+'</c:if>'
//	+'<c:forEach begin="${startPg}" end="${lastPg}" step="1" varStatus="i">'
//	+'<c:choose>'
//	+'<c:when test="${i.index == pgNum}">'
//	+'<font color="red">${i.index}</font>'
//	+'</c:when>' 					
//	+'<c:otherwise>'
//	+'<a href="${context}/member/list/${i.index}">${i.index}</a>'
//	+'</c:otherwise>'
//	+'</c:choose>'
//	+'</c:forEach>'
//	+'<c:if test="${startPg + pgSize le totPg}">'
//	+'<li>'
//	+'<a href="${context}/member/list/${startPg-pgSize}" aria-label="Next">'
//	+'<span aria-hidden="true">&raquo;</span>'
//	+'</a>'
//	+'</li>'
//	+'</c:if>'
//	+'</ul>'
//	+'</nav>'
//	+'<div align="center">'
//	+'<form action="${context}/member/search" method="post">'
//	+'<select name="keyField" id="">'
//	+'<option value="name" selected>이름</option>'
//	+'<option value="mem_id">ID</option>'
//	+'</select>'
//	+'<input type="text" name="keyword"/>'
//	+'<input type="submit" name="검색"/>'
//	+'</form>'
//	+'</div>'
//	+'</div>'
//	+'</section>'
//	+'</div>';	
var DETAIL_FORM =
		'<div class="box">'
		+'<h1>회원상세정보</h1>'
		+'<table id="member_detail" class="table">'
		+'<tr>'
		+'<td rowspan="5" style="width:30%">'
		+'<img id="img" alt="proImg" width="104"'
		+'height="142"></td>'
		+'<td style="width:20%" class="font_bold bg_color_yellow">ID</td>'
		+'<td id="id" style="width:40%"></td><tr>'
		+'<td class="font_bold bg_color_yellow">이 름</td>'
		+'<td id="name"></td></tr><tr>'
		+'<td class="font_bold bg_color_yellow">비번</td>'
		+'<td id="u_pw"></td></tr><tr>'
		+'<td class="font_bold bg_color_yellow">성 별</td>'
		+'<td id="gender"></td></tr><tr>'
		+'<td class="font_bold bg_color_yellow">이메일</td>'
		+'<td id="u_email"></td>'
		+'</tr>'
		+'<tr>'
		+'<td class="font_bold bg_color_yellow">전공과목</td>'
		+'<td id="u_major" colspan="2"></td>'
		+'</tr>'
		+'<tr>'
		+'<td class="font_bold bg_color_yellow">수강과목</td>'
		+'<td id="u_subject" colspan="2"></td>'
		+'</tr>'
		+'<tr>'
		+'<td class="font_bold bg_color_yellow">생년월일</td>'
		+'<td id="birth" colspan="2"></td>'
		+'</tr>'
		+'<tr>'
		+'<td class="font_bold bg_color_yellow">등록일</td>'
		+'<td id="reg_date" colspan="2"></td>'
		+'</tr>'
		+'</table>'
		+'<br /><div id="bt_box">'
		+'<input type="button" value="정보수정하러가기" id="go_update" />'
		+'<input type="button" value="회원탈퇴" id="go_unregist" />'
		+'</div>';
		+'</div>';
		
//	var UPDATE_FORM = 
//		'<div class="box">'
//		+'<h1>회원상세정보</h1>'
//		+'<table id="member_detail" class="table">'
//		+'<tr><td rowspan="5" style="width:30%">'
//		+'<img src="${img}/default/home.png" alt="proImg" width="104"'
//		+'height="142"></td>'
//		+'<td style="width:20%" class="font_bold">ID</td>'
//		+'<td style="width:40%">${member.id}</td></tr><tr>'
//		+'<td class="font_bold">이 름</td>'
//		+'<td>${member.name}</td></tr><tr>'
//		+'<td class="font_bold">성 별</td>'
//		+'<td>남자</td></tr><tr>'
//		+'<td class="font_bold">이메일</td>'
//		+'<td colspan="2">${member.email}</td></tr><tr>'
//		+'<td class="font_bold">전공과목</td>'
//		+'<td colspan="2"></td></tr><tr>'
//		+'<td class="font_bold">수강과목</td>'
//		+'<td colspan="2"></td></tr><tr>'
//		+'<td class="font_bold">생년월일</td>'
//		+'<td colspan="2"></td></tr><tr>'
//		+'<td class="font_bold">등록일</td>'
//		+'<td colspan="2"></td></tr></table><br /></div>';
		
	var UNREGIST_FORM = 
		'<div class="box">'
		+'<h3>탈퇴하려면 비밀번호를 입력해주세요</h3>'
		+'<div style="padding: 20px"></div>'
		+'<form id="member_delete_form" class="navbar-form navbar-center" role="search">'
		+'<embed style="width: 50px; height: 50px" src="'+app.img()+'/default/star.gif"></br>'
		+'<div class="form-group">'
		+'<input id="unregist_pw" type="text" class="form-control" placeholder="PASSWORD"></div>'
		+'<input id="unregist_bt" type="submit" class="btn btn-default" value="탈퇴"/></form></div>';
		
		
var nav = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
	$('#nav ul').addClass('list_style_none').addClass('over_hidden').addClass('bg_color_blue').css('margin','0').css('padding','0');
	$('#nav li').addClass('float_left').addClass('display_inline').css('border-right','1px').css('solid','#bbb');
	$('#nav li:last-child').addClass('border_right_none');
	$('#nav .active').addClass('bg_color_black');
	$('#nav li a').addClass('display_block').addClass('nav_color_white').addClass('text_center').addClass('text_decoration_none').css('padding','14px','16px');
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

//=======멤버

	
	
	
	
	
	
	
	
	
	
	
	
	
