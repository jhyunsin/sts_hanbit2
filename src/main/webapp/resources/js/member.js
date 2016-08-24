var member = (function(){
	return {
		init : function(){
			
			$('#regist').click(function(){location.href=app.context()+"/member/regist"});
			$('#detail').click(function(){location.href=app.context()+"/member/detail"});
			$('#update').click(function(){location.href=app.context()+"/member/update"});
			$('#delete').click(function(){location.href=app.context()+"/member/delete"});
			$('#login').click(function(){location.href=app.context()+"/member/login"});
			$('#logout').click(function(){location.href=app.context()+"/member/logout"});
			$('#list').click(function(){location.href=app.context()+"/member/list"});
			$('#findBy').click(function(){location.href=app.context()+"/member/findBy"});
			$('#count').click(function(){location.href=app.context()+"/member/count"});
			$('#member_content_img_home').attr('alt','home').attr('src',app.img()+'/home.png').css('width','30px');
			$('#member_content_a_home').click(function(){location.href=app.context()+"/"});
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
			
		}
	};
})();