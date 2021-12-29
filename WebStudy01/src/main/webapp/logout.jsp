<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	request.removeAttribute("userid");
//	request.getRequestDispatcher("home.jsp").forward(request,response);
// 	application.removeAttribute("userid");
// 	application.removeAttribute("passcode");

	// session
	session.invalidate(); // 모든 session attribute를 삭제(제거)

	// Cookie
// 	Cookie c= new Cookie("userid","");  // 쿠키 만들기 
// 	Cookie c1= new Cookie("passcode","");
// 	c.setMaxAge(0); // 쿠키 수명 지정 : 0일
// 	c1.setMaxAge(0);
// 	response.addCookie(c);  // 클라이언트에 쿠키화일 생성(화일로쓰기)
// 	response.addCookie(c1);
	
// 	response.sendRedirect("home.jsp");
%>
<jsp:forward page="home.jsp" />