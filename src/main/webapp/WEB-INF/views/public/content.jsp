<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box" style="width:1000px;padding-top:0">
<jsp:include page="slider.jsp"/>
<section id="global_content">
	<a id="global_content_regist"></a> <br /><br /> 
	<a id="global_content_login"></a> <br /> <br />
	<a id="global_content_admin"></a><br /> <br /> <br />
	
</section>
</div>
<script>
$(function() {
	$('#text').click(function(){controller.move('public','slider')});
});
</script>