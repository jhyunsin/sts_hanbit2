// var application = (function(){})(); iife 패턴
	var app = (function(){
		var init = function(context) {
		sessionStorage.setItem('context',context);
		sessionStorage.setItem('js',context+'/resources/js');
		sessionStorage.setItem('css',context+'/resources/css');
		sessionStorage.setItem('img',context+'/resources/img');
		move();
		$('#global_content').addClass('box');
		$('#global_content a').addClass('cursor');
		$('#global_content h2').text('서비스 이용을 위해 회원가입해 주세요!');
		
		$('#global_content_regist').text('SIGN UP')
		.click(function(){location.href=app.context()+"/member/regist"});
		$('#global_content_login').text('LOG IN').click(function(){location.href=app.context()+"/member/login"});
		$('#global_content_admin').text('ADMIN MODE')
		.click(function(){admin.check();});
		
		};
		
		var context = function() {
			return sessionStorage.getItem('context');
		}
		var js = function() {
			return sessionStorage.getItem('js');
		}
		var css = function() {
			return sessionStorage.getItem('css');
		}
		var img = function() {
			return sessionStorage.getItem('img');
		}
		
		var to_douglas = function() {
			location.href=context()+"/douglas.do";
		};
		var move = function() {
				$('#title').click(function() {
			location.href = context() + "/";

		});
		$('#a_member').click(function() {
			location.href = context() + "/member/main";
		});

		$('#a_grade').click(function() {
			location.href = context() + "/grade/main";
		});

		$('#a_account').click(function() {
			location.href = context() + "/bank/main";
		});
		
		$('#abc').click(function() {
			location.href = context() + "/school_info";
		});
				
				
		}
		return{ 
			init : init,
			context : context,
			to_douglas : to_douglas,
			move : move,
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
		 return {
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
		        location.href = app.context()
		        + '/global.do';
		       } else {
		        alert('관리자 비번이 틀립니다.');
		       }
		      }
		     }
		 };
		})();

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
