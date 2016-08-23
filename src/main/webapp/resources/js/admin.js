var admin = (function(){
		var _pass;
		var	setPass = function(pass){this._pass = pass;};
		var	getPass = function(){return this._pass;};
		return{
			setPass : setPass,
			getPass : getPass,
			init : function(){
				document.querySelector('#a_admin').addEventListener('click', this.check, false);
			},
			
			check: function() {
				setPass(1);
				var context = sessionStorage.getItem('context')+'/global.do';
				var isAdmin = window.confirm('관리자입니까?'); //confirm은 내장객체
				if (!isAdmin) {
					alert('관리자만 접근 가능합니다');
				}else{
					var password = window.prompt('관리자 비번을 입력바랍니다');
					if (password == getPass()) {
						location.href = context;
					}else{
						alert('관리자비번이 틀립니다')
					}
				}
			}
		
		
		};

})();
