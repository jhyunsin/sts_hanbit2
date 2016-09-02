<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="user_header" class="navbar navbar-default" >
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a id="go_user_home"><img id="header_brand"></a>
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
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">내 계좌<span class="caret"></span></a>
          <ul id="account" class="dropdown-menu">
            <li><a>계좌 정보</a></li>
            <li><a>계좌 생성</a></li>
            <li><a>입 출금 </a></li>
            <li><a>계좌 해지 </a></li>
          </ul>
        </li>
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">내 성적<span class="caret"></span></a>
          <ul id="grade" class="dropdown-menu">
            <li><a>최근성적보기</a></li>
            <li><a>지난성적보기</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="과목명을 입력하세요">
        </div>
        <button type="submit" class="btn btn-default">점수조회</button>
      </form>
      
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
       <ul class="nav navbar-nav navbar-right">
        <li><div style="text-align:right ;color:black ; margin-left: 80px; padding-top: 15px;" >${user.name}님 환영합니다.</div></li>
        <li><a id="logout">  <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>나가기</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a id="a_mypage">마이페이지</a></li>
            <li><a id="a_detail">내정보보기</a></li>
            <li><a id="a_update">내 정보 수정</a></li>
            <li><a id="a_delete">회원 탈퇴</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<script type="text/javascript">
$(function(){
 $('#go_user_home').click(function(){controller.move('member', 'content');});
 $('#user_header').css('height','50px');
 $('#user_header #a_mypage').click(function(){controller.move('member', 'content');});
 $('#user_header #a_detail').click(function(){controller.move('member', 'detail');});
 $('#user_header #a_update').click(function(){controller.move('member', 'update');});
 $('#user_header #a_delete').click(function(){controller.move('member', 'delete');});
 $('.navbar-header').css('height','50px');
 $('#user_header #logout').click(function(){controller.home();});
 $("#user_header #account li:eq(0) a").click(function(){alert('계좌목록클릭');controller.move('bank', 'detail');}); 
 $("#user_header #account li:eq(1) a").click(function(){controller.move('bank', 'open');});
 $("#user_header #account li:eq(2) a").click(function(){controller.move('bank', 'transaction');}); 
 $("#user_header #account li:eq(3) a").click(function(){controller.move('bank', 'delete');}); 
 $("#user_header #grade li:eq(0) a").click(function(){alert('성적목록클릭');controller.move('grade', 'detail');}); 
 $("#user_header #grade li:eq(1) a").click(function(){controller.move('grade', 'find');}); 
});
</script>