<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<title>한빛아카데미</title>
<link rel="stylesheet" href="${css}/global.css" />
<div class="box">
	<h2>서비스를 이용하시려면 회원가입을 하세요</h2>
	<a href="${context}/member.do?page=regist">회원가입 하러 가기 </a> <br /><br /> 
	<a href="${context}/member.do?page=login">로긴하러 가기 </a> <br /> <br />
	<a href="#" id="a_admin">정보처리기사 합격자 모드</a><br /> <br /> <br />
</div>
<jsp:include page="../global/footer.jsp" />
<jsp:include page="../global/end.jsp" />
<script src="${js}/admin.js"></script>
<script type="text/javascript">
	admin.init();
	</script>
