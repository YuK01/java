<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/study/addMenu" method="post">
		메뉴명 : <input type=text name=menuname><br>
		가격 : <input type=number name=price><br>
		<input type=submit value="추가">
	</form>
</body>
</html>