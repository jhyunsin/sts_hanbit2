<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<link rel="stylesheet" href="${css}/global.css" />
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}


</style>
</head>
<body>
<div class="box">
<h1 >목록보기</h1><br/>
	

<table id="member_list">
  <tr>
    <th>ID</th>
    <th>이름</th>
    <th>등록일</th>
    <th>생년월일</th>
    <th>이메일</th>
    <th>전화번호</th>
  </tr>
  <c:forEach var="member" items="${list}">
  <tr>
    <td>${member.id}</td>
  <td><a href="${context}/member.do?action=findById&page=findById&keyword=${member.id}">
	    	${member.name}</a></td>
    <td>${member.regDate}</td>
    <td>${member.birth}</td>
    <td>${member.email}</td>
    <td>${member.phone}</td>
  </tr>
 </c:forEach>
 </table>
<a href="${context}/member.do"><br /><br />
<img src="${img}/member.png" alt="member" style="width:30px" /></a>
<a href="${context}/index.do">
		<img src="${img}/home.png" alt="member" style="width:30px" />
		</a>
</div>
</body>
</html>