<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul id="admin_nav" class="nav nav-tabs">
   <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      회원 <span class="caret"></span>
    </a>
    <ul id="member_mgmt" class="dropdown-menu">
		<li><a id="list" ><span style="cursor:pointer;">목 록</span></a></li>
		<li><a id="findBy" ><span style="cursor:pointer;">검 색</span></a></li>
		<li><a id="count" ><span style="cursor:pointer;">회원수</span></a></li>
    </ul>
  </li>
   <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      성적 <span class="caret"></span>
    </a>
    <ul id="grade_mgmt" class="dropdown-menu">
	  	<li><a id="g_list"><span style="cursor:pointer;">목 록</span></a></li>
    	<li><a id="g_regist"><span style="cursor:pointer;">등 록</span></a></li>
		<li><a id="g_update"><span style="cursor:pointer;">수 정</span></a></li>
		<li><a id="g_delete"><span style="cursor:pointer;">삭제</span></a></li>
		<li><a id="g_count"><span style="cursor:pointer;">카운트</span></a></li>
		<li><a id="g_search"><span style="cursor:pointer;">검색</span></a></li>
    </ul>
  </li>
   <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      계좌 <span class="caret"></span>
    </a>
    <ul id="account_mgmt" class="dropdown-menu">
		<li><a id="list"><span style="cursor:pointer;">목 록</span></a></li>
		<li><a id="find"><span style="cursor:pointer;">조회</span></a></li>
		<li><a id="count"><span style="cursor:pointer;">통장수</span></a></li>
    </ul>
  </li>
</ul>