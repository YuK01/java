<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
String jspfile=null;
if (request.getParameter("userid").equals("xaexal") && request.getParameter("passcode").equals("human123")) {
	// Cookie
// 	Cookie c=new Cookie("userid",request.getParameter("userid"));
// 	c.setMaxAge(365*24*60*60);
// 	response.addCookie(c);	
// 	response.addCookie(new Cookie("passcode",request.getParameter("passcode")));

	// request
// 	request.setAttribute("userid", request.getParameter("userid"));
// 	request.getRequestDispatcher("home.jsp").forward(request, response);
	
	session.setAttribute("userid", request.getParameter("userid"));
	session.setAttribute("passcode", request.getParameter("passcode"));
// 	response.sendRedirect("home.jsp");
	jspfile="home.jsp";
} else {
// 	== request.getRequestDispatcher("login.jsp").forward(request, response);
// 	response.sendRedirect("login.jsp");
	jspfile="login.jsp";
}

// if (request.getParameter("userid").equals(application.getAttribute("userid")) &&
// 	request.getParameter("passcode").equals(application.getAttribute("passcode"))) {
// 	session.setAttribute("userid", request.getParameter("userid"));
// 	response.sendRedirect("home.jsp");
//  request.getRequestDispatcher("home.jsp").forward(request, response);
// } else {
// 	request.getRequestDispatcher("login.jsp").forward(request, response);
// }
%>
<jsp:forward page="<%=jspfile%>" />