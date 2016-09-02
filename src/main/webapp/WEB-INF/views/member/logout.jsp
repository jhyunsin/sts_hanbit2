<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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



