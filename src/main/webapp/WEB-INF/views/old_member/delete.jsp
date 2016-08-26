<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${css}/global.css" />
</head>
<body>

<div class="box">
<embed src="${context}/img/star.gif">
<h1>탈퇴 페이지</h1>

<form action="${context}/member.do" method="post">  
	<input type="hidden" name="id" value = "${delete.id} }"/>
	<span class="meta">PW</span> <input type="text" name="pw"/><br/>

	<p></p><br />
   <input type="hidden" name = "action" value="delete"/>
	<input type="hidden" name = "directory" value="member"/>
	<input type="hidden" name = "page" value="main"/>


<a href="${context}/member.do"><br /><br />
<img src="${img}/member.png" alt="member" style="width:30px" /></a>
<a href="${context}/index.do">
		<img src="${img}/home.png" alt="member" style="width:30px" />
		</a>
</form>
</div>

</body>
</html>