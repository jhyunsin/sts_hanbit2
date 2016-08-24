var account = (function(){
	return {
		init : function(){
			
			$('#b_regist').click(function(){location.href=app.context()+"/bank/regist"});
			$('#b_deposit').click(function(){location.href=app.context()+"/bank/deposit"});
			$('#b_withdraw').click(function(){location.href=app.context()+"/bank/withdraw"});
			$('#b_update').click(function(){location.href=app.context()+"/bank/update"});
			$('#b_delete').click(function(){location.href=app.context()+"/bank/delete"});
			$('#b_list').click(function(){location.href=app.context()+"/bank/list"});
			$('#b_search').click(function(){location.href=app.context()+"/bank/search"});
			$('#b_count').click(function(){location.href=app.context()+"/bank/count"});
			$('#bank_content_img_home').attr('src',app.img()+'/home.png').css('width','30px');
			$('#bank_content_a_home').click(function(){location.href=app.context()+"/"});
			$('#bank_content').addClass('box').css('font-size' ,'20px');
			$('#bank_content > article').css('width','300px')
			.addClass('center').addClass('text_left');
			$('#bank_content > article').css('font-size' ,'17px').addClass('cursor');
			
			$('#bank_content > h1').text('BANK MGMT');
			$('#bank_content_ol > li > a').addClass('remove_underline');
			$('#bank_content_ol > li:first > a').text('개설');
			$('#bank_content_ol > li:nth(1) > a').text('입금');
			$('#bank_content_ol > li:nth(2) > a').text('출금');
			$('#bank_content_ol > li:nth(3) > a').text('비번수정');
			$('#bank_content_ol > li:nth(4) > a').text('해지');
			$('#bank_content_ol > li:nth(5) > a').text('목록');
			$('#bank_content_ol > li:nth(6) > a').text('조회(이름)');
			$('#bank_content_ol > li:nth(7) > a').text('통장수');
		
		}
	};
})();