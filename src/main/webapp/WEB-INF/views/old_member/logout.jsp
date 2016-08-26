<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${css}/global.css" />
</head>
<body>
<div class="box">
	
	<form action="${context}/member.do" method="post">
			<br/><br/><br/>
		<input type="hidden" name="id" value="${logout.id} }"/>
		<input type="hidden" name="pw" value="${logout.pw}"/>
		<input type="submit"  value="로그아웃"/>
 	 <input type="hidden" name = "action" value="logout"/>
	<input type="hidden" name = "directory" value="member"/>
	<input type="hidden" name = "page" value="main"/>

	</form>

	</div>




</body>
</html>