<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h5 style="text-align: center">BANK detail</h5>
<div class ="box" style="padding-top:0;width:70%">
	<section style="height: 150px">
    	<div class="panel panel-default">
  			<ul class="list-group">
        			<li class="list-group-item">총학생수 : 120명</li>
  			</ul>
		</div>
	<div class="panel panel-success">
	<div class="panel-heading" style="font-size: 25px;color: black">성적 리스트</div>
		<table id="grade_list_table" class="table">
		  <tr>
		<th>ID</th>
	    <th>이 름</th>
	    <th>학년</th>
	    <th>평균</th>
		  </tr>
		  <tr>
		    <td>lee</td>
		    <td><a class="name">이순신</a></td>
		    <td>4학년</td>
		    <td>3.5</td>
		  </tr>
		  <tr>
		    <td>lee</td>
		    <td><a class="name">박근해</a></td>
		    <td>1학년</td>
		    <td>3.5</td>
		  </tr>
		  <tr>
		    <td>lee</td>
		    <td><a class="name">반기문</a></td>
		    <td>2학년</td>
		    <td>4.5</td>
		  </tr>
		 
		</table>
		<nav aria-label="Page navigation">
 			<ul class="pagination">
   				<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
 				<li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
   				<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</nav>
		</div>
	</section>
</div>	
<script type="text/javascript">
$(function() {
	$('#member_list_table .name').click(function(){alert('name');controller.moveWithKey('member','a_detail','lee');});
	$('#member_list_table .regist').click(function(){alert('regist');controller.moveWithKey('grade','regist','lee');});
	$('#member_list_table .update').click(function(){alert('regist');controller.moveWithKey('grade','update','lee');});
});

</script>
