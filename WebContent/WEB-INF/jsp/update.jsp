<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="/update" method="post">
	<input type="hidden" name="i_board" value="${param.i_board }">
		<div>
			<input type="text" name="title" placeholder="제목" value="${update.title }">
		</div>
		<div>
			<label>
				내용 : <textarea name="ctnt" placeholder="내용">${update.ctnt }</textarea>
			</label>
		</div>
		<div>
			<input type="submit" value="수정완료">
			<input type="reset" value="다시작성">
		</div>
	</form>
</body>
</html>