<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h5 style="text-align: center">BANK detail</h5>
<div class ="box" style="padding-top:0;width:70%">
	<section style="height: 150px">
    	<div class="panel panel-default">
  			<ul class="list-group">
        			<li class="list-group-item">총계좌수 : 88개</li>
  			</ul>
		</div>
	<div class="panel panel-success">
	<div class="panel-heading" style="font-size: 25px;color: black">계좌 리스트</div>
		<table id="account_list_table" class="table">
		  <tr>
		<th>계좌번호</th>
	    <th>이 름</th>
	    <th>생년월일</th>
	    <th>잔액</th>
		  </tr>
		  <tr>
		    <td>123-567-890</td>
		    <td><a class="name">이순신</a></td>
		    <td>1980년 10월 2일</td>
		    <td>300￦</td>
		  </tr>
		  <tr>
		    <td>123-567-890</td>
		    <td><a class="name">홍길동</a></td>
		    <td>1980년 10월 2일</td>
		    <td>300￦</td>
		  </tr>
		   <tr>
		    <td>123-567-890</td>
		    <td><a class="name">유승준</a></td>
		    <td>1980년 10월 2일</td>
		    <td>300￦</td>
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
	$('#account_list_table .name').click(function(){alert('name');controller.moveWithKey('account','a_detail','lee');});
	$('#account_list_table .regist').click(function(){alert('regist');controller.moveWithKey('account','regist','lee');});
	$('#account_list_table .update').click(function(){alert('regist');controller.moveWithKey('account','update','lee');});
});

</script>
