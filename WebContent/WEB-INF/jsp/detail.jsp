<%@page import="com.koreait.board.model.BoardEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="/list?page=${param.page}">리스트로 돌아가기</a>
		<a href="/del?i_board=${param.i_board }"><button>삭제</button></a>
		<a href="/update?i_board=${param.i_board }"><button>수정</button></a>
	</div>
	<div>
		<div>번호 : ${data.i_board} or ${param.i_board }</div>	<!-- 쿼리 스트링값으로 받은값, request로 전달하면 값이 전부 담긴다. -->
		<div>타이틀 : ${data.title}</div>
		<div>작성일시 : ${data.r_dt}</div>
		<hr>
		<div>내용 : ${data.ctnt}</div>
	</div>
</body>
</html>