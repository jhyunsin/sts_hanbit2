<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul id="admin_nav" class="nav nav-tabs">
   <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      회원 <span class="caret"></span>
    </a>
    <ul id="member_mgmt" class="dropdown-menu">
		<li><a id="list" ><span style="cursor:pointer;">목 록</span></a></li>
		<li><a id="findBy" ><span style="cursor:pointer;">검 색</span></a></li>
		<li><a id="count" ><span style="cursor:pointer;">회원수</span></a></li>
    </ul>
  </li>
   <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      성적 <span class="caret"></span>
    </a>
    <ul id="grade_mgmt" class="dropdown-menu">
    	<li><a id="regist"><span style="cursor:pointer;">등 록</span></a></li>
		<li><a id="update"><span style="cursor:pointer;">수 정</span></a></li>
	  	<li><a id="list"><span style="cursor:pointer;">목 록</span></a></li>
    </ul>
  </li>
   <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      계좌 <span class="caret"></span>
    </a>
    <ul id="account_mgmt" class="dropdown-menu">
		<li><a id="list"><span style="cursor:pointer;">목 록</span></a></li>
		<li><a id="find"><span style="cursor:pointer;">조회</span></a></li>
		<li><a id="count"><span style="cursor:pointer;">통장수</span></a></li>
    </ul>
  </li>
</ul>
<script type="text/javascript">
$(function(){
	$('#grade_mgmt #regist').click(function(){alert('등록을 위해 회원리스트로 이동합니다');controller.move('member','list');});
	$('#grade_mgmt #update').click(function(){alert('수정을 위해 회원리스트로 이동합니다');controller.move('member','list');});
	$('#admin_nav').css('height','50px');
	$('#account_mgmt #list').click(function(){controller.move('bank','list');});
	$('#account_mgmt #find').click(function(){controller.move('bank','find');});
	$('#account_mgmt #count').click(function(){controller.move('bank','count');});
});
</script>