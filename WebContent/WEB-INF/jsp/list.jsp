<%@page import="com.koreait.board.model.BoardEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<BoardEntity> list = (List<BoardEntity>) request.getAttribute("list");
	int listLength = (int) request.getAttribute("pageLength");
	
	String strPage = request.getParameter("page");
	if(strPage == null) {
		strPage = "1";
	}
	
	int p = Integer.parseInt(strPage);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/common.css">
<title>리스트</title>

</head>
<body>
	<div>
		<a href="/write"><button>글쓰기</button></a>
	</div>
	<div>
		<!-- <a href="/detail?i_board=1">리스트</a>	<!-- get방식 주소창에 /detail?i_board=1 넘어감 -->
		<table border="1">
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>작성일자</th>
			</tr>
			<%
				for (BoardEntity vo : list) {
			%>
			<tr onclick="location.href='/detail?i_board=<%=vo.getI_board()%>&page=${param.page}'">
				<td><%=vo.getI_board()%></td>
				<td><%=vo.getTitle()%></td>
				<td><%=vo.getR_dt()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<div class="pagingContainer">
		<%for(int i = 1; i <= listLength; i++) { %>
			<span class="page <%=p == i ? "selectedPage" : ""%>">
				<a href="/list?page=<%=i%>"><%=i%></a>
			</span>
		<%}%>
		</div>
	</div>
</body>
</html>