<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// application.setAttribute("userid", request.getParameter("userid"));
// application.setAttribute("passcode", request.getParameter("passcode"));
// request.setAttribute("userid", request.getParameter("userid"));
// request.setAttribute("passcode", request.getParameter("passcode"));
// request.getRequestDispatcher("login.jsp").forward(request, response);
%>
<jsp:forward page="login.jsp">
	<jsp:param name="userid" value="<%=request.getParameter("userid") %>" />
</jsp:forward>