<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="box">
		<h1>검색된 회원 정보</h1>
	
		
		<table id="member_detail">
				<tr>
				<td rowspan="4" style="width:30%">
				<img src="${img}/${member.id}.jpg" alt="proImg" width="104"
			height="142"></td>
				<td style="width:20%" class="font_bold bg_color_yellow">ID</td>
				<td style="width:40%">${member.id}</td>
			</tr>
			<tr>
				
				<td class="font_bold bg_color_yellow">이 름</td>
				<td>${member.name}</td>
			</tr>
			
			<tr>
				
				<td class="font_bold bg_color_yellow">성 별</td>
				<td>${member.gender}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이메일</td>
				<td colspan="2">${member.email}</td>
				
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">생년월일</td>
				<td colspan="2">${member.birth}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">등록일</td>
				<td colspan="2">${member.regDate}</td>
				
			</tr>
		</table>
		
		
		<br /> 
		<p>
			
		</p>
<a href="${context}/member.do"><br /><br />
<img src="${img}/member.png" alt="member" style="width:30px" /></a>
<a href="${context}/index.do">
		<img src="${img}/home.png" alt="member" style="width:30px" />
		</a>

	</div>
