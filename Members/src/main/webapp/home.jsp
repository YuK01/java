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
	if(request.getAttribute("userid")==null){
		out.print("<a href='login.jsp'>로그인</a>&nbsp;<a href='signon.jsp'>회원가입</a>");
	} else {
		out.print(request.getAttribute("userid")+"<a href='logout.jsp'>로그아웃</a>");
	}
%>
</body>
</html>