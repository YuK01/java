<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookies=request.getCookies(); // 같은 프로젝트에서 만들어진 cookie만 읽음
	for(Cookie c:cookies){
		out.println(c.getName()+":"+c.getValue()+"<br>");
	}
%>
</body>
</html>