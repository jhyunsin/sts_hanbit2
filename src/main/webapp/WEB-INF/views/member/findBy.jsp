<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp"/>
<jsp:include page="../global/header.jsp"/>
<jsp:include page="../global/navi.jsp"/>
<div class="box">


<h1>ID검색</h1>
<form action="${context}/member.do" method="get">
<input type="text" name = "keyword" placeholder="검색할ID"/>
<input type="hidden" name = "action" value = "findById"/>
<input type="hidden" name = "page" value = "findById"/>
<input type="submit" value = "Id검색"/>
<input type="reset" value = "취소"/>
</form>
<h1>이름검색</h1>
<form action="${context}/member.do" method="get">
<input type="text" name = "keyword" placeholder="검색할 NAME"/>
<input type="hidden" name = "action" value = "findByName"/>
<input type="hidden" name = "page" value = "list"/>
<input type="submit" value = "Name이름검색"/>
<input type="reset" value = "취소"/>

</form>
<iframe src="${context}/member.do?page=image" class="ifrm" style="border:none;"></iframe>
<a href="${context}/member.do"><br /><br />
<img src="${img}/member.png" alt="member" style="width:30px" /></a>
<a href="${context}/index.do">
		<img src="${img}/home.png" alt="member" style="width:30px" />
		</a>

</div>
<jsp:include page="../global/footer.jsp"/>
<jsp:include page="../global/end.jsp"/>