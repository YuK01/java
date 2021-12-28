<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리</title>
</head>
<body>
	<%
		application.setAttribute("userid",request.getParameter("userid"));
		application.setAttribute("passcode",request.getParameter("passcode"));
		request.getRequestDispatcher("login.jsp").forward(request,response); 
	%>
</body>
</html>