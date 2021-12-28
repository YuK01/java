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
if (request.getParameter("userid").equals(application.getAttribute("userid")) &&
	request.getParameter("passcode").equals(application.getAttribute("passcode"))) {
	request.setAttribute("userid", request.getParameter("userid"));
	request.getRequestDispatcher("home.jsp").forward(request, response);
} else {
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>
</body>
</html>