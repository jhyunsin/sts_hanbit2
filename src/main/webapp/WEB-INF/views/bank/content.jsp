<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
div.memberClass{font-size: 20px;}
  </style>
<div id="" class="memberClass box">
	<h1>계좌관리</h1><br />
	<div style="width: 300px; margin: 0 auto; text-align: left;">
	<ol>
		<li><a href="${context}/bank/regist.do">개설</a></li>
		<li><a href="${context}/bank/deposit.do">입금</a></li>
		<li><a href="${context}/bank/withdraw.do">출금</a></li>
	  	<li><a href="${context}/bank/update.do">비번수정</a></li>
		<li><a href="${context}/bank/delete.do">해지</a></li>
		<li><a href="${context}/bank/list.do">목록</a></li>
		<li><a href="${context}/bank/search.do">조회(이름)</a></li>
		<li><a href="${context}/bank/count.do">통장수</a></li>
	</ol>
	</div>

<a href="${context}/home.do">
		<img src="${img}/home.png" alt="home" style="width: 30px"/>
	</a>

</div>
