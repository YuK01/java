<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원의 정보 입력 폼</h1>
<form method="post" action="useBeanDemo.jsp">
<table>
	<tr>
		<td>이름</td>
		<td><input type=text name="name"></td>
	</tr>	
	<tr>
		<td>별명</td>
		<td><input type=text name="nickname"></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type=text name="userid"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type=password name="pwd"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type=text name="email"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type=text name="phone"></td>
	</tr>
	<tr>
		<td><input type=submit value="전송"></td>
		<td><input type=reset value="취소"></td>
	</tr>
</table>
</form>
</body>
</html>