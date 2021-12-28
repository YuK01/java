<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// if (request.getParameter("userid").equals("xaexal") && request.getParameter("passcode").equals("human123")) {
// 	request.setAttribute("userid", request.getParameter("userid"));
// 	request.getRequestDispatcher("home.jsp").forward(request, response);
// } else {
// 	request.getRequestDispatcher("login.jsp").forward(request, response);
// }

if (request.getParameter("userid").equals(application.getAttribute("userid")) &&
	request.getParameter("passcode").equals(application.getAttribute("passcode"))) {
	session.setAttribute("userid", request.getParameter("userid"));
	response.sendRedirect("home.jsp");
// 	request.getRequestDispatcher("home.jsp").forward(request, response);
} else {
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>