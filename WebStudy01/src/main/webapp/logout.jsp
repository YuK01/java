<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	request.removeAttribute("userid");
	application.removeAttribute("userid");
	application.removeAttribute("passcode");
	session.invalidate();
// 	request.getRequestDispatcher("home.jsp").forward(request,response);
	response.sendRedirect("home.jsp");
%>