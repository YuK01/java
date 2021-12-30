<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page  session="true" %>
<%
	session.setAttribute("x1",5);
	session.setAttribute("x2",8);
// 	response.sendRedirect("el.jsp");
	request.getRequestDispatcher("el.jsp").forward(request, response);
%>