<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다중선택</title>
</head>
<body>
	<form method="post" action="multiple_bk.jsp">
	<select name=item multiple size=10 style='width:120px'>
	<option value='신발'>신발</option>
	<option value='가방'>가방</option>
	<option value='벨트'>벨트</option>
	<option value='모자'>모자</option>
	<option value='시계'>시계</option>
	<option value='반지'>반지</option>
	</select>
	<input type=submit value='전송'>&nbsp;&nbsp;
	<input type=reset value='Reset'>
	</form>
</body>
</html>