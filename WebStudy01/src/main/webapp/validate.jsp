<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getParameter("userid").equals("xaexal") &&
	   request.getParameter("passcode").equals("human123")){
		request.setAttribute("userid",request.getParameter("userid"));
		request.setAttribute("passcode",request.getParameter("passcode"));
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.forward(request,response); // login.jsp에 request,response가 전달됨.
	} else {
		RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
		rd.forward(request,response);
	}
%>