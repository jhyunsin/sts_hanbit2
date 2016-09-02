<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="box">
		<h1>회원상세정보</h1>
	
		
		<table id="member_detail" class="table">
				<tr>
				<td rowspan="5" style="width:30%">
				<img src="${img}/default/home.png" alt="proImg" width="104"
			height="142"></td>
				<td style="width:20%" class="font_bold">ID</td>
				<td style="width:40%">${member.id}</td>
			</tr>
			<tr>
				
				<td class="font_bold">이 름</td>
				<td>${member.name}</td>
			</tr>
			
			<tr>
				
				<td class="font_bold">성 별</td>
				<td>남자</td>
			</tr>
			<tr>
				<td class="font_bold">이메일</td>
				<td colspan="2">${member.email}</td>
				
			</tr>
			<tr>
				<td class="font_bold">전공과목</td>
				<td colspan="2"></td>
				
			</tr>
			<tr>
				<td class="font_bold">수강과목</td>
				<td colspan="2"></td>
				
			</tr>
			<tr>
				<td class="font_bold">생년월일</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td class="font_bold">등록일</td>
				<td colspan="2"></td>
				
			</tr>
		</table>
		
		
		<br /> 
	</div>

