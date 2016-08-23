<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/global.css" />
<link rel="stylesheet" href="${css}/member.css" />
<jsp:include page="../global/top.jsp"/>
<jsp:include page="../global/header.jsp"/>
<jsp:include page="../global/navi.jsp"/>
<div class="box">
		<h1>회원정보 수정</h1>
	
		
		<form action="${context}/member.do" method="post">
		<table id="member_detail">
				<tr>
				<td rowspan="5" style="width:30%">
				<img src="${img}/member.do" alt="W3Schools.com" width="104"
			height="142"></td>
				<td style="width:20%" class="font_bold bg_color_yellow">ID</td>
				<td style="width:40%">${detail.id}</td>
				
			</tr>
			<tr>
				
				<td class="font_bold bg_color_yellow">이 름</td>
				<td>${detail.name}</td>
			</tr>
			<tr>
				
				<td class="font_bold bg_color_yellow">비밀번호</td>
				<td><input type="text" name="pw" 
				value= "${detail.pw}" /></td>
				
			</tr>
			<tr>
				
				<td class="font_bold bg_color_yellow">성 별</td>
				<td>${detail.gender}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이메일</td>
				<td><input type="text" name="email" 
				value= "${detail.email}" /></td>
				
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">생년월일</td>
				<td colspan="2">${detail.birth}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">등록일</td>
				<td colspan="2">${detail.regDate}</td>
				
			</tr>
		</table>
		
		<input type="hidden" name = "action" value= "update"/>
		<input type="hidden" name = "directory" value="member"/>
		<input type="hidden" name = "page" value="detail"/>
		<input type="hidden" name="id" value="${detail.id}"/>
		<div style="margin:0 auto">
		<input type="submit" value="수정" />
		<input type="reset" value="취소" />
		</div>
		</form>
		
		<br /> 
		<p>
			
		</p>
<a href="${context}/member.do"><br /><br />
<img src="${img}/member.png" alt="member" style="width:30px" /></a>
<a href="${context}/index.do">
		<img src="${img}/home.png" alt="member" style="width:30px" />
		</a>

	</div>
<jsp:include page="../global/footer.jsp"/>
<jsp:include page="../global/end.jsp"/>