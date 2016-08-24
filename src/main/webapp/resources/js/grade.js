var grade = (function(){
	return {
		init : function(){
			
			$('#g_regist').click(function(){location.href=app.context()+"/grade/regist"});
			$('#g_update').click(function(){location.href=app.context()+"/grade/update"});
			$('#g_delete').click(function(){location.href=app.context()+"/grade/delete"});
			$('#g_list').click(function(){location.href=app.context()+"/grade/list"});
			$('#g_count').click(function(){location.href=app.context()+"/grade/count"});
			$('#g_search').click(function(){location.href=app.context()+"/grade/search"});
			$('#grade_content_img_home').attr('src',app.img()+'/home.png').css('width','30px');
			$('#grade_content_a_home').click(function(){location.href=app.context()+"/"});
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
		}
	};
})();