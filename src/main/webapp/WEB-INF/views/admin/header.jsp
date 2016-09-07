<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="admin_header" class="navbar navbar-default" style="height : 50px">
  <div class="container-fluid"> <!-- 클래스두개 -->
    <div class="navbar-header">
      <a id="go_admin_home"><img id="header_brand"></a>
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"></a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
       <ul class="nav navbar-nav navbar-right">
         <li style="margin-top:14px;margin-right:50px;font-weight: bold; color: brown;"><span aria-hidden="true"></span>관리자 화면</li>
        <li><a id="exit">  <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>나가기</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">비밀번호 변경</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div></nav>
  <script>
  $(function(){
	  $('#go_admin_home').click(function() {controller.move('admin','main');});
		$('#admin_header').css('height','50px');
		$('.navbar-header').css('height','50px');
		$('#admin_header #exit').addClass('cursor');
		$('#admin_header #exit').click(function() {controller.home();});
		
	});
    
  </script>  