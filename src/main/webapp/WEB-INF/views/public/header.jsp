<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default" >
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
         <div class="navbar-header"><a id="go_public_home"><img id="header_brand"></a>
      </div>
           
      <ul class="nav navbar-nav navbar-right">
        <li><a id="free_board"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>자유게시판</a></li>
       
        </ul> <ul class="nav navbar-nav navbar-right">
        <li><a id="school_info"><span class="glyphicon glyphicon-flag" aria-hidden="true"></span>학교소개</a></li>
       
        </ul>
   	   <ul class="nav navbar-nav navbar-right"> 
        <li><a id="contact"><span class="glyphicon glyphicon-fire" aria-hidden="true"></span>오시는길</a></li>
       
          </ul>
        
    </div>

</nav>
<script type="text/javascript">
$(function() {
	
	$('#go_public_home').click(function(){controller.home();});
	$('#school_info').click(function(){controller.move('public','school_info');});
	$('#contact').click(function(){controller.move('public','contact');});
	$('#free_board').click(function(){controller.move('public','free_board');});
});

</script>