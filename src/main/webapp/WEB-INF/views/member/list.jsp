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
	<div class="panel-heading" style="font-size: 25px;color: black">학생 리스트</div>
		<table id="member_list_table" class="table">
		  <tr>
		<th>ID</th>
	    <th>이 름</th>
	    <th>등록일</th>
	    <th>생년월일</th>
	    <th>이메일</th>
	    <th>전화번호</th>
	    <th>성적</th>
		  </tr>
		  <tr>
		    <td>lee</td>
		    <td><a class="name">이순신</a></td>
		    <td>2016-09-01</td>
		    <td>1980-01-01</td>
		    <td>lee@text.com</td>
		    <td>101-1234-4567</td>
		    <td><a class="regist">등록 /</a> <a class="update">수정</a></td>
		  </tr>
		  <tr>
		    <td>lee</td>
		    <td><a class="name">박근해</a></td>
		    <td>2016-09-01</td>
		    <td>1980-01-01</td>
		    <td>lee@text.com</td>
		    <td>101-1234-4567</td>
	    <td><a class="regist">등록 /</a> <a class="update">수정</a></td>
		  </tr>
		  <tr>
		    <td>lee</td>
		    <td><a class="name">반기문</a></td>
		    <td>2016-09-01</td>
		    <td>1980-01-01</td>
		    <td>lee@text.com</td>
		    <td>101-1234-4567</td>
	    <td><a class="regist">등록 /</a> <a class="update">수정</a></td>
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
