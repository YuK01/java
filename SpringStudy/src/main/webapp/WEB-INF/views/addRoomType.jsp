<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실타입 추가</title>
</head>
<body>
	<form action="/study/addtype" method="get">
		타입코드 : <input type=number name=typecode><br>
		객실타입명 : <input type=text name=typename><br>
		<input type=submit value="추가">
	</form>
</body>
</html>